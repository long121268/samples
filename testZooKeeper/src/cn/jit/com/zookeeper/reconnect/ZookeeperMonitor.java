package cn.jit.com.zookeeper.reconnect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jit.com.zookeeper.messager.ZooKeeperHandler;
import cn.jit.com.zookeeper.messager.ZooKeeperMessager;

public class ZookeeperMonitor {
	private ZooKeeperHandler	zooKeeperHandler	= new ZooKeeperHandler();
	private static Logger		logger				= LoggerFactory.getLogger(ZookeeperMonitor.class);

	public void run() {
		try {
			while (true) {
				logger.info("start monit zookeeper.");
				Thread.sleep(1000 * 3);
				if (!zooKeeperHandler.isConnected()) {
					logger.error("zookeeper connect failed, reconnect.");
					zooKeeperHandler.reConnect();
					logger.error("zookeeper reconnect success, reregist listener.");
					new ZooKeeperMessager().reRegistListener();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
