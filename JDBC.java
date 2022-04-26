package ConLib;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.Regis;

public class JDBC extends Connector {

	JButton btn;

	public boolean save(Lib inse) {
		//declare and initialize
		boolean result = false;
		Connection conn;
		String sql = "insert into registration(name, Dob, gender ,address, nationality, email, phone, Credit, customerType, password ) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstat;
		try {
			//sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);			
			pstat.setString(1, inse.getName());
			pstat.setString(2,  inse.getDob());
			pstat.setString(3, inse.getGender());
			pstat.setString(4, inse.getAddress());
			pstat.setString(5, inse.getNation());
			pstat.setString(6, inse.getEmail());
			pstat.setInt(7, inse.getPhone());
			pstat.setString(8, inse.getCredit());
			pstat.setString(9, inse.getCusType());
			pstat.setString(10, inse.getPass());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Welcome to Hotel Luton!!");	
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" +ex.getMessage());
		}
		return result;

	}
	public boolean saveBook(libBook inse) {
		//declare and initialize
		boolean result = false;
		Connection conn;
		String sql = "insert into booking (Checkin_date,Checkout_date,Change_view,Booking_status,preffered_room,Uid)values(?,?,?,?,?,?)";
		PreparedStatement pstat;
		try {
			//sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);			
			pstat.setString(1, inse.getCheckin_date());
			pstat.setString(2,  inse.getCheckout_date());
			pstat.setString(3, inse.getChange_view());
			pstat.setString(4, inse.getBooking_status());
			pstat.setString(5, inse.getPreffered_room());
			pstat.setInt(6, inse.getUid());
			
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Your Booking was a Sucess!!");	
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" +ex.getMessage());
		}
		return result;

	}
}
