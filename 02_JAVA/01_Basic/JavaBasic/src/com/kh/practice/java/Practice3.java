package com.kh.practice.java;

import java.util.Scanner;

public class Practice3 {
	
	/*
	 * 대소문자가 섞인 영어 단어 사이에서 가장 많이 사용된 알파벳을 대문자로 출력해라.
	 * 가장 많이 사용된 알파벳이 여러 개면 ? 출력
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		String word = sc.next().toUpperCase();
		
		int[] count = new int[26];
		for(int i=0;i<word.length();i++) {
			int index = word.charAt(i) - 'A';
			count[index]++;
		}
		
		int max = 0, index = 0;
		boolean isDupl = false;
		for(int i=0; i<count.length; i++) {
			max = count[i]  > max ? count[i] : max;
			
			if(count[i] > max) {
				max = count[i];
				index = i;
				isDupl = false;
			} else if(count[i] == max) {
				isDupl = true;
			}
				
		}
	}
}