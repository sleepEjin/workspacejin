package com.kh.practice.control;

import java.util.Scanner;

public class Pracetice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dice1 =6;
		int dice2 = 6;
		int dice3 = 6;
		
		System.out.print("# 입력: ");
		dice1 =sc.nextInt(); 
		dice2 = sc.nextInt();
		dice3 = sc.nextInt();
		
		System.out.println("# 출력:");
		
		if(dice1 <=6 && dice2 <=6 && dice3 <=6) {
		if(dice1 == dice2 && dice2 == dice3) {
			System.out.println(10000 + dice1*1000);
		}
		else if(dice1 == dice2) {
			System.out.println(1000 + dice1*100);
		}
			else if(dice1 == dice3) {
			System.out.println(1000 + dice1*100);
			}
			else if(dice2 == dice3) {
			System.out.println(1000 + dice2*100);
		}
		
			else if(dice1 > dice2 && dice1 > dice3) {
			System.out.println(dice1*100);
		}
			else if(dice2 > dice1 && dice2 > dice3) {
			System.out.println(dice2*100);
		}
			else if(dice3 > dice1 && dice3 > dice2) {
			System.out.println(dice3*100); 
			//java에서 제공해주는 수학함수
			//java.lang.math -> 코드를 작성할 때 기본적으로 유용한 것들을 담아서 제공
			//Math.max(n1, n2) -> 둘 중 큰값을 반환함
		}
			}
		else {
			System.out.println("잘못 입력하셨습니다");
			}
		}
	}
