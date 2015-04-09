package com.murali.mongodb.crud;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class UpdateTest {

	public static void main(String...args) throws UnknownHostException{
		DBCollection collection = createCollection();
		collection.drop();
		
		List<String> names = Arrays.asList("Alice", "Bob", "Cathy", "David", "Ethan");
		
		for(String name : names){
			collection.insert(new BasicDBObject("_id", name));
		}
		
		collection.update(new BasicDBObject("_id", "Alice"), new BasicDBObject("age", 24));
		//This will override the "age" field
		//collection.update(new BasicDBObject("_id", "Alice"), new BasicDBObject("gender", "F"));
		
		collection.update(new BasicDBObject("_id", "Alice"), 
				new BasicDBObject("$set", new BasicDBObject("gender", "F")));
		
		collection.update(new BasicDBObject("_id", "Frank"), 
				new BasicDBObject("$set", new BasicDBObject("gender", "M")), 
				true, 
				false);
		
		collection.update(new BasicDBObject(),
				new BasicDBObject("$set", new BasicDBObject("title", "Dr")), 
				false, 
				true);
		
		//collection.remove(new BasicDBObject());
		collection.remove(new BasicDBObject("_id", "Alice"));
		
		printCollection(collection);
	}
	
	private static void printCollection(DBCollection collection){
		System.out.println("Find All :");
		DBCursor cursor = collection.find();
		try{
			while(cursor.hasNext()){
				DBObject obj = cursor.next();
				System.out.println(obj);
			}
		}
		finally{
			cursor.close();
		}
	}
	
	private static DBCollection createCollection() throws UnknownHostException{
		MongoClient client = new MongoClient("localhost", 27017);
		DB db = client.getDB("course");
		return db.getCollection("updateTest");
	}
}
