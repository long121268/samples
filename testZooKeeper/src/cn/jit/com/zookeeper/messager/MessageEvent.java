package cn.jit.com.zookeeper.messager;

import java.util.Map;

public class MessageEvent {
	private String		key;
	private IMessager	messager;

	public MessageEvent(String key, IMessager messager) {
		this.key = key;
		this.messager = messager;
	}

	public String getKey() {
		return key;
	}

	public IMessager getMessager() {
		return messager;
	}

	public byte[] getChangeData() {
		return messager.getData(key);
	}

	public <T> T getChangeData(Class<T> className) {
		return messager.getData(key, className);
	}

	public Map<String, byte[]> getChildren() {
		return messager.getChildren(key);
	}

	public <T> Map<String, T> getChildren(Class<T> className) {
		return messager.getChildren(key, className);
	}
}
