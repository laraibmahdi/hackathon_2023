import java.util.*;
public class Bank {

    private String bankName;
    private String bankAddress;
    private String swiftCode;
    private int bankID;
    private List<Account> accounts;


    public Bank(String name, String address, String swift, int id){
        this.bankName = name;
        this.bankAddress = address;
        this.swiftCode = swift;
        this.bankID = id;
        this.accounts = new ArrayList<>();

    }


    public void addAccount(Account c){
        this.accounts.add(c);
    }


    public boolean isCustomer(String name){
        for (Account customer : accounts){
            if (Account.getUserID().equals(name))
            return true;
        }
    return false;
    }


    public Account getCustomer(String name){
        Account c = null;

        return c;
    }
    
}
