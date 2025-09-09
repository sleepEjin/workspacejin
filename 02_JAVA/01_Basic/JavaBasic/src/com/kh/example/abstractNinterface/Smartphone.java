package com.kh.example.abstractNinterface;

public abstract class Smartphone {
	private String maker;

	public Smartphone() {
		super();
	}
	
	//각 인터페이스의 메서드들의 반환값을 모두 조합해서 반환(자식에서 구현)
	public abstract String printInformation();

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}
}
