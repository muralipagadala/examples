package com.murali.basics;

public class DefaultMethod {
	public static void main(String... args) {
		NormalInterface iface = new NormalInterfaceImpl();
		iface.myDefaultMethod();
		iface.myNormalMethod();
	}
}

interface NormalInterface {
	public void myNormalMethod();

	public default void myDefaultMethod() {
		System.out.println("-> myDefaultMethod");
	}
}

class NormalInterfaceImpl implements NormalInterface {
	@Override
	public void myNormalMethod() {
		System.out.println("-> myNormalMethod");
	}
}