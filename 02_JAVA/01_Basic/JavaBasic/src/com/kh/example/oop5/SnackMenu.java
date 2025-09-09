package com.kh.example.oop5;

import java.util.Scanner;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		scr.saveData(null, null, null, 0, 0);
		System.out.println("스낵류를 입력하세요");
		System.out.print("종류 : ");
		String kind = sc.next();
		String name = sc.next();
		
		
	}
}
