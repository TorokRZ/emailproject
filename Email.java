package emailapp;

import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private String email;
    private String password;
    private int mailboxCapacity;
    private String alternateEmail;
    private int defaultPassLength = 10;
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        String department = setDepartment();

        this.password = randomPassword(defaultPassLength);
        System.out.println("Your password is: " + this.password);

        String companySuffix = "leyndellplc.com";
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "."  + companySuffix;
    }

    private String setDepartment()
    {
        System.out.print("New employee: "+ firstName + " " + lastName + "\nDepartment codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            setMailboxCapacity(10);
            return "sales";
        } else if (depChoice == 2) {
            setMailboxCapacity(15);
            return "dev";
        } else if (depChoice == 3) {
            setMailboxCapacity(20);
            return "accounting";
        } else {
            return "";
        }
    }
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIKLMNOPQRTSUZXYZ0123456789!@&#";
        char[] password = new char[length];
        for (int i=0; i<length; i++)
        {
            int rnd = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rnd);
        }
        return new String(password);
    }
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }
    public void changePassword(String password){
        this.password = password;
    }
    public int getMailboxCapacity() {return mailboxCapacity; }
    public String getAlternateEmail(){ return alternateEmail; }
    public String getPassword(){return password; }

    public  String showInfo() {
        return "Display name: " + firstName + " " + lastName + "\n" +
                "Company email: " + email + "\n" +
                "Mailbox capacity: " + mailboxCapacity + "GB";
    }

}
