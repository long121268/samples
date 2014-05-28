package cn.jit.com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 控制台输出工具类
 * 
 * @author guowl
 * @since 2014-1-6
 */
public class ConsolePringter {
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public enum Level {
		ONE, TWO, THREE, FOUR, FIVE, SIX;
	}

	public static void beginPrintln() {
		System.out.println();
		System.out.println(format.format(new Date())
				+ ":----------------------------------------------------------------------------------");
	}

	public static void println(String message, Level level) {
		StringBuffer printContent = new StringBuffer();
		printContent.append(format.format(new Date()));
		printContent.append(":");
		printContent.append(buildPlaceholder(level));
		printContent.append(message);
		System.out.println(printContent.toString());
	}

	private static String buildPlaceholder(Level level) {
		int num = level.ordinal() + 1;
		StringBuffer placeholder = new StringBuffer();
		for (int i = 0; i < num; i++) {
			placeholder.append("----");
		}
		return placeholder.toString();
	}

	public static void endPrintln() {
		System.out.println(format.format(new Date())
				+ ":----------------------------------------------------------------------------------");
	}

	public static void main(String[] args) {
		beginPrintln();
		println("系统监控信息", Level.ONE);
		println("进程池中的进程数量发生了变更，当前的进程总数为：0", Level.TWO);
		endPrintln();
	}
}
