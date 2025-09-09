package com.kh.practice.array2;

import java.util.Scanner;

public class Practice2 {
	/*
	 * n*m 크기의 2차원 배열이 주어질 때 배열에 포함된 가장 큰 값과 그 값이 위치한 행 번호와 열 번호를 출력
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][]arr = new int[n][m];
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int maxValue = Integer.MIN_VALUE;
		int x = 0;
		int y = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]> maxValue) {
					maxValue = arr[i][j];
					x=i;
					y=j;
				}
			}
		}
		System.out.println(maxValue);
		System.out.printf("%d %d", x+1, y+1);
		sc.close();
	}
}
