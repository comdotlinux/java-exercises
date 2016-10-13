package com.linux.test.staticblock;

public class ClassOther extends ClassOne{
	static{
		System.out.println("Static - ClassOther");
	}
	
	ClassOther(){
		System.out.println("Constructor - ClassOther");
	}
	
	@Override
	void sayTheWord(String word){
		System.out.println(this.getClass().getSimpleName() + " said The Word is : " + word);
	}
}
