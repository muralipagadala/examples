package com.murali.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkRoutes {
	
	public static void main(String...args){
		Spark.get(new Route("/"){
			@Override
			public Object handle(final Request request, final Response response) {
				return "Hello World";
			}
		});
		
		Spark.get(new Route("/test"){
			@Override
			public Object handle(final Request request, final Response response) {
				return "Hello World Test";
			}
		});
		
		Spark.get(new Route("/test/:thing"){
			@Override
			public Object handle(final Request request, final Response response) {
				return request.params(":thing");
			}
		});
	}
	
}
