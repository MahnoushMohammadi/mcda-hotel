
public class ReservationData {
	public String checkIn;
	public String checkOut;
	public int guestNum;
	public int roomNum;
	public String lName;
	public String fName;
	public String street;
	public String city;
	public String province;
	public String country;
	public String postalCode;
	public String phoneNumber;
	public String email;
	public String ccType;
	public String ccName;
	public String ccNumber;
	public String ccExpiry;

	
	public ReservationData(
			 String checkIn,
			 String checkOut,
			 int guestNum,
			 int roomNum,
			 String lName,
			 String fName,
			 String street,
			 String city,
			 String province,
			 String country,
			 String postalCode,
			 String phoneNumber,
			 String email,
			 String ccType,
			 String ccName,
			 String ccNumber,
			 String ccExpiry) {

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.guestNum = guestNum;
		this.roomNum = roomNum;
		this.lName = lName;
		this.fName = fName;
		this.street = street;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.ccType = ccType;
		this.ccName = ccName;
		this.ccNumber = ccNumber;
		this.ccExpiry = ccExpiry;
		
		
	}

}

