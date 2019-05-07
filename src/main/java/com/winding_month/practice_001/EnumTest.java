package com.winding_month.practice_001;

/** 枚举方法获取单例 
 * 	枚举中的属性都是一个枚举实例，在枚举中定义的实例方法可以用过这些实例进行调用
 * 	实例也能对实例方法进行重写，达到对某个实例的定制化。
 * */
public class EnumTest {

	public static void main(String[] args) {
		
		System.out.println(type.B.getStr());
		/** type.A  是一个枚举的实例 */
		System.out.println(type.A.getStr());
		
		type.getNum();
		
		/** 这是一个单例 */
		System.out.println(single.INSTANCE.getInstance());
	}
}

enum type {
	
	/** 枚举属性 */
	A {
		public String getStr(){
			return "aaaa";
		}
	},B,C,D;
	
	/** 类方法 */
	static int num;
	public static int getNum(){
		return num;
	}
	
	/** 实例方法 */
	String str;
	public String getStr(){
		return str;
	}
}


enum single{
	
	INSTANCE;
	
	private EnumTest instance;
	
	single(){
		instance = new EnumTest();
	}
	
	public EnumTest getInstance(){
		return instance;
	}
	
}
