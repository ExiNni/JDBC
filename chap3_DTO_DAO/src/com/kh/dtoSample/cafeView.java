package com.kh.dtoSample;

import java.util.List;

public class cafeView {
	// view���� �ַ� void �޼��常 ���
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
