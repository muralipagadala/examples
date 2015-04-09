class Station implements Comparable<Station>{
	String name
	Station next
	Station previous
	int position
	
	Station next() { next }
    Station previous() { previous }
	public int compareTo(Station s) {
		this.position - s.position
	}
	
    String toString(){
        name
    }

	Station plus(Station s) {
		s.position = ++position
		s.previous = this
		this.next = s
		return s
	 }
	
}


Station dc = new Station(name:'DC')
Station phl = new Station(name:'PHL')
Station nyc = new Station(name:'NYC')
Station bos = new Station(name:'BOS')

dc + phl + nyc + bos

def northBound = (dc..bos)*.name
def southBound = (bos..dc)*.name

assert northBound == ['DC', 'PHL', 'NYC', 'BOS']
assert southBound == ['BOS', 'NYC', 'PHL', 'DC']