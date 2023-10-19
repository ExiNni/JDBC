package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	// cafeModel 이라는 클래스를 가지고 오기 위해 멤버변수로 카페 모델을 추가함
	public cafeModel model;

	// model 매개변수를 받을 수 있는 생성자를 만들어줘야 함
	public cafeView(cafeModel model) {
		this.model = model;
	}

	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요");
		System.out.print("상호명: ");
		String name = sc.nextLine();
		System.out.println();
		System.out.print("카페 주소: ");
		String address = sc.nextLine();
		System.out.println();
		System.out.print("전화번호: ");
		String phone = sc.nextLine();
		System.out.println();
		System.out.print("영업시간: ");
		String operHour = sc.nextLine();

		// 카페 모델에서 insertCafe라는 메서드를 가지고 와야함
		model.insertCafe(name, address, phone, operHour);
		System.out.println("카페가 성공적으로 추가되었습니다.");

	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트 하세요");
		System.out.print("수정할 메뉴 설명: ");
		String description = sc.nextLine();
		System.out.println();
		System.out.print("메뉴 ID: ");
		int menuID = sc.nextInt();
		System.out.println();
		System.out.print("카페 ID: ");
		int cafeID = sc.nextInt();
		
		// model에 있는 UpdateMenu를 가지고 와서 사용자가 작성한 수정 내용 추가하기
		model.UpdateMenu(description, menuID, cafeID);
		System.out.println("메뉴 설명이 업데이트 되었습니다");
	}
	
	public void updateOHours() {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 운영시간: ");
		String operating_hours = sc.nextLine();
		System.out.println("수정할 카페 ID: ");
		int cafeID = sc.nextInt();
		
		model.updateCafe(operating_hours, cafeID);
		System.out.println("해당 카페의 운영시간이 수정되었습니다.");
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 카페 id : ");
		// int cafeID = sc.nextInt();
		int cafeID = Integer.parseInt(sc.nextLine());
		
		model.deleteCafe(cafeID);
		System.out.println("해당 카페가 삭제되었습니다.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 메뉴 id: ");
		int menu_id = sc.nextInt();
		System.out.println("삭제할 메뉴의 카페 id: ");
		int cafe_id = sc.nextInt();
		
		model.deleteMenu(menu_id, cafe_id);
		System.out.println("해당 카페의 메뉴가 삭제되었습니다.");
	}
	
	public void selectCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("선택 카페의 메뉴 보기");
		System.out.println("카페 선택: ");
		int cafeID = sc.nextInt();
		
		model.selectCafe(cafeID);
		System.out.println(cafeID + "번 카페의 메뉴판입니다.");
	}
}
