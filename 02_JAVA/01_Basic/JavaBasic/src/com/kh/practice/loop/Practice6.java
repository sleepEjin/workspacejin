package com.kh.practice.loop;

import java.util.Scanner;

public class Practice6 {
	/*
	 * 사용자로부터 10개의 정수를 입력받아 짝수일 경우에만 제곱을 출력하는 프로그램 작성
	 * 홀수는 건너뛰고 출력하지 않음
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=10; i++) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			if(num % 2 == 1) {
				continue;
			}
			System.out.printf("짝수 %d의 제곱은 %d입니다\n",num,num*num);
		}
		sc.close();
	}

}
