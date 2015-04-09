package com.murali.mongodb.crud;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class FindAndModifyTest {

	public static void main(String...args) throws UnknownHostException{
		DBCollection collection = createCollection();
		collection.drop();
		
		final String counterId = "abc";
		int first;
		int numNeeded;
		
		numNeeded = 2;
		first = getRange(counterId, numNeeded, collection);
		System.out.println("Range "+first + "-" +(first + numNeeded - 1));
		
		numNeeded = 3;
		first = getRange(counterId, numNeeded, collection);
		System.out.println("Range "+first + "-" +(first + numNeeded - 1));
		
		numNeeded = 10;
		first = getRange(counterId, numNeeded, collection);
		System.out.println("Range "+first + "-" +(first + numNeeded - 1));
		
		printCollection(collection); 
	}
	
	private static int getRange(String id, int range, DBCollection collection){
		DBObject doc = collection.findAndModify(
				new BasicDBObject("_id", id),
				null,
				null,
				false,
				new BasicDBObject("$inc", new BasicDBObject("counter", range)),
				true,
				true
		);
		return (Integer)doc.get("counter") - range +1 ;
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
		return db.getCollection("findModifyTest");
	}
}
