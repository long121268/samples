package com.guowl.mongo.basic;

import org.junit.Assert;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class BasicCRUDTest {
	private static DBCollection	coll	= MongoTestUtils.coll;

	@Test
	public void should_find_one_result_when_insert_one_data() {
		int id = 1;
		insertData(id);

		DBObject query = new BasicDBObject();
		query.put("id", id);
		Assert.assertEquals(1, coll.count(query));
	}

	@Test
	public void should_update_success_when_update_data() {
		int id = 2;
		insertData(id);

		DBObject query = new BasicDBObject();
		query.put("id", id);
		DBObject update = coll.findOne(query);
		update.put("place", "bei jing");
		coll.update(query, update);

		DBObject result = coll.findOne(query);
		Assert.assertEquals("bei jing", result.get("place").toString());
	}

	@Test
	public void should_update_success_when_add_attr() {
		int id = 3;
		insertData(id);

		DBObject query = new BasicDBObject();
		query.put("id", id);
		DBObject update = coll.findOne(query);
		update.put("favorities", "周星驰全集");
		coll.update(query, update);

		DBObject result = coll.findOne(query);
		Assert.assertEquals("周星驰全集", result.get("favorities").toString());
	}

	private void insertData(int id) {
		DBObject data = new BasicDBObject();
		data.put("id", id);
		data.put("name", "guowl" + id);
		data.put("place", "fu ping");
		data.put("age", 30);
		coll.insert(data);
	}

}
