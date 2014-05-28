package com.guowl.websocket;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientEndpoint
public class WebSocketClient {
	private static Logger logger = LoggerFactory.getLogger(WebSocketClient.class);
	@OnOpen
    public void onOpen(Session session) {
		logger.info("Connected to endpoint: WebSocketClient" );
        try {
            session.getBasicRemote().sendText("Hello");
        } catch (IOException ex) {
        }
    }
 
    @OnMessage
    public void onMessage(String message) {
        System.out.println(message);
    }
 
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
