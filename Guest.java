import java.time.LocalDate;
import java.util.*;

public class Guest extends User {

    static enum genders{
        male,
        female
    }

    Scanner scan = new Scanner(System.in);

    private double balance;
    private String address;
    private genders gender;
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

    public genders getGender() {
        return gender;
    }
    // Getters

    //Setters

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(genders gender) {
        this.gender = gender;
    }

    //Setters

    Guest(String username, String password, LocalDate dateOfBirth, double balance, String address, genders gender, roomPreferences roomPreference, int index){
        setUsername(username);
        setPassword(password);
        setDateOfBirth(dateOfBirth);
        this.balance = balance;
        this.address = address;
        this.gender = gender;
        this.roomPreference = roomPreference;
        this.index = index;
        guestcount++;


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

        System.out.print("Please enter your preferred room type: ");
        String roomtype = scan.next();

        System.out.print("Please enter your preferred floor: ");
        int floor = scan.nextInt();

        roomPreferences roompreferences = new roomPreferences(roomtype, floor);


        System.out.print("Please enter your gender, must be either male or female: ");
        String genderstr;
        while (true){
            genderstr = scan.next();

            if (genderstr.toLowerCase() != "male" && genderstr.toLowerCase() != "female"){
                System.out.print("Invalid gender, please try again");
                genderstr = scan.next();
            }
            else{
                break;
            }
        }

        genders gender = genders.valueOf(genderstr);

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
                    Database.setCurrentuser(Database.getGuest(i));
                }
            }
            if ( !found){
                System.out.println("Invalid login, please try again");
            }
        }
    }

    void processpayment(double amount){

        balance-=amount;
        System.out.println("Guess payment complete. New balance: " + balance);
    }

    boolean validatefunds(double amount){

        if (amount>balance){
            return false;
        }

        else{
            return true;
        }
    }
}

