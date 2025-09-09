package com.kh.control;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 나이를 입력받아
		 * 13세 이하면 : 어린이
		 * 13세 초과 19세 이하면 청소년
		 * 19세 초과면 : 성인
		 * 
		 * [출력]
		 * 나이를 입력 : xx
		 * xx은 xxx에 속합니다.
		 * 
		 */
		int age = 0;
		System.out.println("나이를 입력 : ");
		age = sc.nextInt();
		if(age < 13) {
			System.out.printf("%d는 어린이에 속합니다",age);
		} else if(age <=19) {
			System.out.printf("%d는 청소년에 속합니다",age);
		}else {
			System.out.printf("%d는 성인에 속합니다",age);
		}
	}
}
