package cn.jit.com.zookeeper.messager;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZooKeeperHandler {
	private static Logger		logger	= LoggerFactory.getLogger(ZooKeeperHandler.class);
	private static ZooKeeper	zooKeeper;

	static {
		zooKeeper = createZooKeeper();
	}

	private static ZooKeeper getZooKeeper() {
		return zooKeeper;
	}

	public boolean isConnected() {
		return zooKeeper.getState().isConnected();
	}

	public void reConnect() {
		zooKeeper = createZooKeeper();
	}

	/**
	 * 建立与zookeeper的连接。
	 * 
	 * @return ZooKeeper对象。
	 */
	private static ZooKeeper createZooKeeper() {
		String addr = "127.0.0.1";
		int sessionTimeOut = 4000;
		try {
			ZooKeeper zooKeeper = new ZooKeeper(addr, sessionTimeOut, new Watcher() {
				public void process(WatchedEvent event) {}
			});
			Thread.sleep(1000);
			return zooKeeper;
		} catch (Exception e) {
			logger.error("Can't connect to zookeeper[addr:" + addr + ", sessionTimeOut" + sessionTimeOut + "]", e);
			return null;
		}
	}

	public byte[] getFromZookeeper(String path) {
		return getFromZookeeper(path, null);
	}

	public byte[] getFromZookeeper(String path, Watcher watcher) {
		try {
			if (!existsInZookeeper(path)) {
				return new byte[0];
			}
			if (watcher == null) {
				return getZooKeeper().getData(path, false, null);
			} else {
				return getZooKeeper().getData(path, watcher, null);
			}
		} catch (KeeperException e) {
			logger.error("Can't get node from zookeeper[path:" + path + "]", e);
		} catch (InterruptedException e) {
			logger.error("Can't get node from zookeeper[path:" + path + "]", e);
		}

		return null;
	}

	public boolean existsInZookeeper(String path) {
		try {
			if (getZooKeeper().exists(path, false) == null) {
				return false;
			} else {
				return true;
			}
		} catch (KeeperException e) {
			logger.error("Check node is exist in zookeeper[path:" + path + "] failed.", e);
			return false;
		} catch (InterruptedException e) {
			logger.error("Check node is exist in zookeeper[path:" + path + "] failed.", e);
			return false;
		}
	}

	public void createToZookeeper(String path, byte[] data, boolean persistent) {
		CreateMode mode = CreateMode.EPHEMERAL;
		if (persistent) {
			mode = CreateMode.PERSISTENT;
		}

		try {
			getZooKeeper().create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);
		} catch (KeeperException e) {
			logger.error("Can't create node to zookeeper[path:" + path + "]", e);
		} catch (InterruptedException e) {
			logger.error("Can't create node to zookeeper[path:" + path + "]", e);
		}
	}

	public void updateToZookeeper(String path, byte[] data) {
		try {
			getZooKeeper().setData(path, data, -1);
		} catch (KeeperException e) {
			logger.error("Can't update node to zookeeper[path:" + path + "]", e);
		} catch (InterruptedException e) {
			logger.error("Can't update node to zookeeper[path:" + path + "]", e);
		}
	}

	public List<String> getChildrenFromZookeeper(String path) {
		return getChildrenFromZookeeper(path, null);
	}

	public List<String> getChildrenFromZookeeper(String path, Watcher watcher) {
		try {
			if (!existsInZookeeper(path)) {
				return new ArrayList<String>();
			}
			if (watcher == null) {
				return makeFullPaths(getZooKeeper().getChildren(path, false), path);
			} else {
				return makeFullPaths(getZooKeeper().getChildren(path, watcher), path);
			}
		} catch (KeeperException e) {
			logger.error("Can't get children from zookeeper[parent path:" + path + "]", e);
		} catch (InterruptedException e) {
			logger.error("Can't get children from zookeeper[parent path:" + path + "]", e);
		}

		return null;
	}

	public void removeFromZookeeper(String path) {
		if (!existsInZookeeper(path)) {
			return;
		}

		try {
			getZooKeeper().delete(path, -1);
		} catch (InterruptedException e) {
			logger.error("Can't remove data from zookeeper[path:" + path + "]", e);
		} catch (KeeperException e) {
			logger.error("Can't remove data from zookeeper[path:" + path + "]", e);
		}
	}

	private List<String> makeFullPaths(List<String> paths, String parentPath) {
		List<String> fullPaths = new ArrayList<String>();
		if (paths != null) {
			for (String path : paths) {
				fullPaths.add(parentPath + "/" + path);
			}
		}
		return fullPaths;
	}
}
