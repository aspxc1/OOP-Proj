import java.util.ArrayList;

public class Database{

    private static ArrayList<Guest> guests = new ArrayList<>();
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static ArrayList<Invoice> invoices = new ArrayList<>();
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<Receptionist> receptionists = new ArrayList<>();

    private static User currentuser;

    public static User getCurrentuser() {
        return currentuser;
    }

    public static void setCurrentuser(User currentuser) {
        Database.currentuser = currentuser;
    }

    public static void addGuest(Guest g){
        guests.add(g);
    }
    public static Guest getGuest(int index){
        return guests.get(index);
    }

}
