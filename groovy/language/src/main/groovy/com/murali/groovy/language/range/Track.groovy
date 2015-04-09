package com.murali.groovy.language.range

class Track {
	List<TrainStation> stations = new LinkedList<TrainStation>()
	Track() {
		// all new stations need a boundary on each end
		stations.add(TrainStation.END)
	}

	void addStation(TrainStation ts) {
		// play with pointers to append the new station
		TrainStation last = stations.last()
		ts.previousStation = last
		ts.nextStation = TrainStation.END
		last.nextStation = ts

		// might as well store the stations, too
		stations.add(ts)
	}

	def visitStations(TrainStation from, TrainStation to) {
		def result = []
		for (station in (from..to)) {
			result << station
		}
		return result
	}

	String toString() {
		return stations.toString()
	}
}
