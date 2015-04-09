package com.murali.mongodb.homework;

import java.io.IOException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Test_7 {
    
    public static void main(String[] args) throws IOException {
        MongoClient c =  new MongoClient(new MongoClientURI("mongodb://mongoroot:talent123@localhost"));
        DB db = c.getDB("blog");
        int i =0;
        DBCollection album = db.getCollection("albums");
        DBCollection image = db.getCollection("images");
        
        DBCursor cur = image.find();
        cur.next();
        
        while (cur.hasNext()){
            Object id = cur.curr().get("_id");
           DBCursor curalbum = album.find(new BasicDBObject("images", id));
           if(!curalbum.hasNext()){
               image.remove(new BasicDBObject("_id", id));
           }
           cur.next();
        }
    }
}

//db.albums.aggregate({$unwind:"$images"},{$group:{_id:null,sum:{$sum:"$images"},count:{$sum:1}}})
