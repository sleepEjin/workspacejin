package com.kh.practice.loop;

import java.util.Scanner;

public class Practice8 {
	/*
	 * 사용자로부터 정수 n()을 입력받아 n층의 왼쪽 정렬된 별 피라미드 출력(줄마다 개행 포함)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int n = sc.nextInt();
		
		//별 출력
		for (int i=0; i<n; i++) {
			for(int k=0; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}