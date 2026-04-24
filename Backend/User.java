import java.time.LocalDate;
import java.util.*;

public abstract class User{

    private String username;
    private String password;
    private LocalDate dateOfBirth;

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    //Setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public static void login(List<? extends User> users) {

        Scanner scan = new Scanner(System.in);
        boolean found = false;
        while (!found) {

            System.out.print("Please enter your username: ");
            String username = scan.next();


            System.out.print("Please enter your password: ");
            String password = scan.next();


            for (User user : users) {

                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    found = true;
                    Database.setCurrentUser(user);
                    return;
                }
            }
            if (!found)
                System.out.println("Invalid login, please try again");
        }
    }

}
