//package com.user.connection.main;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.user.connection.DBConnection;
//
//public class Main {
//	public static void main(String[] args)  {
//
//		DBConnection d=new DBConnection();
//		
//		IO.println(d);
//		IO.print(DBConnection.getConnection());
//		
//		
//		String query="SELECT * FROM USERS";
//		Connection connection=DBConnection.getConnection();
//		
//		try {
//		
//	            PreparedStatement ps = connection.prepareStatement(query);
//	            ResultSet rs = ps.executeQuery();
//
//	            // Loop through all records
//	            while (rs.next()) {
//	                int id = rs.getInt("id");        // column name
//	                String name = rs.getString("name");
//	                String email = rs.getString("email");
//
//	                System.out.println(id + " | " + name + " | " + email);
//	            }
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//		String query1 = "INSERT INTO USERS (ID, NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
//		Connection connection1 = DBConnection.getConnection();
//
//		try {
//		    PreparedStatement ps = connection1.prepareStatement(query1);
//
//		    ps.setInt(1, 1003);
//		    ps.setString(2, "Ravi");
//		    ps.setString(3, "ravi@gmail.com");
//		    ps.setString(4, "ravi123");
//
//		    int row = ps.executeUpdate();
//
//		    if (row > 0) {
//		        System.out.println("User Inserted Successfully");
//		    }
//
//		} catch (SQLException e) {
//		    e.printStackTrace();
//		}
////		✅ 3) UPDATE
//		String query11 = "UPDATE USERS SET NAME=?, EMAIL=?, PASSWORD=? WHERE ID=?";
//		Connection connection11 = DBConnection.getConnection();
//
//		try {
//		    PreparedStatement ps = connection11.prepareStatement(query11);
//
//		    ps.setString(1, "Ravi Kumar");
//		    ps.setString(2, "ravi@gmail.com");
//		    ps.setString(3, "newpass");
//		    ps.setInt(4, 1003);
//
//		    int row = ps.executeUpdate();
//
//		    if (row > 0) {
//		        System.out.println("User Updated Successfully");
//		    }
//
//		} catch (SQLException e) {
//		    e.printStackTrace();
//		}
//		
//		
//		
////		✅ 4) DELETE
//		String query111 = "DELETE FROM USERS WHERE ID=?";
//		Connection connection111 = DBConnection.getConnection();
//
//		try {
//		    PreparedStatement ps = connection111.prepareStatement(query111);
//
//		    ps.setInt(1, 1003);
//
//		    int row = ps.executeUpdate();
//
//		    if (row > 0) {
//		        System.out.println("User Deleted Successfully");
//		    }
//
//		} catch (SQLException e) {
//		    e.printStackTrace();
//		}
////		✅ 5) LOGIN (Very Important 🔥)
//		String query1111 = "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";
//		Connection connection1111 = DBConnection.getConnection();
//
//		try {
//		    PreparedStatement ps = connection1111.prepareStatement(query1111);
//
//		    ps.setString(1, "abhi@gmail.com");
//		    ps.setString(2, "abhi@123");
//
//		    ResultSet rs = ps.executeQuery();
//
//		    if (rs.next()) {
//		        System.out.println("Login Successful");
//		    } else {
//		        System.out.println("Invalid Credentials");
//		    }
//
//		} catch (SQLException e) {
//		    e.printStackTrace();
//		}
//	}
//}
