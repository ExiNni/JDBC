package com.kh.user.VODAO.Product_Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class bankDAO {

	private Connection connect;
	private Scanner scanner;


	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String pw = "kh1234";

	public bankDAO() {
		try {
			connect = DriverManager.getConnection(url, user, pw);
			scanner = new Scanner(System.in);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public bankDTO getBankId() {
	    bankDTO bank;
	    
	    while (true) {
	        System.out.print("결제할 은행 ID: ");
	        int bID = scanner.nextInt();
	        scanner.nextLine();
	        
	        try {
	            PreparedStatement ps = connect.prepareStatement("SELECT * FROM BANK WHERE ACCOUNT_ID = ?");
	            ps.setInt(1, bID);
	            ResultSet result = ps.executeQuery();
	            
	            if (result.next()) {
	                int account_id = result.getInt("account_id");
	                String account_number = result.getString("account_number");
	                String account_name = result.getString("account_name");
	                double balance = result.getDouble("balance");
	                String branch_name = result.getString("branch_name");
	                Date last_transaction_date = result.getDate("last_transaction_date");
	    
	                bank = new bankDTO(account_id, account_number, account_name, balance, branch_name, last_transaction_date);
	            } else {
	                System.out.println("잘못입력하셨습니다.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	public void payment(double totalPrice) {
	    bankDTO bank = null;

	    System.out.print("결제할 은행 ID: ");
	    int bID = scanner.nextInt();
	    scanner.nextLine();

	    try {
	        PreparedStatement ps = connect.prepareStatement("SELECT * FROM BANK WHERE ACCOUNT_ID = ?");
	        ps.setInt(1, bID);
	        ResultSet result = ps.executeQuery();

	        if (result.next()) {
	            int account_id = result.getInt("ACCOUNT_ID");
	            String account_number = result.getString("ACCOUNT_NUMBER");
	            String account_name = result.getString("ACCOUNT_NAME");
	            double balance = result.getDouble("BALANCE");
	            String branch_name = result.getString("BRANCH_NAME");
	            Date last_transaction_date = result.getDate("LAST_TRANSACTION_DATE");

	            bank = new bankDTO(account_id, account_number, account_name, balance, branch_name, last_transaction_date);
	        } else {
	            System.out.println("잘못입력하셨습니다.");
	            return; // Exit the method if the bank is not found
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return; // Exit the method if there's an SQL error
	    }

	    if (bank != null) {
	        if (bank.getBALANCE() >= totalPrice) {
	            try {
	                double newBalance = bank.getBALANCE() - totalPrice;
	                PreparedStatement updateBalance = connect.prepareStatement("UPDATE BANK SET BALANCE = ? WHERE ACCOUNT_ID = ?");
	                updateBalance.setDouble(1, newBalance);
	                updateBalance.setInt(2, bank.getACCOUNT_ID());
	                updateBalance.executeUpdate();

	                System.out.println("결제가 완료되었습니다.");
	            } catch (SQLException e) {
	                e.printStackTrace();
	                return; // Exit the method if there's an SQL error
	            }
	        } else {
	            System.out.println("잔액이 부족합니다. 결제가 실패했습니다.");
	        }
	    } else {
	        System.out.println("은행 정보를 찾을 수 없습니다. 결제가 실패했습니다.");
	    }
	}

}
