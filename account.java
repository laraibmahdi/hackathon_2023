class account {
    //Fields
        private String customerName; 
        private static String id;
        private String address;
        private String phoneNumber;
        String holderPassword;
        double holderBalance;

    //Constructor
    account(String holderName, String id, String holderPassword, String holderAddress, String holderPhoneNumber){
        this.customerName = holderName;
        this.id = id;
        this.address = holderAddress;
        this.phoneNumber = holderPhoneNumber;
        this.holderPassword = holderPassword;
        this.holderBalance = 0.0;
    }

    public static String getUserID(){
        return id;
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
    public void setPassword(String password){
        holderPassword = password;
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
}