package com.linux.test.equalshascodetest;

class B{
	private final int varB;

	B(int varA){
		this.varB = varA;
	}
	
	public int getVarA() {
		return varB;
	}

	@Override
	public boolean equals(Object o){
		if(this == o)
			return true;
		else if(null == o || this.getClass() != o.getClass())
			return false;
	
		B a = (B) o;
		return a.varB == varB;
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.varB;
        return hash;
    }
	
	
}