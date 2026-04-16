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


 public void createRoom(RoomType roomType, List<Amenity> amenities){

     Room room = new Room(roomType, amenities);
     Database.getRooms().add(room);
 }

 public Room readRoom(int roomNumber){
     return Database.getRoom(roomNumber);
 }
 
 public void updateRoom(Room newRoom, List<Room> roomDatabase){
  for(int i=0; i<roomDatabase.size(); i++){
   if(roomDatabase.get(i).getRoomNumber() == newRoom.getRoomNumber()){
    roomDatabase.set(i, newRoom);
    return;//To exit when reaching the right room to not going through all of it
   }
  }
 }
 
 public void deleteRoom(int roomNumber){
  Database.getRooms().remove(roomNumber);
  Room.roomCount--;
 }

 public void createAmenity(String name, int roomnumber){

     Amenity amenity = new Amenity(name);
     Database.getRoom(roomnumber).getAmenities().add(amenity);
 }

 public List <Amenity> readAmenities(int roomnumber){
  return Database.getRoom(roomnumber).getAmenities();
 }
 
 public void updateAmenity(Amenity oldAmenity, String newName, int roomnumber) throws AmenityNotFoundException{

     boolean found = false;
     Room room = Database.getRoom(roomnumber);
     for(int i=0; i < room.getAmenities().size(); i++){

        if (room.getAmenities().get(i).getName().equals(oldAmenity.getName())) {
        room.getAmenities().get(i).setName(newName);
        found = true;
        return;
        }
     }
     throw new AmenityNotFoundException(oldAmenity.getName());
 }
 
 public void deleteAmenity(String amenityId, int roomnumber){
  Database.getRoom(roomnumber).getAmenities().removeIf(amenity -> amenity.getName().equals(amenityId));
 }

 public void createRoomType(String name, double price){
     RoomType roomType = new RoomType(name, price);
 }

 public RoomType readRoomType(int roomNumber){
    return Database.getRoom(roomNumber).getRoomType();
 }

 
 public void deleteRoomType(RoomType roomType){
    Database.getRoomTypes().remove(roomType);
 }

 public void updateRoomType(int roomNumber, RoomType newRoomType) {

     Database.getRoom(roomNumber).getRoomType().setName(newRoomType.getName());
     Database.getRoom(roomNumber).getRoomType().setPricePerNight(newRoomType.getPricePerNight());
 }

}


