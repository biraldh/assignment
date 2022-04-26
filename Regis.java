package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ConLib.JDBC;
import ConLib.Lib;

public class Regis extends JFrame implements ActionListener {
	private static final java.sql.Date AsDate = null;
	JTextField txtID;
	JTextField txtPass;
	JTextField txtAdd;
	JTextField txtNum;
	JTextField txtNam;
	JTextField txtDob;
	JTextField txtEmail;
	JTextField txtCredit;
	JTextField txtNation;

	JLabel lblID, lblPass, lblAdd, lblNum, lblNam, lblDob, lblEmail, lblGender, lblCredit, lblNation, lblCusType;
	JComboBox cGender, cCusType;
	JButton btnLog, btnReg;

	public Regis() throws ParseException {
		setSize(700, 700);
		setResizable(false);

		JPanel panel = new JPanel();
		int alpha = 128;
		Color bgColor = new Color(0, 0, 255, alpha);
		panel.setBackground(bgColor);
		panel.setLayout(null);

		lblID = new JLabel("UserID");
		lblID.setBounds(80, 30, 100, 20);

		txtID = new JTextField();
		txtID.setBounds(180, 30, 100, 20);

		lblNam = new JLabel("Name");
		lblNam.setBounds(80, 70, 100, 20);

		txtNam = new JTextField();
		txtNam.setBounds(180, 70, 100, 20);

		lblPass = new JLabel("Password");
		lblPass.setBounds(80, 110, 100, 20);

		txtPass = new JTextField();
		txtPass.setBounds(180, 110, 100, 20);

		lblNum = new JLabel("Phone No");
		lblNum.setBounds(80, 150, 100, 20);

		txtNum = new JTextField();
		txtNum.setBounds(180, 150, 100, 20);

		lblAdd = new JLabel("Address");
		lblAdd.setBounds(80, 190, 100, 20);

		txtAdd = new JTextField();
		txtAdd.setBounds(180, 190, 100, 20);

		lblDob = new JLabel("Date of Birth");
		lblDob.setBounds(80, 230, 150, 20);

		txtDob = new JTextField();
		txtDob.setBounds(180, 230, 150, 20);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(80, 270, 150, 20);

		txtEmail = new JTextField();
		txtEmail.setBounds(180, 270, 150, 20);

		lblGender = new JLabel("Gender");
		lblGender.setBounds(80, 320, 150, 10);

		btnLog = new JButton("Login");
		btnLog.setBounds(100, 400, 100, 20);
		btnLog.addActionListener(this);

		btnReg = new JButton("Registor");
		btnReg.setBounds(230, 400, 100, 20);
		btnReg.addActionListener(this);

		String gender[] = { "male", "Female" };
		cGender = new JComboBox(gender);
		cGender.setBounds(180, 320, 150, 20);

		lblCusType = new JLabel("CusType");
		lblCusType.setBounds(80, 430, 150, 20);

		String cusTy[] = { "Customer", "Corp-Customer" };
		cCusType = new JComboBox(cusTy);
		cCusType.setBounds(180, 430, 150, 20);

		txtNation = new JTextField();
		txtNation.setBounds(180, 470, 150, 20);

		lblNation = new JLabel("Nation");
		lblNation.setBounds(80, 470, 150, 10);

		txtCredit = new JTextField();
		txtCredit.setBounds(180, 500, 150, 20);

		lblCredit = new JLabel("Credit");
		lblCredit.setBounds(80, 500, 150, 20);

		panel.add(lblID);
		panel.add(txtID);
		panel.add(lblPass);
		panel.add(txtPass);
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
		panel.add(lblEmail);
		panel.add(txtEmail);
		panel.add(lblGender);
		panel.add(cGender);
		panel.add(cCusType);
		panel.add(lblCusType);
		panel.add(lblCredit);
		panel.add(txtCredit);
		panel.add(lblNation);
		panel.add(txtNation);
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) throws ParseException {
		new Regis();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLog) {

			new Demo().setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnReg) {
			// declare initialize
			int Id = Integer.parseInt(txtID.getText());
			String name = txtNam.getText();

			String dat = txtDob.getText();
			// Date date = Date.valueOf(dat);

			try {
				Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dat);
			} catch (ParseException e1) {

			}

			// String Dob = txtDob.getText();
			String gender = cGender.getSelectedItem().toString();
			String email = txtEmail.getText();
			String add = txtAdd.getText();
			int num = Integer.parseInt(txtNum.getText());
			String pass = txtPass.getText();
			String Nation = txtNation.getText();
			String Credit = txtCredit.getText();
			String custType = cCusType.getSelectedItem().toString();

			// if fields are empty data wont be sent
			if (name.isEmpty() || gender.isEmpty() || email.isEmpty() || add.isEmpty() || pass.isEmpty()
					|| Nation.isEmpty() || Credit.isEmpty() || custType.isEmpty()) {
				JOptionPane.showMessageDialog(null, "enter text in textfield");

			} else {
				// sending data to database
				Lib input = new Lib(Id, name, dat, gender, email, add, num, Credit, Nation, custType, pass);
				JDBC jdbc = new JDBC();
				boolean result = jdbc.save(input);

			}

		}
	}
}
