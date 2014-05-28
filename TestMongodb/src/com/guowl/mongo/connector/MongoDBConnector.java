package com.guowl.mongo.connector;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class MongoDBConnector {
	private static String	host	= "172.16.7.113";
	private static int		port	= 27017;
	private static MongoClient	mongo;

	public static MongoClient getMongo() {
		if (mongo == null) {
			mongo = createMongo();
		}
		return mongo;
	}

	public static MongoClient CreateMongo(String host, int port) {
		try {
			MongoClient mongo = new MongoClient(host, port);
			return mongo;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static MongoClient createMongo() {
		try {
			MongoClient mongo = new MongoClient(host, port);
			return mongo;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}
