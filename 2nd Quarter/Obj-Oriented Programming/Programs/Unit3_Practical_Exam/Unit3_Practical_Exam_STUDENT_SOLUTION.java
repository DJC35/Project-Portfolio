package unit3_practical_exam_student_solution;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 * Clothing store GUI for buying clothes using JLabels and ImageIcons
 * including a MenuBar with two menus and items.
 * @author Dylan Connor
 */
public class Unit3_Practical_Exam_STUDENT_SOLUTION extends JPanel implements ActionListener{
    private JMenuBar mainMenuBar;
    
    private JMenu fileMenu;
    private JMenu helpMenu;
    
    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;
    
    private JLabel clothingItemLabel;
    private JLabel pricingLabel;
    private JLabel imageLabel;
    
    private JComboBox selectionBox;
    
    private ImageIcon clothingStoreImage = new ImageIcon("Images/clothingstoreimage.png");
    private ImageIcon shoesImage = new ImageIcon("Images/shoes.png");
    private ImageIcon hatsImage = new ImageIcon("Images/hats.png");
    private ImageIcon pantsImage = new ImageIcon("Images/pants.png");
    
    private final double shoesPrice = 19.99;
    private final double hatsPrice = 10.99;
    private final double pantsPrice = 34.99;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Unit3_Practical_Exam_STUDENT_SOLUTION exam
                = new Unit3_Practical_Exam_STUDENT_SOLUTION();
        
        JFrame frame = new JFrame("Clothing Store");
        
        frame.setSize(400,400);
       
        frame.setContentPane(exam);
        frame.setJMenuBar(exam.buildMenu());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
    private JMenuBar buildMenu(){
        mainMenuBar = new JMenuBar();
        
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setActionCommand("about");
        aboutMenuItem.addActionListener(this);
        
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic('X');
        exitMenuItem.setActionCommand("exit");
        exitMenuItem.addActionListener(this);
        
        fileMenu.add(exitMenuItem);
        helpMenu.add(aboutMenuItem);
        
        mainMenuBar.add(fileMenu);
        mainMenuBar.add(helpMenu);
        
        return mainMenuBar;
    }
    private Unit3_Practical_Exam_STUDENT_SOLUTION(){
        //Set layout of main panel
        this.setLayout(new BorderLayout());
        
        //Create Labels
        clothingItemLabel = new JLabel("Clothing Item: ");
        pricingLabel = new JLabel();
        imageLabel = new JLabel(clothingStoreImage);
        
        //Populate JComboBox with items
        String[] selections = {"Select an option","Shoes","Hats","Pants"};
        selectionBox = new JComboBox(selections);
        selectionBox.addActionListener(this);
        
        //Add all items to Panel
        this.add(clothingItemLabel,BorderLayout.WEST);
        this.add(selectionBox,BorderLayout.NORTH);
        this.add(pricingLabel,BorderLayout.EAST);
        this.add(imageLabel,BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == exitMenuItem){
            System.exit(0);
        }
        if(source == aboutMenuItem){
            JOptionPane.showMessageDialog(null, "Author: Dylan Connor\n"
                                              + "Date Created: 4/5/2016\n"
                                              + "Version: 1.0");
        }
        if(source == selectionBox){
            JComboBox cb = (JComboBox) source;
            String option = (String) cb.getSelectedItem();
            if(option.equalsIgnoreCase("Shoes")){
                pricingLabel.setText("Shoes: $" + shoesPrice);
                imageLabel.setIcon(shoesImage);
            }
            if(option.equalsIgnoreCase("Hats")){
                pricingLabel.setText("Hats: $" + hatsPrice);
                imageLabel.setIcon(hatsImage);
            }
            if(option.equalsIgnoreCase("Pants")){
                pricingLabel.setText("Pants: $" + pantsPrice);
                imageLabel.setIcon(pantsImage);
            }
            if(option.equalsIgnoreCase("Select an option")){
                pricingLabel.setText("");
                imageLabel.setIcon(clothingStoreImage);
            }
        }
    }
}