package com.winding_month.java8.impl;

import com.winding_month.java8.Defaulable;

class OverDefaulable implements Defaulable {

	@Override
	public String invoke() {
		return "over defaulable invoke...";
	}
	
	public String defInvoke() {
		return "this is the over method invoke..";
	};
	
}