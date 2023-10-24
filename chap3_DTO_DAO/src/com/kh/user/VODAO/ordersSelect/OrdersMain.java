package com.kh.user.VODAO.ordersSelect;

import java.util.List;

import java.util.Scanner;

public class OrdersMain {

    public static void main(String[] args) {
        OrdersDAO dao = new OrdersDAO();
        OrdersController controller = new OrdersController(dao);
        OrdersView view = new OrdersView();
        Scanner scanner = new Scanner(System.in);

        System.out.print("카페 ID입력: ");
        int cafe = scanner.nextInt();

        List<OrdersDTO> orders = controller.getAllOrders(cafe);
        view.showOrders(orders);

        double totalPrice = controller.calculateTotalPrice(orders);
        view.showTotalPrice(cafe, totalPrice);

        scanner.close();
    }
}
