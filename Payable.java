public interface Payable {

    enum PaymentMethod{
        CASH, CREDIT_CARD, ONLINE
    }

    void processpayment(double amount, PaymentMethod method) ;

}