package com.kh.practice.array;

import java.util.Scanner;

public class Practice1 {
/*
 * 정수 n개로 이루어진 수열A와 정수X가 있을때, 
 * 수열a에서 x보다 작은 수를 모두 입력된 순서대로 공백 한칸으로 구분하여 출력
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] arrA = new int[n];
		
		for(int i=0;i<n;i++) {
			arrA[i] = sc.nextInt();
		}
		for(int i=0; i<arrA.length; i++) {
			
			if(arrA[i] < x) {
				System.out.print(arrA[i] + " ");
			}
		}
		sc.close();
	}
}
