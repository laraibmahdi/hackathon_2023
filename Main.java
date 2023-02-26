import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        Bank scotia = new Bank("Scotia_Bank", "alsjkdads", "2130123", 123);
        File filename =  new File ("filename.txt");
        System.out.println("Are you a customer ?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String ID = "";
        String password = "";
        addCustomersFromFile(scotia, filename);

        if (input.equals("yes")) { // he is a customer
            System.out.println("Enter your username");
            ID = sc.nextLine();
            if (scotia.isCustomer(ID)) {
                System.out.println("Enter your password");
                password = sc.nextLine();
                if(scotia.getAccount(ID).checkPassword(password)){
                    System.out.println(scotia.getAccount(ID).toString());
                    int option;
                    while (true) {
                        System.out.println("1. View account balance");
                        System.out.println("2. Deposit value");
                        System.out.println("3. Withdraw value");
                        System.out.println("4. Change account password");
                        System.out.println("0. Quit");
                        System.out.print("Please choose an option: ");
                        option = sc.nextInt();
                        
                        if (option == 0)
                            break;
                        switch (option) {
                            case 1:// view account balance
                                System.out.println("Account balance: " + scotia.getAccount(ID).getBalance());
                                System.out.println("\n");
                                break;
                            case 2:// deposit
                                double depositValue;
                                System.out.println("Enter deposit amount: ");
                                depositValue = sc.nextDouble();
                                scotia.getAccount(ID).deposit(depositValue);
                                System.out.println("new account balance: " + scotia.getAccount(ID).getBalance());
                                System.out.println("\n");
                                break;
                            case 3:// withdraw
                                double withdrawValue;
                                System.out.println("Enter withdraw amount: ");
                                withdrawValue = sc.nextDouble();
                                scotia.getAccount(ID).withdraw(withdrawValue);
                                System.out.println("new account balance: " + scotia.getAccount(ID).getBalance());
                                System.out.println("\n");
                                break;
                            case 4:// Change password
                                String currentpassWord = " ";
                                String newPassword = " ";
                                Scanner newScan = new Scanner(System.in);
        
                                System.out.println("Please type in your current password: ");
                                currentpassWord = newScan.nextLine();
                                if(!currentpassWord.equals(password)){
                                    System.out.println("Incorrect password input!");
                                    continue;
                                }
                                System.out.println("Please type in your new password: ");
                                newPassword = newScan.nextLine();
                                while (!scotia.getAccount(ID).changePassword(newPassword)) {
                                    System.out.println("Please type in your new password: ");
                                    newPassword = newScan.nextLine();
                                }
                                password = newPassword;
                                break;
                        }
                    }
                } else{
                    System.out.println("Wrong Password");
                }
            }
            // decrypt the account info
        } else { // he is not a customer
            String name, address, phone_Number;

            System.out.println("Enter your name :");
            name = sc.nextLine();
            System.out.println("Enter your ID :");
            ID = sc.nextLine();
            System.out.println("Enter your password :");
            password = sc.nextLine();
            System.out.println("Enter your address :");
            address = sc.nextLine();
            System.out.println("Enter your phone_Number :");
            phone_Number = sc.nextLine();

            Account newAccount = new Account(name, ID, password, address, phone_Number);

            // Banking option
            int option;
            
            while (true) {
                System.out.println("1. View account balance");
                System.out.println("2. Deposit value");
                System.out.println("3. Withdraw value");
                System.out.println("4. Change account password");
                System.out.println("0. Quit");
                System.out.print("Please choose an option: ");
                option = sc.nextInt();
                
                if (option == 0)
                    break;
                switch (option) {
                    case 1:// view account balance
                        System.out.println("Account balance: " + newAccount.getBalance());
                        System.out.println("\n");
                        break;
                    case 2:// deposit
                        double depositValue;
                        System.out.println("Enter deposit amount: ");
                        depositValue = sc.nextDouble();
                        newAccount.deposit(depositValue);
                        System.out.println("new account balance: " + newAccount.getBalance());
                        System.out.println("\n");
                        break;
                    case 3:// withdraw
                        double withdrawValue;
                        System.out.println("Enter withdraw amount: ");
                        withdrawValue = sc.nextDouble();
                        newAccount.withdraw(withdrawValue);
                        System.out.println("new account balance: " + newAccount.getBalance());
                        System.out.println("\n");
                        break;
                    case 4:// Change password
                        String currentpassWord = " ";
                        String newPassword = " ";
                        Scanner newScan = new Scanner(System.in);

                        System.out.println("Please type in your current password: ");
                        currentpassWord = newScan.nextLine();
                        if(!currentpassWord.equals(password)){
                            System.out.println("Incorrect password input!");
                            continue;
                        }
                        System.out.println("Please type in your new password: ");
                        newPassword = newScan.nextLine();
                        while (!newAccount.changePassword(newPassword)) {
                            System.out.println("Please type in your new password: ");
                            newPassword = newScan.nextLine();
                        }
                        password = newPassword;
                        break;
                }
            }
            final String secretKey = "scotia";
            String id= Encrypter.AES.encrypt(ID,secretKey);
            String Password= Encrypter.AES.encrypt(password,secretKey);
            String Address= Encrypter.AES.encrypt(address,secretKey);
            String Phone_number= Encrypter.AES.encrypt(phone_Number,secretKey);
            System.out.println(id+"\n"+Password+"\n"+Address+"\n"+Phone_number);
            System.out.println("Information encrypted successfully!");
        }

        addToTextFile(scotia, filename);
        // encrypt the account info and add it into a text file

    }

    public static void addCustomersFromFile(Bank bank, File filename){
        int count = 0;
        String ID = " ", name= " ", password = " ", address = "", phone_Number = " ";
        try {

            Scanner sc = new Scanner(filename);
            while (sc.hasNextLine()) {
                count++;

                if (count == 1){
                    ID = sc.nextLine();
                } else if (count == 2){
                    name = sc.nextLine();
                } else if (count == 3){
                    password = sc.nextLine();
                } else if (count == 4){
                    address = sc.nextLine();
                } else if (count == 5){
                    phone_Number = sc.nextLine();
                }
                Account account = new Account(name, ID, password, address, phone_Number);
                bank.addAccount(account);
                count = 0;
            }

            sc.close();


        } catch (FileNotFoundException e){
            System.out.println("File not found: " + filename);
        }
    }

    public static void addToTextFile(Bank bank, File filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));
            for (Account customer : bank.accounts) {
                writer.write(customer.getUserID() + "\n" + customer.getName() + "\n" + customer.getPassword() + "\n" + customer.getAddress() + "\n"
                + customer.getPhoneNumber() + "\n\n");
                writer.newLine();
            }
            writer.close();
            System.out.println("Customers added to text.txt file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to text.txt file.");
            e.printStackTrace();
        }
    }


}