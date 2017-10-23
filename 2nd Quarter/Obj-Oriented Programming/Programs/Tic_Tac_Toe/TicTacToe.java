package tictactoe;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * TicTacToe game in JFrames with buttons
 * @author Dylan Connor
 */
public class TicTacToe extends JPanel implements ActionListener {
    private JButton[] buttons = new JButton[9];    
    private Font arialBold48;
    private boolean player = true;
    
    private JMenuBar mainMenuBar;
    private JMenu gameMenu;
    private JMenu aboutMenu;
    
    private JMenuItem replay;
    private JMenuItem quit;
    private JMenuItem helpDialog;
    private JMenuItem aboutDialog;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        TicTacToe ticTacToe = new TicTacToe();
        //Create frame
        JFrame frame = new JFrame("Swing Tic Tac Toe");
        
        //Set size and resizable
        frame.setSize(250,275);
        frame.setResizable(false);
        
        //set frame content to panel
        frame.setContentPane(ticTacToe);
        frame.setJMenuBar(ticTacToe.buildMenu());
        
        //Close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Show frame
        frame.setVisible(true);
    }
    /**
     * Creates a JPanel containing every button
     */
    public TicTacToe(){
        //define Widgets 
        arialBold48 = new Font ("Arial", Font.BOLD, 48);
        
        //set panel layout
        GridLayout layout = new GridLayout(3,3);
        this.setLayout(layout);
        
        // Create button array and add to panel
        for(int i = 0; i < buttons.length;++i){
            buttons[i]=new JButton();
            buttons[i].setActionCommand(i + "");
            buttons[i].addActionListener(this);
            buttons[i].setFont(arialBold48);
            this.add(buttons[i]);
        }
    } 
    /**
     * Build the MenuBar and its menus
     */
    private JMenuBar buildMenu(){
        //Create menubar
        mainMenuBar = new JMenuBar();
        
        //create top level menus 'game' and 'about'
        gameMenu = new JMenu("Game");
        aboutMenu = new JMenu("About");
        
        //Shortcuts
        gameMenu.setMnemonic('G');
        aboutMenu.setMnemonic('A');
        
        //Create menu items
        quit = new JMenuItem("Quit");
        quit.setMnemonic('Q');
        replay = new JMenuItem("Replay");
        
        aboutDialog = new JMenuItem("About");
        helpDialog = new JMenuItem("Help");
        
        //Build the menus
        gameMenu.add(replay);
        gameMenu.addSeparator();
        gameMenu.add(quit);
        
        aboutMenu.add(helpDialog);
        aboutMenu.addSeparator();
        aboutMenu.add(aboutDialog);
        
        //Add menus to menu bar
        mainMenuBar.add(gameMenu);
        mainMenuBar.add(aboutMenu);
        
        //Add actionListeners
        quit.addActionListener(this);
        helpDialog.addActionListener(this);
        aboutDialog.addActionListener(this);
        replay.addActionListener(this);

        return mainMenuBar;
    }
   
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == buttons[0]){
            if(player == true){
                buttons[0].setBackground(Color.yellow);
                buttons[0].setText("O");
                player = false;//Switch players
                }
                else if(player == false){
                buttons[0].setBackground(Color.green);
                buttons[0].setText("X");
                player = true;
                }
                buttons[0].setEnabled(false);
        }
        if(source == buttons[1]){
            if(player == true){
                buttons[1].setBackground(Color.yellow);
                buttons[1].setText("O");
                player = false;
                }
                else if(player == false){
                buttons[1].setBackground(Color.green);
                buttons[1].setText("X");
                player = true;
                }
                buttons[1].setEnabled(false);
        }
        if(source == buttons[2]){
            if(player == true){
                buttons[2].setBackground(Color.yellow);
                buttons[2].setText("O");
                player = false;
                }
                else if(player == false){   
                buttons[2].setBackground(Color.green);
                buttons[2].setText("X");
                player = true;
                }
                buttons[2].setEnabled(false);
        }
        if(source == buttons[3]){
            if(player == true){
                buttons[3].setBackground(Color.yellow);
                buttons[3].setText("O");
                player = false;
                }
                else if(player == false){
                buttons[3].setBackground(Color.green);
                buttons[3].setText("X");
                player = true;
                }
                buttons[3].setEnabled(false);
        }
        if(source == buttons[4]){
            if(player == true){
                buttons[4].setBackground(Color.yellow);
                buttons[4].setText("O");
                player = false;
                }
                else if(player == false){
                buttons[4].setBackground(Color.green);
                buttons[4].setText("X");
                player = true;
                }
                buttons[4].setEnabled(false);
        }
        if(source == buttons[5]){
            if(player == true){
                buttons[5].setBackground(Color.yellow);
                buttons[5].setText("O");
                player = false;
                }
                else if(player == false){
                buttons[5].setBackground(Color.green);
                buttons[5].setText("X"); 
                player = true;
                }
                buttons[5].setEnabled(false);
        }
        if(source == buttons[6]){
            if(player == true){
                buttons[6].setBackground(Color.yellow);
                buttons[6].setText("O");
                player = false;
                }
                else if(player == false){
                buttons[6].setBackground(Color.green);
                buttons[6].setText("X");
                player = true;
                }
                buttons[6].setEnabled(false);
        }     
        if(source == buttons[7]){
             if(player == true){
                buttons[7].setBackground(Color.yellow);
                buttons[7].setText("O");
                player = false;
                }
                else if(player == false){
                buttons[7].setBackground(Color.green);
                buttons[7].setText("X");
                player = true;
                }
                buttons[7].setEnabled(false);
        }       
        if(source == buttons[8]){
            if(player == true){
                buttons[8].setBackground(Color.yellow);
                buttons[8].setText("O");
                player = false;
                }
                else if(player == false){
                buttons[8].setBackground(Color.green);
                buttons[8].setText("X");
                player = true;
                }
                buttons[8].setEnabled(false);
        }
        if(source == replay){
            for(int i =0;i < buttons.length;++i){
            buttons[i].setBackground(null);
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }  
        player = true;
        }
        if(source == quit){
            System.exit(0);
        }
        if (source == helpDialog){
            JOptionPane.showMessageDialog(null,"Help:\n"
                    + "First player: Os\n"
                    + "Second player: Xs\n"
                    + "Three in a row wins the game.");
        }
        if (source == aboutDialog){
            JOptionPane.showMessageDialog(null,"Author: Dylan Connor\n"
                        + "Version 1.5");
        }
        //Horizontal Victory
        if((buttons[0].getText().equals("O")//1
        && buttons[1].getText().equals("O")
        && buttons[2].getText().equals("O"))
        ||(buttons[0].getText().equals("X")
        && buttons[1].getText().equals("X")
        && buttons[2].getText().equals("X"))){
            buttons[3].setBackground(Color.gray);//Set all other buttons to gray
            buttons[3].setText("");//Set all other buttons' text to null            
            buttons[4].setBackground(Color.gray);
            buttons[4].setText("");            
            buttons[5].setBackground(Color.gray);
            buttons[5].setText("");            
            buttons[6].setBackground(Color.gray);
            buttons[6].setText("");           
            buttons[7].setBackground(Color.gray);
            buttons[7].setText("");            
            buttons[8].setBackground(Color.gray);
            buttons[8].setText("");
            for(int i = 0;i<buttons.length;++i)
            {
                buttons[i].setEnabled(false);
            }
        }
        else if((buttons[3].getText().equals("O")//2
        && buttons[4].getText().equals("O")
        && buttons[5].getText().equals("O"))
        ||(buttons[3].getText().equals("X")
        && buttons[4].getText().equals("X")
        && buttons[5].getText().equals("X"))){
            buttons[0].setBackground(Color.gray);
            buttons[0].setText("");            
            buttons[1].setBackground(Color.gray);
            buttons[1].setText("");            
            buttons[2].setBackground(Color.gray);
            buttons[2].setText("");           
            buttons[6].setBackground(Color.gray);
            buttons[6].setText("");            
            buttons[7].setBackground(Color.gray);
            buttons[7].setText("");            
            buttons[8].setBackground(Color.gray);
            buttons[8].setText("");
            for(int i = 0;i<buttons.length;++i)
            {
                buttons[i].setEnabled(false);
            }
        }
        else if((buttons[6].getText().equals("O")//3
        && buttons[7].getText().equals("O")
        && buttons[8].getText().equals("O"))
        ||(buttons[6].getText().equals("X")
        && buttons[7].getText().equals("X")
        && buttons[8].getText().equals("X"))){
            buttons[1].setBackground(Color.gray);
            buttons[1].setText("");            
            buttons[2].setBackground(Color.gray);
            buttons[2].setText("");           
            buttons[3].setBackground(Color.gray);
            buttons[3].setText("");           
            buttons[4].setBackground(Color.gray);
            buttons[4].setText("");            
            buttons[5].setBackground(Color.gray);
            buttons[5].setText("");            
            buttons[0].setBackground(Color.gray);
            buttons[0].setText("");
            for(int i = 0;i<buttons.length;++i)
            {
                buttons[i].setEnabled(false);
            }
        }
        //Vertical Victory
        if((buttons[0].getText().equals("O")//1
        && buttons[3].getText().equals("O")
        && buttons[6].getText().equals("O"))
        ||(buttons[0].getText().equals("X")
        && buttons[3].getText().equals("X")
        && buttons[6].getText().equals("X"))){
            buttons[1].setBackground(Color.gray);
            buttons[1].setText("");          
            buttons[2].setBackground(Color.gray);
            buttons[2].setText("");          
            buttons[4].setBackground(Color.gray);
            buttons[4].setText("");           
            buttons[5].setBackground(Color.gray);
            buttons[5].setText("");           
            buttons[7].setBackground(Color.gray);
            buttons[7].setText("");           
            buttons[8].setBackground(Color.gray);
            buttons[8].setText("");
            for(int i = 0;i<buttons.length;++i)
            {
                buttons[i].setEnabled(false);
            }
        }
        else if((buttons[1].getText().equals("O")//2
        && buttons[4].getText().equals("O")
        && buttons[7].getText().equals("O"))
        ||(buttons[1].getText().equals("X")
        && buttons[4].getText().equals("X")
        && buttons[7].getText().equals("X"))){
            buttons[0].setBackground(Color.gray);
            buttons[0].setText("");          
            buttons[2].setBackground(Color.gray);
            buttons[2].setText("");           
            buttons[5].setBackground(Color.gray);
            buttons[5].setText("");           
            buttons[6].setBackground(Color.gray);
            buttons[6].setText("");            
            buttons[3].setBackground(Color.gray);
            buttons[3].setText("");            
            buttons[8].setBackground(Color.gray);
            buttons[8].setText("");    
            for(int i = 0;i<buttons.length;++i)
            {
                buttons[i].setEnabled(false);
            }
        }
        else if((buttons[2].getText().equals("O")//3
        && buttons[5].getText().equals("O")
        && buttons[8].getText().equals("O"))
        ||(buttons[2].getText().equals("X")
        && buttons[5].getText().equals("X")
        && buttons[8].getText().equals("X"))){
            buttons[3].setBackground(Color.gray);
            buttons[3].setText("");            
            buttons[4].setBackground(Color.gray);
            buttons[4].setText("");            
            buttons[6].setBackground(Color.gray);
            buttons[6].setText("");            
            buttons[7].setBackground(Color.gray);
            buttons[7].setText("");            
            buttons[0].setBackground(Color.gray);
            buttons[0].setText("");            
            buttons[1].setBackground(Color.gray);
            buttons[1].setText("");
            for(int i = 0;i<buttons.length;++i)
            {
                buttons[i].setEnabled(false);
            }
        }
        //Diagonal Victory
        if((buttons[0].getText().equals("O")//1
        && buttons[4].getText().equals("O")
        && buttons[8].getText().equals("O"))
        ||(buttons[0].getText().equals("X")
        && buttons[4].getText().equals("X")
        && buttons[8].getText().equals("X"))){
            buttons[1].setBackground(Color.gray);
            buttons[1].setText("");           
            buttons[2].setBackground(Color.gray);
            buttons[2].setText("");
            buttons[3].setBackground(Color.gray);
            buttons[3].setText("");
            buttons[5].setBackground(Color.gray);
            buttons[5].setText("");
            buttons[6].setBackground(Color.gray);
            buttons[6].setText("");
            buttons[7].setBackground(Color.gray);
            buttons[7].setText("");
            for(int i = 0;i<buttons.length;++i)
            {
                buttons[i].setEnabled(false);
            }
        }
        else if((buttons[2].getText().equals("O")//2
        && buttons[4].getText().equals("O")
        && buttons[6].getText().equals("O"))
        ||(buttons[2].getText().equals("X")
        && buttons[4].getText().equals("X")
        && buttons[6].getText().equals("X"))){
            buttons[1].setBackground(Color.gray);
            buttons[1].setText("");
            buttons[0].setBackground(Color.gray);
            buttons[0].setText("");
            buttons[3].setBackground(Color.gray);
            buttons[3].setText("");
            buttons[5].setBackground(Color.gray);
            buttons[5].setText("");
            buttons[8].setBackground(Color.gray);
            buttons[8].setText("");
            buttons[7].setBackground(Color.gray);
            buttons[7].setText("");
            for(int i = 0;i<buttons.length;++i)
            {
                buttons[i].setEnabled(false);
            }
        }
    }
}
