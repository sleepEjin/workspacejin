package com.kh.practice.java;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] black = {1,1,2,2,2,8};
		int[] white = new int[black.length];
		for(int i=0; i<6; i++) {
			white[i] = sc.nextInt();
		}
		for(int i=0; i<6; i++) {
			System.out.print((black[i]-white[i]) + " ");
		}
	}
}
