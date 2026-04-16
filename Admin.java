import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

public class Admin extends Staff{
 public Admin(String username, String password, LocalDate dateOfBirth, int workingHours){
  super( username, password, dateOfBirth,Role.ADMIN, workingHours);
 }

 public static void login(){
  login(Database.getAdmins());
 }


 public void createRoom(Room room, List<Room> roomDatabase){
  roomDatabase.add(room);
 }

 public Room readRoom(int roomNumber, List<Room> roomDatabase){
  for(Room room : roomDatabase){ 
     if (room.getRoomNumber() == roomNumber){
       return room;
   }
  } return null;
 }
 
 public void updateRoom(Room newRoom, List<Room> roomDatabase){
  for(int i=0; i<roomDatabase.size(); i++){
   if(roomDatabase.get(i).getRoomNumber() == newRoom.getRoomNumber()){
    roomDatabase.set(i, newRoom);
    return;//To exit when reaching the right room to not going through all of it
   }
  }
 }
 
 public void deleteRoom(int roomNumber, List<Room> roomDatabase){
  roomDatabase.removeIf(room -> room.getRoomNumber() == roomNumber);
 }

 public void createAmenity(Amenity amenity, List<Amenity> amenityDatabase){
  amenityDatabase.add(amenity);
 }

 public Amenity readAmenity(String amenityId, List<Amenity> amenityDatabase){
  for(Amenity amenity : amenityDatabase){ 
     if (amenity.getName().equals(amenityId)){
       return amenity;
   }
  } return null;
 }
 
 public void updateAmenity(Amenity newAmenity, List<Amenity> amenityDatabase){
  for(int i=0; i<amenityDatabase.size(); i++){
   if(amenityDatabase.get(i).getName().equals(newAmenity.getAmenityId())){
    amenityDatabase.set(i, newAmenity);
    return;//To exit when reaching the right amenityId to not going through all of it
   }
  }
 }
 
 public void deleteAmenity(String amenityId, List<Amenity> amenityDatabase){
  amenityDatabase.removeIf(amenity -> amenity.getName().equals(amenityId));
 }

 public void createRoomType(RoomType roomType, List<RoomType> roomTypeDatabase){
  roomTypeDatabase.add(roomType);
 }

 public RoomType readRoomType(String roomTypeName, List<RoomType> roomTypeDatabase){
  for(RoomType roomType : roomTypeDatabase){ 
     if (roomType.getName().equals(roomTypeName)){
       return roomType;
   }
  } return null;
 }
 
 public void updateRoomType(RoomType newRoomType, List<RoomType> roomTypeDatabase){
  for(int i=0; i<roomTypeDatabase.size(); i++){
   if(roomTypeDatabase.get(i).getName().equals(newRoomType.getRoomTypeName())){
    roomTypeDatabase.set(i, newRoomType);
    return;//To exit when reaching the right roomTypeName to not going through all of it
   }
  }
 }
 
 public void deleteRoomType(String roomTypeName, List<RoomType> roomTypeDatabase){
  roomTypeDatabase.removeIf(roomType -> roomType.getName().equals(roomTypeName));
 }

 public void updateRoomType(int roomNumber, String newType, List<Room> rooms) {
  for (Room r : rooms) {
   if (r.getRoomNumber() == roomNumber) {
      RoomType updatedType = new RoomType(newType, r.getRoomType().getPricePerNight());
      r.setRoomType(updatedType);
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
          RoomType roomType = new RoomType(type, price);
          Room room = new Room(num, roomType, allAmenities);
          createRoom(room, allRooms);
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


