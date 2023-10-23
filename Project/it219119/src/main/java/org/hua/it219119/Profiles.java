package org.hua.it219119;

import java.util.*;

public class Profiles {

    //I create the values i will need for my program and set them to protected to be able to use them in the contracts class 
    protected int Afm, Id, Discount;
    protected String Address, Profession, Email;

    //I create the constructor to be able to create clients from within the program
    public Profiles(int Afm, int Id, String Address, String Profession, String Email, int Discount) {
        this.Afm = Afm;
        this.Id = Id;
        this.Address = Address;
        this.Profession = Profession;
        this.Email = Email;
        this.Discount = Discount;
    }

    //Empty constructor for the user to create the clients
    public Profiles() {
    }

    //Create function takes as parameter the arraylist for the clients and the profile that will be created
    public void create(ArrayList<Profiles> Clients, Profiles P3) {

        boolean isNum = false;

        Scanner s = new Scanner(System.in);

        StartAfm:
        do {                                                                                //I use a do while loop to check for errors in the user input
            System.out.println("Give your afm pls: ");                                      //Ask from the user an afm
            if (s.hasNextInt()) {
                setAfm(s.nextInt());                                                        //setAfm
                for (int i = 0; i < Clients.size(); i++) {                                  //I use a for loop to check if the afm the user gives already exists and if it does
                    if (getAfm() == Clients.get(i).getAfm()) {                              // i use continue to start the do while loop again if it doesnt the program runs 
                        System.out.println("This Afm already exists pls give a new one");
                        continue StartAfm;
                    }
                }
                isNum = true;
            } else {
                System.out.println("Please give correct afm");
                isNum = false;
                s.next();
            }
        } while (!(isNum));

        StartId:
        do {                                                                               //I use a do while loop to check for errors in the user input 
            System.out.println("Give your id pls: ");                                      //Ask from the user an id
            if (s.hasNextInt()) {
                setId(s.nextInt());                                                        //setId
                for (int i = 0; i < Clients.size(); i++) {                                 //I use a for loop to check if the id the user gives already exists and if it does
                    if (getId() == Clients.get(i).getId()) {                               // i use continue to start the do while loop again if it doesnt the program runs 
                        System.out.println("This Id already exists pls give a new one");
                        continue StartId;
                    }
                }
                isNum = true;
            } else {
                System.out.println("Please give correct id");
                isNum = false;
                s.next();
            }
        } while (!(isNum));

        System.out.println("Give your address pls: ");
        setAddress(s.next());

        do {                                                                                            //I use a do while loop to check for errors in the user input 
            System.out.println("Give your profession pls(Idiotis, Foititis, Epaggelmatias): ");         //Save the user input in a temp string
            String temp = s.next();
            if ("Idiotis".equals(temp) || "Foititis".equals(temp) || "Epaggelmatias".equals(temp)) {    //Check if temp is the appropriate values if not make the user 
                setProfession(temp);                                                                    // give the right values and setProffesion to temp
                isNum = true;
            } else {
                System.out.println("Please give correct Profession");
                isNum = false;
            }
        } while (!(isNum));

        do {                                                                            //I use a do while loop to check for errors in the user input 
            System.out.println("Give your email pls(Must have @ in it): ");             //Check if the email the user inputs has @ in it
            String temp = s.next();
            if (temp.contains("@") == true) {
                setEmail(temp);                                                         //setEmail to temp
                isNum = true;
            } else {
                System.out.println("Please give correct Email");
                isNum = false;                
            }
        } while (!(isNum));
        Discount = 0;                                                               //Set the discount as 0
        Clients.add(P3);                                                            //Add the clients to the arraylist

        // FOR MORE CHECKING
        System.out.println("\nThis is the info you gave:");
        PrintClient(getAfm(), Clients);

        System.out.println("\nYou have created your profile");

    }

    //PrintClient function takes as parameter the afm of the client that it will print and the Clients arraylist
    public void PrintClient(int Afm, ArrayList<Profiles> Clients) {
        //Using a for loop to go through the Clients arraylist
        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getAfm() == Afm) { //If statement to find the afm 
                //Print all the information of the client
                System.out.println("\nAFM: " + Clients.get(i).getAfm() + "\nID: " + Clients.get(i).getId() + "\nADDRESS: " + Clients.get(i).getAddress() + "\nPROFESSION: " + Clients.get(i).getProfession() + "\nEmail: " + Clients.get(i).getEmail() + "\nDiscount: " + Discount);
            }
        }
    }

    //Creating all the setters and getters for the values i assigned
    public int getAfm() {
        return Afm;
    }

    public void setAfm(int Afm) {
        this.Afm = Afm;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String Profession) {
        this.Profession = Profession;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
