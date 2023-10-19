package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	// cafeModel �̶�� Ŭ������ ������ ���� ���� ��������� ī�� ���� �߰���
	public cafeModel model;

	// model �Ű������� ���� �� �ִ� �����ڸ� �������� ��
	public cafeView(cafeModel model) {
		this.model = model;
	}

	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���");
		System.out.print("��ȣ��: ");
		String name = sc.nextLine();
		System.out.println();
		System.out.print("ī�� �ּ�: ");
		String address = sc.nextLine();
		System.out.println();
		System.out.print("��ȭ��ȣ: ");
		String phone = sc.nextLine();
		System.out.println();
		System.out.print("�����ð�: ");
		String operHour = sc.nextLine();

		// ī�� �𵨿��� insertCafe��� �޼��带 ������ �;���
		model.insertCafe(name, address, phone, operHour);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");

	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ �ϼ���");
		System.out.print("������ �޴� ����: ");
		String description = sc.nextLine();
		System.out.println();
		System.out.print("�޴� ID: ");
		int menuID = sc.nextInt();
		System.out.println();
		System.out.print("ī�� ID: ");
		int cafeID = sc.nextInt();
		
		// model�� �ִ� UpdateMenu�� ������ �ͼ� ����ڰ� �ۼ��� ���� ���� �߰��ϱ�
		model.UpdateMenu(description, menuID, cafeID);
		System.out.println("�޴� ������ ������Ʈ �Ǿ����ϴ�");
	}
	
	public void updateOHours() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ��ð�: ");
		String operating_hours = sc.nextLine();
		System.out.println("������ ī�� ID: ");
		int cafeID = sc.nextInt();
		
		model.updateCafe(operating_hours, cafeID);
		System.out.println("�ش� ī���� ��ð��� �����Ǿ����ϴ�.");
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ī�� id : ");
		// int cafeID = sc.nextInt();
		int cafeID = Integer.parseInt(sc.nextLine());
		
		model.deleteCafe(cafeID);
		System.out.println("�ش� ī�䰡 �����Ǿ����ϴ�.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �޴� id: ");
		int menu_id = sc.nextInt();
		System.out.println("������ �޴��� ī�� id: ");
		int cafe_id = sc.nextInt();
		
		model.deleteMenu(menu_id, cafe_id);
		System.out.println("�ش� ī���� �޴��� �����Ǿ����ϴ�.");
	}
	
	public void selectCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ī���� �޴� ����");
		System.out.println("ī�� ����: ");
		int cafeID = sc.nextInt();
		
		model.selectCafe(cafeID);
		System.out.println(cafeID + "�� ī���� �޴����Դϴ�.");
	}
}
