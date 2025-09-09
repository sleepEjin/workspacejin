package com.kh.practice.control;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		String old;
		int charge;
		String day;
		
		System.out.print("나이를 입력하세요 : ");
		age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("요일를 입력하세요 : ");
		day = sc.nextLine();
		if(age >= 19) {
			old = "성인";
			charge = 10000;		
		}
		else if (age > 13) {
			old = "청소년";
			charge = 7000;
		}
		else {
			old = "어린이";
			charge = 5000;
		}
		switch(day) {
		case ("월"),("화"),("수"),("목"),("금"):
			System.out.println(old + " 요금입니다.\n" + "최종 요금은 " + charge + "입니다");
		break;
		case("토"),("일"):
			System.out.println(old + " 요금입니다. (주말 할인 적용)\n" + "최종 요금은 " + (int)(charge*0.8) + "원입니다");
		break;
		default:
			System.out.println("잘못 입력하셨습니다");
		}
			
	}
		
}

