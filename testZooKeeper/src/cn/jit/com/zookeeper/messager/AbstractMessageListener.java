package cn.jit.com.zookeeper.messager;

public abstract class AbstractMessageListener implements IMessageListener {
	@Override
	public boolean stopListen() {
		return false;
	}

	@Override
	public void onChange(MessageEvent event) {}

	@Override
	public void onChildrenChange(MessageEvent event) {}
}
