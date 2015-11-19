package com.jbpm.util;

public abstract class TestFa {
	
	private String name;
	
	protected TestFa(String name){
		System.out.println(name);
		this.name = name;
		
	}
}

class TestCh extends TestFa{

	public TestCh(String name) {
		super(name);
	}
	
}
