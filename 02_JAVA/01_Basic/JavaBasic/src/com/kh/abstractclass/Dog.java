package com.kh.abstractclass;

public class Dog extends Animal {
	
	//일반메서드
		public void breathe() {
			System.out.println("숨을 쉽니다");
		}

	@Override
	public void speak() {
		System.out.println("멍멍!");
		
	}

	@Override
	public void move() {
		System.out.println("강아지가 달립니다");
		// TODO Auto-generated method stub
	}
	
	public void eat() {
		System.out.println("냠냠");
	}
	
}
