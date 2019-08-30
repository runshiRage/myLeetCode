package com.winding_month.java8;

import java.util.function.Supplier;

public interface DefaulableFactory {

	static Defaulable create(Supplier<Defaulable> supplier) {
		return supplier.get();
	}
	
}
