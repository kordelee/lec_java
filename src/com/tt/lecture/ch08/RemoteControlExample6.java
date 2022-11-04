package com.tt.lecture.ch08;

public class RemoteControlExample6 {
	public static void main(String[] args) {
		RemoteControl.changeBattery();
		
		RemoteControl rc = null;
		
		rc = new Television();
		rc.turnOn();
		rc.setMute(true);
		
		rc = new Audio();
		rc.turnOn();
		rc.setMute(true);
		
		
		
	}
}
