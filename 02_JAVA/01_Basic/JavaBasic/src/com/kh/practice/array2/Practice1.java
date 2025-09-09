package com.kh.practice.array2;

import java.util.Scanner;

public class Practice1 {
	/*
	 * 크기가 n * m인 두 정수 행렬 a,b가 주어질 때, 두 행렬의 원소별 합을 구해 출력하시오
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arrA;
		arrA = new int[n][m];
		for(int i=0;i<arrA.length;i++) {
			for(int j=0;j<arrA[i].length;j++) {
				arrA[i][j] = sc.nextInt();
			}
		}
		
		int[][] arrB;
		arrB = new int[n][m];
		for(int i=0;i<arrB.length;i++) {
			for(int j=0;j<arrB[i].length;j++) {
				arrB[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print((arrA[i][j] + arrB[i][j]) + " ");
				
			}
			System.out.println();
		}	
	}
}

