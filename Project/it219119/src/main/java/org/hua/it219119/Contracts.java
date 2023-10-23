package org.hua.it219119;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Contracts extends Profiles {

    //I create the values i will need for my program
    protected String Type, AccountType, PaymentMethod, LineType, Internet, StartDate;
    protected int FreeMins, Length, Price, FreeSMS, FreeGB, LineSpeed, Discount;
    protected long PhoneNum;

    //Empty constructor for the user to create the contracts
    public Contracts() {
    }

    //Constructor for the contracts of Statheris
    public Contracts(int Afm, String Type, String AccountType, String PaymentMethod, String LineType, String Internet, String StartDate, long PhoneNum, int FreeMins, int Length, int Price, int LineSpeed, int Discount) {
        this.Afm = Afm;
        this.Type = Type;
        this.AccountType = AccountType;
        this.PaymentMethod = PaymentMethod;
        this.LineType = LineType;
        this.Internet = Internet;
        this.StartDate = StartDate;
        this.PhoneNum = PhoneNum;
        this.FreeMins = FreeMins;
        this.Length = Length;
        this.Price = Price;
        this.LineSpeed = LineSpeed;
        this.Discount = Discount;
    }

    //Constructor for the contracts of Kinitis
    public Contracts(int Afm, String Type, String AccountType, String PaymentMethod, String LineType, String Internet, String StartDate, long PhoneNum, int FreeMins, int Length, int Price, int FreeSMS, int FreeGB, int Discount) {
        this.Afm = Afm;
        this.Type = Type;
        this.AccountType = AccountType;
        this.PaymentMethod = PaymentMethod;
        this.LineType = LineType;
        this.Internet = Internet;
        this.StartDate = StartDate;
        this.PhoneNum = PhoneNum;
        this.FreeMins = FreeMins;
        this.Length = Length;
        this.Price = Price;
        this.FreeSMS = FreeSMS;
        this.FreeGB = FreeGB;
        this.Discount = Discount;
    }

    //create function takes as parameter the arraylist for the clients, the arraylist for the contracts and the contract that will be created
    public void create(ArrayList<Contracts> Con, ArrayList<Profiles> Clients, Contracts C3) {

        boolean isNum = false;
        Scanner scan = new Scanner(System.in);

        do {                                                                               //I use a do while loop to check for errors in the user input
            System.out.println("Give your afm:");                                          //Ask from the user an afm
            if (scan.hasNextInt()) {
                setAfm(scan.nextInt());
                for (int i = 0; i < Clients.size(); i++) {                                 //I use a for loop to check if the afm the user gives exists in the clients arraylist
                    if (getAfm() == Clients.get(i).getAfm()) {                             //and if it does the program runs if it doesnt i use return to send the user to the
                        isNum = true;                                                      //menu so he can create a profile
                    }
                }
                if (isNum == false) {
                    System.out.println("This afm does not exist pls create an account first");
                    return;
                }

            } else {
                System.out.println("Please give afm");
                isNum = false;
                scan.next();
            }
        } while (!(isNum));

        do {                                                                                 //I use a do while loop to check for errors in the user input 
            System.out.println("What type of contract you want?(Statheris or Kinitis):");
            String temp = scan.next();                                                       //Save the user input in a temp string
            if ("Statheris".equals(temp) || "Kinitis".equals(temp)) {                        //Check if temp is the appropriate values if not ask the user 
                setType(temp);                                                               //to give the right values
                isNum = true;
            } else {
                System.out.println("Please give correct Type of contract");
                isNum = false;

            }
        } while (!(isNum));

        StartPhoneNum:
        do {                                                                                 //I use a do while loop to check for errors in the user input 
            System.out.println("Give your Phone Number(10 digits):");

            if (scan.hasNextLong()) {                                                        //First check if the user gives numbers
                long temp;
                temp = scan.nextLong();
                long first = firstDigit(temp);
                if (temp > 1000000000l && temp < 10000000000l) {                            //Then i check if the phone number he gives has 10 digits
                    isNum = true;
                    if ("Statheris".equals(getType()) && first != 2) {                      //Check if the contract is statheris the first digit is 2
                        System.out.println("The type of the contract is Statheris the first digit must be 2");
                        System.out.println("Please give correct Phone Number");
                        isNum = false;
                    } else if ("Kinitis".equals(getType()) && first != 6) {                 //Else check if the contract is kinitis the first digit is 6
                        System.out.println("The type of the contract is Kinitis the first digit must be 6");
                        System.out.println("Please give correct Phone Number");
                        isNum = false;
                    }
                    setPhoneNum(temp);
                    for (int i = 0; i < Con.size(); i++) {
                        if (getPhoneNum() == Con.get(i).getPhoneNum()) {                    //Check if the phone number the user gives is in a different contract
                            System.out.println("This phone number is already in a different contract");
                            System.out.println("Please give a different one:");
                            continue StartPhoneNum;
                        }
                    }

                } else {
                    System.out.println("Please give correct Phone Number");
                    isNum = false;
                }
            } else {
                System.out.println("Please give correct Phone Number");
                isNum = false;
                scan.next();
            }
        } while (!(isNum));

        do {                                                                                        //I use a do while loop to check for errors in the user input
            System.out.println("Give the number of free minutes you want:");
            if (scan.hasNextInt()) {                                                                //Check if the user gives numbers and not letters
                setFreeMins(scan.nextInt());
                isNum = true;
            } else {                                                                                //If the user gives numbers loop and give the input again
                System.out.println("Please give correct number for free minutes");
                isNum = false;
                scan.next();
            }
        } while (!(isNum));

        do {                                                                                        //I use a do while loop to check for errors in the user input
            System.out.println("Give the date you want your contract to start(dd/mm/yy):");
            String Date = scan.next();
            boolean d = checkDate(Date);                                                            //Use of check datefuntion to see if the user input is a date
            if (d == true) {
                setStartDate(Date);
                isNum = true;

            } else {                                                                                //If the user gives wrong date loop and give the input again
                System.out.println("Please give correct date");
                isNum = false;
            }
        } while (!(isNum));

        do {                                                                                         //I use a do while loop to check for errors in the user input
            System.out.println("Give the length you want(12 or 24):");
            if (scan.hasNextInt()) {                                                                //Check if the user gives numbers and not letters
                int temp = scan.nextInt();
                if (temp == 12 || temp == 24) {                                                     //If statement to see if the user input is 12 or 24 if not
                    setLength(temp);                                                                //loop and give input again
                    isNum = true;
                } else {
                    System.out.println("Please give correct length");
                    isNum = false;

                }

            } else {
                System.out.println("Please give correct number");
                isNum = false;
                scan.next();
            }
        } while (!(isNum));

        setPrice();

        do {                                                                                     //I use a do while loop to check for errors in the user input
            System.out.println("What type of bill you want(Physical or Online):");
            String temp = scan.next();
            if ("Physical".equals(temp) || "Online".equals(temp)) {                             //if statement to check if the user input is correct or loop again to the start
                setAccountType(temp);
                isNum = true;
            } else {
                System.out.println("Please give correct Type of account");
                isNum = false;

            }
        } while (!(isNum));

        do {                                                                                     //I use a do while loop to check for errors in the user input
            System.out.println("Payment Method(Visa,Cash,Pagia): ");
            String temp = scan.next();
            if ("Visa".equals(temp) || "Cash".equals(temp) || "Pagia".equals(temp)) {           //if statement to check if the user input is correct or loop again to the start
                setPaymentMethod(temp);                                                         //set the PaymentMethod
                isNum = true;
            } else {
                System.out.println("Please give correct Payment Method");
                isNum = false;
            }
        } while (!(isNum));

        if ("Statheris".equals(getType())) {                                                     //If statement to check if the type of account is Statheris
            do {                                                                                 //I use a do while loop to check for errors in the user input
                System.out.println("Do you want Internet(Yes or No):");
                String temp = scan.next();
                if ("Yes".equals(temp) || "No".equals(temp)) {                                  //Check the answer is correct
                    if ("Yes".equals(temp)) {
                        setInternet(temp);                                                      //Set the Internet
                        isNum = true;
                    }
                    if ("No".equals(temp)) {                                                    //if the answer is no the contract is finished
                        System.out.println("Your Contract has been created");
                        Con.add(C3);                                                            //Add contract to the arraylist
                        setDiscount(Clients, Con, getAfm());                                      //Use function setDiscount to set the discount
                        PrintContracts(getAfm(), Con);                                          //Print the contract that has been created
                        return;
                    }
                } else {
                    System.out.println("Please give correct answer");
                    isNum = false;
                }
            } while (!(isNum));

            do {                                                                                //I use a do while loop to check for errors in the user input
                System.out.println("What is the Internet speed you want?");

                if (scan.hasNextInt()) {                                                        //Check if the user is giving numbers else ask for input again
                    setLineSpeed(scan.nextInt());                                               //Set the line speed

                    isNum = true;
                } else {
                    System.out.println("Please give correct number");
                    isNum = false;
                    scan.next();
                }
            } while (!(isNum));

            setLineType();

        } else {
            do {                                                                                 //I use a do while loop to check for errors in the user input
                System.out.println("Do you want Internet(Yes or No):");
                String temp = scan.next();                                                       //Same code as the above when it asks for the internet
                if ("Yes".equals(temp) || "No".equals(temp)) {
                    if ("Yes".equals(temp)) {
                        setInternet(temp);
                        isNum = true;
                    }
                    if ("No".equals(temp)) {
                        System.out.println("Your Contract has been created");
                        Con.add(C3);
                        setDiscount(Clients, Con, getAfm());
                        PrintContracts(getAfm(), Con);
                        return;
                    }
                } else {
                    System.out.println("Please give correct answer");
                    isNum = false;

                }
            } while (!(isNum));

            do {                                                                                     //I use a do while loop to check for errors in the user input
                System.out.println("How many gb you want?");

                if (scan.hasNextInt()) {                                                            //Check if the user is giving numbers else ask for input again
                    setFreeGB(scan.nextInt());                                                      //Set how many gb the user wants
                    isNum = true;
                } else {
                    System.out.println("Please give correct number");
                    isNum = false;
                    scan.next();
                }
            } while (!(isNum));

            do {                                                                                     //I use a do while loop to check for errors in the user input
                System.out.println("How many SMS you want?");

                if (scan.hasNextInt()) {                                                            //Check if the user is giving numbers else ask for input again
                    setFreeSMS(scan.nextInt());                                                     //Set how many SMS the user wants
                    isNum = true;
                } else {
                    System.out.println("Please give correct number");
                    isNum = false;
                    scan.next();
                }
            } while (!(isNum));

        }

        Con.add(C3);                                                                                //Add the contract to the arraylist
        setDiscount(Clients, Con, getAfm());                                                          //Set the discount for the current contract
        PrintContracts(getAfm(), Con);                                                              //Print the current contract

    }

    //Remove function takes as parameter the arraylist for the cotracts and the afm that the user wants to remove
    public void Remove(ArrayList<Contracts> Con, int Afm) {

        Scanner s = new Scanner(System.in);

        //for loop to search the arraylist
        for (int i = 0; i < Con.size(); i++) {
            //if statement to find the afm of the contract the user wants
            if (Con.get(i).getAfm() == Afm) {
                //Print the contents of the contract and its number
                System.out.println("\nNum: " + i + "\nCONTRACT: " + Con.get(i).getType() + "\nPHONE NUM: " + Con.get(i).getPhoneNum() + "\nStartDate: " + Con.get(i).getStartDate() + "\nLength: " + Con.get(i).getLength());
            }
        }
        //User input to choose which contract to remove
        System.out.println("\nWhich contract you want to remove");
        int ans = s.nextInt();
        Con.remove(ans);        //Remove the contract
    }

    //PrintStatistics function takes as parameter the arraylist of the contracts and prints the statistics
    public void PrintStatistics(ArrayList<Contracts> Con) {
        //The values for the type kinitis
        int maxFreeMins = 0, maxLineSpeed = 0, maxPrice = 0, maxFreeSMS = 0, maxFreeGB = 0;                                 //Setting all the max values to 0
        int minFreeMins = 100000, minLineSpeed = 100000, minPrice = 100000, minFreeSMS = 100000, minFreeGB = 100000;           //Setting all the min valus to 10000(Big Number)
        int meanFreeMins, meanLineSpeed, meanPrice, meanFreeSMS, meanFreeGB;

        //The values for the type Statheris
        int SmaxFreeMins = 0, SmaxLineSpeed = 0, SmaxPrice = 0, SmaxFreeSMS = 0, SmaxFreeGB = 0;                            //Doing the same for this values
        int SminFreeMins = 100000, SminLineSpeed = 100000, SminPrice = 10000, SminFreeSMS = 10000, SminFreeGB = 10000;
        int SmeanFreeMins, SmeanLineSpeed, SmeanPrice, SmeanFreeSMS, SmeanFreeGB;

        for (int i = 0; i < Con.size(); i++) {                        //Using a for loop to search through the Contracts arraylist

            if ("Kinitis".equals(Con.get(i).getType())) {               //If statement to find the  type kinitis
                if (Con.get(i).getFreeMins() > maxFreeMins) {           //Basic way to find the min and max
                    maxFreeMins = Con.get(i).getFreeMins();
                }
                if (Con.get(i).getLineSpeed() > maxLineSpeed) {
                    maxLineSpeed = Con.get(i).getLineSpeed();
                }
                if (Con.get(i).getPrice() > maxPrice) {
                    maxPrice = Con.get(i).getPrice();
                }
                if (Con.get(i).getFreeSMS() > maxFreeSMS) {
                    maxFreeSMS = Con.get(i).getFreeSMS();
                }
                if (Con.get(i).getFreeGB() > maxFreeGB) {
                    maxFreeGB = Con.get(i).getFreeGB();
                }
                if (Con.get(i).getFreeMins() < minFreeMins) {
                    minFreeMins = Con.get(i).getFreeMins();
                }
                if (Con.get(i).getLineSpeed() < minLineSpeed) {
                    minLineSpeed = Con.get(i).getLineSpeed();
                }
                if (Con.get(i).getPrice() < minPrice) {
                    minPrice = Con.get(i).getPrice();
                }
                if (Con.get(i).getFreeSMS() < minFreeSMS) {
                    minFreeSMS = Con.get(i).getFreeSMS();
                }
                if (Con.get(i).getFreeGB() < minFreeGB) {
                    minFreeGB = Con.get(i).getFreeGB();
                }

            }
        }
        //Adding the min and max and doing division /2 to find the mean
        meanFreeMins = (maxFreeMins + minFreeMins) / 2;
        meanFreeSMS = (maxFreeSMS + minFreeSMS) / 2;
        meanFreeGB = (maxFreeGB + minFreeGB) / 2;
        meanLineSpeed = (maxLineSpeed + minLineSpeed) / 2;
        meanPrice = (maxPrice + minPrice) / 2;

        //Printing out the values for Kinitis
        System.out.println("\nKINITIS\n");
        System.out.println("\nMaxFreeMins: " + maxFreeMins + "\nMaxPrice: " + maxPrice + "\nMaxGB: " + maxFreeGB + "\nMaxFreeSMS: " + maxFreeSMS);
        System.out.println("\nMinFreeMins: " + minFreeMins + "\nMinPrice: " + minPrice + "\nMinGB: " + minFreeGB + "\nMinFreeSMS: " + minFreeSMS);
        System.out.println("\nMeanFreeMins: " + meanFreeMins + "\nMeanPrice: " + meanPrice + "\nMeanGB: " + meanFreeGB + "\nMeanFreeSMS: " + meanFreeSMS);

        //Doing the same thing as i did above but for the Statheris type
        for (int i = 0; i < Con.size(); i++) {
            if ("Statheris".equals(Con.get(i).getType())) {
                if (Con.get(i).getFreeMins() > SmaxFreeMins) {
                    SmaxFreeMins = Con.get(i).getFreeMins();
                }
                if (Con.get(i).getLineSpeed() > SmaxLineSpeed) {
                    SmaxLineSpeed = Con.get(i).getLineSpeed();
                }
                if (Con.get(i).getPrice() > SmaxPrice) {
                    SmaxPrice = Con.get(i).getPrice();
                }
                if (Con.get(i).getFreeSMS() > SmaxFreeSMS) {
                    SmaxFreeSMS = Con.get(i).getFreeSMS();
                }
                if (Con.get(i).getFreeGB() > SmaxFreeGB) {
                    SmaxFreeGB = Con.get(i).getFreeGB();
                }
                if (Con.get(i).getFreeMins() < SminFreeMins) {
                    SminFreeMins = Con.get(i).getFreeMins();
                }
                if (Con.get(i).getLineSpeed() < SminLineSpeed) {
                    SminLineSpeed = Con.get(i).getLineSpeed();
                }
                if (Con.get(i).getPrice() < SminPrice) {
                    SminPrice = Con.get(i).getPrice();
                }
                if (Con.get(i).getFreeSMS() < SminFreeSMS) {
                    SminFreeSMS = Con.get(i).getFreeSMS();
                }
                if (Con.get(i).getFreeGB() < SminFreeGB) {
                    SminFreeGB = Con.get(i).getFreeGB();
                }

            }

        }
        SmeanFreeMins = (SmaxFreeMins + SminFreeMins) / 2;
        SmeanFreeSMS = (SmaxFreeSMS + SminFreeSMS) / 2;
        SmeanFreeGB = (SmaxFreeGB + SminFreeGB) / 2;
        SmeanLineSpeed = (SmaxLineSpeed + SminLineSpeed) / 2;
        SmeanPrice = (SmaxPrice + SminPrice) / 2;

        System.out.println("\nSTATHERIS\n");
        System.out.println("\nMaxFreeMins: " + SmaxFreeMins + "\nMaxPrice: " + SmaxPrice + "\nMaxLineSpeed: " + SmaxLineSpeed);
        System.out.println("\nMinFreeMins: " + SminFreeMins + "\nMinPrice: " + SminPrice + "\nMaxLineSpeed: " + SminLineSpeed);
        System.out.println("\nMeanFreeMins: " + SmeanFreeMins + "\nMeanPrice: " + SmeanPrice + "\nMaxLineSpeed: " + SmeanLineSpeed);
    }

    //PrintContracts function takes as parameter the afm of the contract that it will print and the Contracts arraylist
    public void PrintContracts(int Afm, ArrayList<Contracts> Con) {
        //Using a for loop to go through the Contracts arraylist
        for (int i = 0; i < Con.size(); i++) {
            //If statement to find the afm 
            if (Con.get(i).getAfm() == Afm) {
                //if statement to find the type of the account and print accordingly
                if ("Statheris".equals(Con.get(i).getType())) {
                    System.out.println("\nCONTRACT: " + Con.get(i).getType() + "\nPHONE NUM: " + Con.get(i).getPhoneNum() + "\nStartDate: " + Con.get(i).getStartDate() + "\nLength: " + Con.get(i).getLength() + "\nFreeMinutes: " + Con.get(i).getFreeMins() + "\nMonthlyCost: " + Con.get(i).getPrice() + "\nAccountType: " + Con.get(i).getAccountType() + "\nPaymentMethod:" + Con.get(i).getPaymentMethod() + "\nDiscount: " + Con.get(i).getDiscount());

                } else {
                    System.out.println("\nCONTRACT: " + Con.get(i).getType() + "\nPHONE NUM: " + Con.get(i).getPhoneNum() + "\nStartDate: " + Con.get(i).getStartDate() + "\nLength: " + Con.get(i).getLength() + "\nFreeMinutes: " + Con.get(i).getFreeMins() + "\nMonthlyCost: " + Con.get(i).getPrice() + "\nAccountType: " + Con.get(i).getAccountType() + "\nPaymentMethod:" + Con.get(i).getPaymentMethod() + "\nFreeGB: " + Con.get(i).getFreeGB() + "\nFreeSMS: " + Con.get(i).getFreeSMS() + "\nDiscount: " + Con.get(i).getDiscount());
                }
            }
        }

    }

    //SetDiscount function takes as parameters the afm the user want to fidn the discount for and the arraylists for the Contracts and Clients
    public void setDiscount(ArrayList<Profiles> Clients, ArrayList<Contracts> Con, int afm) {
        Discount = 0;                                       //Set Discount to 0 
        int cnt = 0;
        int temp = 0, temp1 = 0;
        for (int i = 0; i < Clients.size(); i++) {          //For loop to search through the Clients arraylist
            if (afm == Clients.get(i).getAfm()) {           //If statement to find the afm the user wants      
                temp = i;                                   //Save the afm in temp
            }
        }
        for (int j = 0; j < Con.size(); j++) {                //For loop to search through the Contracts arraylist
            if (afm == Con.get(j).getAfm()) {                 //If statement to find the afm the user wants 
                temp1 = j;                                    //Save the afm in temp
                cnt++;                                        //Use cnt to count how many contracts a single afm has
            }
        }

        //Using if statements to find the criteria for the Discounts and add them
        if ("Epaggelmatias".equals(Clients.get(temp).getProfession())) {
            Discount += 10;
        }
        if ("Foititis".equals(Clients.get(temp).getProfession())) {
            Discount += 15;
        }
        if (Con.get(temp1).getFreeMins() > 1000 && "Statheris".equals(Con.get(temp1).getType())) {
            Discount += 8;
        }
        if (Con.get(temp1).getFreeMins() > 1000 && "Kinitis".equals(Con.get(temp1).getType())) {
            Discount += 11;
        }
        if ("Visa".equals(Con.get(temp1).getPaymentMethod()) || "Pagia".equals(Con.get(temp1).getPaymentMethod())) {
            Discount += 5;
        }
        if ("Online".equals(Con.get(temp1).getAccountType())) {
            Discount += 2;
        }
        if (cnt == 1) {
            Discount += 5;
        }
        if (cnt == 2) {
            Discount += 10;
        }
        if (cnt > 2) {
            Discount += 15;
        }
        if (Discount > 45) {
            Discount = 45;
        }

    }
    
    //Setters and getters for the values

    public int getDiscount() {
        return Discount;
    }

    public int getPrice() {
        return Price;
    }

    //Setting the price using an algorithm i came up with
    public void setPrice() {
        int price = 20 + (getFreeMins() / 75) + (getFreeSMS() / 75) + ((getFreeGB() * 1000) / 75);
        Price = price;
    }

    public String getLineType() {
        return LineType;
    }

    //Setting the LineType depending on the LineSpeed
    public void setLineType() {
        if (LineSpeed > 50) {
            LineType = "VDSL";
        } else {
            LineType = "ADSL";
        }
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public String getInternet() {
        return Internet;
    }

    public void setInternet(String Internet) {
        this.Internet = Internet;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public long getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(long PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public int getFreeMins() {
        return FreeMins;
    }

    public void setFreeMins(int FreeMins) {
        this.FreeMins = FreeMins;
    }

    public int getLength() {
        return Length;
    }

    public void setLength(int Length) {
        this.Length = Length;
    }

    public int getFreeSMS() {
        return FreeSMS;
    }

    public void setFreeSMS(int FreeSMS) {
        this.FreeSMS = FreeSMS;
    }

    public int getFreeGB() {
        return FreeGB;
    }

    public void setFreeGB(int FreeGB) {
        this.FreeGB = FreeGB;
    }

    public int getLineSpeed() {
        return LineSpeed;
    }

    public void setLineSpeed(int LineSpeed) {
        this.LineSpeed = LineSpeed;
    }

    //Checking if the date format that is given is correct
    public boolean checkDate(String Date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date BOD = null;
        df.setLenient(false);

        try {
            BOD = df.parse(Date);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    //FirstDigit function to find the first digit of a number used for the phone number
    public long firstDigit(long n) {
        // Remove last digit from number 
        // till only one digit is left 
        while (n >= 10) {
            n /= 10;
        }

        // return the first digit 
        return n;
    }

}
