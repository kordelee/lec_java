package com.tt.lecture.ch07;

public class PhoneExample {
	public static void main(String[] args) {
		//Phone phone = new Phone(); (x)
		
		
//		SmartPhone smartPhone = new SmartPhone("홍길동");
		SmartPhone smartPhone = new SmartPhone();
		
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
	}

}
