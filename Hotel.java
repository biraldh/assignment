package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ConLib.JDBC;
import ConLib.Lib;

public class Hotel extends JFrame implements ActionListener {
	public JLabel lbltitle;

	public JPasswordField txtPass;
	public JTextField txtAdd;
	public JTextField txtNum;
	public JTextField txtNam;
	public JTextField txtDob;
	public JTextField txtEmail;
	public JTextField txtNat;
	public JTextField txtCredit;
	public JLabel lbltxt, lbldot, lblPass, lblAdd, lblNum, lblNam, lblDob, lblEmail, lblGender, lblNat, lblCredit,
			lblCusty;
	public JComboBox cGender, cCusty;
	public JButton btnLog, btnReg;

	public Hotel() {
		setSize(450, 460);
		setResizable(false);
		// declare and initialize variables
		JPanel panel = new JPanel();
		int alpha = 128;
		Color bgColor = new Color(40, 100, 200, alpha);
		panel.setBackground(bgColor);
		panel.setLayout(null);

		JLabel lbltitle = new JLabel("Welcome To Luton Hotel");
		lbltitle.setBounds(80, 2, 309, 27);
		lbltitle.setForeground(new Color(0, 0, 0));
		lbltitle.setFont(new Font("Tahoma", Font.BOLD, 24));

		lblCusty = new JLabel("Customer Type: ");
		lblCusty.setBounds(20, 45, 95, 20);

		String Custy[] = { "Customer", "Corporate Customer" };
		cCusty = new JComboBox(Custy);
		cCusty.setBounds(110, 45, 170, 20);

		lblNam = new JLabel("Name : ");
		lblNam.setBounds(20, 105, 100, 20);

		txtNam = new JTextField();
		txtNam.setBounds(110, 105, 280, 20);

		lblPass = new JLabel("Password : ");
		lblPass.setBounds(20, 135, 100, 20);

		txtPass = new JPasswordField();
		txtPass.setBounds(110, 135, 280, 20);

		lblNum = new JLabel("Phone No : ");
		lblNum.setBounds(20, 165, 100, 20);

		txtNum = new JTextField();
		txtNum.setBounds(110, 165, 280, 20);

		lblNat = new JLabel("Nationality : ");
		lblNat.setBounds(20, 195, 100, 20);

		txtNat = new JTextField();
		txtNat.setBounds(110, 195, 280, 20);

		lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(20, 225, 100, 20);

		txtEmail = new JTextField();
		txtEmail.setBounds(110, 225, 280, 20);

		lblAdd = new JLabel("Address : ");
		lblAdd.setBounds(20, 255, 100, 20);

		txtAdd = new JTextField();
		txtAdd.setBounds(110, 255, 280, 20);

		lblDob = new JLabel("Date of Birth : ");
		lblDob.setBounds(20, 285, 150, 20);

		txtDob = new JTextField();
		txtDob.setBounds(110, 285, 110, 20);

		lblGender = new JLabel("Gender : ");
		lblGender.setBounds(230, 285, 150, 20);

		String gender[] = { "Male", "Female" };
		cGender = new JComboBox(gender);
		cGender.setBounds(300, 285, 90, 20);

		lblCredit = new JLabel("Credit Card : ");
		lblCredit.setBounds(20, 315, 100, 20);

		txtCredit = new JTextField();
		txtCredit.setBounds(110, 315, 280, 20);

		btnLog = new JButton("Login");
		btnLog.setBounds(110, 360, 100, 20);
		btnLog.addActionListener(this);

		btnReg = new JButton("Register");
		btnReg.setBounds(230, 360, 100, 20);
		btnReg.addActionListener(this);

		lbltxt = new JLabel("www.lutonhotel.com");
		lbltxt.setBounds(155, 405, 150, 20);
		lbltxt.setFont(new Font("Tahoma", Font.BOLD, 10));

		lbldot = new JLabel("____________________________________________________________________");
		lbldot.setBounds(0, 390, 1000, 20);

		// add variables to jpanel
		panel.add(lbltitle);
		panel.add(lbldot);
		panel.add(lblPass);
		panel.add(txtPass);
		panel.add(lblNat);
		panel.add(txtNat);
		panel.add(lblEmail);
		panel.add(txtEmail);
		panel.add(btnLog);
		panel.add(btnReg);
		panel.add(lblAdd);
		panel.add(txtAdd);
		panel.add(lblNum);
		panel.add(txtNum);
		panel.add(lblNam);
		panel.add(txtNam);
		panel.add(lblDob);
		panel.add(txtDob);
		panel.add(lblCredit);
		panel.add(txtCredit);
		panel.add(lbltxt);
		panel.add(lblGender);
		panel.add(cGender);
		panel.add(lblCusty);
		panel.add(cCusty);
		// add panel to jframe
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Hotel();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// button login then goes to dashboard
		if (e.getSource() == btnLog) {
			new Demo().setVisible(true);
			this.dispose();
			// changing String to date data type
		} else if (e.getSource() == btnReg) {

			String dat = txtDob.getText();

			try {
				Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dat);
			} catch (ParseException e1) {

			}
			// new variable for textField

			String name = txtNam.getText();
			String gender = cGender.getSelectedItem().toString();
			String email = txtEmail.getText();
			String add = txtAdd.getText();
			int num = Integer.parseInt(txtNum.getText());
			String pass = txtPass.getText();
			String Nation = txtNat.getText();
			String Credit = txtCredit.getText();
			String custType = cCusty.getSelectedItem().toString();

			// email pattern is correct or not
			Pattern regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
			Matcher regMatcher = regexPattern.matcher(email);

			// if email pattern correct code will execute
			if (regMatcher.matches()) {

				// if fields are empty data wont be sent
				if (name.isEmpty() || gender.isEmpty() || email.isEmpty() || add.isEmpty() || pass.isEmpty()
						|| Nation.isEmpty() || Credit.isEmpty() || custType.isEmpty() || num == 0) {

					JOptionPane.showMessageDialog(null, "enter text in textfield");

				} // finding if password has 8 letters or not
				if (pass.length() <= 8) {
					JOptionPane.showMessageDialog(null, "password needs to be greater then 8 letters!");

				}

				else {
					// sending data to database
					Lib input = new Lib(name, dat, gender, email, add, num, Credit, Nation, custType, pass);
					JDBC jdbc = new JDBC();
					boolean result = jdbc.save(input);

				}

			} else {
				JOptionPane.showMessageDialog(null, "Email invalid");
			}
		}

	}

}
