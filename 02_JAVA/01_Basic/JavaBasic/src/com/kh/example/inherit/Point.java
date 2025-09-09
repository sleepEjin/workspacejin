package com.kh.example.inherit;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		super();
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() { // 부모클래스에 있는 메서드를 재정의
		return x + ", " + y; //object가 아닌 이 클래스의 toString 호출
	}
		
}
	
	

