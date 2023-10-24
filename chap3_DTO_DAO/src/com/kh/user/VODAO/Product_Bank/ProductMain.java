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
			System.out.println("1. ��ǰ �߰�");
			System.out.println("2. ��ǰ ����");
			System.out.println("3. ��ٱ��� ��� ���");
			System.out.println("4. ���� ���");
			System.out.println("5. ����");
			System.out.println("0. ����");
			System.out.println("*********************");
			System.out.println();
			System.out.print("��ȣ ����: ");
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
			    System.out.println("��ٱ��� �� ����: " + totalPrice);
			    break;

			case 5:
			    double totalPrice2 = productDAO.calculateTotalPrice();
			    bankdao.payment(totalPrice2);
			    break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("��ȿ���� ���� �����Դϴ�. �ٽ� �����ϼ���.");
			}
		}
	}
}
