package com.kh.user.VODAO.Product_Bank;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		bankDAO bankdao = new bankDAO();
		int choice;

		while (true) {
			System.out.println();
			System.out.println("*********************");
			System.out.println("1. 제품 추가");
			System.out.println("2. 제품 제거");
			System.out.println("3. 장바구니 목록 출력");
			System.out.println("4. 가격 계산");
			System.out.println("5. 결제");
			System.out.println("0. 종료");
			System.out.println("*********************");
			System.out.println();
			System.out.print("번호 선택: ");
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				productDAO.addToCart();
				break;
			case 2:
				productDAO.deleteCart();
				break;
			case 3:
				productDAO.displayCart();
				break;
			case 4:
				double totalPrice = productDAO.calculateTotalPrice();
			    System.out.println("장바구니 총 가격: " + totalPrice);
			    break;

			case 5:
			    double totalPrice2 = productDAO.calculateTotalPrice();
			    bankdao.payment(totalPrice2);
			    break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("유효하지 않은 선택입니다. 다시 선택하세요.");
			}
		}
	}
}
