package unit3practical;
import javax.swing.*;
import java.awt.event.*;
/**
 *  A Dice game using a random number generator,
 * two ImageIcons, two JLabels, and a JButton.
 * @author Dylan Connor
 */
public class Unit3Practical extends JPanel implements ActionListener{
    private JLabel diceOneLabel;
    private JLabel diceTwoLabel;
    
    private JButton rollDiceButton;
    
    private ImageIcon diceOneIcon;
    private ImageIcon diceTwoIcon;
    
    private int random1; 
    private int random2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        JFrame frame = new JFrame("Dice Game");
        
        frame.setSize(300,210);
        frame.setResizable(false);
        
        frame.setContentPane(new Unit3Practical());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
    private Unit3Practical(){
        //Create Widgets
        diceOneIcon = new ImageIcon("dice1.gif");
        diceTwoIcon = new ImageIcon("dice1.gif");
        
        diceOneLabel = new JLabel();
        diceTwoLabel = new JLabel();
        
        diceOneLabel.setIcon(diceOneIcon);
        diceTwoLabel.setIcon(diceTwoIcon);
        
        rollDiceButton = new JButton("Roll Dice!");
        rollDiceButton.addActionListener(this);
        
        //Add widgets
        this.add(diceOneLabel);
        this.add(diceTwoLabel);
        this.add(rollDiceButton);
    }
    /**
     * Controls actions made through Swing Components such as 
     * JButtons and MenuItems using given parameter:
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == rollDiceButton){
            random1 = (int)(1+(Math.random()*6));
            random2 = (int)(1+(Math.random()*6));
            
            diceOneLabel.setIcon(new ImageIcon("dice"+random1+".gif"));
            diceTwoLabel.setIcon(new ImageIcon("dice"+random2+".gif"));
        }
    }
}
