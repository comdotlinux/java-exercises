package com.linux.test.staticblock;

public class ClassOne {
	static{
		System.out.println("Static - ClassOne");
	}
	
	ClassOne(){
		System.out.println("Constructor - ClassOne");
	}
	
	void sayTheWord(String word){
		System.out.println(this.getClass().getSimpleName() + " said The Word is : " + word);
	}
}
