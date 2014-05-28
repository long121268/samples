package com.guowl.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestWebSocket {
	private static Logger logger = LoggerFactory.getLogger(TestWebSocket.class);
	public Session session;

	protected void start() {
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		String uri = "ws://127.0.0.1:8080/TestWebSocket/websocket/dateservice";
//		String uri = "ws://127.0.0.1:8080/websocket";
		logger.info("Connecting to " + uri);
		try {
			session = container.connectToServer(WebSocketClient.class, URI.create(uri));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		TestWebSocket client = new TestWebSocket();
		client.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {
			do {
				input = br.readLine();
				if (!input.equals("exit"))
					client.session.getBasicRemote().sendText(input);
			} while (!input.equals("exit"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
