package cn.jit.com.processmanager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import cn.jit.com.cmd.CmdProcessorManager;
import cn.jit.com.cmd.CmdUtils;
import cn.jit.com.zookeeper.ZooKeeperConnector;
import cn.jit.com.zookeeper.watcher.ProcessStateChangeWatcher;

/**
 * 测试java进程的管理
 * 
 * @author guowl
 * @since 2014-1-2
 */
public class ProcessManager {
	/**
	 * zooKeeper
	 */
	private ZooKeeper zk;

	public static void main(String[] args) throws Exception {
		ProcessManager processManager = new ProcessManager();
		// 连接到服务器
		processManager.connectZkServer();

		// 进行初始化
		processManager.init();

		// 注册watcher
		processManager.registerWatcher();

		// 接收用户输入命令
		processManager.waitForCommand();
	}

	private void connectZkServer() throws Exception {
		ZooKeeperConnector zooKeeperConnector = new ZooKeeperConnector();
		zk = zooKeeperConnector.getZooKeeper();
	}

	private void init() throws Exception {
		if (zk.exists(ProcessManagerConstants.NODE_CONFIG, false) == null) {
			zk.create(ProcessManagerConstants.NODE_CONFIG, "config".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);
		}
		// 启动期间配置信息——进程数量：5
		zk.create(ProcessManagerConstants.NODE_CONFIG_START, "{\"processNum\":\"5\"}".getBytes(),
				ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		// 业务执行期间配置信息——缓存时间：15分钟，会话过期时间：30分钟
		zk.create(ProcessManagerConstants.NODE_CONFIG_BUSINESS, "{\"cacheTime\":\"15\", \"sessionTime\":\"30\"}"
				.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		// 监控相关配置信息——日志级别：info，
		zk.create(ProcessManagerConstants.NODE_CONFIG_MONITOR, "{\"logLevel\":\"info\"}".getBytes(),
				ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

		if (zk.exists(ProcessManagerConstants.NODE_PROCESS_STATE, false) == null) {
			// 进程状态信息
			zk.create(ProcessManagerConstants.NODE_PROCESS_STATE, "processState".getBytes(),
					ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}

		// 命令行信息
		zk.create(ProcessManagerConstants.NODE_COMMAND, "command".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL);
		
		if (zk.exists("/test", false) == null) {
			zk.create("/test", "/test".getBytes(),
					ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			long start = System.currentTimeMillis();
			for (int i = 0; i < 10; i++) {
				zk.create("/test/" + i, get5MMessage().getBytes(),
						ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			System.out.println("test over:" + (System.currentTimeMillis() - start));
		}
	}

	private String get5KMessage() {
		return "The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality.";
	}
	
	private String get5MMessage() {
		StringBuffer sb = new StringBuffer();
		for (int i =0; i < 100; i++) {
			sb.append(get5KMessage());
		}
		return sb.toString();
	}
	
	private void registerWatcher() throws Exception {
		// 进程状态变更的监视器
		ProcessStateChangeWatcher processStateChangeWatcher = new ProcessStateChangeWatcher(zk);
		zk.getChildren(ProcessManagerConstants.NODE_PROCESS_STATE, processStateChangeWatcher, null);

	}

	// 启动控制台输入命令方式
	private void waitForCommand() throws Exception {
		String welcomeInfo = CmdUtils.welcomeInfo();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String cmd = "";
		CmdProcessorManager cmdProcessorManager = new CmdProcessorManager(zk);
		while (true) {
			System.out.print(welcomeInfo);
			cmd = stdin.readLine();
			cmdProcessorManager.execute(cmd);
		}
	}
}
