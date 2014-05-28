package cn.jit.com.zookeeper.start;

import org.apache.zookeeper.server.quorum.QuorumPeerMain;

/**
 * 启动zookeeper服务
 * 
 * @author guowl
 * @since 2014-1-20
 */
public class ZooKeeperStartService {
	public static void main(String[] args) {
		QuorumPeerMain main = new QuorumPeerMain();
            try {
            	String[] config = {"E:/work/zookeeper-3.4.5/conf/zoo.cfg"};
            	main.main(config);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	}
}
