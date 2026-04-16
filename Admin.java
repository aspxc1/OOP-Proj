import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

public class Admin extends Staff{
 public Admin(String username, String password, LocalDate dateOfBirth, int workingHours){
  super( username, password, Role.ADMIN, dateOfBirth, workingHours);
 }

 public static void login(){
  login(Database.getAdmins());
 }


 public void createRoom(Room room, List<Room> roomDatabase){
  roomDatabase.add(room);
 }

 public Room readRoom(String roomNumber, List<Room> roomDatabase){
  for(Room room : roomDatabase){ 
     if (room.getRoomNumber().equals(roomNumber)){
       return room;
   }
  } return null;
 }
 
 public void updateRoom(Room newRoom, List<Room> roomDatabase){
  for(int i=0; i<roomDatabase.size(); i++){
   if(roomDatabase.get(i).getRoomNumber().equals(newRoom.getRoomNumber())){
    roomDatabase.set(i, newRoom);
    return;//To exit when reaching the right room to not going through all of it
   }
  }
 }
 
 public void deleteRoom(String roomNumber, List<Room> roomDatabase){
  roomDatabase.removeif(room -> room.getRoomNumber().equals(roomNumber));
 }

 public void createAmenity(Amenity amenity, List<Amenity> amenityDatabase){
  amenityDatabase.add(amenity);
 }

 public Amenity readAmenity(String amenityId, List<Amenity> amenityDatabase){
  for(Amenity amenity : amenityDatabase){ 
     if (amenity.getamenityId().equals(amenityId)){
       return amenity;
   }
  } return null;
 }
 
 public void updateAmenity(Amenity newAmenity, List<Amenity> amenityDatabase){
  for(int i=0; i<amenityDatabase.size(); i++){
   if(amenityDatabase.get(i).getAmenityId().equals(newAmenity.getAmenityId())){
    amenityDatabase.set(i, newAmenity);
    return;//To exit when reaching the right amenityId to not going through all of it
   }
  }
 }
 
 public void deleteAmenity(String amenityId, List<Amenity> amenityDatabase){
  amenityDatabase.removeif(amenity -> amenity.getAmenityId().equals(amenityId));
 }

 public void createRoomType(RoomType roomType, List<RoomType> roomTypeDatabase){
  roomTypeDatabase.add(roomType);
 }

 public RoomType readRoomType(String roomTypeName, List<RoomType> roomTypeDatabase){
  for(RoomType roomType : roomTypeDatabase){ 
     if (roomType.getRoomTypeName().equals(roomTypeName)){
       return roomType;
   }
  } return null;
 }
 
 public void updateRoomType(RoomType newRoomType, List<RoomType> roomTypeDatabase){
  for(int i=0; i<roomTypeDatabase.size(); i++){
   if(roomTypeDatabase.get(i).getRoomTypeName().equals(newRoomType.getRoomTypeName())){
    roomTypeDatabase.set(i, newRoomType);
    return;//To exit when reaching the right roomTypeName to not going through all of it
   }
  }
 }
 
 public void deleteRoomType(String roomTypeName, List<RoomType> roomTypeDatabase){
  roomTypeDatabase.removeif(roomType -> roomType.getRoomTypeName().equals(roomTypeName));
 }

 public void updateRoomType(int roomNumber, String newType, List<Room> rooms) {
  for (Room r : rooms) {
   if (r.getRoomNumber() == roomNumber) {
      r.setRoomType(newType); 
      return;
      }
   }
 }

 public void displayMenu(List<Room> allRooms, List<Amenity> allAmenities) {
  Scanner input = new Scanner(System.in);
  System.out.println("\n    Admin Management    ");
  System.out.println("1. Add Room\n2. View Rooms\n3. Delete Room");
  System.out.print("Choice: ");
  int choice = input.nextInt();

  switch (choice) {
      case 1:
        System.out.print("Number: "); int num = input.nextInt();
        System.out.print("Type: "); String type = input.next();
        System.out.print("Price: "); double price = input.nextDouble();
          addRoom(new Room(num, type, price), allRooms);
            break;
       case 2:
        viewAllRooms(allRooms);
            break;
       case 3:
        System.out.print("Room Number to delete: ");
        int toDelete = input.nextInt();
        deleteRoom(toDelete, allRooms);
            break;
        }
    }

}


