import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Admin admin1 = new Admin("Omar", "12345678", LocalDate.ofYearDay(2006, 99), 8);
        Receptionist receptionist1 = new Receptionist("Yousef", "12345678", LocalDate.ofYearDay(2006, 94), 8);
        RoomType roomtype1 = new RoomType("Single",20);
        RoomType roomtype2 = new RoomType("Double",22);
        RoomType roomtype3 = new RoomType("Suite",25);
        roomPreferences roompref = new roomPreferences(roomtype1,1);
        Guest guest1 = new Guest("Ahmed", "12345678", LocalDate.ofYearDay(2008,56), 500, "testaddress", Guest.Genders.male, roompref);
        Amenity amenity1 = new Amenity("Wifi");
        Amenity amenity2 = new Amenity("TV");
        Amenity amenity3 = new Amenity("Minibar");
        Amenity amenity4 = new Amenity("AC");
        Amenity amenity5 = new Amenity("Bathtub");
        Room room1 = new Room(roomtype1, List.of(amenity1, amenity2, amenity5), 1);
        Room room2 = new Room(roomtype2, List.of(amenity1, amenity2, amenity4, amenity5), 2);
        Room room3 = new Room(roomtype3, List.of(amenity1, amenity2, amenity3, amenity4, amenity5), 3);
        Reservation reservation = new Reservation(LocalDate.now(), LocalDate.now().plusWeeks(2),0,2,"CONFIRMED");
        room3.setAvailable(false);

        Scanner scan = new Scanner(System.in);
        boolean quit = false;

        System.out.print("Please choose your role, enter g for guest, a for admin, r for receptionist: ");
        char choice  = scan.next().charAt(0);

        if (choice == 'g'){
            System.out.print("Would you like to login or signup? Type l for login and s for signup: ");
            choice  = scan.next().charAt(0);
            if (choice == 'l'){
                Guest.login();
            }
            else if (choice == 's'){
                Guest.register();
            }
            else{
                throw new IllegalArgumentException("Invalid choice");
            }
        while (!quit) {

        System.out.print("1.View Profile and Active Reservations \n" + "2.View Available Rooms \n" + "3.Cancel Reservation \n" + "4.Make Reservation \n" + "5.Checkout and Pay \n");
        System.out.print("Type your choice 1-5: ");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                ((Guest) Database.getCurrentUser()).displayDetails();
                ((Guest) Database.getCurrentUser()).viewreservations();
                break;
            case 2:
                ((Guest) Database.getCurrentUser()).viewavailablerooms();
                break;
            case 3:
                System.out.print("Please enter the room number of the reservation you want to cancel: ");
                int roomnumber = scan.nextInt();
                ((Guest) Database.getCurrentUser()).cancelreservation(roomnumber);
                break;
            case 4:
                ((Guest) Database.getCurrentUser()).makereservation();
                break;
            case 5:
                System.out.print("Please enter the room number of the reservation you want to check out from: ");
                int roomnumber2 = scan.nextInt();
                ((Guest) Database.getCurrentUser()).checkoutandPay(roomnumber2);
                break;


        }
        System.out.print("Would you like to quit the application? Type y/n: ");
        char answer = scan.next().charAt(0);
        if (answer == 'y'){
            quit = true;
        }
        else if (answer == 'n'){
            System.out.println("Welcome Back.");
        }
        else {
            throw new IllegalArgumentException("Invalid choice");
        }
    }
        }

        else if (choice == 'a'){
            Admin.login();
        }
        else if (choice == 'r'){
            Receptionist.login();
        }
        else{
            throw new IllegalArgumentException("Invalid choice");
        }

    }

}
