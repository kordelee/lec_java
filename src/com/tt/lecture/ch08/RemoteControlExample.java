package com.tt.lecture.ch08;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		System.out.println(rc.getClass());
		System.out.println(RemoteControl.MAX_VOLUME);
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(10);
		rc.setMute(false);
		
		
		System.out.println();
		
		rc = new Audio();
		System.out.println(rc.getClass());
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(10);
		
		System.out.println();
		
		Audio audio = new Audio();
		
		audio.turnOff();
		audio.setMute(false);
		
		System.out.println();
		
	}

}