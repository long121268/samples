package cn.jit.com.zookeeper.messager;

public interface IMessageListener {

	/**
	 * 是否停止监听。通过该方法对监听事件进行控制，可以从监听状态切换为停止监听状态，但是不能从停止监听状态切换为监听状态。
	 * 
	 * @return true：停止监听；false：继续监听。
	 */
	public boolean stopListen();

	public void onChange(MessageEvent event);

	public void onChildrenChange(MessageEvent event);
}
