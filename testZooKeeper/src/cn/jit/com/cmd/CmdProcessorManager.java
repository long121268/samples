package cn.jit.com.cmd;

import java.util.List;

import org.apache.zookeeper.ZooKeeper;

import cn.jit.com.zookeeper.ZooKeeperGetCmd;
import cn.jit.com.zookeeper.ZooKeeperHelpCmd;
import cn.jit.com.zookeeper.ZooKeeperSetCmd;
import cn.jit.com.zookeeper.ZooKeeperStartCmd;
import cn.jit.com.zookeeper.ZooKeeperStopCmd;

/**
 * 对命令行进行分析处理的类
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class CmdProcessorManager {
	private CmdProcessor helpCmd;
	private CmdProcessor startCmd;
	private CmdProcessor stopCmd;
	private CmdProcessor setCmd;
	private CmdProcessor getCmd;

	public CmdProcessorManager(ZooKeeper zk) throws Exception {
		helpCmd = new ZooKeeperHelpCmd();
		startCmd = new ZooKeeperStartCmd();
		stopCmd = new ZooKeeperStopCmd();
		stopCmd.registerSource(zk);
		setCmd = new ZooKeeperSetCmd();
		setCmd.registerSource(zk);
		getCmd = new ZooKeeperGetCmd();
		getCmd.registerSource(zk);
	}

	public void execute(String cmd) throws Exception {
		if (cmd == null || cmd.trim().equals("")) {
			return;
		}

		List<String> cmdList = CmdUtils.format(cmd);
		if (cmdList.size() > 0) {
			try {
				String cmdType = cmdList.get(0);
				if (cmdType.equals("help")) {
					helpCmd.execute(cmdList);
				} else if (cmdType.equals("start")) {
					startCmd.execute(cmdList);
				} else if (cmdType.equals("stop")) {
					stopCmd.execute(cmdList);
				} else if (cmdType.equals("set")) {
					setCmd.execute(cmdList);
				} else if (cmdType.equals("get")) {
					getCmd.execute(cmdList);
				} else {
					helpCmd.execute(cmdList);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
