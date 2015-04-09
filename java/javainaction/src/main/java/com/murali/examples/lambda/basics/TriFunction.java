package com.murali.examples.lambda.basics;

public interface TriFunction<R, T, U, V> {

	R apply(T t, U u, V v);
}
