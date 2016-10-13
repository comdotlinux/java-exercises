package com.linux.test.equalshascodetest;

class A{
	private final int varA;

	A(int varA){
		this.varA = varA;
	}
	
	public int getVarA() {
		return varA;
	}

	@Override
	public boolean equals(Object o){
		if(this == o)
			return true;
		else if(null == o || this.getClass() != o.getClass())
			return false;
	
		A a = (A) o;
		return a.varA == varA;
	}
}