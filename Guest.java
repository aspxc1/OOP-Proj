import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.*;

public class Guest extends User implements Payable{

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



    public static void register(){

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

        System.out.print("Please enter your preferred room price per night: ");
        double price = scan.nextDouble();

        System.out.print("Please enter your preferred floor: ");
        int floor = scan.nextInt();

        RoomType roomtype = new RoomType(roomtypename,price);

        roomPreferences roompreferences = new roomPreferences(roomtype, floor);


        System.out.print("Please enter your gender, must be either male or female: ");
        String genderstr;
        Genders gender;
        String genderlower;
        while (true){
            genderstr = scan.next();
            genderlower = genderstr.toLowerCase();

            if (!genderlower.equals("male") && !genderlower.equals("female")){
                System.out.print("Invalid gender, please try again: ");
            }
            else{
                break;
            }
        }
        gender = Genders.valueOf(genderlower);
        Guest guest = new Guest(name,password,dateOfBirth,balance,address,gender,roompreferences,guestcount);

    }

    public static void login(){

        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter your username");
        String username = scan.next();


        System.out.print("Please enter your password");
        String password = scan.next();

        boolean found = false;
        while ( !found ){

            for (int i = 0; i < guestcount; i++) {

                if (Database.getGuest(i).getUsername().equals(username) && Database.getGuest(i).getPassword().equals(password)) {
                    found = true;
                    Database.setCurrentUser(Database.getGuest(i));
                }
            }
            if ( !found )
                System.out.println("Invalid login, please try again");
        }
    }

    public void processpayment(double amount){

        balance-=amount;
        System.out.println("Guess payment complete. New balance: " + balance);
    }

    public boolean validatefunds(double amount){

        return ( !(amount>balance) );
    }

    public void viewavailablerooms(){

        System.out.println("Here are the current available rooms: ");
        for (int i = 0; i < Room.roomCount; i++){
            Room room = Database.getRoom(i);

            if (room.isAvailable())
                room.displayRoomDetails();
        }

    }

    public void makereservation() {

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
           System.out.println("Sorry, there are no available rooms, a reservation cannot currently be made.");
        }

        if (found){
            int guestReference = this.index;

            Reservation reservation= new Reservation(checkIn,checkOut,guestReference,roomReference,"COMPLETED");
            System.out.println("Reservation Successful.");
        }
    }

    public void viewreservation(){
        boolean found = false;
        for (int i = 0; i < Reservation.reservationCount; i++) {

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

    public void cancelreservation(int reservationindex){

        Reservation reservation = Database.getReservation(reservationindex);

        if (( reservation != null ) && reservation.getGuestReference() == this.index && (reservation.getReservationStatus() != Reservation.ReservationStatus.CANCELLED)) {
            reservation.setReservationStatus(Reservation.ReservationStatus.CANCELLED);
        }
        else
            System.out.println("There is no such reservation under you.");
    }

    public double calculatetotal(int reservationindex){
        int roomref = Database.getReservation(reservationindex).getRoomRefrence();

        long daysBetween = ChronoUnit.DAYS.between(Database.getReservation(reservationindex).getCheckInDate(), Database.getReservation(reservationindex).getCheckOutDate());
        return Database.getRoom(roomref).getRoomType().getPricePerNight() * daysBetween;
    }

    public void checkout(int reservationindex){

    }
}




