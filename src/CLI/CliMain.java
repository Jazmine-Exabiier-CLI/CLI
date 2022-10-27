package CLI;

public class CliMain {


    public static void main(String[] args) {
        ContactsList contact1 = new ContactsList("Jaz", "9032935456");
        System.out.println(contact1.getName());
        System.out.println(contact1.getNumber());
    }

}
