package com.kh.example.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("========== KH 사이트 ========== ");
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
			case 1:
				joinMembership();
				break;
			case 2:
				boolean isLogin = logIn();
				if(isLogin) {
					memberMenu();
				}
				return;
			case 3:
				sameName();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");	
			}
			System.out.println();
		}
    }

    public void memberMenu() {
        System.out.println("******* 회원 메뉴 *******");
        System.out.println("1. 비밀번호 바꾸기");
		System.out.println("2. 이름바꾸기");
		System.out.println("3. 로그아웃");
		System.out.print("메뉴 번호 선택");
		int sel = sc.nextInt();
		
		switch(sel) {
		case 1:
			changePassword();
		case 2:
			changeName();
		case 3:
			System.out.println("로그아웃 되었습니다");
			return;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
    }

    public void joinMembership() {
    	
    	while(true) {
       System.out.print("아이디 : ");
       String id = sc.nextLine();
       System.out.print("패스워드 : ");
       String pwd = sc.nextLine();
       System.out.print("이름 : ");
       String name = sc.nextLine();
       
       boolean isOk = mc.joinMembership(id, new Member(pwd, name));
       if(isOk) {
    	   System.out.println("성공적으로 회원가입 완료하였습니다");
    	   return;
       } 
    	 	System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
       		}
    	}
 

    public boolean logIn() {
    	for(int i=0; i<3; i++) {
    	System.out.print("아이디 : ");
        String id = sc.nextLine();
        
        System.out.print("패스워드 : ");
        String pwd = sc.nextLine();
        
        String name = mc.logIn(id, pwd);
        
        if(name != null) {
        	System.out.println(name + "님, 환영합니다!");
        	return true;
        }
        System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요");
    	}
    	return false;
    }

    public void changePassword() {
    	while(true) {
    	System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 : ");
        String oldPwd = sc.nextLine();
        System.out.print("변경할 비밀번호 : ");
        String newPwd = sc.nextLine();
        boolean isChange = mc.changePassword(id, oldPwd, newPwd);
        if(isChange) {
        	System.out.println("비밀번호 변경에 성공했습니다");
        	return;
        	}
        System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요");
    	}
        
        
    }

    public void changeName() {
    	while(true) {
    	System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 : ");
        String oldPwd = sc.nextLine();
        
        String name = mc.logIn(id, oldPwd);
        
        if(name == null) {
        	System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요");
        	continue;
        }
        System.out.println("현재 설정된 이름 : " + name);
        System.out.print("변경할 이름");
        String newName = sc.nextLine();
        
        mc.changeName(id, newName);
        System.out.println("이름 변경에 성공했습니다");
    	}
    }

    public void sameName() {
       System.out.print("검색할 이름 : ");
       String name = sc.nextLine();
       TreeMap<String, String> map = mc.sameName(name);
       
       for(Map.Entry<String, String> e : map.entrySet()) {
    	   System.out.println(e.getValue() + "-" + e.getKey());
       }
    }
}
