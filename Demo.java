package GUI;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ConLib.Lib;
// import ConLib.Connector;

public class Demo extends JFrame implements ActionListener {
	JTextField txtID;
	JPasswordField txtPass;
	JLabel lblID, lblPass;
	JButton btnLog, btnReg;

	public Demo() {
		setSize(300, 230);
		setResizable(false);
		// Jpanel Characteristic
		JPanel panel = new JPanel();
		int alpha = 128;
		Color bgColor = new Color(0, 0, 255, alpha);
		panel.setBackground(bgColor);
		panel.setLayout(null);
		// declare initialize variables
		lblID = new JLabel("Email");
		lblID.setBounds(70, 30, 100, 20);

		txtID = new JTextField();
		txtID.setBounds(140, 30, 100, 20);

		lblPass = new JLabel("Password");
		lblPass.setBounds(70, 70, 100, 20);

		txtPass = new JPasswordField();
		txtPass.setBounds(140, 70, 100, 20);

		btnLog = new JButton("Login");
		btnLog.setBounds(30, 120, 100, 20);
		btnLog.addActionListener(this);

		btnReg = new JButton("Registor");
		btnReg.setBounds(150, 120, 100, 20);
		btnReg.addActionListener(this);
		// adding fields, label etc to panel
		panel.add(lblID);
		panel.add(txtID);
		panel.add(lblPass);
		panel.add(txtPass);
		panel.add(btnLog);
		panel.add(btnReg);
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {

		new Demo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if btnreg pressed registration page opens
		if (e.getSource() == btnReg) {
			try {
				new Regis();
			} catch (ParseException e1) {

				e1.printStackTrace();
			}
			dispose();
		}
		// if btnlog pressed dashborad page opens
		else if (e.getSource() == btnLog) {
			String email = txtID.getText();
			String password = txtPass.getText();
			try {
				Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample",
						"root", "");

				PreparedStatement st = (PreparedStatement) connection
						.prepareStatement("Select name, password from registration where email=? and password=?");

				st.setString(1, email);
				st.setString(2, password);
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					dispose();
					new dash().setVisible(true);

				} else {
					JOptionPane.showMessageDialog(btnLog, "Wrong email or Password");
				}
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
	}
}
