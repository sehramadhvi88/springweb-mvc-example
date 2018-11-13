package com.infinitskills.mvc.controllers;

public class Dummyclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dummyclass d1= new Test();
		
		d1.method1();
		d1.method2();
		//d1.method3(); // =>The method method3() is undefined for the type Dummyclass
	}

	private void method1(){
		System.out.println("private of parent");
	}
	
	public void method2(){
		System.out.println("public of child");
	}
}


class Test extends Dummyclass{
	
	private void method1(){
		System.out.println("private of child");
	}
	
	public void method3(){
		System.out.println("public of child");
	}
	
}