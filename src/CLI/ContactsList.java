package CLI;


//import java.util.ArrayList;

public class ContactsList {

//    private ArrayList<String> name;
    private String nameNum;
    private String number;
    //=========================GETTING AND SETTING NAME=============================
    public String getName() {
        return nameNum;
    }
    public void setName(String name) {
        this.nameNum = name;
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
        return nameNum;
    }

    public ContactsList(){}

    //=====Conductor putting both name and number on the same line=======================
    public ContactsList(String name, String number){
        this.nameNum = name + "-" + number;

    }



}
