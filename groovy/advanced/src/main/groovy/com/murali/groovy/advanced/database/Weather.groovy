package com.murali.groovy.advanced.database


import groovy.sql.Sql
import com.mysql.jdbc.*

def sql = Sql.newInstance('jdbc:mysql://localhost:3306/weather', 'murali', 'murali', 'com.mysql.jdbc.Driver')
	
println sql.connection.catalog

processMeta = { metaData ->
	metaData.columnCount.times{ i ->
		printf "%-21s", metaData.getColumnLabel(i+1)
	}
	println ""	
}

sql.eachRow('Select * from weather', processMeta) {
	printf "%-20s%s\n", it.city, it[1]
}

rows = sql.rows('Select * from weather')
println "Weather information available for ${rows.size()} cities"

builder = new groovy.xml.MarkupBuilder()

builder.weather{
	sql.eachRow('Select * from weather'){
		city(name:it.city, temperature:it.temperature)
	}
}

println ''

dataSet = sql.dataSet('weather')
citiesBelowFreezing = dataSet.findAll{ it.temperature < 32}
citiesBelowFreezing.each{
	println it.city
}

println "Number of cities :"+sql.rows('select * from weather').size()
dataSet.add(city:'Denver', temperature:19)
println "Number of cities :"+sql.rows('select * from weather').size()

temperature = 50
sql.executeInsert("""INSERT INTO weather (city, temperature) VALUES ('Oklahoma City', ${temperature})""")
println sql.firstRow("SELECT temperature from weather WHERE city='Oklahoma City'")