class Account {
    //Fields
        private String customerName; 
        private String id;
        private String address;
        private String phoneNumber;
        private String holderPassword;
        private double holderBalance;

    //Constructor
    Account(String holderName, String id, String holderPassword, String holderAddress, String holderPhoneNumber){
        this.customerName = holderName;
        this.id = id;
        this.address = holderAddress;
        this.phoneNumber = holderPhoneNumber;
        this.holderPassword = holderPassword;
        this.holderBalance = 0.0;
    }

    public String getUserID(){
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
        boolean passVerify = true;
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


    public boolean checkPassword(String pass){
        return holderPassword.equals(pass);
    }

    public String getName() {
        return this.customerName;
    }

    public String getPassword() {
        return this.holderPassword;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public double getBalance(){
        return this.holderBalance;
    }
}