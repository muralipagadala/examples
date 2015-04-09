import groovy.transform.Immutable

@Immutable
class Money{
	Integer amount
	String currency
	
	Money plus (Money other){
		if(other == null){
			return this
		}
		if(!(other.currency == currency)){
			throw new IllegalArgumentException("cannot add $other.currency to $currency")
		}
		return new Money(amount + other.amount, currency)
		
	}
	
	Money plus (Integer value){
		return new Money(amount + value, currency)
	}
}

Money buck = new Money(1, 'USD')
assert buck
assert buck == new Money(1, 'USD')

assert buck + buck == new Money(2, 'USD')