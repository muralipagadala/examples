package com.murali.mongodb;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class SparkFreemarker {

	public static void main(String...args){
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFreemarker.class, "/");
		
		Spark.get(new Route("/"){
			@Override
			public Object handle(final Request request, final Response response) {
				Template template;
				StringWriter writer = new StringWriter();
				try {
					template = configuration.getTemplate("hello.ftl");
					Map<String, Object> data = new HashMap<String,Object>();
					data.put("name", "Mongodb");
					template.process(data, writer);
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
