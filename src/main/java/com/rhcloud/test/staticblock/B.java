package com.rhcloud.test.staticblock;

public class B extends A{
	static{
		System.out.println("Static - B");
	}
	
	B(){
		System.out.println("Constructor - B");
	}
	
	@Override
	void sayTheWord(String word){
		System.out.println(this.getClass().getSimpleName() + " said The Word is : " + word);
	}
}
