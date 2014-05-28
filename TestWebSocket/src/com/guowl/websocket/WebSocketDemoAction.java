package com.guowl.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guowl.dateservice.DateService;

@ServerEndpoint("/websocket/dateservice")
public class WebSocketDemoAction {
	private static Logger logger = LoggerFactory.getLogger(WebSocketDemoAction.class);
	private Session session;

	@OnOpen
	public void onOpen(Session session) {
		logger.info("open connection.");
		this.session = session;
	}

	@OnMessage
	public void onMessage(String message) {
		logger.info("on message.");
		logger.info("--msg from client :" + message);
		try {
			while(true){
				session.getAsyncRemote().sendText(DateService.getTime() + "");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnClose
	public void onClose(Session peer) {
		logger.info("on close.");
	}
}