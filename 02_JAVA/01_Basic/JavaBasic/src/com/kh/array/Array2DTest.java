package com.kh.array;

import java.util.Scanner;

public class Array2DTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//사용자에게 행(m)과 열(n)을 입력받아
		//해당 행과열의 빙고판을 만들어라.
		//다음 행과 열의 들어갈 문자를 각각 모두 입력받아 저장한 뒤
		//출력해라
		
		/*
		 * 행 : 2
		 * 열 : 3
		 * 
		 * 1행1열 : 바나나
		 * 1행2열 : 배
		 * ...
		 * 2행3열 : 귤
		 */
		//행과 열을 입력
		/*
		System.out.print("행 : ");
		int m = sc.nextInt();
		
		System.out.print("열 : ");
		int n = sc.nextInt();
		
		String[][] board = new String[m][n];
		
		for(int i=0;i<board.length;i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.printf("%d행 %d열", i,j);
				board[i][j] = sc.next();
			}
		}
		for(int i=0;i<board.length;i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j]);		
	}
}
		*/
		//사용자에게 좌석의 행과 열을 입력받아 2차원배열을 생성
		//각 좌석에 들어갈 관객의 이름을 입력받아 저장한뒤
		//모두 입력받았으면 좌석표를 출력
		
		//ex)
		//행(줄)의 수 :
		//열(좌석)의 수 :
		//1행 1열 : 철수~
		//...
		//"======좌석표======"
		//철수 민수 상수 ....
		
		System.out.print("행(줄)의 수 : ");
		int m = sc.nextInt();
		System.out.print("열(좌석)의 수 : ");
		int n = sc.nextInt();
		
		String[][] seat = new String[m][n];
		
		for(int i=0;i<seat.length;i++) {
			for(int j=0;j<seat[i].length; j++) {
				System.out.printf("%d행 %d열 : ",i+1,j+1);
				seat[i][j] =sc.next();
			}
		}
		for(int i=0;i<seat.length;i++) {
			for(int j=0;j<seat[i].length; j++) {
				System.out.print(seat[i][j] + " ");
			}
			System.out.println();
		}

	}
}
	