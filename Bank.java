import java.util.*;
import java.io.*;

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

        public boolean addAccount(Account c) {
            if (accounts.contains(c)) {
                System.out.println("Error, you already have an account at this institution, failed to create new account.");
                return false;
            }
        
            try {
                final String secretKey = "scotia";
                FileWriter fileWriter = new FileWriter("filename.txt", true);
                fileWriter.write("\n"); // Add a blank line before writing the new account information
                fileWriter.write(Encrypter.AES.encrypt(c.getUserID(), secretKey) + "\n");
                fileWriter.write(Encrypter.AES.encrypt(c.getName(), secretKey) + "\n");
                fileWriter.write(Encrypter.AES.encrypt(c.getPassword(), secretKey) + "\n");
                fileWriter.write(Encrypter.AES.encrypt(c.getAddress(), secretKey) + "\n");
                fileWriter.write(Encrypter.AES.encrypt(c.getPhoneNumber(), secretKey) + "\n");
                fileWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        
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
                if(customer.getUserID().equals(ID)){
                    return customer;
                }
            }
            return null;
        }
}