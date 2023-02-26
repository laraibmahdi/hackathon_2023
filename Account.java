class Account {
    //Fields
    String customerName;
    String id;
    String address;
    String phoneNumber;
    String holderPassword;
    double holderBalance;

    //Constructor
    Account(String holderName,String id, String holderPassword, String holderAddress,double balance, String holderPhoneNumber){
        this.customerName = holderName;
        this.id = id;
        this.address = holderAddress;
        this.phoneNumber = holderPhoneNumber;
        this.holderPassword = holderPassword;
        this.holderBalance = balance;
    }

    public String getUserID(){
        return this.id;
    }

    //deposit method
    public void deposit(double amount){
        this.holderBalance += amount;
    }

    //withdraw method
    public void withdraw(double amount){
        this.holderBalance -= amount;
    }

    //setPassword method
    private void setPassword(String password){
        holderPassword = password;
    }

    public boolean checkPassword(String pass){
        if (pass.equals(this.holderPassword)){
            return true;
        }
        return false;

    }

    //changePassword method
    public boolean changePassword(String newPassword){
        boolean passVerify = false;
        //verify old password
        if(holderPassword.equals(newPassword)){
            System.out.printf("The new password is the same as the old one! Please use a different password\n");
            passVerify = false;
        }
        else{
            //change the password
            this.holderPassword = newPassword;
            passVerify = true;
            System.out.println("Password changed successfully!\n");
        }
        return passVerify;
    }

    public String toString(){

        String s = "";
        s+= customerName + " " + address + " " + phoneNumber + " " + holderBalance;
        return s;
    }

}
