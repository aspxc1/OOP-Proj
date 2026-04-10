import java.time.LocalDate;
enum PaymentMethod{
    CASH, CREDIT_CARD, ONLINE
}
public class Invoice {
private double totalAmount;
private LocalDate paymentDate;
private PaymentMethod method;


    public Invoice() {
    }

    public PaymentMethod getMethod() {
        return this.method;
    }

    public void setMethod(final PaymentMethod method) {
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




}