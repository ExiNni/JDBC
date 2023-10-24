package com.kh.MVC.singleton.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class bankDAO {

    Connection connect;

    public bankDAO(Connection connect) {
        this.connect = connect;
    }

    /*
    public boolean transact(bankVO transfer) {
        try {
            String selectSql = "SELECT BALANCE FROM BANK WHERE ACCOUNT_ID = ?";
            PreparedStatement selectPs = connect.prepareStatement(selectSql);
            selectPs.setInt(1, transfer.getAccount_id());
            ResultSet resultSet = selectPs.executeQuery();

            double currentBalance = transfer.getBalance();
            if (resultSet.next()) {
                currentBalance = resultSet.getDouble("BALANCE");
            }

            double newBalance = currentBalance - transfer.getBalance();

            String updateSql = "UPDATE BANK SET BALANCE = ? WHERE ACCOUNT_ID = ?";
            PreparedStatement updatePs = connect.prepareStatement(updateSql);
            updatePs.setDouble(1, newBalance);
            updatePs.setInt(2, transfer.getAccount_id());

            int rows = updatePs.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getter(bankVO get) {
        try {
            String selectSql = "SELECT BALANCE FROM BANK WHERE ACCOUNT_ID = ?";
            PreparedStatement selectPs = connect.prepareStatement(selectSql);
            selectPs.setInt(1, get.getAccount_id());
            ResultSet resultSet = selectPs.executeQuery();

            double currentBalance = get.getBalance();
            if (resultSet.next()) {
                currentBalance = resultSet.getDouble("BALANCE");
            }

            double newBalance = currentBalance + get.getBalance();

            String updateSql = "UPDATE BANK SET BALANCE = ? WHERE ACCOUNT_ID = ?";
            PreparedStatement updatePs = connect.prepareStatement(updateSql);
            updatePs.setDouble(1, newBalance);
            updatePs.setInt(2, get.getAccount_id());

            int rows = updatePs.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	*/
    
    public boolean transact2(bankVO user) {
    	
    	String sql = "UPDATE BANK SET BALANCE = BALANCE - ? WHERE BANK_ID = ?;"
    			+ "UPDATE BANK SET BALANCE = BALANCE + ? WHERE BANK_ID = ?";
    	try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setDouble(1, 700);
			ps.setInt(2, user.getAccount_id());
			ps.setDouble(3, 700);
			ps.setInt(4, user.getAccount_id());
			
			int rows = ps.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return false;
    }
}
