package com.murali.basics.types.collective

class Weekday implements Comparable{
	static final DAYS = 
		['Sunday', 'Monday', 'Tuesday', 'Thursday', 'Friday', 'Saturday']
	
	private Integer index
	
	Weekday(String day){
		index = DAYS.indexOf(day);
	}
	
	Weekday next(){
		return new Weekday(DAYS[index+1])
	}
	
	Weekday previous(){
		return new Weekday(DAYS[index-1])
	}

	@Override
	public int compareTo(Object o) {
		return this.index <=> o.index;
	}
	
	String toString(){
		return DAYS[index]
	}
	
	static void main(args){
		def sun = new Weekday('Sunday')
		def sat = new Weekday('Saturday')
		
		for(day in sun..sat){
			println day
		}
		println ''
		(sat..sun).each{day -> println day}
	}
}
