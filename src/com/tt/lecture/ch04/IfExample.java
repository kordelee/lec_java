package com.tt.lecture.ch04;

public class IfExample {

	public static void main(String[] args) {
		int score = 93;
		
		if(score>=90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A 입니다.");
		}
		
//		true 시 실행해야 되는 구문이 한줄이라면 블럭을 생략할 수 있다.
		
		if(score< 90) 
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B 입니다.");

	}

}
