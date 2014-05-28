package cn.jit.com.zookeeper.connection;

import cn.jit.com.zookeeper.ZooKeeperConnector;

public class ZookeeperClient implements Runnable {

	@Override
	public void run() {
		ZooKeeperConnector zookeeper = new ZooKeeperConnector();
		try {
			zookeeper.getZooKeeper();
			Thread.sleep(1000 * 60 * 60);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
