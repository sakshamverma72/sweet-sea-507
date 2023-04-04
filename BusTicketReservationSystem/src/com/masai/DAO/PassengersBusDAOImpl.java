package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.Bus;
import com.masai.DTO.BusImpl;
import com.masai.DTO.Customer;
import com.masai.Exception.ExceptionInPassengers;
import com.masai.UI.CustomerLogin;

public class PassengersBusDAOImpl implements PassengersBusDAO {

	@Override
	public void addPassengers(Customer customer) throws ExceptionInPassengers {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "INSERT INTO Passengers (passenger_id, name, username, password, mobile_no) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, customer.id());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getUsername());
			ps.setString(4, customer.getPassword());
			ps.setString(5, customer.getMobile_no());

			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInPassengers("Unable to add customer");
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
	public boolean loginPassengers(Customer customer) throws ExceptionInPassengers {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "SELECT * FROM Passengers WHERE username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());

			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				return false;
			}
			else {
				while(rs.next()) {
					CustomerLogin.passengerId = rs.getInt(1);
				}
				return true;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInPassengers("Unable to add bus");
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
	public List<Bus> showAvailableBuse() throws ExceptionInPassengers {
		Connection conn = null;
		List<Bus> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionFromHere();
			LocalDateTime lct = LocalDateTime.now();
			String query = "SELECT * FROM Bus WHERE departureTime < ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setTimestamp(1, Timestamp.valueOf(lct));
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				list = null;
			}
			else {
				while(rs.next()) {
					list.add(new BusImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6).toLocalDateTime(), rs.getTimestamp(7).toLocalDateTime(), rs.getInt(8)));
				}
			}

		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInPassengers("Unable to add bus");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void bookTicketByBussNumber(int busId) throws ExceptionInPassengers {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "INSERT INTO bookings (passenger_id, bus_id, booking_date) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, CustomerLogin.passengerId);
			ps.setInt(2, busId);
			ps.setDate(3, Date.valueOf(LocalDate.now()));
			
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInPassengers("Unable to book ticket");
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
	public List<Bus> bookingHistory() throws ExceptionInPassengers {
		Connection conn = null;
		List<Bus> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "select b.id, busname, source, destination, departureTime, arrivalTime from bus b inner join bookings bs on b.id = bs.bus_id inner join passengers p on p.pid = bs.passenger_id where pid = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, CustomerLogin.passengerId);
			
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				list = null;
			}
			else {
				while(rs.next()) {
					list.add(new BusImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), null,rs.getTimestamp(5).toLocalDateTime(), rs.getTimestamp(6).toLocalDateTime(), 0));
				}
			}
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInPassengers("Unable to fetch history");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void deleteAccount(String oldPassword) throws ExceptionInPassengers {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "UPDATE passengers SET is_delete = 1 WHERE pid = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, CustomerLogin.passengerId);
			ps.setString(2, oldPassword);
			
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInPassengers("Unable to Delete account password");
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
