package com.winding_month.java8.impl;

import com.winding_month.java8.Defaulable;
import com.winding_month.java8.DefaulableFactory;

public class Exec {

	public static void main(String[] args) {
		
		Defaulable defaulable = DefaulableFactory.create(DefDefaulable::new);
		System.out.println(defaulable.invoke());
		
		
		defaulable = DefaulableFactory.create(OverDefaulable::new);
		System.out.println(defaulable.invoke());
		
	}
}
