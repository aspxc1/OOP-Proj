import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Staff extends User{

//enum
 public enum Role {
  ADMIN,
  RECEPTIONIST
 }

 private String username;
 private String password;
 private LocalDate dateOfBirth;
 private Role role;
 private int workingHours;

 public Staff(String username, String password, LocalDate dateOfBirth, Role role, int workingHours) {
    this.username = username;
    this.password = password;
    this.dateOfBirth = dateOfBirth;
    this.role = role;
    this.workingHours = workingHours;
 }

 //Getters
 public String getUsername(){ 
 return username; 
 }
 public Role getRole(){ 
 return role; 
 }

 //Viewing methods
 public void viewAllRooms(List<Room> rooms) {
    rooms.forEach(System.out::println);
 }
}

 
