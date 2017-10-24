
package fileio_lab;

import  java.io.*;

/**
 * Boiler plate for menu driven File I/O lab
 * @author madine
 */
public class FileIO_Lab {

    private static BufferedReader  stdIn =
		new  BufferedReader(new  InputStreamReader(System.in));

    private static PrintWriter  stdOut =
		new  PrintWriter(System.out, true);
    
    
    
    /**
     * Display a menu and solicit user input based on the available choices
     * if the user selects an option that does not exist, this method will 
     * retry it self.
     * 
     * @return integer representing the users choice
     */
    public static int menu() throws IOException {
        
        int choice=0;
        
        while(true){
            
            // prompt the user their choice
            stdOut.println("Please choose from the following");
            stdOut.println("1) Encrypt a file");
            stdOut.println("2) Decrypt a file");
            stdOut.println("3) Quit");
            stdOut.print("   Choice -> ");
            stdOut.flush();

            // wait for the user to enter their choice
            try {
            choice = Integer.parseInt(stdIn.readLine());
            if(choice < 4 && choice > 0)
                return choice;
            
            // this line is executed whenever the user enters an out of the domain of {1,2,3}
            stdOut.println("\n ***INVALID INPUT, Please try again***\n");
            }
            
            catch(NumberFormatException nfe) {
                stdOut.println("\n ***INVALID INPUT, Please try again***\n");
            }
            
        }
        
    }
    
    /**
     * 
     */
    public static void encrypt() throws IOException
    {
        char x;
        int difference=0;
        String filspc = "";             // re-useable variable containing the [path and] file name
	BufferedReader  input = null;	// reference to the input file
	PrintWriter  output = null;	// reference to the output file
        
        //Ask user for file
            stdOut.print("Source filename:  ");
            stdOut.flush();
            filspc = stdIn.readLine();
        
        try {
		// open the file for reading else throw a 'FileNotFoundException
		input = new BufferedReader( new FileReader(filspc));
            }
	catch (FileNotFoundException fnfe) {
		// inform the user of the problem then terminate this application
		stdOut.println("The file " + filspc + " was not found. Program terminated.");
		System.exit(1);
            }
        //Choose where to create encrypted file
            stdOut.print("Destination filename:  ");
            stdOut.flush();
            filspc = stdIn.readLine();
            
        try {
                // open the file for writing else throw a 'FileNotFoundException
                output = new  PrintWriter(new FileWriter(filspc));
            }
        catch (FileNotFoundException fnfe) {
                // inform the user of the problem then terminate this application
                stdOut.println("The file " + filspc + " was not found. Program terminated.");
                System.exit(1);
            }
        //Array for characters
            
            String processWords = "";
        
        // read the first line if possible
            String  line = input.readLine();
            
        //loop through lines untill done
            while (line != null)  {
                //Encrypt
                for(int i = 0;i < line.length();++i){
                    x = line.charAt(i);
                    x+=5;
                    
                    if(x > 122){
                        difference = x - 122;
                            x = (char) ('z' + (difference-1));}
                    processWords +=x;
                    
                }
                    //copy to file
                    output.println(processWords);
                    line = input.readLine();
                    
		}
            
        input.close();
	output.close();
        // print  completion
            stdOut.println("Encryption Complete!");
        
    
    }
    /**
     * 
     */
    public static void decrypt() throws IOException
    {
        char x;
        int difference = 0;
        String filspc = "";             // re-useable variable containing the [path and] file name
	BufferedReader  input = null;	// reference to the input file
	PrintWriter  output = null;	// reference to the output file
        
        //Ask user for file
            stdOut.print("Source filename:  ");
            stdOut.flush();
            filspc = stdIn.readLine();
        
        try {
		// open the file for reading else throw a 'FileNotFoundException
		input = new BufferedReader( new FileReader(filspc));
            }
	catch (FileNotFoundException fnfe) {
		// inform the user of the problem then terminate this application
		stdOut.println("The file " + filspc + " was not found. Program terminated.");
		System.exit(1);
            }
        //Choose where to create Decrypted file
            stdOut.print("Destination filename:  ");
            stdOut.flush();
            filspc = stdIn.readLine();
            
        try {
                // open the file for writing else throw a 'FileNotFoundException
                output = new  PrintWriter(new FileWriter(filspc));
            }
        catch (FileNotFoundException fnfe) {
                // inform the user of the problem then terminate this application
                stdOut.println("The file " + filspc + " was not found. Program terminated.");
                System.exit(1);
            }
        //Array for characters
            
            String processWords="";
        
        // read the first line if possible
            String  line = input.readLine();
            
        //loop through lines untill done
            while (line != null)  {
                    //Decrypt
                    for(int i = 0;i < line.length();++i){
                    x = line.charAt(i);
                    x-=5;
                    
                    if(x < 102){
                        difference = x - 122;
                            x = (char) ('a' - (difference-1));}
                    processWords +=x;
                }
                    //copy to file
                    output.println(processWords);
                    line = input.readLine();
                    
              }
            
        input.close();
	output.close();
        // print  completion
            stdOut.println("Decryption Complete!");
        
    }
    
    /**
     * @param args the command line arguments
     * 
     * @throws IOException
     */
    public static void main(String[] args)  throws IOException {
             
        while(true){
            int userInput = menu();


            switch(userInput) {
                case 1:
                    // This is where the code for encryption should go.
                    stdOut.println("You choose encryption");
                    encrypt();
                    break;

                case 2:
                    // This is where the code for decryption should go.
                    stdOut.println("You choose decryption");
                    decrypt();
                    break;

                case 3:
                    // exit.
                    stdOut.println("Good-By Moto.");
                    System.exit(0);
                    break;
            }
        }
        
    }
    
}
