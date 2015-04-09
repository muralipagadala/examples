package com.murali.script

class ScriptShellTests extends GroovyShellTestCase{
	String base = 'src/main/groovy'
	
	void testChuckNorris(){
		shell.evaluate(new File("$base/chcuknorris.groovy"));
	}

	void testHelloWorld(){
		def content = new StringWriter()
		withBinding([out:new PrintWriter(content)]){
			shell.evaluate(new File("$base/helloworld.groovy"))
			assert "Hello, World!" == content.toString().trim()
		}
	}
	
	void testHelloName(){
		def content = new StringWriter()
		withBinding([out:new PrintWriter(content), name:'Dolly']){
			shell.evaluate(new File("$base/hello.groovy"))
			assert "Hello Dolly!" == content.toString().trim()

		}
	}
	
	void testAddition(){
		println '################################# testAddition #############################'
		def result = withBinding([x:4, y:5]){
			shell.evaluate(new File("$base/calc.groovy"))
			shell.context.z
		}
		
		assert 9 == result
	}
	
	void testLogScript(){
		Binding b = new Binding(x:3, y:4)
		GroovyShell shell = new GroovyShell(b)
		shell.evaluate(new File("$base/calc_with_logger.groovy"))
		println shell.context.z
	}
}
