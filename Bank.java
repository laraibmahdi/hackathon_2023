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


    public boolean addAccount(Account c){
        c = Encrypter.encrypt(c);
        this.accounts.add(c);

        return true;
    }


    public boolean isCustomer(String name){
        for (Account customer : accounts){
            if (customer.getUserName().equals(name))
            return true;
        }
    return false;
    }


    public Account getCustomer(String name){
        Account c = null;

        return c;
    }
    
}
