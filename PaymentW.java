interface paym{
    void pay(double amount);
}

class UPI implements paym{
    public void pay(double amount){
        System.out.println("Amount Paid through UPI: "+amount);
    }
}
class Card implements paym{
    public void pay(double amount){
        System.out.println("Amount Paid through Card: "+amount);
    }
}
class Netbanking implements paym{
    public void pay(double amount){
        System.out.println("Amount Paid through Netbanking: "+amount);
    }
}
class PaymentW{
    public static void main(String[]args){
        paym u = new UPI();
        u.pay(1000);
        paym c = new Card();
        c.pay(2000);
        paym p = new Netbanking();
        p.pay(3000);
    }
}
