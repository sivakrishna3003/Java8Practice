package com.example.demo.interfaces;

@FunctionalInterface
public interface Interf {

	void m1();

	default void m2(int i) {
		System.out.println("Default method");
	}

	
	static void m3() {
		System.out.println("Static method");
	}
}
