package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.BookingModel;

public class BookingDAO {
	
	public BookingModel getDetails(int booking_id) {
		
		Connection connect = null;
		ResultSet resultSet = null;
		Statement statement = null;
		PreparedStatement pStmt =null;
		
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny", "root", "papa1602");
			
			pStmt = connect.prepareStatement("SELECT * FROM Booking WHERE booking_id = ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
			pStmt.setInt(1, booking_id); 
			resultSet = pStmt.executeQuery(); 
			
			BookingModel booking = new BookingModel();
			
			if(resultSet.next())
			{
				booking.setBooking_price(resultSet.getInt("booking_price"));
				booking.setFirst_date(resultSet.getString("first_date"));
				booking.setLast_date(resultSet.getString("last_date"));
			}
			
			
			System.out.println(booking.toString());
			return booking;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
