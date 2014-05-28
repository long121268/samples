package cn.jit.com.zookeeper.watcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import cn.jit.com.cmd.CmdUtils;
import cn.jit.com.processmanager.ProcessFactory;
import cn.jit.com.processmanager.ProcessManagerConstants;

/**
 * 当cmd命令发生变更时,执行该命令
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class CmdChangeWatcher implements Watcher {
	private ZooKeeper zookeeper;

	public CmdChangeWatcher(ZooKeeper zookeeper) {
		this.zookeeper = zookeeper;
	}

	@Override
	public void process(WatchedEvent event) {
		try {
			byte[] cmd = zookeeper.getData(ProcessManagerConstants.NODE_COMMAND, this, null);
			String cmdStr = new String(cmd);
			List<String> cmdList = CmdUtils.format(cmdStr);
			if (cmdList.size() >= 3 && cmdList.get(0).equals("stop") && cmdList.get(1).equals("-p")) {
				Set<String> pids = new HashSet(cmdList.subList(2, cmdList.size()));
				String currentPid = CmdUtils.getPid() + "";
				if (pids.contains(currentPid)) {
					ProcessFactory processFactory = new ProcessFactory();
					processFactory.stopProcessByPid(currentPid);
				}
			}
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
