package com.kh.example.abstractNinterface;

public class PhoneController {
	private String[] result = new String[2];
	
	public String[] method() {
		Phone[] phoneArr = new Phone[2];
		phoneArr[0] = new GalaxyNote9(); //다형성
		phoneArr[1] = new V40(); //다형성
		
		String[] result = new String[2];
		int index = 0;
		for(Phone p : phoneArr) {
			if(p instanceof Smartphone) {
				result[index++] = ((Smartphone)p).printInformation();
			}
		}
		return result;
	}
}
