public class Person {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private long mobileNumber;

    public Person() {
    }

    public Person(String firstName,String lastName,String street,String city,String state,long mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.mobileNumber = mobileNumber;
    }
}
