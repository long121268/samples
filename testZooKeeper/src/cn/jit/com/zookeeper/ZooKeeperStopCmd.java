package cn.jit.com.zookeeper;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.ZooKeeper;

import cn.jit.com.cmd.CmdProcessor;
import cn.jit.com.cmd.CmdUtils;
import cn.jit.com.processmanager.ProcessManagerConstants;

/**
 * 停止命令
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class ZooKeeperStopCmd implements CmdProcessor {
	/**
	 * zooKeeper
	 */
	private ZooKeeper zk;

	@Override
	public void execute(List<String> cmd) throws Exception {
		List<String> pidList = new ArrayList<String>();
		if (cmd.size() == 2) {
			List<String> processPids = zk.getChildren(ProcessManagerConstants.NODE_PROCESS_STATE, false);
			if (processPids != null && processPids.size() > 0) {
				for (String pid : processPids) {
					pidList.add(pid);
				}
				stopProcesses(pidList);
			}
		}

		if (cmd.size() == 3) {
			pidList.add(cmd.get(2));
			stopProcesses(pidList);
		}

	}

	/*
	 * private void stopProcess(String pid) throws Exception { ProcessFactory
	 * processFactory = new ProcessFactory();
	 * processFactory.stopProcessByPid(pid);
	 * System.out.println(CmdUtils.welcomeInfo() + "已经成功销毁了进程号为" + pid + "的进程");
	 * }
	 */

	private void stopProcesses(List<String> pidList) throws Exception {
		String cmd = "stop -p ";
		String pids = "";
		for (int i = 0; i < pidList.size(); i++) {
			pids += pidList.get(i) + " ";
		}

		zk.setData(ProcessManagerConstants.NODE_COMMAND, (cmd + pids).getBytes(), -1);
		System.out.println(CmdUtils.welcomeInfo() + "已经向id为" + pids + "的进程发送了销毁命令");
	}

	@Override
	public void registerSource(Object source) throws Exception {
		zk = (ZooKeeper) source;
	}
}
