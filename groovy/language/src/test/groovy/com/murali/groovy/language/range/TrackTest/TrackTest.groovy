package com.murali.groovy.language.range.TrackTest

import com.murali.groovy.language.range.Track
import com.murali.groovy.language.range.TrainStation

class TrackTest extends GroovyTestCase {
    Track acela
     
    TrainStation bos = new TrainStation(name:'Boston')
    TrainStation nh = new TrainStation(name:'New Haven')
    TrainStation ny = new TrainStation(name:'New York')
    TrainStation ph = new TrainStation(name:'Philadelphia')
    TrainStation dc = new TrainStation(name:'Washington')
     
    void setUp() throws Exception{
        acela = new Track()
        acela.addStation(bos)
        acela.addStation(nh)
        acela.addStation(ny)
        acela.addStation(ph)
        acela.addStation(dc)
    }
     
    void testVisitOneStation() {
        def expected = [bos].toArray()
        def result = acela.visitStations(bos,bos).toArray()
        assertArrayEquals(expected,result)
    }
     
    void testVisitTwoStations() {
        def expected = [bos,nh].toArray()
        def result = acela.visitStations(bos,nh).toArray()
        assertArrayEquals(expected,result)
    }
     
    void testVisitManyStations(){
        def acela_sb = [bos, nh, ny, ph, dc]
        def result = acela.visitStations(bos,dc)
        assertArrayEquals(acela_sb.toArray(),result.toArray())
         
        def acela_nb = [dc, ph, ny, nh, bos]
        result = acela.visitStations(dc,bos)
        assertArrayEquals(acela_nb.toArray(),result.toArray())
    }   
}
