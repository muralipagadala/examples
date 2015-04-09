package com.murali.mongodb.crud;

import java.net.UnknownHostException;
import java.util.Random;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class FindTest {

	public static void main(String...args) throws UnknownHostException{
		MongoClient client = new MongoClient("localhost", 27017);
		DB db = client.getDB("course");
		DBCollection collection = db.getCollection("findTest");
		
		collection.drop();
		
		for(int i = 0; i < 10; i++){
			collection.insert(new BasicDBObject().append("x", new Random().nextInt(100)));
		}
		
		System.out.println("Find One :");
		DBObject doc = collection.findOne();
		System.out.println("One Document :"+doc);
		
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
		System.out.println("Find Count :"+collection.count());
	}
}
