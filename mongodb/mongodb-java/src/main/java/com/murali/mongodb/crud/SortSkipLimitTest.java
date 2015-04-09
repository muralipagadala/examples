package com.murali.mongodb.crud;

import java.net.UnknownHostException;
import java.util.Random;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

public class SortSkipLimitTest {

	public static void main(String...args) throws UnknownHostException{
		MongoClient client = new MongoClient("localhost", 27017);
		DB db = client.getDB("course");
		DBCollection collection = db.getCollection("sortSkipTest");
		
		collection.drop();
		Random random = new Random();
		for(int i = 0; i < 10; i++){
			collection.insert(new BasicDBObject("_id", i )
								.append("start", 
										new BasicDBObject("x", random.nextInt(90) + 10)
												  .append("y", random.nextInt(90) + 10)
								)
								.append("end", 
										new BasicDBObject("x", random.nextInt(90) + 10)
												  .append("y", random.nextInt(90) + 10)
								)
			);
		}
	
		
		System.out.println("Find All :");
		DBCursor cursor = collection.find().sort(new BasicDBObject("start.x", -1).append("start.y", -1)).skip(2).limit(5);
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
}
