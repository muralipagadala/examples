@Grab('commons-lang:commons-lang:2.6')
import org.apache.commons.lang.ClassUtils

class Outer {
	class Inner{
	}
}

assert ClassUtils.isInnerClass(Outer.Inner)
assert !ClassUtils.isInnerClass(Outer)
