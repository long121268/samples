package cn.jit.com.zookeeper;

import java.util.List;

import cn.jit.com.cmd.CmdProcessor;

/**
 * 帮助命令的实现
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class ZooKeeperHelpCmd implements CmdProcessor {

	@Override
	public void execute(List<String> cmd) throws Exception {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("当前支持的所有命令如下所示：");
		System.out.println("    help ：列出所有支持的命令。");
		System.out.println("    start -n num ：启动num个进程，例如 [start -n 5]代表启动5个进程。");
		System.out.println("    stop -a ： 销毁所有进程。");
		System.out.println("    stop -p pid ： 销毁指定的进程，例如[stop -p 4356]销毁id为4356的进程。");
		System.out.println("    get path ： 获得指定路径的内容，例如[get /config/monitor]获得该节点的内容。");
		System.out.println("    set path data ： 修改指定路径的内容，例如[set /config/monitor {\"logLevel\":\"debug\"}]修改日志级别为debug。");
	}
	
	public static void main(String[] args) throws Exception{
		new ZooKeeperHelpCmd().execute(null);
	}

	@Override
	public void registerSource(Object source) throws Exception {
	}
}
