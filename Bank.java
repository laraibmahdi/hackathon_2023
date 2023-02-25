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
}

