class Account extends Customer{
    //Fields
        String holderName = " ";
        String holderPassword = " ";
        double holderBalance = 0.0;
    //Constructor
    Account(String holderName,String holderPassword, double holderBalance, String holderAddress, String holderPhoneNumber){
        super(holderName,holderAddress,holderPhoneNumber);
        this.holderName = holderName;
        this.holderPassword = holderPassword;
        this.holderBalance = holderBalance;
    }
    //deposit method
    private void deposit(double amount){
        this.holderBalance += amount;
    }
    
    //withdraw method
    private void withdraw(double amount){
        this.holderBalance -= amount;
    }

    //setPassword method
    private void setPassword(String password){
        holderPassword = password;
    }

    //changePassword method
    private void changePassword(String oldPassword, String newPassword){
        boolean passVerify = false;
        //verify old password
        while(!passVerify){
            if(this.holderPassword == oldPassword){
                //change the password
                holderPassword = newPassword;
                passVerify = true;
            }
            else{
                System.out.printf("Incorect old password!");
            }
        }
    }
}
