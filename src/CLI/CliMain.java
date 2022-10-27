package CLI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    private final static Path PATH = Paths.get("src","CLI","CLI.txt");


    public static void showContact(ContactsList NameNum, ArrayList<String> contact){
//        We need
        List<String> name = contact;
        name.add(NameNum.getName());
        name.add(NameNum.getNumber());
        for(int i=0;i<name.size();i++){
            System.out.println(name.get(i));
        }
    }

    public static void write(ArrayList<String> contact){
        List<String> name = contact;
        try {
            Files.write(PATH, name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





    public static void main(String[] args) {
        ArrayList<String> contact = new ArrayList<>();
        ContactsList contact1 = new ContactsList("Jaz", "9032935456");
        showContact(contact1, contact);
        System.out.println(contact);
        write(contact);
    }

//    public static void setNameList(List<String> nameList) {
//        CliMain.nameList = nameList;
//    }
}
