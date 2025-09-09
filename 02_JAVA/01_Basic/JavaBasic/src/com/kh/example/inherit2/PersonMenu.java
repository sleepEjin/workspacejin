package com.kh.example.inherit2;

import java.util.Scanner;

public class PersonMenu {
	Scanner sc = new Scanner(System.in);
	PersonController pc = new PersonController();
	
	public void mainMenu() {
		//0 -> 학생 수, 1 -> 사원 수
		int[] count = pc.personCount();
		System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
		System.out.printf("현재 저장된 학생은 %d명입니다.\n",count[0]);
		System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
		System.out.printf("현재 저장된 사원은 %d명입니다.\n",count[1]);
		
		while(true) {
			System.out.println("1. 학생메뉴");
			System.out.println("2. 사원메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				studentMenu();
			case 2:
				employeeMenu();
			case 9:
				System.out.println("종료합니다.");
				return;
			default: // 유효성 검사
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}
	
	public void studentMenu() {
		while(true) {
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1: //추가
				insertStudent();
				break;
			case 2: //보기
				printStudent();
				break;
			case 9: //메인으로
				return;
			default: // 유효성 검사
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}
	
	public void employeeMenu() {
		while(true) {
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int m = sc.nextInt();
			
			switch(m) {
			case 1:
				insertEmployee();
				break;
			case 2:
				printEmployee();
				break;
			case 9:
				return;
			default: // 유효성 검사
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}
	
	public void insertStudent() {
		if(pc.personCount()[0] > 3) {
			System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생메뉴로 돌아갑니다.");
			return;
		}
		
		while(true) {
			
		System.out.print("학생 이름 : ");
		String sName = sc.next();
		System.out.print("학생 나이 : ");
		int sAge = sc.nextInt();
		System.out.print("학생 키 : ");
		double sHeight = sc.nextDouble();
		System.out.print("학생 몸무게 : ");
		double sWeight = sc.nextDouble();
		System.out.print("학생 학년 : ");
		int sGrade = sc.nextInt();
		System.out.print("학생 전공 : ");
		String sMajor = sc.next();
		
		pc.insertStudent(sName, sAge, sHeight, sWeight, sGrade, sMajor);
		
		System.out.println("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
		char an = sc.next().toUpperCase().charAt(0);
		if(an == 'N') break;
	}
	}
	
	public void printStudent() {
		Student[] stArr = pc.printStudent();
		for(Student st : stArr) {
			if(st == null) break;
			System.out.println(st.toString());
		}
	}
	
	public void insertEmployee() {
		if(pc.personCount()[1] > 10) {
			System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원메뉴로 돌아갑니다.");
			return;
		}
		
		while(true) {
			
		System.out.print("직원 이름 : ");
		String eName = sc.next();
		System.out.print("직원 나이 : ");
		int eAge = sc.nextInt();
		System.out.print("직원 키 : ");
		double eHeight = sc.nextDouble();
		System.out.print("직원 몸무게 : ");
		double eWeight = sc.nextDouble();
		System.out.print("직원 월급 : ");
		int eSalary = sc.nextInt();
		System.out.print("직원 부서명 : ");
		String eDept = sc.next();
		System.out.println("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
		
		char an = sc.next().toUpperCase().charAt(0);
		if(an == 'N') break;
		
		pc.insertStudent(eName, eAge, eHeight, eWeight, eSalary, eDept);
		}
	}
	
	public void printEmployee() {
		Employee[] empArr = pc.printEmployee();
		for(Employee emp : empArr) {
			if(emp == null) break;
			System.out.println(emp.toString());
		}
	}
}
