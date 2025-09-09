package com.kh.api;

public class MathAPI {
	//java.lang.Math
	//모든 필드 상수필드, 모든 메서드가 static 메서드다.
	public void method() {
		System.out.println("PI : " + Math.PI);
		
		//랜덤수
		System.out.println("랜덤(0.00~ 0.99) : " + Math.random());
		
		//절대값
		System.out.println("절댓값 : " +Math.abs(-10.5));
		
		//올림
		System.out.println("올림 : " + Math.ceil(10.2));
		
		//반올림
		System.out.println("반올림 : " + Math.round(10.2));
				
		//버림
		System.out.println("버림 : " + Math.floor(10.2));
		
		//제곱
		System.out.println("버림 : " + Math.pow(2,10));
	}
	
}
