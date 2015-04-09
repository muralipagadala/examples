package com.murali.mongodb;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class MongoSparkFreemarker {

	public static void main(String...args) throws UnknownHostException{
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFreemarker.class, "/");
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB database = mongoClient.getDB("course");
		DBCollection collection = database.getCollection("users");
		
		final DBObject document = collection.findOne();
		
		Spark.get(new Route("/"){
			@Override
			public Object handle(final Request request, final Response response) {
				Template template;
				StringWriter writer = new StringWriter();
				try {
					template = configuration.getTemplate("hello.ftl");
					template.process(document, writer);
					System.out.println(writer);
				} catch (Exception e) {
					halt(500);
					e.printStackTrace();
				}
				return writer;
			}
		});
	}
}
