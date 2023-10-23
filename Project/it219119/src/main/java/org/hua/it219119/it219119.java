package org.hua.it219119;

import java.util.*;

class it219119 {

    public static void main(String args[]) {

        boolean flag = false;
        
        //  Create 2 new client from the profile class using the constructor
        Profiles P1 = new Profiles(219119, 12345, "eleutherias", "foititis", "it219119@hua.gr", 0); 
        Profiles P2 = new Profiles(219149, 12335, "giannaki", "idiotis", "it219149@hua.gr", 0);
        Profiles test = new Profiles();

        ArrayList<Profiles> Clients = new ArrayList(); //Create the arraylist for the clients

        // Adding the 2 clients to the arraylist
        Clients.add(P1);
        Clients.add(P2);
        
        // Create 3 new contracts from the contracts class using the constructor
        Contracts C1 = new Contracts(219119, "Statheris", "Online", "Visa", "VDSL", "YES", "12/1/21", 2097782945l, 1030, 12, 20, 100, 35);       
        Contracts C2 = new Contracts(219149, "Kinitis", "Online", "Pagia", "ADSL", "YES", "22/1/21", 6099457856l, 50, 24, 25, 100, 150, 17);
        Contracts C3 = new Contracts(219149, "Statheris", "Physical", "Cash", "VDSL", "YES", "24/1/21", 209943356l, 40, 24, 50, 120, 10);
        Contracts testC = new Contracts();

        ArrayList<Contracts> Con = new ArrayList<>(); //Create the arraylist for the contracts

        // Add the 3 contracts to the arraylist
        Con.add(C1);
        Con.add(C2);
        Con.add(C3);

        //Print the menu for the program
        System.out.println("                WELCOME TO JAVAPHONE                ");
        System.out.println("                ------- ~~~~ -------");

        //Use a while loop to show the menu again after each command is completed
        while (flag == false) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("\n");
            System.out.println("----------------------------------");
            System.out.println("|1.Create Profile                 |");
            System.out.println("----------------------------------");
            System.out.println("|2.Create Contract                |");
            System.out.println("----------------------------------");
            System.out.println("|3.Remove Contract                |");
            System.out.println("----------------------------------");
            System.out.println("|4.Show statistics                |");              //I split the show statistics and the show details in 2
            System.out.println("----------------------------------");
            System.out.println("|5.Show details of users contracts|");
            System.out.println("----------------------------------");
            System.out.println("|6.Quit                           |");
            System.out.println("----------------------------------");           
            System.out.println("Choose a number: ");

            Scanner s = new Scanner(System.in);

            //Use a switch to get a number from the user and complete the command accordingly
            switch (s.nextInt()) {
                case 1 -> {
                    Profiles P3 = new Profiles();   //In case 1 we create a new profile and use the create function from the profiles class
                    P3.create(Clients, P3);
                }

                case 2 -> {
                    Contracts C4 = new Contracts(); //In case 2 we create a new contract and use the create contract function from the contracts class
                    C4.create(Con, Clients, C4);
                }

                case 3 -> {
                    System.out.println("Give your afm pls");    //In case 3 i ask the user for an afm and use that afm to call the remove function from the contracts class
                    int afm = s.nextInt();                     // and i call the printcontracts function after

                    testC.Remove(Con, afm);

                    testC.PrintContracts(afm, Con);
                }

                case 4 -> {
                    testC.PrintStatistics(Con);     //In case 4 i call the printStatistics function from the contracts class
                }

                case 5 -> {
                    boolean isNum = false;
                    int afm = 0;
                    do {                                        //In case 5 i use a do while to check if the afm the user gives is correct and if it exists in the clients
                        System.out.println("Give your afm:");   // arraylist after that i call the setdiscount and printcontracts functions from the cintracts class
                        if (s.hasNextInt()) {
                            afm = s.nextInt();
                            for (int i = 0; i < Clients.size(); i++) {
                                if (afm == Clients.get(i).getAfm()) {
                                    testC.setDiscount(Clients, Con, afm);
                                    testC.PrintContracts(afm, Con);                                    
                                    isNum = true;

                                }
                            }
                            if (isNum == false) {
                                System.out.println("This afm does not exist pls create an account first");
                                break;
                            }

                        } else {
                            System.out.println("Please give afm");
                            isNum = false;
                            s.next();
                        }
                    } while (!(isNum));
                }

                case 6 -> {
                    flag = true;    //In case 6 i use the bool flag to end the loop and the program
                }
               

            }

        }
    }

}
