package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ConLib.JDBC;
import ConLib.Lib;
import ConLib.libBook;

public class BookingFrom extends JFrame implements ActionListener {
	
		JTextField txtID;
		JPanel panel;
		JTextField txtPass;
		JTextField txtNum , txtNum1, txtNum2, txtNum3;
		JTextField txtNam;
		JLabel lbltitle, lblID, lbldot, lbltxt, lblPass, lblAdd, lblNum, lblNum1, lblNum2, lblNum3, lblNam, lblbot;
		JButton btnLog, btnReg, btnback;

		public BookingFrom() {
			setSize(380, 380);
			setResizable(false);
			setLayout(null);

			panel = new JPanel();
			panel.setBounds(0, 0, 450, 460);
			int alpha = 128;
			Color bgColor = new Color(40, 100, 200, alpha);
			panel.setBackground(bgColor);
			panel.setLayout(null);

			lbltitle = new JLabel("Booking Form");
			lbltitle.setBounds(110, 5, 309, 27);
			lbltitle.setForeground(new Color(0, 0, 0));
			lbltitle.setFont(new Font("Bauhaus 93", Font.PLAIN, 27));

			lblID = new JLabel("User ID : ");
			lblID.setBounds(20, 50, 100, 20);

			txtID = new JTextField();
			txtID.setBounds(120, 50, 200, 20);

			lblNam = new JLabel("Room No. : ");
			lblNam.setBounds(20, 80, 100, 20);

			txtNam = new JTextField();
			txtNam.setBounds(120, 80, 200, 20);

			lblPass = new JLabel("Room Type : ");
			lblPass.setBounds(20, 110, 100, 20);

			txtPass = new JTextField();
			txtPass.setBounds(120, 110, 200, 20);

			lblNum = new JLabel("Room Price : ");
			lblNum.setBounds(20, 140, 100, 20);

			txtNum = new JTextField();
			txtNum.setBounds(120, 140, 200, 20);

			lblNum1 = new JLabel("Checkin Date : ");
			lblNum1.setBounds(20, 170, 100, 20);

			txtNum1 = new JTextField();
			txtNum1.setBounds(120, 170, 200, 20);

			lblNum2 = new JLabel("Checkout Date : ");
			lblNum2.setBounds(20, 200, 100, 20);

			txtNum2 = new JTextField();
			txtNum2.setBounds(120, 200, 200, 20);

			lblNum3 = new JLabel("Booking Status : ");
			lblNum3.setBounds(20, 230, 100, 20);

			txtNum3 = new JTextField();
			txtNum3.setBounds(120, 230, 200, 20);

			btnLog = new JButton("Save");
			btnLog.setBounds(30, 270, 100, 30);
			btnLog.addActionListener(this);

			btnReg = new JButton("Search");
			btnReg.setBounds(140, 270, 100, 30);
			btnReg.addActionListener(this);

			btnback = new JButton("Back");
			btnback.setBounds(250, 270, 100, 30);
			btnback.addActionListener(this);

			lbltxt = new JLabel("www.lutonhotel.com");
			lbltxt.setBounds(130, 320, 150, 20);
			lbltxt.setFont(new Font("Tahoma", Font.BOLD, 10));

			lbldot = new JLabel("____________________________________________________________________");
			lbldot.setBounds(0, 300, 1000, 20);

			lblbot = new JLabel(
					"-------------------------------------------------------------------------------------------------------------");
			lblbot.setBounds(0, 20, 1000, 20);

			panel.add(lbltitle);
			panel.add(lbldot);
			panel.add(lblbot);
			panel.add(lblID);
			panel.add(txtID);
			panel.add(lblPass);
			panel.add(txtPass);
			panel.add(btnLog);
			panel.add(btnReg);
			panel.add(lblNum);
			panel.add(txtNum);
			panel.add(lblNum1);
			panel.add(txtNum1);
			panel.add(lblNum2);
			panel.add(txtNum2);
			panel.add(lblNum3);
			panel.add(txtNum3);
			
			panel.add(lblNam);
			panel.add(txtNam);
			panel.add(lbltxt);
			panel.add(btnback);
			add(panel);
			setVisible(true);
		}


	

	public static void main(String[] args) {
		new BookingFrom();

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnLog) {
			String view = txtView.getText();
			String Chekout = txtChekout.getText();
			try {
				Date Chekout1 = new SimpleDateFormat("yyyy/MM/dd").parse(Chekout);
			} catch (ParseException e1) {
				System.out.println("Error :" +e1.getMessage());
			}
			String Checkin = txtCheckin.getText();
			try {
				Date Checkin1 = new SimpleDateFormat("yyyy/MM/dd").parse(Checkin);
			} catch (ParseException e1) {
				System.out.println("Error :" +e1.getMessage());
			}
			String Pref = txtPref.getText();
			String status =  txtStatus.getText();
			int Id = Integer.parseInt(txtId.getText());
			libBook input = new libBook (Checkin , Chekout,view,status,Pref,Id );
			JDBC jdbc = new JDBC();
			boolean result = jdbc.saveBook(input);
		}
	}*/
}