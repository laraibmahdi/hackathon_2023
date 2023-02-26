import com.company.Encrypter;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank scotia = new Bank("klsad", "alsjkdads", "2130123", 123);
        System.out.println("Are you a customer ?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // creating objects using a file
        try {
            File filename = new File("filename.txt");
            Scanner filereader = new Scanner(filename);
            String ID = "", name = "", password = "", address = "", phone_Number = "", balance="";
            int counter = 0;

            while (filereader.hasNextLine()) {
                String line = filereader.nextLine();
                line = Encrypter.AES.decrypt(line,"scotia");
                if (counter ==6){
                    counter = 0;
                }
                if(counter == 0){
                    ID = line;
                } else if (counter == 1){
                    name = line;
                } else if (counter == 2){
                    password = line;
                } else if (counter == 3){
                    address = line;
                } else if (counter==4) {
                    balance=line;
                } else {
                    phone_Number = line;
                    scotia.addAccount(new Account(name, ID, password, address,Integer.parseInt(balance), phone_Number));
                }
                counter++;
            }

            filereader.close();


            if (input.equals("yes")) { // he is a customer
                System.out.println("Enter your username");
                ID = sc.nextLine();
                if (scotia.isCustomer(ID)) {
                    System.out.println("Enter your password");
                    password = sc.nextLine();
                    if(scotia.getAccount(ID).checkPassword(password)){ // we are getting account id here
                        System.out.println(scotia.getAccount(ID).toString());
                        while (true) {
                            System.out.println("1. View account balance");
                            System.out.println("2. Deposit value");
                            System.out.println("3. Withdraw value");
                            System.out.println("4. Change account password");
                            System.out.println("0. Quit");
                            System.out.print("Please choose an option: ");

                            int option;
                            option = sc.nextInt();

                            if (option == 0)
                                break;
                            switch (option) {
                                case 1:// view account balance
                                    System.out.println("Account balance: " + scotia.getAccount(ID).holderBalance);
                                    System.out.println("\n");
                                    break;
                                case 2:// deposit
                                    double depositValue;
                                    System.out.println("Enter deposit amount: ");
                                    depositValue = sc.nextDouble();
                                    scotia.getAccount(ID).deposit(depositValue);
                                    System.out.println("new account balance: " + scotia.getAccount(ID).holderBalance);
                                    System.out.println("\n");
                                    break;
                                case 3:// withdraw
                                    double withdrawValue;
                                    System.out.println("Enter withdraw amount: ");
                                    withdrawValue = sc.nextDouble();
                                    scotia.getAccount(ID).withdraw(withdrawValue);
                                    System.out.println("new account balance: " + scotia.getAccount(ID).holderBalance);
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
            }
                }
            } else { // he is not a customer

                System.out.println("Enter your name :");
                name = sc.nextLine();
                System.out.println("Enter your ID :");
                ID = sc.nextLine();
                if (scotia.isCustomer(ID)){
                    System.out.println("dumbass");
                    System.exit(0);
                }
                System.out.println("Enter your password :");
                password = sc.nextLine();
                System.out.println("Enter your address :");
                address = sc.nextLine();
                System.out.println("Enter your phone_Number :");
                phone_Number = sc.nextLine();

                Account newAccount= new Account(name,ID,password,address,0,phone_Number);
                scotia.addAccount(newAccount);



            }
            System.out.println(scotia.accounts.get(0).holderBalance);
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(scotia.writeFile());
            myWriter.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
