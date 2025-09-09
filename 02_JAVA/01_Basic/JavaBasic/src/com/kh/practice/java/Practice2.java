package com.kh.practice.java;

import java.util.Scanner;

public class Practice2 {
	/*
	 * 알파벳 소문자로만 이루어진 단어가 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어인지 확인하는 프로그램 작성
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		boolean isOk = true;
		for(int i=0,j=word.length()-1; i<j; i++,j--) {
			if(word.charAt(i) != word.charAt(j)) {
				isOk = false;
				break;
			}
		}
		System.out.println(isOk ? 1 : 0);
	}
}
