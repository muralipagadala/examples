class MyBean implements Serializable{
	def untyped
	String typed
	def item1, item2
	def assigned = 'assigned value'
}

def myBean = new MyBean()
assert myBean.getAssigned() == 'assigned value'
assert null == myBean.getUntyped()
myBean.setUntyped('untyped value')
assert 'untyped value' == myBean.getUntyped()

myBean = new MyBean(typed:'Typed')
assert 'Typed' == myBean.getTyped()

myBean = [untyped:'untyped', typed:'typed', item1:'item1', item2:'item2', assigned:'assigned']
assert myBean['untyped'] == 'untyped'
assert myBean['typed'] == 'typed'

class DoublerBean{
	public value
	
	void setValue(value){
		this.value = value;
	}
	
	def getValue(){
		value * 2
	}
}

def doubler = new DoublerBean(value:100)
assert 100 == doubler.@value
assert 200 == doubler.value
