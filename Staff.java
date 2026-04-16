import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Staff extends User{

//enum
 public enum Role {
  ADMIN,
  RECEPTIONIST
 }


 private Role role;
 private int workingHours;

 public Staff(String username, String password, LocalDate dateOfBirth, Role role, int workingHours) {
    this.setUsername(username);
    this.setPassword(password);
    this.setDateOfBirth(dateOfBirth);
    this.role = role;
    this.workingHours = workingHours;
 }

 //Getters
 public Role getRole(){ 
 return role; 
 }

 //Viewing methods
 public void viewAllRooms(){
     for (int i = 0; i < Database.getRooms().size(); i++) {
         Database.getRoom(i).displayRoomDetails();
     }
 }

 public void viewAllGuests(){
     for (int i = 0; i < Database.getGuests().size(); i++) {
        Database.getGuest(i).displayDetails();
     }
 }

 public void viewAllReservations(){
     for (int i = 0; i < Database.getReservations().size(); i++) {
             System.out.println("Guest Reference: " + Database.getReservation(i).getGuestReference());
             System.out.println("Room Reference: " + Database.getReservation(i).getRoomReference());
             System.out.println("Check In Date: " + Database.getReservation(i).getCheckInDate());
             System.out.println("Check Out Date: " + Database.getReservation(i).getCheckOutDate());
             System.out.println("Status: " + Database.getReservation(i).getReservationStatus());
         }
     }
 }


 
