package CLI;


//import java.util.ArrayList;

public class ContactsList {

//    private ArrayList<String> name;
    private String name;
    private String number;
    //=========================GETTING AND SETTING NAME=============================
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //=========================GETTING AND SETTING NUMBER=============================
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    //===========================toString Method====================
    public String toString(){
        return name;
    }

    public ContactsList(){}

    //=====Conductor putting both name and number on the same line=======================
    public ContactsList(String name, String number){
        this.name = name;
        this.number = number;

    }



}
