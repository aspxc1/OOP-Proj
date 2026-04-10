import java.time.LocalDate;
import java.util.*;

public class Guest extends User implements Payable{

    enum genders{
        male,
        female
    }

    Scanner scan = new Scanner(System.in);

    private double balance;
    private String address;
    private genders gender;
    private roomPreferences roomPreference;
    private int guestcount = 0;


    Guest(String username, String password, LocalDate dateOfBirth, double balance, String address, genders gender, roomPreferences roomPreference){
        username = username;
        password = password;
        dateOfBirth = dateOfBirth;
        balance = balance;
        address = address;
        gender = gender;
        roomPreference = roomPreference;
        guestcount++;


    }

    public static void register(){
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

        roomPreferences roompreferences;
        roompreferences.roomtype = roomtype;
        roompreferences.floor = floor;

        System.out.print("Please enter your gender, must be either male or female: ");
        while (true){
            String genderstr = scan.next();

            if (genderstr.toLowerCase != "male" && genderstr.toLowerCase != "female"){
                System.out.print("Invalid gender, please try again");
                String genderstr = scan.next();
            }
            else{
                break;
            }
        }

        gender genders = gender.valueof(genderstr);

        Guest(name,password,dateOfBirth,balance,address,genders,roompreferences);

    }

    public static void login(){

        System.out.print("Please enter your username");
        String username = scan.next();


        System.out.print("Please enter your password");
        String password = scan.next();

        for (int i = 0; i < guestcount; i++){

            if (guests[i].username == username && guests[i].password == password){
                bool found = true;
                Database.currentuser = guests[i];
            }
        }

        if (not found){
            System.out.println("Invalid login, if you would like to terminate enter x, otherwise try again.")
        }
    }

    void processpayment(double amount){

        balance-=amount;
        System.out.println("Guess payment complete. New balance: " + balance);
    }

    boolean funds(double amount){

        if (amount>balance){
            return false;
        }

        else{
            return true;
        }
    }
}
