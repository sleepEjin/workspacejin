package com.kh.example.poly1;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] an = new Animal[5];
		an[0] = new Dog("가나",2,"치와와");
		an[1] = new Cat("다라",3,"검정색");
		an[2] = new Dog("마바",1,"말티즈");
		an[3] = new Cat("사아",4,"갈색");
		an[4] = new Dog("자차",7,"보더콜리");
		for(int i=0; i<an.length; i++) {
			if(an[i] instanceof Dog) {
				System.out.println();
				System.out.printf("이 개의 견종은 %s입니다", ((Dog)an[i]).getBreed());
			}
			
			if(an[i] instanceof Cat) {
				((Cat)an[i]).getColor();
				System.out.println();
				System.out.printf("이 고양이의 색상은 %s입니다", ((Cat)an[i]).getColor());
			}
		}
	}
}