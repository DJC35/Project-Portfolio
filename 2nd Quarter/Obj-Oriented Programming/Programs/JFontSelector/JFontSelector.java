/*
  Create a JFrame that holds 5 buttons with the names of 5 different fonts.
  Include a sixth button to change font size.
  Display a JLabel using the Font style and size the user selects.
  Save as JFontSelector.java
*/
package jfontselector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Dylan Connor
 */
public class JFontSelector extends JPanel implements ActionListener{
    private Font arialFont;
    private Font comicSansMSFont;
    private Font verdanaFont;
    private Font timesNewRomanFont;
    private Font handwrittenFont;
    
    private JLabel displayLabel;
    
    private JButton[] fontButtons;
    private JButton sizeButton;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        JFrame frame = new JFrame("JFontSelector");
        //Set size and resizable
        frame.setSize(200,300);
        
        //set frame content to panel
        frame.setContentPane(new JFontSelector());
        
        //Close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Show frame
        frame.setVisible(true);
    }

    public JFontSelector()
    {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        //Create Widgets
        fontButtons = new JButton[5];
        arialFont = new Font("Arial",Font.PLAIN,12);
        comicSansMSFont = new Font("ComicSansMS",Font.PLAIN,12);
        verdanaFont = new Font("Verdana",Font.PLAIN,12);
        timesNewRomanFont = new Font("TimesNewRoman",Font.PLAIN,12);
        handwrittenFont = new Font("Handwritten",Font.PLAIN,12);
        
        displayLabel = new JLabel();
        
        sizeButton = new JButton();
        sizeButton.addActionListener(this);
        
        for(int i = 0;i < fontButtons.length;++i)
        {
            fontButtons[i] = new JButton();
            fontButtons[i].setActionCommand(i + "");
            fontButtons[i].addActionListener(this);
            this.add(fontButtons[i]);
        }
        
        fontButtons[0].setText("Arial");
        fontButtons[1].setText("ComicSansMS");
        fontButtons[2].setText("Verdana");
        fontButtons[3].setText("TimesNewRoman");
        fontButtons[4].setText("Handwritten");
        
        sizeButton.setText("12");
        
        displayLabel.setText("This is a JLabel, it shows you stuff.");
        
        this.add(sizeButton);
        this.add(displayLabel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();
    }
    
}
