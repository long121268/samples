package cn.jit.com.zookeeper.connection;

public class TestConnectionNums {
	public static void main(String[] args) {
		int num = 81;
		for (int i = 0; i < num; i++) {
			Thread thread = new Thread(new ZookeeperClient());
			thread.start();
		}
	}
}
