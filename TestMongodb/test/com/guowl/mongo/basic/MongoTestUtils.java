package com.guowl.mongo.basic;

import com.guowl.mongo.connector.MongoDBConnector;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoTestUtils {
	public static Mongo		mongo;
	public static DB			db;
	public static DB			admindb;
	public static DBCollection	coll;

	static {
		mongo = MongoDBConnector.getMongo();
		db = mongo.getDB("BasicCRUDTest");
		admindb = mongo.getDB("admin");
		try {
			coll = db.getCollection("users");
			// 清空数据
			coll.drop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
