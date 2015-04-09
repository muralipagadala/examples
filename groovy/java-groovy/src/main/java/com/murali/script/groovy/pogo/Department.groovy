package com.murali.script.groovy.pogo

class Department {
	private Integer id;
	private String name;
	private Map<Integer, Employee> empMap = 
						new HashMap<Integer, Employee>();
						
	public Collection<Employee> getEmployees() { 
		return empMap.values(); 
	}
	
	public void hire(Employee e) { 
		empMap.put(e.getId(), e)
	}
	public void layOff(Employee e) {
		 empMap.remove(e.getId())
	}
	public Department plus(Employee e) {
		hire(e);
		return this;
	}
	
	public Department minus(Employee e) {
		layOff(e);
		return this;
	}
	public Department leftShift(Employee e) {
		hire(e);
		return this;
	}
}
