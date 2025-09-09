package com.kh.abstractclass;

public class Cat extends Animal {
	
	public void breathe() {
		System.out.println("숨을 쉽니다");
	}

	@Override
	public void speak() {
		System.out.println("야옹");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		System.out.println("고양이가 달립니다");
		// TODO Auto-generated method stub
		
	}
	
}
