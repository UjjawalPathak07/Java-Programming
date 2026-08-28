class bankaccount{
    String accholder;
    long accnum;
    String acctype;
    double bankbal;
    
    void bankAccount(String name, long num, String type, double bal){
        accholder=name;
        accnum=num;
        acctype=type;
        bankbal=bal;
    }
    
    void display(){
        System.out.println("Account Holder: "+ accholder);
        System.out.println("Account Number: "+ accnum);
        System.out.println("Account Type: "+ acctype);
        System.out.println("Account Balance: "+ bankbal);
        
    }
    
    void withdraw(double withdr){
        bankbal=bankbal-withdr;
        System.out.println("Amount Withdrawn, Balance remaining: "+bankbal);
    }
    
    void deposit(double dep){
        bankbal=bankbal+dep;
        System.out.println("Amount deposited, Bankbalance: "+bankbal);
    }
    
    void enquiry(){
        System.out.println("Bankbalance: "+bankbal);
    }
    
    public static void main(String[]args){
        
        bankaccount b1=new bankaccount();
        b1.bankAccount("ABCD",233454321,"Savings",90000);
        b1.display();
        b1.withdraw(5000);
        b1.deposit(10000);
        b1.enquiry();
    }    
}