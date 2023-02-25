class Account {
    //Fields
        private String customerName; 
        private String id;
        private String address;
        private String phoneNumber;
        String holderPassword;
        double holderBalance;

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
        return this.id;
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