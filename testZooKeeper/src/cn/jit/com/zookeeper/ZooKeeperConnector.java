package cn.jit.com.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperConnector {
	private String addr = "127.0.0.1:2181";
	private int sessionTimeOut = 4000;

	public ZooKeeper getZooKeeper() throws Exception {
		return getZooKeeper(new Watcher() {
			// 监控所有被触发的事件
			public void process(WatchedEvent event) {
				
			}
		});
	}

	public ZooKeeper getZooKeeper(Watcher watcher) throws Exception {
		return new ZooKeeper(addr, sessionTimeOut, watcher);
	}
}
