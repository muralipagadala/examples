package com.murali.mongodb;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTemplate {
	public static void main(String...args) throws IOException, TemplateException{
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(FreeMarkerTemplate.class, "/");
		
		Template template = configuration.getTemplate("hello.ftl");
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("name", "Mongodb");
		StringWriter writer = new StringWriter();
		template.process(data, writer);
		System.out.println(writer);
	}
}
