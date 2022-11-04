package com.tt.lecture.ch13;

public class BoxExample {
	public static void main(String[] args) {
//		Box<String> box1 = new Box<String>();
//		box1.setT("hello");
//		String str = box1.getT();
//		
//		System.out.println("box1.getT(): " + box1.getT());
//
//		Box<Integer> box2 = new Box<Integer>();
//		box2.setT(6);
//		int value = box2.getT();
//		
//		System.out.println("box2.getT(): " + box2.getT());
		
		Box<String, Integer> box1 = new Box<String, Integer>();
		box1.setT("hello");
		box1.setT2(1);
		String str = box1.getT();
		
		System.out.println("box1.getT(): " + box1.getT());
		System.out.println("box1.getT2(): " + box1.getT2());

		Box<Integer, String> box2 = new Box<Integer, String>();
		box2.setT(2);
		box2.setT2("world");
		int value = box2.getT();
		
		System.out.println("box2.getT(): " + box2.getT());
		System.out.println("box2.getT2(): " + box2.getT2());
		
		
	}
}
