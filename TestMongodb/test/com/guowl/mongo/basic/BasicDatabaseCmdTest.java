package com.guowl.mongo.basic;

import org.junit.Assert;
import org.junit.Test;

import com.mongodb.CommandResult;
import com.mongodb.DB;

public class BasicDatabaseCmdTest {
	private static DB	db	= MongoTestUtils.admindb;

	@Test
	public void should_return_correct_db_info() {
		CommandResult result = db.command("listDatabases");
		Assert.assertTrue(result.ok());
	}
}
