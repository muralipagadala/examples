package com.murali.script.groovy.gdk

def user = 'username'
def pwd  = 'passowrd'

def encoded = "$user:$pwd".getBytes().encodeBase64().toString()
println "$user:$pwd -> $encoded"
assert encoded == 'dXNlcm5hbWU6cGFzc293cmQ='
def(u,p) =	new String(encoded.decodeBase64()).split(':')
println "(u,p) = ($u,$p)"
assert user == u
assert pwd == p