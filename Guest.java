import java.time.LocalDate;
import java.util.*;



public class Guest{

    enum genders{
        male,
        female
    }

    Scanner scan = new Scanner(System.in);

    private String username;
    private String password; // minimum 8 characters long, checked during registration
    private LocalDate dateOfBirth;
    private double balance;
    private String address;
    private genders gender;
    private roomPreferences roomPreference;


    Guest(String username, String password, LocalDate dateOfBirth, double balance, String address, genders gender){
        username = username;
        password = password;
        dateOfBirth = dateOfBirth;
        balance = balance;
        address = address;
        gender = gender;
    }

    void register(){
        System.out.print("Please enter your username: ");
        String name = scan.nextLine();

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





    }


}
