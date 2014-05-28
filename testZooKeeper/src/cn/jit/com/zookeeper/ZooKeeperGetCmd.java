package cn.jit.com.zookeeper;

import java.util.List;

import org.apache.zookeeper.ZooKeeper;

import cn.jit.com.cmd.CmdProcessor;
import cn.jit.com.cmd.CmdUtils;

/**
 * 获取数据命令
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class ZooKeeperGetCmd implements CmdProcessor {
	/**
	 * zooKeeper
	 */
	private ZooKeeper zk;

	@Override
	public void execute(List<String> cmd) throws Exception {
		if (cmd.size() == 2) {
			byte[] nodeData = zk.getData(cmd.get(1), false	, null);
			System.out.println(CmdUtils.welcomeInfo() + new String(nodeData));
		}
	}

	@Override
	public void registerSource(Object source) throws Exception {
		zk = (ZooKeeper) source;
	}
}
