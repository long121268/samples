package cn.jit.com.zookeeper;

import java.util.List;

import cn.jit.com.cmd.CmdProcessor;
import cn.jit.com.cmd.CmdUtils;
import cn.jit.com.processmanager.ProcessFactory;

/**
 * 启动进程命令
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class ZooKeeperStartCmd implements CmdProcessor {

	@Override
	public void execute(List<String> cmd) throws Exception {
		if (cmd.size() == 3) {
			int num = Integer.parseInt(cmd.get(2));
			ProcessFactory processFactory = new ProcessFactory();
			processFactory.startProcess(num);
			System.out.println(CmdUtils.welcomeInfo() + "已经成功启动了" + num + "个进程");
		}
	}

	@Override
	public void registerSource(Object source) throws Exception {
	}

}
