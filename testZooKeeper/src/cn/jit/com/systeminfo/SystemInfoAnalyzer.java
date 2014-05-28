package cn.jit.com.systeminfo;

/**
 * 系统情况分析表
 * 
 * @author guowl
 * @since 2014-1-3
 */
public class SystemInfoAnalyzer {
	/**
	 * 获得当前系统的资源信息
	 * 
	 * @return 返回当前系统的资源信息
	 */
	public SystemInfo getSystemInfo() {
		return new SystemInfo();
	}
}
