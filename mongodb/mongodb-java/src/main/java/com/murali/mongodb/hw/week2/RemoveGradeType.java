package com.murali.mongodb.hw.week2;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class RemoveGradeType {

	public static void main(String...args) throws UnknownHostException{
		DBCollection collection = createCollection();
		printCollection(collection);
	}
	
	private static void printCollection(DBCollection collection){
		System.out.println("Find All :");
		DBCursor cursor = collection.find(new BasicDBObject("type", "homework")).sort(new BasicDBObject("student_id", 1).append("score", 1));
		try{
			Integer tempStudentId = Integer.MIN_VALUE;
			while(cursor.hasNext()){
				DBObject obj = cursor.next();
				Integer studentId = (Integer)obj.get("student_id");
				
				if(studentId.intValue() != tempStudentId.intValue()){
					collection.remove(obj);
					tempStudentId = new Integer(studentId);
				}
				System.out.println(obj);
			}
		}
		finally{
			cursor.close();
		}
	}
	
	private static DBCollection createCollection() throws UnknownHostException{
		MongoClient client = new MongoClient("localhost", 27017);
		DB db = client.getDB("students");
		return db.getCollection("grades");
	}
}
