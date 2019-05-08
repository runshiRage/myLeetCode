package com.winding_month.java8;

@FunctionalInterface
public interface Defaulable {

	String invoke();
	
	/** java8 才有的接口默认方法 */
	default String defInvoke() {
		return "this is the default method invoke..";
	};
	
}



