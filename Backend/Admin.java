package Backend;

import java.time.LocalDate;
import java.util.*;

public class Admin extends Staff{
 public Admin(String username, String password, LocalDate dateOfBirth, int workingHours){
  super( username, password, dateOfBirth,Role.ADMIN, workingHours);
 }

 public static void login(){
  login(Database.getAdmins());
 }


 public void add(Manageable M){
     M.add();
 }

 public void delete(Manageable M){
     M.delete();
 }

 public void update(Manageable M, Manageable M2){
     M.update(M2);
 }

 public void read(Manageable M){
     M.read();
 }

 public void createRoom(RoomType roomType, List<Amenity> amenities,int floor){

     Room room = new Room(roomType, amenities, floor);
     Database.getRooms().add(room);
 }

 public void createAmenity(String name, int roomnumber){

     Amenity amenity = new Amenity(name);
     Database.getRoom(roomnumber).getAmenities().add(amenity);
 }

 public void createRoomType(String name, double price){
     RoomType roomType = new RoomType(name, price);
 }
}


