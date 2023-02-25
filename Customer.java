public class Customer {

    private String customerName; 
    private String address;
    private String phoneNumber;
    


    public Customer(String name, String address, String phoneNumber){
        this.customerName = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public String getName(){
        return customerName;
    }


    
}
