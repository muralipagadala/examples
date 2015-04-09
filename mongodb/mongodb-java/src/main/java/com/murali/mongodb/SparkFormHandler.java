package com.murali.mongodb;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class SparkFormHandler {

	public static void main(String...args){
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFormHandler.class, "/");
		
		Spark.get(new Route("/"){
			@Override
			public Object handle(final Request request, final Response response) {
				Template template;
				StringWriter writer = new StringWriter();
				try {
					template = configuration.getTemplate("fruitPicker.ftl");
					Map<String, Object> data = new HashMap<String,Object>();
					data.put("fruits", Arrays.asList("Apple", "Grape", "Pineapple", "kiwi"));
					template.process(data, writer);
					System.out.println(writer);
				} catch (Exception e) {
					halt(500);
					e.printStackTrace();
				}
				return writer;
			}
		});
		
		Spark.post(new Route("/favorite_fruit"){

			@Override
			public Object handle(Request request, Response response) {
				final String fruit = request.queryParams("fruit");
				if(fruit != null){
					return "Your favorite fruit is :"+fruit;
				}else{
					return "Why don't you pick your fruit?";
				}
			}
			
		});
	}
}
