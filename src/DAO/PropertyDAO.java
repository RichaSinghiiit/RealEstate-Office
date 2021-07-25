package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.BookingModel;
import Models.PropertyModel;

public class PropertyDAO {
	
public PropertyModel getDetails(int property_id) throws SQLException {
		
		Connection connect = null;
		ResultSet resultSet = null;
		Statement statement = null;
		PreparedStatement pStmt =null;
		
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny", "root", "papa1602");
			
		pStmt = connect.prepareStatement("SELECT * FROM Property WHERE property_id = ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
		pStmt.setInt(1, property_id); 
		resultSet = pStmt.executeQuery(); 
		
		PropertyModel property = new PropertyModel();
		
		if(resultSet.next())
		{
			property.setAsking_price(resultSet.getInt("asking_price"));
			property.setConstruction_status(resultSet.getString("construction_status"));
			property.setFurnishing(resultSet.getString("furnishing"));
			property.setHouse_number(resultSet.getInt("house_number"));
			property.setLocality(resultSet.getString("locality"));
			property.setNew_or_resale(resultSet.getString("new_or_resale"));
			property.setNumber_of_bathrooms(resultSet.getInt("number_of_bathrooms"));
			property.setNumber_of_bedrooms(resultSet.getInt("number_of_bedrooms"));
			property.setParking(resultSet.getInt("parking"));
			property.setProperty_for(resultSet.getString("property_for"));
			property.setProperty_type(resultSet.getString("property_type"));
			property.setSize(resultSet.getInt("size"));
			property.setBooking_status(resultSet.getString("bookingStatus"));
		}
		
		
		pStmt = connect.prepareStatement("SELECT booking_price, first_date, last_date"
				+ "FROM Property P, Booking B WHERE P.property_id = ? AND B.property_id = P.property_id;",ResultSet.TYPE_SCROLL_INSENSITIVE);
		pStmt.setInt(1, property_id); 
		resultSet = pStmt.executeQuery();
		
		BookingModel booking = new BookingModel();
		if(resultSet.next())
		{
			booking.setBooking_price(resultSet.getInt("booking_price"));
			booking.setFirst_date(resultSet.getString("first_date"));
			booking.setLast_date(resultSet.getString("last_date"));
		}
		property.setBooking(booking);
		
		System.out.println(property.toString());
		return property;
}
}
