package cn.jit.com.zookeeper.watcher;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import cn.jit.com.common.ConsolePringter;
import cn.jit.com.common.ConsolePringter.Level;
import cn.jit.com.processmanager.ProcessManagerConstants;

/**
 * 配置信息发生变化后，触发的watcher
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class MonitorConfigChangeWatcher implements Watcher {
	private ZooKeeper zookeeper;

	public MonitorConfigChangeWatcher(ZooKeeper zookeeper) {
		this.zookeeper = zookeeper;
	}

	@Override
	public void process(WatchedEvent event) {
		try {
			byte[] monitorConfig = zookeeper.getData(ProcessManagerConstants.NODE_CONFIG_MONITOR, this, null);
			ConsolePringter.beginPrintln();
			ConsolePringter.println("系统监控信息", Level.ONE);
			ConsolePringter.println("监控信息配置发生了变更，当前内容为：" + new String(monitorConfig), Level.TWO);
			ConsolePringter.endPrintln();
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
