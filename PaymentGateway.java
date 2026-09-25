class Payment{
    void makepayment(double amount){
        System.out.println("Amount: "+amount);
    }
    void makepayment(double amount, String transactionid){
        System.out.println("Amount: "+amount);
        System.out.println("Transaction ID: "+ transactionid);
    }
}

class CreditCardPayment extends Payment{
    @Override
    void makepayment(double amount){
        System.out.println("Payment amount through Credit Card: "+amount);
    }
}

class UPIPayment extends Payment{
    @Override
    void makepayment(double amount){
        System.out.println("Payment amount through UPI: "+amount);
    }
}

class NetBankingPayment extends Payment{
    @Override
    void makepayment(double amount){
        System.out.println("Payment amount through Net Banking: "+amount);
    }
}

class PaymentGateway{
    public static void main(String[]args){
        Payment pay;
        pay= new CreditCardPayment();
        pay.makepayment(5000.98);
        pay= new UPIPayment();
        pay.makepayment(1232.98);
        pay= new NetBankingPayment();
        pay.makepayment(5467.77);
    }
}
