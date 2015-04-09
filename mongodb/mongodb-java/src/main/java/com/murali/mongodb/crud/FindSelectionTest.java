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

public class FindSelectionTest {

	public static void main(String...args) throws UnknownHostException{
		MongoClient client = new MongoClient("localhost", 27017);
		DB db = client.getDB("course");
		DBCollection collection = db.getCollection("findSelectionTest");
		
		collection.drop();
		Random random = new Random();
		for(int i = 0; i < 10; i++){
			collection.insert(new BasicDBObject().append("x", 
					random.nextInt(2)).append("y",random.nextInt(100)).append("z",random.nextInt(1000)));
		}
		
		
		QueryBuilder builder = 
				new QueryBuilder().start("x").is(0).and("y").lessThan(90).and("y").greaterThan(10);	
		
		System.out.println("Find All :");
		//DBCursor cursor = collection.find(builder.get(), new BasicDBObject("x", false).append("_id", false));
		DBCursor cursor = collection.find(builder.get(), new BasicDBObject("y", true).append("_id", false));
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
