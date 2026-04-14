import java.time.LocalDate;
import java.util.*;

public class Invoice implements Payable{

    private double totalAmount;
    private LocalDate paymentDate;
    private PaymentMethod method;
    private double amountPaid = 0;


    public Invoice() {
    }

    public PaymentMethod getMethod() {
        return this.method;
    }

    public void setMethod( PaymentMethod method) {
        this.method = method;
    }

    public Invoice(double totalAmount) {
        this.totalAmount = totalAmount;
        Database.addInvoice(this);
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

    public static void showPaymentMethods(){
        System.out.println("----payment methods----");
        System.out.println("CASH\nCREDIT_CARD\nONLINE\n");
    }

    public void processpayment(double amount,  PaymentMethod method) {

        this.amountPaid += amount;
        this.method=method;
        this.paymentDate=LocalDate.now();

    }



}
