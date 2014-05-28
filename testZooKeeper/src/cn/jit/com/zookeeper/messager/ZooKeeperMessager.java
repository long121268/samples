package cn.jit.com.zookeeper.messager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jit.com.common.JsonParser;

public class ZooKeeperMessager implements IMessager {
	public static final String			NODE_ROOT					= "/processManage";
	public static final String			NODE_CONFIG					= "/processManage/config";
	public static final String			NODE_COMMAND				= "/processManage/command";
	public static final String			NODE_PROCESS_STATE			= "/processManage/processState";
	public static final String			NODE_CONFIG_PROCESS_MANAGE	= "/processManage/config/processManage";
	private static Logger				logger						= LoggerFactory.getLogger(ZooKeeperMessager.class);
	private static Set<ListenerWrap>	listeners					= new HashSet<ListenerWrap>();
	private ZooKeeperHandler			zooKeeperHandler;

	public ZooKeeperMessager() {
		zooKeeperHandler = new ZooKeeperHandler();
	}

	/**
	 * 单元测试专用
	 */
	ZooKeeperMessager(ZooKeeperHandler zooKeeperHandler) {
		this.zooKeeperHandler = zooKeeperHandler;
	}

	@Override
	public byte[] getData(String key) {
		return zooKeeperHandler.getFromZookeeper(key);
	}

	@Override
	public <T> T getData(String key, Class<T> className) {
		byte[] data = getData(key);
		return JsonParser.jsonToBean(data, className);
	}

	@Override
	public void putData(String key, byte[] data, boolean persistent) {
		if (zooKeeperHandler.existsInZookeeper(key)) {
			zooKeeperHandler.updateToZookeeper(key, data);
		} else {
			zooKeeperHandler.createToZookeeper(key, data, persistent);
		}
	}

	@Override
	public <T> void putData(String key, T t, boolean persistent) {
		byte[] data = JsonParser.beanToJson(t);
		putData(key, data, persistent);
	}

	@Override
	public Map<String, byte[]> getChildren(String key) {
		List<String> paths = zooKeeperHandler.getChildrenFromZookeeper(key);
		Map<String, byte[]> children = new HashMap<String, byte[]>();
		if (paths != null && paths.size() > 0) {
			for (String path : paths) {
				byte[] data = getData(path);
				if (data != null && data.length > 0) {
					children.put(path, data);
				}
			}
		}
		return children;
	}

	@Override
	public <T> Map<String, T> getChildren(String key, Class<T> className) {
		List<String> paths = zooKeeperHandler.getChildrenFromZookeeper(key);
		Map<String, T> children = new HashMap<String, T>();
		if (paths != null && paths.size() > 0) {
			for (String path : paths) {
				T t = getData(path, className);
				if (t != null) {
					children.put(path, t);
				}
			}
		}
		return children;
	}

	@Override
	public void registListener(final String key, final IMessageListener listener) {
		// 把注册的listener记录
		listeners.add(new ListenerWrap(listener, key));

		final MessageEvent messageEvent = new MessageEvent(key, this);
		logger.info("Start regist listener to node : " + key);
		zooKeeperHandler.getChildrenFromZookeeper(key, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				listener.onChildrenChange(messageEvent);
				if (!listener.stopListen()) {
					zooKeeperHandler.getChildrenFromZookeeper(key, this);
				}
			}

		});

		zooKeeperHandler.getFromZookeeper(key, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				listener.onChange(messageEvent);
				if (!listener.stopListen()) {
					zooKeeperHandler.getFromZookeeper(key, this);
				}
			}
		});
	}

	@Override
	public boolean existData(String key) {
		return zooKeeperHandler.existsInZookeeper(key);
	}

	@Override
	public void removeData(String key) {
		zooKeeperHandler.removeFromZookeeper(key);
	}

	@Override
	public void removeDataCascade(String key) {
		List<String> children = zooKeeperHandler.getChildrenFromZookeeper(key);
		if (children != null && children.size() > 0) {
			for (String child : children) {
				removeDataCascade(child);
			}
		}
		zooKeeperHandler.removeFromZookeeper(key);
	}

	@Override
	public void reRegistListener() {
		logger.info("zookeeper session expired, reregist listener.");
		for (ListenerWrap o : listeners) {
			if (!o.getListener().stopListen()) {
				this.registListener(o.getPath(), o.getListener());
			}
		}
	}

	class ListenerWrap {
		private IMessageListener	listener;
		private String				path;

		public ListenerWrap(IMessageListener listener, String path) {
			this.listener = listener;
			this.path = path;
		}

		public IMessageListener getListener() {
			return listener;
		}

		public void setListener(IMessageListener listener) {
			this.listener = listener;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

	}
}


