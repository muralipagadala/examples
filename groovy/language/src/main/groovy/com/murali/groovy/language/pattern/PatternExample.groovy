def matcher = 'a b c' =~ /\S/
assert matcher[0] == 'a'
assert matcher[1..2] == ['b','c']
assert matcher.size() == 3

matcher = 'a:1 b:1 c:1'=~ /(\S+):(\S+)/

assert matcher.hasGroup()

assert matcher[0] == ['a:1', 'a', '1']