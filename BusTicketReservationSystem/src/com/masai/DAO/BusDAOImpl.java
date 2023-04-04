package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.masai.DTO.Bus;
import com.masai.Exception.ExceptionInBus;

public class BusDAOImpl implements BusDAO {

	@Override
	public void addBus(Bus bus) throws ExceptionInBus {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "INSERT INTO Bus (busname, source, destination, busType, departureTime, arrivalTime, totalSeats) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, bus.getBusname());
			ps.setString(2, bus.getSource());
			ps.setString(3, bus.getDestination());
			ps.setString(4, bus.getBusType());
			ps.setTimestamp(5, Timestamp.valueOf(bus.getDepartureTime()));
			ps.setTimestamp(6, Timestamp.valueOf(bus.getArrivalTime()));
			ps.setInt(7, bus.getTotalSeats());

			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInBus("Unable to add bus");
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
	public void updateBus(Bus bus, int busId) throws ExceptionInBus {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "UPDATE Bus SET busname = ?, busType = ?, totalSeats = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, bus.getBusname());
			ps.setString(2, bus.getBusType());
			ps.setInt(3, bus.getTotalSeats());
			ps.setInt(4, busId);
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInBus("Unable to Update bus");
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
	public void deleteBus(int busId) throws ExceptionInBus {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionFromHere();

			String query = "UPDATE Bus SET is_delete = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, 1);
			ps.setInt(2, busId);
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInBus("Unable to delete bus");
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
	public int viewBookingsForADateRange(LocalDate startingDate, LocalDate endingDate) throws ExceptionInBus {

		Connection conn = null;
		int n = 0;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "SELECT COUNT(*) AS 'Total Bookings' FROM bookings WHERE booking_date BETWEEN ? AND ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDate(1, Date.valueOf(startingDate));
			ps.setDate(2, Date.valueOf(endingDate));
			ResultSet rs = ps.executeQuery();

			if (DBUtils.isResultSetEmpty(rs)) {
				System.out.println("There is no such bookings available in this range");
			} else {
				rs.next();
				n = rs.getInt(1);
			}

		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInBus("Something went wrong in date range");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n;
	}

	@Override
	public int viewBookingsByBusName(String busName) throws ExceptionInBus {
		Connection conn = null;
		int n = 0;
		try {
			conn = DBUtils.getConnectionFromHere();
			String query = "SELECT COUNT(*) FROM bus b INNER JOIN bookings bs ON b.id = bs.bus_id WHERE b.busname = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, busName);
			ResultSet rs = ps.executeQuery();

			if (DBUtils.isResultSetEmpty(rs)) {
				System.out.println("There is no such bookings available for this bus "+busName);
			} else {
				rs.next();
				n = rs.getInt(1);
			}

		} catch (SQLException | ClassNotFoundException ex) {
			throw new ExceptionInBus("Something went wrong in search bookings with busname");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n;
	}

}
