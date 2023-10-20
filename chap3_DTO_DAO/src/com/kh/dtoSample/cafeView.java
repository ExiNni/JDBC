package com.kh.dtoSample;

import java.util.List;

public class cafeView {
	// view에는 주로 void 메서드만 사용
	public void displayCafes(List<CafeDTO>cafes) {
		for(CafeDTO c: cafes) {
			System.out.println("Cafe Id: " + c.getCafeId());
			System.out.println("Cafe Name: " + c.getCafeName());
			System.out.println("Cafe Address: " + c.getAddress());
			System.out.println("Cafe Phone Number: " + c.getPhone_number());
			System.out.println("Cafe Operating Hours" + c.getOperatingHours());
			System.out.println();
		}
 	}
}
