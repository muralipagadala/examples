MetaClass mc = String.metaClass
final Object[] NO_ARGS = []
assert 1 == mc.respondsTo("toString", NO_ARGS).size()
mc.properties.each{property -> println property}

assert 3 == mc.properties.size()
assert 74 == mc.methods.size()
assert 250 == mc.metaMethods.size()

assert "" == mc.invokeMethod("","toString", NO_ARGS)
assert null == mc.invokeStaticMethod(String, "println", NO_ARGS)
assert "" == mc.invokeConstructor(NO_ARGS)


//----------------Add method to class

Integer.metaClass.static.answer = { -> 42 }
assert 42 == Integer.answer()

class MySuperGroovy{}
class MySubGroovy extends MySuperGroovy{}
MySuperGroovy.metaClass.added = {-> true}
assert new MySubGroovy().added()