package com.murali.functional.java8lambdas.chapter3;

import com.murali.functional.java8lambdas.domain.Artist;
import java.util.Iterator;
import java.util.List;

public class Iteration {
    public int externalCountArtistsFromLondon(List<Artist> allArtists) {
        int count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
        return count;
    }
    
    public int externalCountArtistsFromLondonExpanded(List<Artist> allArtists) {
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
        return count;
    }
    
    public long internalcountArtistsFromLondon(List<Artist> allArtists){
       return allArtists.stream()
                .filter(artist -> artist.isFrom("London"))
                .count();
    }
}
