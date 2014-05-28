package cn.jit.com.processmanager;

import java.util.Random;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import cn.jit.com.cmd.CmdUtils;
import cn.jit.com.common.ConsolePringter;
import cn.jit.com.common.ConsolePringter.Level;
import cn.jit.com.zookeeper.ZooKeeperConnector;
import cn.jit.com.zookeeper.watcher.CmdChangeWatcher;
import cn.jit.com.zookeeper.watcher.MonitorConfigChangeWatcher;

/**
 * 创建进程
 * 
 * @author guowl
 * @since 2014-1-2
 */
public class ProcessCreator {
	// 在zookeeper中创建一个节点，记录该进程的信息
	public static void main(String[] args) {
		// 创建一个与服务器的连接
		ZooKeeper zk = null;
		try {
			ZooKeeperConnector zooKeeperConnector = new ZooKeeperConnector();
			zk = zooKeeperConnector.getZooKeeper();

			// 为该进程创建一个临时的节点，节点的名称为该进程的id
			String pid = CmdUtils.getPid() + "";
			zk.create(ProcessManagerConstants.NODE_PROCESS_STATE + "/" + pid, createNodeData().getBytes("utf-8"),
					ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

			// 打印出公共配置信息的内容
			String startConfig = new String(zk.getData(ProcessManagerConstants.NODE_CONFIG_START, false, null));
			String businessConfig = new String(zk.getData(ProcessManagerConstants.NODE_CONFIG_BUSINESS, false, null));
			Watcher monitorWatcher = new MonitorConfigChangeWatcher(zk);
			String monitorConfig = new String(zk.getData(ProcessManagerConstants.NODE_CONFIG_MONITOR, monitorWatcher,
					null));
			// 注册对cmd节点的监控器
			Watcher cmdWatcher = new CmdChangeWatcher(zk);
			zk.getData(ProcessManagerConstants.NODE_COMMAND, cmdWatcher, null);

			ConsolePringter.beginPrintln();
			ConsolePringter.println("公共配置信息：", Level.ONE);
			ConsolePringter.println("初始化信息配置：" + startConfig, Level.TWO);
			ConsolePringter.println("业务信息配置：" + businessConfig, Level.TWO);
			ConsolePringter.println("监控信息配置：" + monitorConfig, Level.TWO);
			ConsolePringter.endPrintln();

			Thread.sleep(1000 * 60);
			// zk.close();
			Thread.sleep(1000 * 60 * 60);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			if (zk != null) {
				try {
					zk.close();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 创建节点的内容：随机性的
	private static String createNodeData() {
		Random r = new Random();
		String nodeData = "请求数：" + (100 + r.nextInt(300));
		return nodeData;

	}
}
