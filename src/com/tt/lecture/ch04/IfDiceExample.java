package com.tt.lecture.ch04;

public class IfDiceExample {

	public static void main(String[] args) {
		
//		0.0 과 1.0 은 아닌 1.0에 가까운 double 타입 난수 발생
		
		double random = Math.random();
		System.out.println("random: " + random);
		
		int randomInt = (int) (Math.random()*10);
		System.out.println("randomInt: " + randomInt);
		
//		* (최대값-최소값 + 1) + 최소값
		
		int num = (int)(Math.random()*6) + 1;
		
		if(num==1) {
			System.out.println("1번이 나왔습니다.");
		} else if(num==2) {	
			System.out.println("2번이 나왔습니다.");
		} else if(num==3) {
			System.out.println("3번이 나왔습니다.");
		} else if(num==4) {
			System.out.println("4번이 나왔습니다.");
		} else if(num==5) {
			System.out.println("5번이 나왔습니다.");
		} else {
			System.out.println("6번이 나왔습니다.");
		}

	}
	
//	주사위 2개 던져서 나온값의 합을 출력 하시요

}
