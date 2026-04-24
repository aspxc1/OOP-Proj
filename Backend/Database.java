package Backend;

import java.util.ArrayList;
import java.util.List;

public class Database{

    private final static List<Guest> guests = new ArrayList<>();
    private final static List<Room> rooms = new ArrayList<>();
    private final static List<Reservation> reservations = new ArrayList<>();
    private final static List<Invoice> invoices = new ArrayList<>();
    private final static List<Admin> admins = new ArrayList<>();
    private final static List<Receptionist> receptionists = new ArrayList<>();
    private final static List<User> users = new ArrayList<>();
    private final static List<RoomType> roomTypes = new ArrayList<>();
    private final static List<Amenity> amenities = new ArrayList<>();

    private static User currentUser;

    //User
    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentuser) {
        Database.currentUser = currentuser;
    }

    public static List<User> getUsers() {
        return users;
    }


    // Guest
    public static void addGuest(Guest g){

        guests.add(g);
        users.add(g);
    }
    public static Guest getGuest(int index){
        if (index >= 0 && index < guests.size())
            return guests.get(index);
        else
            throw new IndexOutOfBoundsException("Guest with such index does not exist");
    }
    public static List<Guest> getGuests(){
        return guests;
    }


    // Room
    public static void addRoom(Room room){
        rooms.add(room);
    }
    public static Room getRoom(int index){
        if (index >= 0 && index < rooms.size())
            return rooms.get(index);
        else
            throw new IndexOutOfBoundsException("Room with such index does not exist");
    }
    public static List<Room> getRooms(){
        return rooms;
    }


    // Room Type
    public static void addRoomType(RoomType roomType){
        roomTypes.add(roomType);
    }
    public static RoomType getRoomType(int index){
        if (index >= 0 && index < roomTypes.size())
            return roomTypes.get(index);
        else
            throw new IndexOutOfBoundsException("Room type with such index does not exist");
    }
    public static List<RoomType> getRoomTypes(){
        return roomTypes;
    }
    // Reservation
    public static void addReservation(Reservation reservation){
        reservations.add(reservation);
    }
    public static Reservation getReservation(int index){
        if (index >= 0 && index < reservations.size())
            return reservations.get(index);
        else
            throw new IndexOutOfBoundsException("Reservation with such index does not exist");
    }
    public static List<Reservation> getReservations(){
        return reservations;
    }


    // Invoice
    public static void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }
    public static Invoice getInvoice(int index){
        if (index >= 0 && index < invoices.size())
            return invoices.get(index);
        else
            throw new IndexOutOfBoundsException("Invoice with such index does not exist");
    }
    public static List<Invoice> getInvoices(){
        return invoices;
    }


    // Admin
    public static void addAdmin(Admin admin){

        admins.add(admin);
        users.add(admin);
    }
    public static Admin getAdmin(int index){
        if (index >= 0 && index < admins.size())
            return admins.get(index);
        else
            throw new IndexOutOfBoundsException("Admin with such index does not exist");
    }
    public static List<Admin> getAdmins(){
        return admins;
    }


    // Receptionist
    public static void addReceptionist(Receptionist receptionist){

        receptionists.add(receptionist);
        users.add(receptionist);
    }
    public static Receptionist getReceptionist(int index){
        if (index >= 0 && index < receptionists.size())
            return receptionists.get(index);
        else
            throw new IndexOutOfBoundsException("Receptionist with such index does not exist");
    }
    public static List<Receptionist> getReceptionists(){
        return receptionists;
    }


    // Amenity
    public static void addAmenity(Amenity amenity){
        amenities.add(amenity);
    }
    public static Amenity getAmenity(int index){
        if (index >= 0 && index < amenities.size())
            return amenities.get(index);
        else
            throw new IndexOutOfBoundsException("Amenity with such index does not exist");
    }
    public static List<Amenity> getAmenities(){
        return amenities;
    }

}
