package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.masai.Exception.UnableToEditProfile;
import com.masai.UI.CustomerLogin;

public class ProfileDAOImpl implements ProfileDAO {

	@Override
	public void changeName(String name) throws UnableToEditProfile {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "UPDATE passengers SET name = ? WHERE pid = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, name);
			ps.setInt(2, CustomerLogin.passengerId);
			
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw new UnableToEditProfile("Unable to edit name");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void changeUserName(String username) throws UnableToEditProfile {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "UPDATE passengers SET username = ? WHERE pid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, username);
			ps.setInt(2, CustomerLogin.passengerId);
			
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw new UnableToEditProfile("Unable to edit username");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void changeMobile(String mobile) throws UnableToEditProfile {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "UPDATE passengers SET mobile_no = ? WHERE pid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, mobile);
			ps.setInt(2, CustomerLogin.passengerId);
			
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw new UnableToEditProfile("Unable to edit mobile number");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void changePassword(String oldPassword, String newPassword) throws UnableToEditProfile {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "UPDATE passengers SET password = ? WHERE pid = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, newPassword);
			ps.setInt(2, CustomerLogin.passengerId);
			ps.setString(3, oldPassword);
			
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw new UnableToEditProfile("Unable to Update password");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
