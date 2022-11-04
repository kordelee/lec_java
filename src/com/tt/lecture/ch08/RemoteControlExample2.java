package com.tt.lecture.ch08;

public class RemoteControlExample2 {
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl() {
			public void turnOn() { 
				System.out.println("adsadsf"); }	
			public void turnOff() { /*실행문*/ }
			public void setVolume(int volume) { /*실행문*/ }
		};
		
		rc.turnOn();
	}
}
