package com.murali.mongodb;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongodbClient {

	public static void main(String...args)throws UnknownHostException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB database = mongoClient.getDB("course");
		DBCollection collection = database.getCollection("hello");
		
		DBObject helloDocument = collection.findOne();
		System.out.println("Document :"+helloDocument);
	}
}
	