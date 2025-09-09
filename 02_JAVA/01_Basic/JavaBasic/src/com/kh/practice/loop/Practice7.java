package com.kh.practice.loop;

public class Practice7 {
	/*
	 * 2단부터 9단까지 구구단 전체를 출력하는 프로그램 작성
	 */
	public static void main(String[] args) {
		for(int n=2; n<=9; n++) {
			for(int i=1;i<=9;i++) {
				System.out.println(n + " * " + i + " = " + (n*i));
			}
		}
	}
}
