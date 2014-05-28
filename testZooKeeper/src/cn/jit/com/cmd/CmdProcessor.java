package cn.jit.com.cmd;

import java.util.List;

/**
 * 命令行执行工具
 * 
 * @author guowl
 * @since 2014-1-6
 */
public interface CmdProcessor {
	/**
	 * 执行命令
	 * 
	 * @param cmd
	 *            以list的方式存储命令及命令的参数
	 */
	public void execute(List<String> cmd) throws Exception;
	
	/**
	 * 注册资源，如果在执行cmd的时候需要资源，可以通过该接口进行注册
	 * @param source 资源
	 * @throws Exception
	 */
	public void registerSource(Object source) throws Exception;
}
