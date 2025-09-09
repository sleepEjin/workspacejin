package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GearRentMenu {
	private GearRentController gc = new GearRentController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== KH 장비 대여 관리 ===");
			System.out.print("1) 장비등록 ");
			System.out.print("2) 회원등록 ");
			System.out.print("3) 대여 ");
			System.out.print("4) 반납 ");
			System.out.print("5) 태그검색 \n");
			System.out.print("6) 키워드검색 ");
			System.out.print("7) 전체장비 ");
			System.out.print("8) 대여중목록 ");
			System.out.print("9) 종료 \n");
			System.out.print("메뉴 : ");
			
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1:
				addDevice();
				break;
			case 2:
				addMember();
				break;
			case 3:
				borrow();
				break;
			case 4:
				returnItem();
				break;
			case 5:
				findByTag();
				break;
			case 6:
				findByKeyword();
				break;
			case 7:
				printAllDevices();
				break;
			case 8:
				printActiveLoans();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
	public void addDevice() {
		System.out.println("유형(1:Camera, 2:Laptop) : ");
		int type = sc.nextInt();
		
		System.out.print("id : ");
		String id = sc.next();
		
		System.out.print("name : ");
		String name = sc.next();
		
		System.out.print("category : ");
		String category = sc.next();
		
		System.out.print("tags(쉼표로 구분) : ");
		String tags = sc.next();
		sc.nextLine();
		
		Set<String> tags = new HashSet<>();
		for(String s : tag.split(",")) {
			tags.add(s.trim());
		}
		
		Device device;
		switch(type) {
			case 1:
				device = new Camera(id, name, category, tags);
				break;
			case 2:
				device = new Laptop(id, name, category, tags);
				break;
			default:
				System.out.println("유형을 잘못 입력하셨습니다");
				return;
		}
		
		boolean isOk = gc.addDevice(device);
		System.out.println(isOk ? "등록 완료" : "중복된 ID입니다. 다시 입력해주세요");
	}
	
	public void addMember() {
		System.out.print("member id : ");
		String id = sc.next();
		
		System.out.print("name : ");
		String name = sc.next();
		sc.nextLine();
		
		boolean isOk = gc.addMember(new Member(id, name));
		System.out.println("가입 완료");
		
		
		
	}
	
	public void borrow() {
		System.out.print("memberId : ");
		String id = sc.next();
		
		System.out.print("itemID : ");
		String iId = sc.next();
		
		System.out.print("대여일(YYYY-MM-DD) : ");
		String bDay = sc.next();
		sc.nextLine();
		
		LocalDate today = LocalDate.parse(bDay);
		
		Loan loan = gc.borrow(id, iId, today);
		System.out.println("대여 생성 완료 : " + loan);
		System.out.println("반납 예정일 : " + loan.getDueDate());
		
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		Date date = new Date(year,month,day);
		gc.borrow(id, iId, date);
		System.out.println("대여 완료 : " + gc.borrow(id, iId, date));
	}
	
	public void returnItem() {
		System.out.print("itemID : ");
		String iId = sc.next();
		
		System.out.print("반납일 : ");
		String day = sc.next();
		sc.nextLine();

		LocalDate today = LocalDate.parse(day);
		
		int fee = gc.returnItem(iId, today);
		
		if(fee == -1) {
			System.out.println("대여이력이 없습니다");
		} else {
			System.out.println("반납 완료, 연체료 : " + fee + "원");
		}
	}
	
	public void findByTag() {
		System.out.print("검색 태그 : ");
		String tag = sc.nextLine();
		
		List<Device> list =gc.findByKeyword(keyword);
	}
	
	public void findByKeyword() {
		
	}
	
	public void printAllDevices() {
		gc.getAllDevices();
	}
	
	
	public void printActiveLoans() {
		gc.getActiveLoan();
	}
}
