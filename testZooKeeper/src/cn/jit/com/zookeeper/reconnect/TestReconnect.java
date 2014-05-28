package cn.jit.com.zookeeper.reconnect;

public class TestReconnect {
	// 测试session过期后，重新创建listener的过程
	public static void main(String[] args) throws Exception {

		// 线程2：模拟对节点数据的读写操作
		Thread listener = new Thread(new ZookeeperNodeListener());
		listener.start();

		// 线程1：用来进行轮询，判断zookeeper状态，如果有问题，则重建
		new ZookeeperMonitor().run();
	}
}
