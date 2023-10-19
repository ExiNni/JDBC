package chap2_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;

	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}

	// run
	public void run() {
		boolean isTrue = true;
		while (isTrue) {
			Scanner sc = new Scanner(System.in);
			// 선택할 번호 출력 메서드로 입력
			System.out.println("1. 카페 정보 추가");
			System.out.println("2. 메뉴 설명 업데이트");
			System.out.println("3. 운영시간 업데이트");
			System.out.println("4. 카페 삭제");
			System.out.println("5. 메뉴 삭제");
			System.out.println("6. 카페 선택 메뉴");
			System.out.println("7. 종료");
			System.out.println("원하는 작업을 선택해주세요");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				view.addCafeName();
				break;
			case 2:
				view.updateMenu();
				break;
			case 3:
				view.updateOHours();
				break;
			case 4:
				view.deleteCafe();
				break;
			case 5:
				view.deleteMenu();
				break;
			case 6:
				view.selectCafe();
				break;
			case 7:
				System.out.println("프로그램을 종료합니다");
				isTrue = false;
				break;
			default:
				System.out.println("잘못된 번호입니다.");
			}
		}
	}

}
