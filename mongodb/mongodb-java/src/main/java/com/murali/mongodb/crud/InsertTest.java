package com.murali.mongodb.crud;

import java.net.UnknownHostException;
import java.util.Arrays;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class InsertTest {

	public static void main(String...args) throws UnknownHostException{
		MongoClient client = new MongoClient("localhost", 27017);
		DB db = client.getDB("course");
		DBCollection collection = db.getCollection("insertTest");
		collection.drop();
		DBObject doc = new BasicDBObject().append("x", 1);
		//DBObject doc2 = new BasicDBObject().append("_id", new ObjectId()).append("y", 2);
		//collection.insert(Arrays.asList(doc, doc2));
		collection.insert(doc);
		doc.removeField("_id");
		collection.insert(doc);
		
		System.out.println("Successfully inserted two documents.");
		
	}
}
