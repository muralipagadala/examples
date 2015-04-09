package com.murali.groovy.language.range

class TrainStation {
	public static final TrainStation END = new TrainStation(name:'END')
	String name
	TrainStation nextStation
	TrainStation previousStation


	TrainStation() {
		nextStation = END
		previousStation = END
	}

	TrainStation next() {
		nextStation
	}
	TrainStation previous() {
		previousStation
	}

	int compareTo(Object o) {
		boolean greater = false
		boolean lesser = false

		greater = isGreater(o)
		if (greater) {
			return 1
		}

		lesser = isLesser(o)
		if (lesser) {
			return -1
		}

		return 0
	}

	boolean isLesser(TrainStation ts) {
		if (this.equals(END)) {
			return false
		}

		if (this.next().equals(END)) {
			return false
		}

		if (this.next().equals(ts)) {
			return true
		}

		return nextStation.isLesser(ts)
	}

	boolean isGreater(TrainStation ts) {
		if (this.equals(END)) {
			return false
		}

		if (this.previous().equals(END)) {
			return false
		}

		if (this.previous().equals(ts)) {
			return true
		}

		return this.previous().isGreater(ts)
	}
	String toString() {
		name
	}

	boolean equals(Object o) {
		return this.name == o.name
	}

	int hashCode() {
		name.hashCode()
	}
}
