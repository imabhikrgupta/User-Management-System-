package com.user.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

//	register / insert
	
	public boolean registerUser(User user) {
		boolean status=false;
		
		try {
			
			Connection con= DBConnection.getConnection();
			
			String query="INSERT INTO user_db(id,name,email,password) VALUES(?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4,user.getPassword());
			
			int row=ps.executeUpdate();
			
			if(row>0) {
				status=true;
			}
					
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return status;
	}
	
	
	//login
	public boolean loginUser(String email, String password) {
		
		boolean status=false;
		
		try {
			Connection con= DBConnection.getConnection();
			
			String query="SELECT * FROM user_db WHERE email=? AND password=?";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,email);
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				status=true;
			}
							
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
		
	}
	
	
	// Read / view All user
	
	public List<User> getAllUser(){
		
		List<User> list=new ArrayList<>();
		
		try {
			Connection con=DBConnection.getConnection();
			
			String query="SELECT * FROM user_db";
			PreparedStatement ps= con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User u=new User(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("password")
						);
				list.add(u);
			}
			
					
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return list;
	}
	
	
//	  get User By Id 
	public User getUserById(int id) {
		
		User user=null;
		
		try {
			Connection con=DBConnection.getConnection();
			String query="SELECT * FROM user_db WHERE ID=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user=new User(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("password")
						);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	
//	  Update 
	
	public boolean updateUser(User user) {
		
		boolean status=false;
		try {
			Connection con= DBConnection.getConnection();
			
			String  query="UPDATE user_db SET name=?, email=?, password=? where id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getId());
			
			//IO.println(user);
			int row=ps.executeUpdate();
			
			if(row>0) {
				status=true;						
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
//	 delete
	
	public boolean deleteUser(int id) {
		boolean status=false;
		
		try {
			Connection con= DBConnection.getConnection();
			
			String query="DELETE FROM user_db WHERE id=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if(row>0) {
				status =true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
