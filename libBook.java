package ConLib;

public class libBook {
	
    String Checkin_date ;
    String Checkout_date ;
    String Change_view;
    String Booking_status ;
    String preffered_room ; 
    int Uid ;
    String roomType;
    String roomPrice;
    int roomNo; 
    
	
    public libBook() {
		
		Checkin_date = "";
		Checkout_date = "";
		Change_view = "";
		Booking_status = "";
		this.preffered_room = "";
		Uid = 0;
		roomType ="";
		roomPrice = "";
		roomNo = 0;
	}
    
    
	public libBook(String checkin_date, String checkout_date, String change_view, String booking_status,
			String preffered_room, int uid, String roomType, String roomPrice, int roomNo) {
		super();
		Checkin_date = checkin_date;
		Checkout_date = checkout_date;
		Change_view = change_view;
		Booking_status = booking_status;
		this.preffered_room = preffered_room;
		Uid = uid;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomNo = roomNo;
	}



	public String getCheckin_date() {
		return Checkin_date;
	}
	public void setCheckin_date(String checkin_date) {
		Checkin_date = checkin_date;
	}
	public String getCheckout_date() {
		return Checkout_date;
	}
	public void setCheckout_date(String checkout_date) {
		Checkout_date = checkout_date;
	}
	public String getChange_view() {
		return Change_view;
	}
	public void setChange_view(String change_view) {
		Change_view = change_view;
	}
	public String getBooking_status() {
		return Booking_status;
	}
	public void setBooking_status(String booking_status) {
		Booking_status = booking_status;
	}
	public String getPreffered_room() {
		return preffered_room;
	}
	public void setPreffered_room(String preffered_room) {
		this.preffered_room = preffered_room;
	}
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public String getRoomPrice() {
		return roomPrice;
	}


	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}


	public int getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	
    
}
