package com.murali.functional.java8lambdas.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Album implements Performance{
    
    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);

        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.musicians = new ArrayList<>(musicians);
    }
    
     public String getName() {
        return name;
    }

   
    public Stream<Track> getTracks() {
        return tracks.stream();
    }

    public List<Track> getTrackList() {
        return unmodifiableList(tracks);
    }

    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }

   
    public List<Artist> getMusicianList() {
        return unmodifiableList(musicians);
    }

    public Artist getMainMusician() {
        return musicians.get(0);
    }
    
     public Album copy() {
        List<Track> tracks = getTracks().map(Track::copy).collect(Collectors.toList());
        List<Artist> musicians = getMusicians().map(Artist::copy).collect(Collectors.toList());
        return new Album(name, tracks, musicians);
    }
}
