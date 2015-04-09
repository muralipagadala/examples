package com.murali.groovy.advanced.excel
/*
class TestBase extends GroovyTestCase {
  static String result
  
  void setUp() {
    result = ""
  }

  void runShellScript(scriptFileName) {
    result = "$scriptFileName".execute().text
  }
  
  void evaluateScript(scriptFileName) {
    result = "groovy $scriptFileName".execute().text
  }
  
  def runInGroovyShell(scriptFileName) {
    new GroovyShell().evaluate(new File(scriptFileName).text)
  }

  void runGradle(tasks) {
    result = "gradle -q $tasks".execute().text
  }

  void assertResultEquals(expected) {
    assertEquals(expected, result)
  }
  
  void assertResultMatchesFileContent(contentFile) {
    assertEquals(new File(contentFile).text, result)
  }
  
  void assertResultStartsWith(expected) {
    assertTrue result.startsWith(expected)
  }
  
  void assertResultContains(expected) {
    assertTrue result.replace('\n', '').contains(expected.replace('\n', ''))
  }
  
  void replaceAllObjectIDsInResult() {
    result = result.replaceAll("@[a-z0-9]+", "@")
  }
  
  void replaceDateInResultWithFormat() {
    result = result.trim().replaceAll(/\w\w\w \w\w\w \d\d \d\d:\d\d:\d\d \w\w\w \d\d\d\d/, "DAY MON DY HH:MM:SS TZN YYYY")
  }

  void assertResultDate() {
     assertResultEquals 'DAY MON DY HH:MM:SS TZN YYYY'
  }
}*/
