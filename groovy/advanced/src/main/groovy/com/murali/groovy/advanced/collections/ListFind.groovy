package com.murali.groovy.advanced.collections

lst = [1, 3, 4, 1, 8, 9, 2, 6]

println lst.find{ it == 2 }
println lst.find{ it > 4}

println lst.findAll{it == 2}