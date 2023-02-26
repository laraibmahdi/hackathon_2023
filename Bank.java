import com.company.Encrypter;

import java.util.List;
import java.util.*;
import java.util.ArrayList;

public class Bank {

    String bankName;
    String bankAddress;
    String swiftCode;
    int bankID;
    List<Account> accounts;


    public Bank(String name, String address, String swift, int id){
        this.bankName = name;
        this.bankAddress = address;
        this.swiftCode = swift;
        this.bankID = id;
        this.accounts = new ArrayList<>();

    }


    public boolean addAccount(Account c){
        if (accounts.contains(c)){
            System.out.println("Error, you already have an account at this institution, failed to create new account.");
            return false;
        }

//            c = Encrypter.AES.encrypt(c);
        this.accounts.add(c);

        return true;
    }


    public boolean isCustomer(String name){
        for (Account customer : accounts){
            if (customer.getUserID().equals(name))
                System.out.println(customer.getUserID());
            return true;
        }
        return false;
    }

    public Account getAccount(String ID){
        for(Account customer : accounts){
            if(customer.id.equals(ID)){
                return customer;
            }
        }
        return null;
    }

    public String writeFile(){
        String allData="";
        for (int i=0; i<accounts.size();i++){
            allData+=Encrypter.AES.encrypt(accounts.get(i).id,"scotia")+"\n"+Encrypter.AES.encrypt(
                    accounts.get(i).customerName, "scotia")+"\n"+Encrypter.AES.encrypt(accounts.get(i).
                    holderPassword,"scotia") +"\n"
                    +Encrypter.AES.encrypt(accounts.get(i).address, "scotia")+"\n"+
                    Encrypter.AES.encrypt(String.valueOf(accounts.get(i).holderBalance),"scotia")+"\n"+
                    Encrypter.AES.encrypt(accounts.get(i).phoneNumber,"scotia");
        }

        return allData;
    }
}
