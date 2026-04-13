public interface Payable {

    void processpayment(double amount);
    boolean validatefunds(double amount);
    double calculatetotal(int reservationindex);

}