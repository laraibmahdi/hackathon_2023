import java.util.*;
public class Bank {

    private String bankName;
    private String bankAddress;
    private String swiftCode;
    private int bankID;
    private List<Customer> customers;


    public Bank(String name, String address, String swift, int id){
        this.bankName = name;
        this.bankAddress = address;
        this.swiftCode = swift;
        this.bankID = id;
        this.customers = new ArrayList<>();

    }


    public boolean addAccount(Customer c){
        if (customers.contains(c)){
            System.out.println("Error, you already have an account at this institution, failed to create new account.");
        return false;
        }

        c = Encrypter.encrypt(c);
        this.customers.add(c);

        return true;
    }


    public Customer getAccount(String name){
        for (Customer customer : customers){
            if (customer.getName().equals(name))
            return customer;
        }
    }

    return null;
    
}
