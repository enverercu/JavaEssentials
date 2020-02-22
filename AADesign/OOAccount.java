package Basic.AADesign;

import java.util.*;

//"constructor chaining" - "number" can probably be declared final as it's unlikely to change during a Book object's lifetime.
//Consider using the Builder pattern. It allows for you to set default values on your parameters and initialize in a clear and concise way.
//It also removes the need for multiple constructors with different signatures and is way more readable

//constructor icinde istemedigimiz degerlerin set edilmesini engelleyebiliriz.

public class OOAccount {
    private final String number;//not in constructor input, auto-generated.Final, assign in constructor.
    private double balance;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;

    public OOAccount(double balance, String customerName, String customerEmailAddress,
            String customerPhoneNumber) {
    	 
    	 Random random = new Random();
         String acc = String.valueOf(random.nextInt(1000000));
//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<8-acc.length();i++) sb.append("0");
//         sb.append(acc);
//    	   this.number = sb.toString();
         this.number = String.format("%1$8s",acc).replace(" ", "0");
    	 
		 if (balance > 0.0){
			 System.out.println("Balance should be zero.");
			 this.balance = 0.0;
		 }
		 else{
			 this.balance = balance;
		 }
		 
		 this.customerName = customerName;
		 this.customerEmailAddress = customerEmailAddress;
		 this.customerPhoneNumber = customerPhoneNumber;
    }
    
    public OOAccount() {
        this(0.0, "Default name", "Default address", "default phone");
    }

    public void deposit(double depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made.  New balance is " + this.balance);
    }

    public void withdrawal(double withdrawalAmount) {
        if(this.balance - withdrawalAmount <0) {
            System.out.println("Only " + this.balance + " available. Withdrawal not processed");
        } else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed.  Remaining balance = " + this.balance);
        }
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
