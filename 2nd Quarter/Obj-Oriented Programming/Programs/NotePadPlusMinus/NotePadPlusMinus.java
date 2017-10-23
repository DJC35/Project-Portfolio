/*
 * Student Starter files
 *
 * Your task is to implememt
 *      1) Spellchecking:
 *          Read a text file 
 *          and create an array of words to compair the JTextArea to.
 */
package pti.edu;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * 
 * @author DJC35
 */
public class NotePadPlusMinus extends JPanel implements ActionListener {

    // standerd I/O Bioler Plate
    private static BufferedReader  stdIn = new BufferedReader(new  InputStreamReader(System.in));
    private static PrintWriter  stdOut = new PrintWriter(System.out, true);
    private static PrintWriter  stdErr = new PrintWriter(System.err, true);

    // GUI References
    private JTextArea jTextArea;
    private JScrollPane jScrollPane;
    private JScrollPane jScrollPlane;
    private JButton open;
    private JButton close;
    private JButton clear;
    private JButton quit;
    private JButton check;
    private Font ArialPlain12Font;
    private Font ArialBold14Font;
    private String[] dictionary= {"run",
                                  "eat",
                                  "house",
                                  "mouse",
                                  "bug",
                                  "rug",
                                  "mug",
                                  "snug",
                                  "seat",
                                  "meet"};
    /**
     * Standard main boiler plate
     * 
     * @param args String array of command line arguments
     * 
     * @throws IOException 
     */
    public static void main(String[] args)  {
        
        JFrame frame = new JFrame("NotePad+-");

	frame.setContentPane(new NotePadPlusMinus());

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setSize(800,600);
                
	frame.setVisible(true);
    }
    
    
    //Build the GUI
    private NotePadPlusMinus() {
        
        // create the widgets
        // General assets
        ArialPlain12Font = new Font("Arial", Font.PLAIN, 12);
        ArialBold14Font = new Font("Arial", Font.BOLD, 14);
        this.setLayout(new BorderLayout());
  
        // Create teh Panel for the buttons 
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 0, 0));
        
        // Create Open Button
        open = new JButton("Open");
        open.setFont(ArialBold14Font);
        open.addActionListener(this);
        open.setActionCommand("open");
        
        // Create Close close Button
        close = new JButton("Close");
        close.setFont(ArialBold14Font);
        close.addActionListener(this);
        close.setActionCommand("close");
        
        // Create Clear close Button
        clear = new JButton("Clear");
        clear.setFont(ArialBold14Font);
        clear.addActionListener(this);
        clear.setActionCommand("clear");
        
        // Create quit button
        quit = new JButton("Quit");
        quit.setFont(ArialBold14Font);
        quit.addActionListener(this);
        quit.setActionCommand("quit");
        
        // Create spell check button
        check = new JButton("Check");
        check.setFont(ArialBold14Font);
        check.addActionListener(this);
        check.setActionCommand("check");
        
        // add all buttons to the Panel
        buttonPanel.add(open);
        buttonPanel.add(clear);
        buttonPanel.add(close);
        buttonPanel.add(check);
        buttonPanel.add(quit);
        
        // Create the Panel for the JTextArea
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new GridLayout(1,1));
        
        // create the testArea and a ScrollPane
        // this part might sound crazy but... you add the Srcoll features to 
        // the Panel and add the JTextField to the viewport of the JScrollPane
        jTextArea = new JTextArea();
        jTextArea.setMargin(new Insets(5,5,5,5));
        jScrollPane = new JScrollPane(textAreaPanel,
                                      ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                                      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        jScrollPane.setViewportView(jTextArea);

        // add the text area to the Panel
        textAreaPanel.add(jScrollPane);
        
    // add the buttons panel and the Scrollable TextArea to the display Panel
        this.add(buttonPanel, BorderLayout.WEST);
        this.add(jScrollPane, BorderLayout.CENTER);
        
    }
 
    private void readTheFile() {
        
        String filspc = "";			// re-useable variable containing the [path and] file name
	BufferedReader  input = null;		// reference to the input file
	
        String accumulatedText = "";
        
	// prompt the user for a path and filename
	stdErr.print("Source filename:  ");
	stdErr.flush();
	
            try {
                filspc = stdIn.readLine();
                
		// open the file for reading else throw a 'FileNotFoundException
		input = new BufferedReader( new FileReader(filspc));
                
                String  line = input.readLine();							
                // repeat until you've read the entire file
                while (line != null)  {
                    accumulatedText += line + "\n";
                    line = input.readLine();
                }
                
                // close input
                input.close();
                
                // add the text to the JTextArea
                jTextArea.setText(accumulatedText);
            }
            catch (FileNotFoundException fnfe) {
		// inform the user of the problem then terminate this application
		stdErr.println("The file " + filspc + " was not found.\n Program terminated.");
		System.exit(1);
            }
            catch (IOException ioe) {
		// inform the user of the problem then terminate this application
		stdErr.println(ioe.toString() + "\n Program terminated.");
		System.exit(1);
		}
    }
    
    
    // students get to design and implment this code
    private void writeTheFile() throws IOException {
        String filspc = "";			// re-useable variable containing the [path and] file name
	PrintWriter output = null;		// reference to the input file

	// prompt the user for a path and filename
	stdErr.print("Destination filename:  ");
	stdErr.flush();
        
        try {
                filspc = stdIn.readLine();
                
		// open the file for reading else throw a 'FileNotFoundException
		output = new PrintWriter( new FileWriter(filspc));

                jTextArea.write(output);
                
                //Close output
                output.close();
        }
                catch (FileNotFoundException fnfe) {
		// inform the user of the problem then terminate this application
		stdErr.println("The file " + filspc + " was not found.\n Program terminated.");
		System.exit(1);
            }
    }
    
    private void spellChecker()
    {
        boolean misspelled;
        String[] words = jTextArea.getText().split("\\s+");
        
        for(String wordInDocument : words)
        {
            misspelled = true;
            for(String wordInDictionary : dictionary)
            {
                if(wordInDocument.equalsIgnoreCase(wordInDictionary))
                {
                    misspelled = false;
                    break;
                }
            }
            if(misspelled)
            {
                System.out.println(wordInDocument);
            }
        }
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String buttonID = e.getActionCommand();
        
        switch(buttonID) {
            
            case "quit":
                System.out.println("Exiting program.");
                System.exit(0);
                break;
            
            case "open":
                readTheFile();
                System.out.println("Open");
                break;
                
            case "close":
        {
            try {
                writeTheFile();
            } catch (IOException ex) {
                Logger.getLogger(NotePadPlusMinus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                System.out.println("Close");
                break;
                
            case "clear":
                jTextArea.setText("");
                System.out.println("Clear");
                break;
                
            case "check":
                spellChecker();
                break;
        }
    }
    
}
