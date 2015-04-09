package com.murali.script

import static org.testng.Assert.*
import com.murali.script.groovy.pogo.Department
import com.murali.script.groovy.pogo.Employee
import spock.lang.Specification

class DepartmentSpec extends Specification{

	private Department dept;
	
	def setup(){ 
		dept = new Department(name:'IT')
	}
	
	def "add employee to dept should increase total by 1"(){
		given:Employee fred = [id:1, name:'Fred']
		when :dept = dept + fred
		then :dept.employees.size() == old(dept.employees.size())+ 1
	}
	
	/*def "add two employees via chained plus"(){
		given : "two employees"
		def fred = [id:1, name:'Fred'] as Employee
		def barney = [id:2, name:'Barney'] as Employee
		
		when : "adding them dept via chained plus"
		dept = dept + fred + barney
		
		then: "dept will have 2 employees"
		dept.employees.size() == 2
	}
	
	def "remove employee from dept should reduce 1"(){
		given : def fred = [id:1, name:'Fred'] as Employee
		when : dept.hire fred
		       dept - fred
	    then : assert dept.employees.size() == old(dept.employees.size()) -1
	}
	
	
	def "remove two employees via chained minus"(){
		given :
		def fred = [id:1, name:'Fred'] as Employee
		def barney = [id:2, name:'Barney'] as Employee
		when : 
		dept.hire fred
		dept.hird barney
		dept = dept - fred - barney
		then :
		dept.employees.size() == 0
	}
	
	def "left shift should increase employee total by 1"() {
		given :
		def fred = [id:1, name:'Fred']
		when:
		dept = dept << fred
		then:
		dept.employees.size() == 1
	}
	
	def "add two employees via chained left shift"() {
		given : "two employees"
		def fred = [id:1, name:'Fred'] as Employee
		def barney = [id:2, name:'Barney'] as Employee
		
		when : "adding them dept via chained plus"
		dept = dept << fred << barney
		
		then: "dept will have 2 employees"
		dept.employees.size() == 2
	}*/
}
