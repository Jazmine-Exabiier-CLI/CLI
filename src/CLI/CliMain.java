package CLI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CliMain {

    // greet names
//        greetNames();
//        System.out.println("==================");

    // write to file and replace names...
//        List<String> newNames = Arrays.asList("Cody", "Nikki", "Jordy", "Jay");
//        writeLines(newNames);
//        greetNames();

//    private static void greetNames() {
//        for (String name : readLines()) {
//            System.out.printf("%s works at Codeup.%n", name);
//        }
//    }

    private final static Path PATH = Paths.get("src", "CLI", "CLI.txt");


    public static String userInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void create() {
//        user input
        System.out.println("Enter the name: ");
        String name = userInput();
        System.out.println("Enter the number: ");
        String num = userInput();
        String[] nameNum = {name, num};
        //////////////////////////////
        ////////////Part 2///////////
        ////////////////////////////

//      Reading from the txt file
        List<String> file = read();

//        Put and add the Array together but we get back an array list
        ArrayList<String[]> StringArray = convertArray(nameNum, file);

//       We need to convert the String[] back to a string so we can write onto the file like we want
        ArrayList<String> stringList = convertBackToString(StringArray);
        write(stringList);
    }

    public static ArrayList<String> convertBackToString(ArrayList<String[]> convert){
        List<String[]> listOfConverted = convert.stream().toList();
        ArrayList<String> listOfSplitConverted = new ArrayList<>();
        for (String[] listItem : listOfConverted) {
            String str = String.join(" - ", listItem);
            ;
            listOfSplitConverted.add(str);
//            System.out.println(Arrays.toString(listItem));
        }
        return listOfSplitConverted;
    }

    public static ArrayList<String[]> convertArray(String[] newAdd, List<String> file){

//        String[] newAdd = create();
//        List<String> listOfContacts = file.stream().toList();
        ArrayList<String[]> listOfSplitContacts = new ArrayList<>();
        for (String listItem : file) {
            String[] splitListItem = listItem.split(" - ");
            listOfSplitContacts.add(splitListItem);
        }
        listOfSplitContacts.add(newAdd);
        return listOfSplitContacts;
    }

    public static void patternSearch(List<String> list, String userInput){
        for(String contact : list) {
            if (contact.toLowerCase().contains(userInput.toLowerCase())) {
                System.out.println(contact);
            }
        }
    }

    public static void searchContact(){

        System.out.println("Please Enter the Name of the ");
        String name = userInput();

        ///////////////////////////////////////

        List<String> fromText = read();
        System.out.println("Here is your seach for " + name);

        ///////////////// Search regardless of Uppercase or LowerCase /////////////////////

        patternSearch(fromText, name);

        }

        public static void delete () {

        ////////////////// Out Putting //////////////////////////

            List<String> contacts = read();
            int count = 0;
            System.out.println("Here are the current contacts Available: ");
            for(int i = 0; i<contacts.size(); i++){
                System.out.println((count+1) + ". " + contacts.get(i));
                count ++;
            }
            System.out.println(count);

            ////////////////// User Input /////////////////////////////
            System.out.println("Please pick the contact you want to delete by number:");
            String userInput = userInput();

            /////////////////// if there is no number ////////////////
            if(isNumeric(userInput)){



            } else{
                System.out.println("Please Enter a real number!");
                delete();
            }


        }

//        create another function for when you get an out of bounds for the index of the list



    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


//        Iterator<String> textIt = fromText.iterator();

        // Condition check for elements in List
        // using hasNext() method returning true till
        // there i single element in a List
//        while (textIt.hasNext()) {
//            if(textIt.contains() )
//
//            // Print all elements of List
//            System.out.println(textIt.next());
//        }



//        we need to have a way to show the contacts:
//        from the file.

//        what if we have names that are the same. Lets make a new array and if that arrrays length is less then one then will ask the user which one would the like to get.




    //=======Method for looping through contact array==================
    public static void showContact() {

        List<String> name = read();
        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i));
        }
    }

    //===========Method for writing to the txt doc of contact array
    public static void write(ArrayList<String> contact) {
        List<String> name = contact;
        try {
            Files.write(PATH, name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> read() {
        List<String> names;
        try {
            names = Files.readAllLines(PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return names;
    }


    ///==========

    public static boolean findContactByName(String name, List<String> contactsList) {
        for (String listItem : contactsList) {
            System.out.println(listItem);
            String[] splitListItem = listItem.split("-");
            System.out.println(splitListItem[0]);
            System.out.println(splitListItem[1]);
            if (splitListItem[0].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {

//        1. View contacts.
//        2. Add a new contact.
//        3. Search a contact by name.
//        4. Delete an existing contact.
//        5. Exit.
//                Enter an option (1, 2, 3, 4 or 5):

//        Name | Phone number
//                ---------------
//                Jack Blank | 1231231234
//        Jane Doe | 2342342345
//        Sam Space | 3453453456

//    create();
//    searchContact();
        delete()








//        ArrayList<String> contact = new ArrayList<>();
//        ContactsList contact1 = new ContactsList("Jaz", "9032935456");
//        showContact(contact1, contact);
//        System.out.println(contact);
//        write(contact);

//        Adding from Users to the arraylist:
//        List<String> file = read();
//        String[] newAdd = create();
//        List<String> listOfContacts = file.stream().toList();
//        ArrayList<String[]> listOfSplitContacts = new ArrayList<>();
//        for (String listItem : file) {
//            String[] splitListItem = listItem.split(" - ");
//            listOfSplitContacts.add(splitListItem);
//
//        }
//        listOfSplitContacts.add(newAdd);

        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////

//        List<String[]> listOfContact = listOfSplitContacts.stream().toList();
//        ArrayList<String> listOfSplitContacts1 = new ArrayList<>();
//        for (String[] listItem : listOfContact) {
//            String str = String.join(" - ", listItem);
//            ;
//            listOfSplitContacts1.add(str);
////            System.out.println(Arrays.toString(listItem));
//        }
//        System.out.println(listOfSplitContacts1);
//        for (String splitContact : listOfSplitContacts1) {
//            System.out.println(splitContact.toString());

//        }
            ;
//        System.out.println(Arrays.toString(create()));


//      old code:
//        Stream<String> newContacts = file.stream();
//        Stream<Object> newContact1 = newContacts.map(s->{
//           return s.split("-");
//        });
//        Object[] newContact2 = newContact1.toArray(Object[]::new);
//        List<Object> list = new ArrayList<Object>();
//        list.add(newContact2);
//        System.out.println(list);

//        using stream to create convert sting to String []
//        String nameToFind = "Jaz";
//        List<String> listOfContacts = file.stream().toList();
//        ArrayList<String[]> listOfSplitContacts = new ArrayList<>();
//        for (String listItem : file){
//            System.out.println(listItem);
//            String[] splitListItem = listItem.split("-");
//            System.out.println(splitListItem[0]);
//            System.out.println(splitListItem[1]);
//            listOfSplitContacts.add(splitListItem);
//        }
//        System.out.println(findContactByName("Exabiier", file));
//        for (String[] splitContact : listOfSplitContacts){
//            System.out.println(splitContact[0]);
//            System.out.println(splitContact[1]);
//        }
//        System.out.println(listOfSplitContacts);


//        for(int i=0;i<x.size();i++){
//            String ContactInfo = x.get(i);
//
//        }


//        }

//    StandardOpenOption.APPEND

//    public static void setNameList(List<String> nameList) {
//        CliMain.nameList = nameList;
//    }
    }
}
