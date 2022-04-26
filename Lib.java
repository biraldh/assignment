package ConLib;

import java.sql.Date;

public class Lib {

	String Name;
	String Dob;
	String gender;
	String email;
	String Address;
	int Phone;
	String Credit;
	String Nation;
	String cusType;
	String Pass;

	public Lib() {

		Name = "";
		Dob = null;
		this.gender = "";
		this.email = "";
		Address = "";
		Phone = 0;
		Credit = "";
		Pass = "";
		Nation = "";
		this.cusType = "";
	}

	public Lib(String name, String AsDate, String gender, String email, String address, int phone, String credit,
			String nation, String cusType, String pass) {

		Name = name;
		Dob = AsDate;
		this.gender = gender;
		this.email = email;
		Address = address;
		Phone = phone;
		Credit = credit;
		Nation = nation;
		this.cusType = cusType;
		Pass = pass;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int phone) {
		Phone = phone;
	}

	public String getCredit() {
		return Credit;
	}

	public void setCredit(String credit) {
		Credit = credit;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getNation() {
		return Nation;
	}

	public void setNation(String nation) {
		Nation = nation;
	}

	public String getCusType() {
		return cusType;
	}

	public void setCusType(String cusType) {
		this.cusType = cusType;
	}

}
