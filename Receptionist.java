import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Receptionist extends Staff {

 public Receptionist(String name, String password, LocalDate birthDate, int weeklyHours) {
    super(name, password, birthDate, Role.RECEPTIONIST, weeklyHours);
 }
   
 public static void login(){
    login(Database.getReceptionists());
 }

 public void processCheckIn(int targetResId, List<Reservation> allRes) {
   if (targetResId >= 0 && targetResId < allRes.size()) {
       allRes.get(targetResId).setReservationStatus(Reservation.ReservationStatus.CONFIRMED);
       System.out.println("Check-in successful for Reservation ID: " + targetResId);
       return;
   }
   System.out.println("Error: Could not find Reservation ID " + targetResId);
  }

 public void processCheckOut(int targetResId, List<Reservation> allRes) {
   if (targetResId >= 0 && targetResId < allRes.size()) {
       allRes.get(targetResId).setReservationStatus(Reservation.ReservationStatus.COMPLETED);
       System.out.println("Check-out successful for Reservation ID: " + targetResId);
       return;
   }
   System.out.println("Error: Could not find Reservation ID " + targetResId);
 }

 public void displayMenu(List<Reservation> allRes) {
   Scanner input = new Scanner(System.in);
   System.out.println("\n    Receptionist Desk ");
   System.out.println("1. Check-In\n2. Check-Out\n3. View All");
   System.out.print("Choice: ");
   int choice = input.nextInt();

   switch (choice) {
    case 1:
      System.out.print("Enter Reservation ID: ");
      processCheckIn(input.nextInt(), allRes);
       break;
    case 2:
      System.out.print("Enter Reservation ID: ");
      processCheckOut(input.nextInt(), allRes);
       break;
    case 3:
      viewAllRes(allRes);
       break;
       }
   }

}
