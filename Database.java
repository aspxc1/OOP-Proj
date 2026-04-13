import java.util.ArrayList;
import java.util.List;

public class Database{

    private final static List<Guest> guests = new ArrayList<>();
    private final static List<Room> rooms = new ArrayList<>();
    private final static List<Reservation> reservations = new ArrayList<>();
    private final static List<Invoice> invoices = new ArrayList<>();
    private final static List<Admin> admins = new ArrayList<>();
    private final static List<Receptionist> receptionists = new ArrayList<>();

    private static User currentUser;

    // Current User
    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentuser) {
        Database.currentUser = currentuser;
    }

    // Guest
    public static void addGuest(Guest g){

        guests.add(g);
    }
    public static Guest getGuest(int index){
        if (index > 0 && index < guests.size())
            return guests.get(index);
        else
            return null;
    }

    // Room
    public static void addRoom(Room room){
        rooms.add(room);
    }
    public static Room getRoom(int index){
        if (index > 0 && index < rooms.size())
            return rooms.get(index);
        else
            return null;
    }

    // Reservation
    public static void addReservation(Reservation reservation){
        reservations.add(reservation);
    }
    public static Reservation getReservation(int index){
        if (index > 0 && index < reservations.size())
            return reservations.get(index);
        else
            return null;
    }

    // Invoice
    public static void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }
    public static Invoice getInvoice(int index){
        if (index > 0 && index < invoices.size())
            return invoices.get(index);
        else
            return null;
    }

    // Admin
    public static void addAdmin(Admin admin){
        admins.add(admin);
    }
    public static Admin getAdmin(int index){
        if (index > 0 && index < admins.size())
            return admins.get(index);
        else
            return null;
    }

    // Receptionist
    public static void addReceptionist(Receptionist receptionist){
        receptionists.add(receptionist);
    }
    public static Receptionist getReceptionist(int index){
        if (index > 0 && index < receptionists.size())
            return receptionists.get(index);
        else
            return null;
    }


}
