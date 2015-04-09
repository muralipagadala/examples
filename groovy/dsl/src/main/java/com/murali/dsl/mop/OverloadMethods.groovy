package com.murali.dsl.mop

String.metaClass.blanked = { delegate.replaceAll(/./) {'%'} }
String.metaClass.blanked = { delegate.replaceAll(/./) {'@'} }
String.metaClass.blanked = { delegate.replaceAll(/./) {'*'} }
assert "A String".blanked() == "********"

String.metaClass.static.valueAndType = { String s -> 'Murali' }
//String.metaClass.static.valueAndType = { 'Murali' }
assert String.valueAndType() == 'Murali'

String.metaClass.static.valueAndType = { double d -> "${d.class.name}:${valueOf(d)}" }
String.metaClass.static.valueAndType = { float f -> "${f.class.name}:${valueOf(f)}" }
String.metaClass.static.valueAndType = { int i -> "${i.class.name}:${valueOf(i)}" }
String.metaClass.static.valueAndType = { long l -> "${l.class.name}:${valueOf(l)}" }


assert String.valueAndType(1.0) == "java.lang.Double:1.0"
assert String.valueAndType(3.333f) == "java.lang.Float:3.333"
assert String.valueAndType(101) == "java.lang.Integer:101"
assert String.valueAndType(1000000L) == "java.lang.Long:1000000"