package Basic.AADesign;

import java.util.ArrayList;

//AUTOBOXING

public class OOBank {
    private String name;
    private ArrayList<Branch> branches;

    public OOBank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }

        return false;
    }

    private Branch findBranch(String branchName) {
        for(int i=0; i<this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }

        return null;
    }

   public boolean listCustomers(String branchName, boolean showTransactions) {
       Branch branch = findBranch(branchName);
       if(branch != null) {
           System.out.println("Customer details for branch " + branch.getName());

           ArrayList<Customer> branchCustomers = branch.getCustomers();
           for(int i=0; i<branchCustomers.size(); i++) {
               Customer branchCustomer = branchCustomers.get(i);
               System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
               if(showTransactions) {
                   System.out.println("Transactions");
                   ArrayList<Double> transactions = branchCustomer.getTransactions();
                   for(int j=0; j<transactions.size(); j++) {
                       System.out.println("[" + (j+1) + "]  Amount "  + transactions.get(j));
                   }
               }
           }
           return true;
       } else {
           return false;
       }
   }
   
   public static void main(String[] args) {

       OOBank bank = new OOBank("National Australia Bank");

       if(bank.addBranch("Adelaide")) {
           System.out.println("Adelaide branch created");
       }

       bank.addCustomer("Adelaide", "Tim", 50.05);
       bank.addCustomer("Adelaide", "Mike", 175.34);
       bank.addCustomer("Adelaide", "Percy", 220.12);

       bank.addBranch("Sydney");
       bank.addCustomer("Sydney", "Bob", 150.54);

       bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
       bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
       bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

       bank.listCustomers("Adelaide", true);
       bank.listCustomers("Sydney", true);

       bank.addBranch("Melbourne");

       if(!bank.addCustomer("Melbourne", "Brian", 5.53)) {
           System.out.println("Error Melbourne branch does not exist");
       }

       if(!bank.addBranch("Adelaide")) {
           System.out.println("Adelaide branch already exists");
       }

       if(!bank.addCustomerTransaction("Adelaide", "Fergus", 52.33)) {
           System.out.println("Customer does not exist at branch");
       }

       if(!bank.addCustomer("Adelaide", "Tim", 12.21)) {
           System.out.println("Customer Tim already exists");
       }
}

class Branch {
	    private String name;
	    private ArrayList<Customer> customers;

	    public Branch(String name) {
	        this.name = name;
	        this.customers = new ArrayList<Customer>();
	    }

	    public String getName() {
	        return name;
	    }

	    public ArrayList<Customer> getCustomers() {
	        return customers;
	    }

	    public boolean newCustomer(String customerName, double initialAmount) {
	        if(findCustomer(customerName) == null) {
	            this.customers.add(new Customer(customerName, initialAmount));
	            return true;
	        }

	        return false;
	    }

	    public boolean addCustomerTransaction(String customerName, double amount) {
	        Customer existingCustomer = findCustomer(customerName);
	        if(existingCustomer != null) {
	            existingCustomer.addTransaction(amount);
	            return true;
	        }

	        return false;
	    }

	    private Customer findCustomer(String customerName) {
	        for(int i=0; i<this.customers.size(); i++) {
	            Customer checkedCustomer = this.customers.get(i);
	            if(checkedCustomer.getName().equals(customerName)) {
	                return checkedCustomer;
	            }
	        }

	        return null;
	    }
}

class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}


























}
