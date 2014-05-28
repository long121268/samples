package cn.jit.com.zookeeper.watcher;

import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import cn.jit.com.common.ConsolePringter;
import cn.jit.com.common.ConsolePringter.Level;
import cn.jit.com.processmanager.ProcessManagerConstants;

/**
 * 进程状态改变后触发的watcher
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class ProcessStateChangeWatcher implements Watcher {
	private ZooKeeper zookeeper;

	public ProcessStateChangeWatcher(ZooKeeper zookeeper) {
		this.zookeeper = zookeeper;
	}

	@Override
	public void process(WatchedEvent event) {
		try {
			List<String> ps = zookeeper.getChildren(ProcessManagerConstants.NODE_PROCESS_STATE, this, null);
			ConsolePringter.beginPrintln();
			ConsolePringter.println("系统监控信息", Level.ONE);
			ConsolePringter.println("进程池中的进程数量发生了变更，当前的进程总数为：" + ps.size(), Level.TWO);
			if (ps.size() > 0) {
				ConsolePringter.println("进程的id为：" + ps, Level.TWO);
			}
			ConsolePringter.endPrintln();
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
