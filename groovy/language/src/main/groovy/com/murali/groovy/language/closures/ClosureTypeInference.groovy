//http://melix.github.io/blog/2014/01/closure_param_inference.html
import groovy.transform.TypeChecked

/*void test(){
	assert ['foo', 'bar' , 'baz'].collect{ it.toUpperCase() } == ['FOO', 'BAR', 'BAZ']
}
*/
test()

@TypeChecked
void test(){
	assert ['foo', 'bar' , 'baz'].collect{ String it -> it.toUpperCase() } == ['FOO', 'BAR', 'BAZ']
}