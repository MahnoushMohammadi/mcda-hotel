import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Csv2Reservation {

	public static ReservationData convert2csv(String path) {
		ReservationData data;
		Reader in;
		try {
			in = new FileReader(path);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			for (CSVRecord record : records) {
			    String checkIn = record.get(0);
			    String checkOut = record.get(1);    
				 int guestNum = Integer.parseInt(record.get(2));
				 int roomNum = Integer.parseInt(record.get(3));
				 String lName = record.get(4);
				 String fName = record.get(5); // at this, point skip 1
				 String street = record.get(7);
				 String city = record.get(8);
				 String province = record.get(10); // reordered  (9)
				 String country = record.get(9); // reorederd (10)
				 String postalCode = record.get(11);
				 String phoneNumber = record.get(12);
				 String email = record.get(13); // skip one
				 String ccType = record.get(15);
				 String ccName = record.get(16);
				 String ccNumber = record.get(17);
				 String ccExpiry = record.get(18);
			    
			    data = new ReservationData(
				  checkIn, checkOut, guestNum, roomNum,	lName, fName,
				  street, city, province, country, postalCode, phoneNumber,
				  email, ccType, ccName, ccNumber, ccExpiry);
			    return data;
			}			
			
		} catch ( IOException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	

		

}
