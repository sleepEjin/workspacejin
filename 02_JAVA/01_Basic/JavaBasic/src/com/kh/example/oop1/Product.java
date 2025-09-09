package com.kh.example.oop1;

public class Product {
	private String pname;
	private int price;
	private String brand;
	
	public Product() {
		super();
	}
	
	public void information() {
		System.out.printf("상품명 : %s /가격 : %d / 브랜드 : %s\n",pname,price,brand);
	}
}

