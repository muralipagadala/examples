package com.murali.mongodb.hw.week3;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

public class RemoveGradesFromArray {

	public static void main(String...args) throws UnknownHostException{
		DBCollection collection = getCollection();
		printCollection(collection);
	}
	
	private static void printCollection(DBCollection collection){
		System.out.println("Find All :");
		DBCursor cursor = collection.find();
		try{
			while(cursor.hasNext()){
				DBObject obj = cursor.next();
				List<DBObject> scores = (List<DBObject>)obj.get("scores");
				
				
				BasicDBObject lowestHomeWork = getLowestHomework(scores);
				if(lowestHomeWork != null){
					System.out.println(obj.get("_id") +" --> "+lowestHomeWork);
					BasicDBObject match = new BasicDBObject("_id", obj.get("_id"));
					collection.update(match, new BasicDBObject("$pull", lowestHomeWork));
				}
			}
		}
		finally{
			cursor.close();
		}
	}
	
	private static BasicDBObject getLowestHomework(List<DBObject> scores){
		Double homework_1 = null;
		Double homework_2 = null;
		for(DBObject score : scores){
			if(homework_1 == null && "homework".equals(score.get("type"))){
				homework_1 = (Double)score.get("score");
			}
			if(homework_1 != null && "homework".equals(score.get("type"))){
				homework_2 = (Double)score.get("score");
			}
			
			if(homework_1 != null && homework_2 != null){
				if(homework_1.compareTo(homework_2) < 0 ){
					//return new BasicDBObject("scores", new BasicDBObject("homework", homework_1));
					return new BasicDBObject("scores", new BasicDBObject("type", "homework").append("score", homework_1));
				}else if(homework_1.compareTo(homework_2) > 0 ){
					//return new BasicDBObject("scores", new BasicDBObject("homework", homework_2));
					return new BasicDBObject("scores", new BasicDBObject("type", "homework").append("score", homework_2));
				}
			}	
		}
		return null;
	}
	
	
	private static DBCollection getCollection() throws UnknownHostException{
		MongoClient client = new MongoClient("localhost", 27017);
		DB db = client.getDB("school");
		return db.getCollection("students");
	}
	
	/**
	
	db.students.update(
		{ "_id" : 0},
		{$pull: {scores:
					{
						"type" : "homework",
						"score" : 6.676176060654615
					}
				}
		}
	)
	*/
}
