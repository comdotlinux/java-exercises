package com.rhcloud.test.staticblock;

public class A {
	static{
		System.out.println("Static - A");
	}
	
	A(){
		System.out.println("Constructor - A");
	}
	
	void sayTheWord(String word){
		System.out.println(this.getClass().getSimpleName() + " said The Word is : " + word);
	}
}
