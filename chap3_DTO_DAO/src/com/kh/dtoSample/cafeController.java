package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

// model �� view �������ִ� �߰��ٸ�
public class cafeController {
	// �ʵ�
	private cafeModel model; // �� �������
	private cafeView view; // �� �������
	
	// �Ķ���͸� �ۼ��� ������
	public cafeController(Connection con, cafeView view) {
		this.model = new cafeModel(con);
		this.view = view;
	}
	
	// ��¸޼���
	public void displayAllCafe() {
		List<CafeDTO> cafe = model.getCafes();
		view.displayCafes(cafe);
		
	}
}
