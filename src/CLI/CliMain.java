package CLI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CliMain {

//    The path for for our file
    private final static Path PATH = Paths.get("src", "CLI", "CLI.txt");

///////////////////////////////////////////////
/////////////// UserInput ////////////////////
/////////////////////////////////////////////
    public static String userInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

///////////////////////////////////////////////
/////////////// Read and Write ////////////////////
/////////////////////////////////////////////

//    Writing to the Text file:
    public static void write(ArrayList<String> contact) {
        List<String> name = contact;
        try {
            Files.write(PATH, name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    Reading form the Text file
    public static List<String> read() {
        List<String> names;
        try {
            names = Files.readAllLines(PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return names;
    }


///////////////////////////////////////////////
/////////////// Creating Contact ////////////////////
/////////////////////////////////////////////

    public static void create() {
//        user input
        System.out.println("Enter the name: ");
        String name = userInput();
        System.out.println("Enter the number: ");
        String num = userInput();

//        Using the object in Order to to add to the list:
        ContactsList newUser = new ContactsList(name, num);
        String[] nameNum = {newUser.getName(), newUser.getNumber()};

        //////////////////////////////
        ////////////Part 2///////////
        ////////////////////////////

//      Reading from the txt file
        List<String> file = read();

//        Put and add the Array together but we get back an array list
//      Line 100:
        ArrayList<String[]> StringArray = convertArray(nameNum, file);

//       We need to convert the String[] back to a string so we can write onto the file like we want
//      Line 88:
        ArrayList<String> stringList = convertBackToString(StringArray);

//        Writing the
        write(stringList);

//      To show conacts after creat a new contact
        printOut();
        backToMain();
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

        ArrayList<String[]> listOfSplitContacts = new ArrayList<>();
        for (String listItem : file) {
            String[] splitListItem = listItem.split(" - ");
            listOfSplitContacts.add(splitListItem);
        }
        listOfSplitContacts.add(newAdd);
        return listOfSplitContacts;
    }


///////////////////////////////////////////////
/////////////// Search Contact ////////////////////
/////////////////////////////////////////////

    public static void patternSearch(List<String> list, String userInput){
        System.out.println("Name | Phone number\n" +
                "---------------");
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

//      Line 116:
        patternSearch(fromText, name);
        backToMain();
        }

///////////////////////////////////////////////
/////////////// Delete Contact ////////////////////
/////////////////////////////////////////////

        public static void delete () {

        ////////////////// Out Putting //////////////////////////

            List<String> contacts = read();
            printOut();

        ////////////////// User Input /////////////////////////////
            System.out.println("\nPlease pick the contact you want to delete:");
            String userInput = userInput();

        /////////////////// if there is no number ////////////////
//          Line 172:
            if(isNumeric(userInput)){
//              Line 184:
                deleteFromArray(contacts, userInput);
            } else{
                System.out.println("\nPlease Enter a real number!");
                delete();
            }


        }

//        To see if a number is a number
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

    public static void deleteFromArray(List<String> contacts, String userInput){
        int userInputNum = Integer.parseInt(userInput);
        try{
            contacts.remove(userInputNum-1);
        } catch(Exception e){
            System.out.println("Please pick a number between 1 and " + contacts.size());
            delete();
        }

//        converting a List<String> to ArrayList<String>
        ArrayList<String> contacts1 = (ArrayList<String>) contacts;
        write(contacts1);
        System.out.println("Here is your new Contact list:\n");
        printOut();

        /////////////////////// Would You like to go back /////////

        backToMain();
    }

///////////////////////////////////////////////
/////////////// PrintOut Contact ////////////////////
/////////////////////////////////////////////

    public static void printOut(){
        System.out.println("Name | Phone number\n" +
                "---------------");
        int count = 0;
        List<String> contacts = read();
        for(int i = 0; i<contacts.size(); i++){
            System.out.println((count+1) + ". " + contacts.get(i));

            count ++;
        }
    }

///////////////////////////////////////////////
/////////////// Main Menu Contact ////////////////////
/////////////////////////////////////////////

    public static void mainMenu (){
        System.out.println("\n1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
        String mainInput = userInput();
        switch(mainInput){
            case "1":
                //function to loop through contacts

//              Line 208:
                printOut();

//              Line 277:
                backToMain();

                break;
            case "2":
                //add new contact
//              Line 54:
                create();

                break;
            case "3":
                //search by name
//              Line 126:
                searchContact();

                break;
            case "4":
                //delete an existing contact
//              Line 147:
                delete();

                break;
            case "5":

                printOut();
                break;
            default:
                System.out.println("Please ONLY enter (1, 2, 3, 4, or 5): ");

                main(new String[] {});
        }

    }

///////////////////////////////////////////////
/////////////// Back to Main Menu ////////////////////
/////////////////////////////////////////////

    public static void backToMain(){
        System.out.println("Would you like to go back to the main Menu [y/n]");
        String exitInput = userInput();
        if(exitInput.equalsIgnoreCase("y")){

            main (new String[] {});

        } else {
            System.out.println("Have a nice Day!");
            printOut();
        }
    }

    public static void main(String[] args) {

//        Line 211:
        mainMenu();
    }
}
