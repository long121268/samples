package cn.jit.com.cmd;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.List;

public class CmdUtils {
	/**
	 * 对输入的命令进行格式化，去掉多余的空格，以字符list的方式返回
	 * 
	 * @param cmd
	 *            输入的命令
	 * @return 把命令拆分成字符list返回
	 */
	public static List<String> format(String cmd) {
		List<String> cmdList = new ArrayList<String>();
		if (cmd == null || cmd.trim().length() == 0) {
			return cmdList;
		}

		String[] cmdArray = cmd.split(" ");
		for (int i = 0; i < cmdArray.length; i++) {
			if (!cmdArray[i].trim().equals("")) {
				cmdList.add(cmdArray[i]);
			}
		}

		return cmdList;
	}
	
	/**
	 * 开始输入控制台命令前的提示信息
	 * @return
	 */
	public static String welcomeInfo(){
		RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();  
        String name = runtime.getName(); 
        return "[" + name + "]#";
	}
	
	// 获得进程id
	public static int getPid() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();  
        String name = runtime.getName(); 
        try {  
            return Integer.parseInt(name.substring(0, name.indexOf('@')));  
        } catch (Exception e) {  
            return -1;  
        }  
    }  
}
