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

public class DotNotationTest {

	public static void main(String...args) throws UnknownHostException{
		MongoClient client = new MongoClient("localhost", 27017);
		DB db = client.getDB("course");
		DBCollection collection = db.getCollection("doNotationTest");
		
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
		
		
		QueryBuilder builder = new QueryBuilder().start("start.x").greaterThan(50);	
		
		System.out.println("Find All :");
		DBCursor cursor = collection.find(builder.get(), new BasicDBObject("start.y", true));
		try{
			while(cursor.hasNext()){
				DBObject obj = cursor.next();
				System.out.println(obj);
			}
		}
		finally{
			cursor.close();
		}
		System.out.println("Find Count :"+collection.count(builder.get()));
	}
}
