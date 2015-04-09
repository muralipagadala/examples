package com.murali.groovy.advanced.collections

lst = [1, 3, 4, 1, 8, 9, 2, 6]
println lst
println lst.getClass().getName()

subLst = lst[2..5]
println subLst.dump()
subLst[0] = 55
println "After subLst[0]=55 lst = $lst"