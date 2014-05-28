package com.guowl.mongo.preparedata;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.UUID;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class PrepareData {
	private static String		mongoIp		= "172.16.7.113";
	private static int			mongoPort	= 10000;
	private static DBCollection	coll;
	private static int			size_10_m	= 1000;
	private static int			size_100_m	= 10 * size_10_m;
	private static int			size_500_m	= 5 * size_100_m;
	private static int			size_800_m	= 80 * size_10_m;
	static {
		try {
			MongoClient mongo = new MongoClient(Arrays.asList(new ServerAddress(mongoIp, mongoPort)));
			coll = mongo.getDB("cloud-docs").getCollection("spreadsheets");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// int count = 1;
//		 int count = size_10_m;
		int count = size_100_m;
		// int count = size_500_m;
		// int count = size_800_m;
		System.out.println("start insert");
		String data = get10K();
		for (int i = 0; i < count; i++) {
			insert(i, data);
			System.out.println(">>>>>>inserting "  + i + " data");
		}
		System.out.println("insert "  + count  + " datas");
	}

	private static String get10K() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 1024 * 10; i++) {
			sb.append("s");
		}
		return sb.toString();
	}

	private static void insert(int i, String data) {
		DBObject user = new BasicDBObject();
		user.put("id", i);
		user.put("username", randomName());
		user.put("data", data);
		coll.insert(user);
	}

	private static String randomName() {
		String name = "";
		String uuid = UUID.randomUUID().toString();
		name = uuid.split("-")[0];

		return name;
	}
}
