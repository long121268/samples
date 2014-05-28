package cn.jit.com.zookeeper.reconnect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jit.com.zookeeper.messager.AbstractMessageListener;
import cn.jit.com.zookeeper.messager.MessageEvent;
import cn.jit.com.zookeeper.messager.ZooKeeperMessager;

public class ZookeeperNodeListener extends AbstractMessageListener implements Runnable {
	private static Logger	logger	= LoggerFactory.getLogger(ZookeeperNodeListener.class);

	@Override
	public void run() {
		new ZooKeeperMessager().putData("/test", new byte[0], true);
		new ZooKeeperMessager().registListener("/test", new ZookeeperNodeListener());
	}

	@Override
	public void onChange(MessageEvent event) {
		logger.info(System.currentTimeMillis() + ": value :" + new String(event.getChangeData()));
	}
}
