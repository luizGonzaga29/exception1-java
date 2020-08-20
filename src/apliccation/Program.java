package apliccation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner entry = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reservation res = new Reservation();
			
		try {
			System.out.print("Room number: ");
			int roomNumber = res.checkRoom(entry.nextLine());
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIni = sdf.parse(entry.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(entry.next());
					
			Reservation reservation = new Reservation(roomNumber, checkIni, checkOut);
			System.out.println(reservation);
			System.out.println();
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIni = sdf.parse(entry.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(entry.next());
			
			reservation.updateDates(checkIni, checkOut);
			
			System.out.println(reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		/*catch (RuntimeException e) {
			System.out.println("Unexpected exception!");
		}*/
		entry.close();
	}

}
