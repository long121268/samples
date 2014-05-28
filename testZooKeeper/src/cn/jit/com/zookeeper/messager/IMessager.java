package cn.jit.com.zookeeper.messager;

import java.util.Map;

public interface IMessager {
	public boolean existData(String key);

	public byte[] getData(String key);

	public <T> T getData(String key, Class<T> className);

	public void putData(String key, byte[] data, boolean persistent);

	public <T> void putData(String key, T t, boolean persistent);

	public void registListener(String key, IMessageListener listener);
	
	public void reRegistListener();

	public abstract Map<String, byte[]> getChildren(String key);

	public <T> Map<String, T> getChildren(String key, Class<T> className);

	public void removeData(String key);

	public void removeDataCascade(String key);
}
