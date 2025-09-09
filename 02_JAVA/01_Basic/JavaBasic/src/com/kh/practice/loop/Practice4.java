package com.kh.practice.loop;

public class Practice4 {
	/*
	 * 1부터 100의 숫자 중에서 7의 배수만 출력하는 프로그램 작성
	 * 단, 짝수인 7의 배수는 건너뛰고, 출력에서 제외
	 */
	public static void main(String[] args) {
		for(int i=1;i<=100;i++) {
			if(i % 7 != 0 || i % 2 ==0) {
				continue;
			}
			System.out.print(i + " ");
		}

	}

}
