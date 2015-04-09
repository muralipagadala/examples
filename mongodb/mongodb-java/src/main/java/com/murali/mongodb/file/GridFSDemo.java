package com.murali.mongodb.file;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

public class GridFSDemo {

	public static void main(String...args) throws IOException{
		DB db =  getDatabase();
		DBCollection collection = createCollection(db);
		
		
		GridFS gridFS = new GridFS(getDatabase());
		GridFSInputFile inputFile = gridFS.createFile(getFile());
		inputFile.save();
	}
	
	
	private static File getFile(){
		File file = new File("C:/examples/mongodb/mongodb-java/src/main/resources/input/files/wildlife.wmv");
        return file;
	}
	
	private static DBCollection createCollection(DB db) throws UnknownHostException{
		return db.getCollection("documents");
	}
	
	private static DB getDatabase() throws UnknownHostException{
		MongoClient client = new MongoClient("localhost", 27017);
		DB db = client.getDB("myfiles");
		return db;
	}
}
