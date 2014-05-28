package cn.jit.com.systeminfo;

/**
 * 系统信息
 * 
 * @author guowl
 * @since 2014-1-3
 */
public class SystemInfo {
	private long cpu;
	private long memory;
	private long disk;

	public long getCpu() {
		return cpu;
	}

	public void setCpu(long cpu) {
		this.cpu = cpu;
	}

	public long getMemory() {
		return memory;
	}

	public void setMemory(long memory) {
		this.memory = memory;
	}

	public long getDisk() {
		return disk;
	}

	public void setDisk(long disk) {
		this.disk = disk;
	}

}
