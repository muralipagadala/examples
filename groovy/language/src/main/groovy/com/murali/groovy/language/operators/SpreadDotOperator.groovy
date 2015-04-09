def map = [a:"apple", o:"orange", p:"pear"]
def keys = ["a", "o", "p"]
def values = ["apple", "orange", "pear"]

assert map.collect{ it.key } == keys
assert map.collect{it.value} == values

assert map*.key == keys
assert map*.value == values