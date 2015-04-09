package com.murali.groovy.advanced.collections

lst = [1, 3, 4, 1, 8, 9, 2, 6]

lst.each { println it }

def singles = [1, 2, 3]
assert [2, 4, 6] == singles.collect{ it * 2 } 