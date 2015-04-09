def input = new File('input file')
assert input.exists(), "Cannot find '$input.name'"
assert input.canRead(), "Cannot read '$input.canonicalPath'"
println input.text