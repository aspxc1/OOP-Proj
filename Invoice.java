import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Invoice implements Payable{
    public enum PaymentMethod{
        CASH, CREDIT_CARD, ONLINE
    }
    private double totalAmount;
    private LocalDate paymentDate;
    private PaymentMethod method;
    private String creditCDetails;


    public Invoice() {
    }

    public PaymentMethod getMethod() {
        return this.method;
    }

    public void setMethod( PaymentMethod method) {
        this.method = method;
    }

    public Invoice(LocalDate paymentDate, double totalAmount) {
        this.paymentDate = paymentDate;
        this.totalAmount = totalAmount;
    }

    public LocalDate getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate( LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount( double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void showPaymentMethods(){
        System.out.println("----payment methods----");
        System.out.println("CASH\nCREDIT_CARD\nONLINE");
    }

    public void processpayment(double amount){


    }
    public boolean validatefunds(double amount){


    }

    public double calculatetotal(int reservationindex){
        int roomref = Database.getReservation(reservationindex).getRoomRefrence();

        long daysBetween = ChronoUnit.DAYS.between(Database.getReservation(reservationindex).getCheckInDate(), Database.getReservation(reservationindex).getCheckOutDate());
        return Database.getRoom(roomref).getRoomType().getPricePerNight() * daysBetween;
    }


    public void paymentMethodStatus() {
        Scanner input = new Scanner(System.in);

        if (method == PaymentMethod.CASH) {
            System.out.println("Payment Method: CASH");
            System.out.println("Please pay the total amount: " + totalAmount + " EGP");
        } else if (method == PaymentMethod.CREDIT_CARD) {
            System.out.println("Payment Method: CREDIT CARD");
            System.out.println("Total Amount: " + totalAmount + " EGP");
            System.out.println("enter credit number ");
            creditCDetails = input.next();
            System.out.println("enter credit name ");
            String s = input.next();
            creditCDetails = creditCDetails.concat(" " + (s));
            while (true) {
                System.out.println("enter ending month ");
                s = input.next();
                int m = Integer.parseInt(s);
                if (m > 0 && m < 13) {
                    break;
                }

            }
            while (true) {
                System.out.println("enter ending day ");
                s = input.next();
                int m = Integer.parseInt(s);
                if (m > 0 && m < 32) {
                    break;
                }

            }

        }
        else if (method == PaymentMethod.ONLINE){
            System.out.println("you will be go to an online paying site");

        }

    }

}
