package com.tt.lecture.ch03;

public class IncreaseDecreaseOperatorExample {

		public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("-----------------------");
		x++;
		++x;
		System.out.println("x=" + x);		
		
		System.out.println("-----------------------");		
		y--;
		--y;
		System.out.println("y=" + y);		
		
		System.out.println("-----------------------");	// 12
		z = x++;
		System.out.println("z=" + z);	//12
		System.out.println("x=" + x);	//13
		
		System.out.println("-----------------------");	//	13	
		z = ++x;
		System.out.println("z=" + z);	//14
		System.out.println("x=" + x);	//14
		
		System.out.println("-----------------------");	// 14,8		
		z = ++x + y++;
		System.out.println("z=" + z);	//	23
		System.out.println("x=" + x);	//	15
		System.out.println("y=" + y);	//	9
	}

}
