package com.kh.practice.loop;

import java.util.Scanner;

public class Practice5 {
	/*
	 * 사용자에게 정수를 반복 입력받아 총합을 누적 계산하는 프로그램 작성
	 * 단, 음수를 입력하면 입력 종료하고, 마지막에 누적된 총합 출력
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int num =sc.nextInt();
			
			if(num < 0) {
			break; //음수 입력시 반복 종료
			}	
			sum +=num;
		}
		System.out.print("총합 : " + sum);
	}
}
