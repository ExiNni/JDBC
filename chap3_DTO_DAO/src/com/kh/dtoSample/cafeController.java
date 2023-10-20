package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

// model 과 view 연결해주는 중간다리
public class cafeController {
	// 필드
	private cafeModel model; // 모델 멤버변수
	private cafeView view; // 모델 멤버변수
	
	// 파라미터를 작성한 생성자
	public cafeController(Connection con, cafeView view) {
		this.model = new cafeModel(con);
		this.view = view;
	}
	
	// 출력메서드
	public void displayAllCafe() {
		List<CafeDTO> cafe = model.getCafes();
		view.displayCafes(cafe);
		
	}
}
