package cn.jit.com.zookeeper;

import java.util.List;

import org.apache.zookeeper.ZooKeeper;

import cn.jit.com.cmd.CmdProcessor;
import cn.jit.com.cmd.CmdUtils;

/**
 * 
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class ZooKeeperSetCmd implements CmdProcessor {
	/**
	 * zooKeeper
	 */
	private ZooKeeper zk;

	@Override
	public void execute(List<String> cmd) throws Exception {
		if (cmd.size() < 3) {
			return;
		}

		String data = "";
		for (int i = 2; i < cmd.size(); i++) {
			if (i > 2) {
				data += " ";
			}
			data += cmd.get(i);
		}

		zk.setData(cmd.get(1), data.getBytes(), -1);
		System.out.println(CmdUtils.welcomeInfo() + "已经成功修改了路径为[" + cmd.get(1) + "]的配置信息的内容，修改后的内容为" + data);
	}

	@Override
	public void registerSource(Object source) throws Exception {
		zk = (ZooKeeper) source;
	}

}
