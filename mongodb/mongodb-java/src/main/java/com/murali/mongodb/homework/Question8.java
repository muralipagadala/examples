package com.murali.mongodb.homework;

import java.io.IOException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Question8 
{
        public static void main(String[] args) throws IOException 
        {
        	MongoClient c =  new MongoClient(new MongoClientURI("mongodb://mongoroot:talent123@localhost"));
            DB db = c.getDB("blog");
            DBCollection animals = db.getCollection("animals");

            BasicDBObject animal = new BasicDBObject("animal", "monkey");

            animals.insert(animal);
            animal.removeField("animal");
            animal.append("animal", "cat");
            animals.insert(animal);
            animal.removeField("animal");
            animal.append("animal", "lion");
            animals.insert(animal);
        }
}