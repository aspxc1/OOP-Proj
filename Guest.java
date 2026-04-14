import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.*;

public class Guest extends User{

    public static enum Genders{
        male,
        female
    }

    Scanner scan = new Scanner(System.in);

    private double balance;
    private String address;
    private Genders gender;
    private roomPreferences roomPreference;
    private int index;
    private static int guestcount = 0;

    // Getters
    public double getBalance() {
        return balance;
    }

    public String getAddress() {
        return address;
    }

    public Genders getGender() {
        return gender;
    }

    public int getIndex() { return index; }

    //Setters

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public void setIndex(int index) { this.index = index; }

    Guest(String username, String password, LocalDate dateOfBirth, double balance, String address, Genders gender, roomPreferences roomPreference, int index){
        setUsername(username);
        setPassword(password);
        setDateOfBirth(dateOfBirth);
        this.balance = balance;
        this.address = address;
        this.gender = gender;
        this.roomPreference = roomPreference;
        this.index = index;
        guestcount++;

        Database.addGuest(this);


    }



    public static void register() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter your username: ");
        String name = scan.next();

        System.out.print("Please enter your password, it must be at least 8 characters long: ");
        String password = scan.next();
        while (password.length() < 8) {
            System.out.println("Password must be at least 8 characters, please try again: "); // password validation
            password = scan.next();
        }

        System.out.print("Please enter your birthday: ");
        int birthday = scan.nextInt();
        while (birthday > 30 || birthday < 1) {
            System.out.println("Your birth day must be within 1 and 30, please try again: "); // check for valid day
            birthday = scan.nextInt();
        }

        System.out.print("Please enter your birth month: ");
        int birthmonth = scan.nextInt();
        while (birthmonth > 12 || birthmonth < 1) {
            System.out.println("Your birth month must be within 1 and 12, please try again: "); // check for valid month
            birthmonth = scan.nextInt();
        }

        System.out.print("Please enter your birth year: ");
        int birthyear = scan.nextInt();
        while (birthyear < 0) {
            System.out.println("Your birth year must be positive, please try again: ");
            birthyear = scan.nextInt();
        }

        LocalDate dateOfBirth = LocalDate.of(birthyear, birthmonth, birthday);

        System.out.print("Please enter your balance: ");
        double balance = scan.nextDouble();
        while (balance < 0) {
            System.out.println("Your balance must be positive, please try again: "); // check for valid balance
            balance = scan.nextDouble();
        }

        System.out.print("Please enter your address: ");
        String address = scan.nextLine();

        System.out.print("Please enter your preferred room type's name: ");
        String roomtypename = scan.next();

        double price = 0;
        try {
            System.out.print("Please enter your preferred room price per night: ");
            price = scan.nextDouble();
            while (price <= 0) {
                System.out.print("Price must be positive, please try again: ");
                price = scan.nextDouble();
            }

        } catch (InputMismatchException e) {
            System.out.println("You must enter a valid room price per night.");
            scan.nextLine();
        }

        int floor = 0;
        try {
            System.out.print("Please enter your preferred floor (0-7): ");
            floor = scan.nextInt();

            if (floor < 0 || floor > 7) {
                throw new IllegalArgumentException("You must enter a valid room floor number.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
        catch (InputMismatchException a){
            System.out.println("You must enter a number.");
            scan.nextLine();
        }


        RoomType roomtype = new RoomType(roomtypename,price);

        roomPreferences roompreferences = new roomPreferences(roomtype, floor);


        System.out.print("Please enter your gender, must be either male or female: ");
        String genderstr,genderupper,genderlower;
        Genders gender;
        while (true){
            genderstr = scan.next();
            genderlower = genderstr.toLowerCase();
            genderupper = genderstr.toUpperCase();

            if (!genderlower.equals("male") && !genderlower.equals("female")){
                System.out.print("Invalid gender, please try again: ");
            }
            else{
                break;
            }
        }
        gender = Genders.valueOf(genderupper);
        Guest guest = new Guest(name,password,dateOfBirth,balance,address,gender,roompreferences,guestcount);

    }

    public static void login(){
        login(Database.getGuests());
    }


    public void viewavailablerooms() throws RoomNotAvailableException{

        boolean found = false;
        System.out.println("Here are the current available rooms: ");
        for (int i = 0; i < Room.roomCount; i++){
            Room room = Database.getRoom(i);

            if (room.isAvailable()){
                room.displayRoomDetails();
                found = true;}
        }
        if (!found){
            throw new RoomNotAvailableException("No rooms are currently available.");
        }

    }

    public void makereservation() throws RoomNotAvailableException {

        Scanner scan = new Scanner(System.in);

        LocalDate checkIn = LocalDate.now();

        System.out.print("Please enter how many weeks you'd like to reserve for: ");
        int weeks = scan.nextInt();

        while (weeks < 1) {
            System.out.println("Invalid entry, number of weeks must be greater than 0, please try again: ");
            weeks = scan.nextInt();
        }

        LocalDate checkOut = checkIn.plusWeeks(weeks);
        int roomReference = 0;
        boolean found = false;

        for (int i = 0; i < Room.roomCount; i++) {
            boolean available = Database.getRoom(i).isAvailable();
            boolean prefmatch = Database.getRoom(i).getRoomType().getName().equals(this.roomPreference.getRoomType().getName());

            if (prefmatch && available) {
                roomReference = Database.getRoom(i).getRoomNumber();
                found = true;
                System.out.println("The following room has been reserved: " );
                Database.getRoom(i).displayRoomDetails();
            }

        }
        if (!found) {
            for (int i = 0; i < Room.roomCount; i++) {

                if (Database.getRoom(i).isAvailable()) {
                    roomReference = Database.getRoom(i).getRoomNumber();
                    found = true;
                    System.out.println("Your preferred room type was not available, however the following room has been reserved: " );
                    Database.getRoom(i).displayRoomDetails();
                }
            }
        }
        if (!found) {
           throw new RoomNotAvailableException("No rooms are currently available.");
        }

        if (found){
            int guestReference = this.index;

            Reservation reservation= new Reservation(checkIn,checkOut,guestReference,roomReference,"COMPLETED");
            System.out.println("Reservation Successful.");
        }
    }

    public void viewreservation(){
        boolean found = false;
        for (int i = 0; i < Database.getReservations().size(); i++) {

            if (Database.getReservation(i).getGuestReference() == this.index && (Database.getReservation(i).getReservationStatus() != Reservation.ReservationStatus.CANCELLED)) {
                found = true;
                System.out.println("Checkin Date: " + Database.getReservation(i).getCheckInDate());
                System.out.println("Checkout Date: " + Database.getReservation(i).getCheckOutDate());
                Database.getRoom(Database.getReservation(i).getRoomRefrence()).displayRoomDetails();
                System.out.println("Reservation Status: " + Database.getReservation(i).getReservationStatus());
            }
        }
        if (!found) {
            System.out.println("No reservations found.");
        }
    }

    public void cancelreservation(int reservationindex) throws ReservationAlreadyCancelledException{

        Reservation reservation = Database.getReservation(reservationindex);
        if (reservation.getReservationStatus() == Reservation.ReservationStatus.CANCELLED)
            throw new ReservationAlreadyCancelledException("Reservation is already cancelled.");

        if (reservation.getGuestReference() == this.index) {
            reservation.setReservationStatus(Reservation.ReservationStatus.CANCELLED);
        }
        else
            System.out.println("There is no such reservation under you.");
    }


    public void checkoutandPay(double total , Payable bill) throws InvalidPaymentException{

        System.out.println("Please choose your desired payment method: ");
        Invoice.showPaymentMethods();

        if (this.balance < total)
            throw new InvalidPaymentException("Insufficient balance.");

        String method = scan.next().toUpperCase();
        if (!method.equals("CREDIT_CARD") && !method.equals("CASH") && !method.equals("ONLINE"))
            throw new InvalidPaymentException("Invalid payment method.");

        Payable.PaymentMethod paymentMethod = Payable.PaymentMethod.valueOf(method);

        bill.processpayment(total, paymentMethod);


    }
}




