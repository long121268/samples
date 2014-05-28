package cn.jit.com.processmanager;

import cn.jit.com.systeminfo.SystemInfo;
import cn.jit.com.systeminfo.SystemInfoAnalyzer;

/**
 * 根据系统信息及其它信息分析初始化时需要启动的进程的数量
 * 
 * @author guowl
 * @since 2014-1-3
 */
public class ProcessNumAnalyzer {
	/**
	 * 分析初始化时需要启动的进程的数量
	 * 
	 * @return
	 */
	public int getProcessNum() {
		SystemInfoAnalyzer systemInfoAnalyzer = new SystemInfoAnalyzer();
		SystemInfo systemInfo = systemInfoAnalyzer.getSystemInfo();
		return getProcessNum(systemInfo);
	}

	// TODO 需要有具体的算法
	private int getProcessNum(SystemInfo systemInfo) {
		return 5;
	}
}
