import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    private static Scanner sc = new Scanner(System.in);
   public static Map<String,ArrayList<Person>> newAddressBook = new HashMap<String,ArrayList<Person>>();
    //public static ArrayList<Person> contact = new ArrayList<Person>();
    public static ArrayList<Person> addressBook = new ArrayList<Person>();
        public static void main(String args[]) {
            System.out.println("Welcome to Address Book");
            boolean isExit = false;
            //AddressBookMain addressBook = new AddressBookMain();
            while (!isExit) {
                System.out.println("1.Add Address Book \n 2.Exit");
                System.out.print("Enter Option:");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter Name Of Address Book");
                        String addBookName=sc.nextLine();
                        if(newAddressBook.containsKey(addBookName)){
                            System.out.println("This name already exists");
                        }else{
                            newAddressBook.put(addBookName,addressBook);
                            addAddressBook();
                            for (Map.Entry<String,ArrayList<Person>>Entry:newAddressBook.entrySet()){
                                System.out.println("AddressBook Name: "+Entry.getKey()+" and the "+"Contact Details :: \n"+Entry.getValue());
                            }
                            break;
                        }
                    case 2:
                        isExit = true;
                        System.out.println("Exit");
                    default:
                        System.out.println("Please Enter Valid Input");
                }

            }
        }

    public static void addPerson() {
        System.out.println("Enter First name");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name");
        String lastName = sc.nextLine();
        System.out.println("Enter Street");
        String street = sc.nextLine();
        System.out.println("Enter City");
        String city = sc.nextLine();
        System.out.println("Enter State");
        String state = sc.nextLine();
        System.out.println("Enter Phone Number");
        long mobileNumber = Long.parseLong(sc.nextLine());
        Person person = new Person(firstName, lastName, street, city, state, mobileNumber);
        addressBook.add(person);

    }

    public static void editContact() {
        //Person person = new Person();
        System.out.println("Enter First Name of the contact to be edited");
        String enteredName = sc.nextLine();
        for (Person person : addressBook) {
            if (person.firstName.equals(enteredName)) {

                System.out.println("Enter Street");
                String street = sc.nextLine();
                person.street = street;
                System.out.println("Enter City");
                String city = sc.nextLine();
                person.city = city;
                System.out.println("Enter State");
                String state = sc.nextLine();
                person.state = state;
            }
              else  {
                System.out.println(enteredName + " Contact not found");
            }
        }
    }
    public static void deleteContact() {
        System.out.println("Enter Name of Contact to be deleted:");
        String first_name = sc.nextLine();
        for (Person person : addressBook) {
            if (person.firstName.equals(first_name)) {
                addressBook.remove(person);
            }
             else {
                System.out.println("Contact not found");
            }
        }

    }
    public static void showAddressBook() {
        for(int i = 0; i < addressBook.size(); i++) {
            System.out.println(addressBook.get(i));
        }
    }
    public static void checkDuplicate(){
        Set<String> ContactSet=new HashSet<>();
        Set<Person>newSet=addressBook.stream().filter(n -> !ContactSet.add(n.getFirstName())).collect(Collectors.toSet());
        for (Person addressBook:newSet){
            System.out.println(" Displaying Duplicate contact: "+addressBook.getFirstName()+ " "+ addressBook.getLastName());
        }
    }
    public static void noOfContactsInCity() {
        System.out.println("Enter City name");
        String input = sc.nextLine();
        long count= addressBook.stream().filter(city -> city.getCity().equals(input)).count();
        System.out.println("No of Contacts matched is " + count);
    }
    public static void searchByCityOrState() {
        System.out.println("Enter the Name of AddressBook");
        String bookName = sc.nextLine();
        ArrayList<Person> book = newAddressBook.get(bookName);
        AddressBookMain addressBookSystem = new AddressBookMain();
        if (book == null) {
            System.out.println("No results found");
        } else {
            addressBookSystem.searchContactDetails();
        }
    }

    public void searchContactDetails() {
        System.out.println("Enter city or state to search");
        String input = sc.nextLine();
        for (Person person : addressBook) {
            if (person.getCity().equals(input) || person.getState().equals(input)) {
                System.out.println("Result with city or state: " + person);
            }
        }
    }
    public static void sortAddressBookByPerson() {
        if (addressBook.isEmpty()) {
            System.out.println("Address Book is empty");
        } else {
            addressBook.stream().sorted(Comparator.comparing(Person::getFirstName)).forEach(System.out::println);
        }
    }
    public static void sortByState() {
        if (addressBook.isEmpty()) {
            System.out.println("Address Book is empty");
        } else {
            addressBook.stream().sorted(Comparator.comparing(Person::getState)).forEach(System.out::println);
        }
    }
    public static void addAddressBook(){
        boolean isExit = true;
        while(isExit){
            System.out.println("Address Book Menu");
            System.out.println("1.Add Contact Details \n" +
                    " 2.Edit Contact Details \n" +
                    " 3.Delete Contact Details \n" +
                    " 4.Show Contact Details \n" +
                    " 5.Duplicate Contact Details \n" +
                    " 6.No of Contact in Same City \n" +
                    " 7.Search in City or State \n" +
                    " 8.Sort contacts by Name \n" +
                    " 9.Sort contacts by State \n" +
                    " 10.Exit");
            System.out.print("Please Enter Option: ");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:
                    addPerson();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    showAddressBook();
                    break;
                case 5:
                    checkDuplicate();
                    break;
                case 6:
                    noOfContactsInCity();
                    break;
                case 7:
                    searchByCityOrState();
                    break;
                case 8:
                    sortAddressBookByPerson();
                    break;
                case 9:
                    sortByState();
                    break;
                case 10:
                    isExit = false;
                    System.out.println("Exit");
                default:
                    System.out.println("Please enter valid option");
            }
        }
    }
}

