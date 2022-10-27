package CLI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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

    public static String[] create() {
        System.out.println("Enter the name: ");
        String name = userInput();
        System.out.println("Enter the number: ");
        String num = userInput();
        String[] nameNum = {name, num};
        return nameNum;
    }


    //=======Method for looping through contact array==================
    public static void showContact(ContactsList NameNum, ArrayList<String> contact) {
        List<String> name = contact;
//        name.add(NameNum.getName());
        name.add(NameNum.getName());
        for (int i = 0; i < name.size(); i++) {
//            System.out.println(name.get(i));
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
        ArrayList<String> contact = new ArrayList<>();
        ContactsList contact1 = new ContactsList("Jaz", "9032935456");
//        showContact(contact1, contact);
//        System.out.println(contact);
//        write(contact);

//        Adding from Users to the arraylist:
        List<String> file = read();
        String[] newAdd = create();
        List<String> listOfContacts = file.stream().toList();
        ArrayList<String[]> listOfSplitContacts = new ArrayList<>();
        for (String listItem : file) {
            String[] splitListItem = listItem.split("-");
            listOfSplitContacts.add(splitListItem);

        }
        listOfSplitContacts.add(newAdd);

        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////

        List<String[]> listOfContact = listOfSplitContacts.stream().toList();
        ArrayList<String> listOfSplitContacts1 = new ArrayList<>();
        for (String[] listItem : listOfContact) {
            String str = listItem.toString();
            ;
            listOfSplitContacts1.add(str);
            System.out.println(listItem);
        }
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
