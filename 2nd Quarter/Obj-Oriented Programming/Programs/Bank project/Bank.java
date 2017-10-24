package pti.edu;

import java.util.ArrayList;
import pti.bank.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Program to read and write to a text file containing a list of Bank Accounts
 * @author djc35
 */
public class Bank 
{
    private static ArrayList<Account> accounts;
    private static BufferedReader  stdIn =
		new  BufferedReader(new  InputStreamReader(System.in));

    private static PrintWriter  stdOut =
		new  PrintWriter(System.out, true);
    private static String[] words;
    private static String line;
    private static Path file = Paths.get("F:/Programming/Obj-Oriented Programming/Programs/Bank Project/Bank_Part_2/bankAccounts.txt");
        /**
         * Creates a Constructor for the Bank class
         */
        public Bank()
        {
            accounts = new ArrayList<Account>();
        }
        
        /**
         * Display and functionality if the program's main menu system
         * @return 
         * @throws java.io.IOException 
         */
        public static int menu() throws IOException
        {
            int choice;
            stdOut.print("1) Open Bank\n"
                           + "2) Close Bank\n"
                           + "3) Display All Accounts\n"
                           + "4) Add an Account\n"
                           + "5) Remove an Account\n"
                           + "6) Quit. Exits the Application.\n"
                           + "Choice --> ");
            stdOut.flush();
            try{
            choice = Integer.parseInt(stdIn.readLine());
            
            if(choice == 1)
                return 1;
            else if(choice == 2)
                return 2;
            else if(choice == 3)
                return 3;
            else if(choice == 4)
                return 4;
            else if(choice == 5)
                return 5;
            else if(choice == 6)
                return 6;
            }
            catch(NumberFormatException nfe)
            {
                stdOut.println("Not a valid number! Please try aggain.");
            }
            return 0;
            
        }
        
        /**
         * Displays the Accounts in a String form
         * @return 
         */
        public String toString()
        {
            String Prefix = "";
            int x;
            for(x = 0;x<accounts.size() ;++x)
                return  Prefix + " " + 
                        accounts.get(x).getUserID() + " " +
                        accounts.get(x).getNameOnAccount()+ " " +
                        accounts.get(x).getAccountBalance() +"\n";
            return "";
        }
        
        /**
         * Opens the file bankAccounts.txt to read and write to.
         * @throws java.io.IOException
         */
        public static void load() throws IOException
        {
            BufferedReader br=null;
            try {
                    // open the file for reading else throw a 'FileNotFoundException
                    InputStream is = new FileInputStream(file.toString());
                    br = new BufferedReader(new InputStreamReader(is));    
                    
                    line = br.readLine();							
                    while (line  != null)  {
                    words = line.split("_");

                    if(words[0].startsWith("CHECKING"))
                        accounts.add(new CheckingAccount(Integer.parseInt(words[1]),
                                words[2],
                                Float.parseFloat(words[3])));
                    if(words[0].startsWith("SAVINGS"))
                        accounts.add(new SavingsAccount(Integer.parseInt(words[1]),
                                words[2],
                                Float.parseFloat(words[3])));
                    
                    line = br.readLine();
                    }
                    br.close();
                }catch (FileNotFoundException fnfe) {
			// inform the user of the problem then terminate this application
			stdOut.println("The file " + file.toString() + " was not found. Program terminated.");
			System.exit(1);
		}
                stdOut.println("job done!");
                stdOut.flush();
        }
        
        /**
         * Writes new bankAccounts to the file.
         * @throws java.io.IOException
         */
        public static void write() throws IOException //Deletes what is in file AKA Writes a blank file over the old one
        {
            PrintWriter  output = null;	// reference to the output file
            int x = 0;
            String processWords;
            words = line.split("_");
            try {
			// open the file for reading else throw a 'FileNotFoundException
			output = new PrintWriter( new FileWriter(file.toString()));
		}
		catch (FileNotFoundException fnfe) {
			// inform the user of the problem then terminate this application
			stdOut.println("The file " + file.toString() + " was not found. Program terminated.");
			System.exit(1);
		}
            while(line!=null)
            {
                processWords = words[x]+"_";
                output.println(processWords);
                ++x;
            }
            stdOut.println("job done!");
        }
        
        /**
         * Exits the program
         */
        public static void close()
        {
            
            stdOut.println("Exiting program.");
            System.exit(0); 
        }
        
        /**
         * Adds a new account to the array list
         * @return 
         * @throws java.io.IOException 
         */
        public static boolean addAccount() throws IOException
        {
            int choice, userID;
            float balance;
            String nameOnAccount;

                stdOut.print("What type of Account would you like to open?\n"
                        + "1) CHECKING\n"
                        + "2) SAVINGS\n"
                        + "Choice -->");
                stdOut.flush();
                choice = Integer.parseInt(stdIn.readLine());
            
                if(choice == 1)
                {
                    stdOut.print("Input a User ID number,\n"
                        + "the Name of the Account holder,\n"
                        + "and a balance to deposit.\n"
                            + "User ID -->");
                    stdOut.flush();
                    userID = Integer.parseInt(stdIn.readLine());
                    
                    stdOut.print("Name -->");
                    stdOut.flush();
                    nameOnAccount = stdIn.readLine();
                
                    stdOut.print("Initial Balance -->");
                    stdOut.flush();
                    balance = Float.parseFloat(stdIn.readLine());
                    
                    accounts.add(new CheckingAccount(userID,nameOnAccount,balance));
                    
                    return true;
                }
                else if(choice == 2)
                {
                    stdOut.print("Input a User ID number,\n"
                            + "the Name of the Account holder,\n"
                            + "and a balance to deposit.\n"
                            + "User ID -->");
                    stdOut.flush();
                    userID = Integer.parseInt(stdIn.readLine());
                    
                    stdOut.print("Name -->");
                    stdOut.flush();
                    nameOnAccount = stdIn.readLine();
                
                    stdOut.print("Initial Balance -->");
                    stdOut.flush();
                    balance = Float.parseFloat(stdIn.readLine());
                
                    accounts.add(new SavingsAccount(userID,nameOnAccount,balance));
                    return true;
                }
                else
                    return false;  
        }
        
        /**
         * Removes an account which contains the User ID number from the 
         * given parameter:
         * @param userID
         * @return 
         */
        public static boolean removeAccount(int userID)//Still Broken Index Out of Bounds Exception
        {
            int x ;
            stdOut.println("Removing Account.");
            stdOut.flush();
            for(x = 0;x<=accounts.size()-1;++x)
            {
                if(accounts.get(x).getUserID()== userID)
                    {
                        accounts.remove(userID);
                    return true;
                    }
                else
                {
                    stdOut.println("Could not remove account. Please try again.");
                    return false;
                }
            }
        return false;    
        } 
        
        /**
         * Primary Driver method
         * @param args 
         * @throws java.io.IOException 
         */
        public static void main(String[] args) throws IOException 
        {
            Bank bank = new Bank();
            
            boolean addAccount, removeAccount;
            int result = 0;
            do{
            result = menu();
            
                if(result==1)
                {
                    stdOut.println("Opening bank.");
                    load();
                }
                else if(result==2)
                {
                    stdOut.println("Closing bank.");
                    write();
                }
                else if(result==3)
                {
                    String display = accounts.toString();
                    stdOut.println("Displaying accounts:");
                    stdOut.flush();
                    stdOut.println(display);
                    stdOut.flush();
                }
                else if(result==4)
                {
                    stdOut.println("Add new account:");
                    stdOut.flush();
                    addAccount = addAccount();
                }
                else if(result==5)
                {
                    int choice;
                    stdOut.print("Input the User ID of the account"
                            + "you wish to remove--> ");
                    stdOut.flush();
                    choice = Integer.parseInt(stdIn.readLine());
                    removeAccount = removeAccount(choice);
                }
                else if(result==6)
                {
                    close();
                } 
            }while(true);
        }
}
