package com.murali.functional.java8lambdas.domain;

import java.util.stream.Stream;

public interface Performance {
    public String getName();
    public Stream<Artist> getMusicians();
    
}
