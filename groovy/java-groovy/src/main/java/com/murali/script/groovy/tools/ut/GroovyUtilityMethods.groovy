package com.murali.script.groovy.tools.ut

class GroovyUtilityMethods implements UtilityMethods {

	@Override
	int[] getPositives(int... values){
		values.findAll{ it > 0}
	}
	
	@Override
	public boolean isPrime(int x) {
		if (x < 0) throw new IllegalArgumentException('argument must be > 0')
		if (x == 2) return true
		/*(2..< Math.sqrt(x) + 1).each { 
			num ->
			if (x % num == 0) 
				return false // DANGER! THIS IS A BUG!
		}
		return true*/

		for (num in 2..< Math.sqrt(x) + 1) {
			if (x % num == 0) {
				return false
			}
		}
		return true
	}
	
	@Override
	public boolean isPalindrome(String s){
		String str = s.toLowerCase().replaceAll(/\W/,'')
		str.reverse() == str
	}
	
	
	
}
