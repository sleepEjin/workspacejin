package com.kh.practice.control;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char score;
		System.out.print("점수를 입력하세요 : ");
		int grade = sc.nextInt();
		
		if(grade <= 100 && grade >90) {
			score = 'A';
		}
		else if(grade >= 80) {
			score = 'B';
		}
		else if(grade >= 70) {
			score = 'C';
		}
		else if(grade >= 60) {
			score = 'D';
		}
		else {
			score = 'F';
		}
		System.out.printf("당신의 성적은 %c입니다",score);
		sc.close();
	}

}
