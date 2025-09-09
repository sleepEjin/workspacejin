package com.kh.practice.array;

import java.util.Scanner;

public class Practice2 {
	/*
	 * n개의 정수가 주어질 때, 이들 중 최솟값과 최댓갑을 찾는 프로그램 작성
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] iArr = new int[n];
		
		//입력받는 부분
		for(int i=0; i<n; i++) {
			iArr[i] = sc.nextInt();
		}
		
		//최솟값 최댓값 확인
		int min = Integer.MAX_VALUE; // int로 표현할 수 있는 수 중 가장 큰 수
		int max = Integer.MIN_VALUE; // int로 표현할 수 있는 수 중 가장 작은 수
		
		for(int num : iArr) {
			if(num < min) min = num;
			if(num > max) max = num;
		}
		
		System.out.println(min + " "+ max);
	}
}
