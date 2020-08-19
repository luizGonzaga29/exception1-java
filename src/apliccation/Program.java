package apliccation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner entry = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
				
		System.out.print("Room number: ");
		int roomNumber = entry.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIni = sdf.parse(entry.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(entry.next());
		
		if(!checkOut.after(checkIni)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		}
		else { 
			Reservation reservation = new Reservation(roomNumber, checkIni, checkOut);
			System.out.println(reservation);
			System.out.println();
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIni = sdf.parse(entry.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(entry.next());
			
			Date now = new Date();
			
			if(checkIni.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!checkOut.after(checkIni)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date!");	
			}
			else {
				reservation.updateDates(checkIni, checkOut);
				System.out.println(reservation);
			}
		}
		
		
		
		
		System.out.println();
		
		
		entry.close();
	}

}
