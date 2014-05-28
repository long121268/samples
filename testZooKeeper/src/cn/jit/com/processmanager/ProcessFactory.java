package cn.jit.com.processmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对进程进行启动、关闭操作
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class ProcessFactory {
	private Process startProcess() {
		try {
			Process process = Runtime
					.getRuntime()
					.exec(
							"java -cp E:\\work\\workspace\\processManager_zooKeeper\\bin -Djava.ext.dirs=E:\\work\\workspace\\processManager_zooKeeper\\lib cn.jit.com.processmanager.ProcessCreator");
			return process;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Process> startProcess(int num) throws Exception {
		List<Process> processList = new ArrayList<Process>();
		if (num > 0) {
			for (int i = 0; i < num; i++) {
				Process process = startProcess();
				Thread.sleep(1000);
				processList.add(process);
			}
		}
		return processList;
	}
	
	public void stopProcessByPid(String pid) throws Exception {
		Runtime.getRuntime().exec("taskkill /pid " + pid + " /f");
	}
}
