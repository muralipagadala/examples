package com.murali.script.groovy.json

import groovy.json.JsonSlurper

def url = 'http://api.icndb.com/jokes/random?limitTo=[nerdy]'
String jsonText = url.toURL().text
def json = new JsonSlurper().parseText(jsonText)
def joke = json?.value?.joke
println joke