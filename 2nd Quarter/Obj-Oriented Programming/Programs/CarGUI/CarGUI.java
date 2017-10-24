package pti.edu;
// Challenge:
// Make space between Combobox and Label Panel with BoxLayout
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 * Associates a license plate from a ComboBox to one from an array of strings
 * @author Dylan Connor
 */
public class CarGUI extends JPanel implements ActionListener
{
    private ArrayList<Car> vehicles;
    private String[] licensePlates;
    //widgets
    private JComboBox licensePlatesComboBox;
    private JPanel labelPanel;
    private JLabel makeLabel;
    private JLabel modelLabel;
    private JLabel ownerLabel;
    private JLabel licensePlateLabel;
    private Font arialBold14;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("License Plate Finder");
        
        frame.setContentPane(new CarGUI());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.pack();
        
        frame.setVisible(true);
        
    }

    private CarGUI()
    {
        vehicles = new ArrayList<Car>();
        loadCarContainer();
        //this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        licensePlates = new String[vehicles.size()];
        int i = 0;
        for(Car car : vehicles)
        {
            licensePlates[i++] = car.getLicensePlate();
        }
        licensePlatesComboBox = new JComboBox(licensePlates);
        licensePlatesComboBox.addActionListener(this);
        licensePlatesComboBox.setPreferredSize(new Dimension(100,25));
        this.add(licensePlatesComboBox);
        
        this.add(new Box.Filler(new Dimension(0,0),new Dimension(25,25),new Dimension(50,50)));
        
        createLabelPanel();
        this.add(labelPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JComboBox cb = (JComboBox) e.getSource();
        String licensePlate = (String) cb.getSelectedItem();
        
        Car invoker = new Car("","","",licensePlate);
        for(Car car : vehicles)
        {
            if(invoker.equals(car))
            {
            makeLabel.setText("Make: " + car.getMake());
            modelLabel.setText("Model: " + car.getModel());
            ownerLabel.setText("Owner: " + car.getOwner());
            licensePlateLabel.setText("LP: " + car.getLicensePlate());
            break;
            }
        }
    }
    
    private void loadCarContainer()//helper method
    {
        vehicles.add(new Car("Jeep","Ranger","Rambo","WE4P0N5"));
        vehicles.add(new Car("Honda","Civic","Mary Jane","5P1D3R"));
        vehicles.add(new Car("Subaru","Coupe","Jack Black","5TY13R"));
        vehicles.add(new Car("GMC","Pick Up","Albert Einstein","5C13NC3"));
        vehicles.add(new Car("Chevy","Sedan","Tom Jones","R4NG3R"));
        vehicles.add(new Car("Toyota","Motorcycle","Blade","V4MP1R3"));
    }
    
    private void createLabelPanel()
    {   
        labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel,BoxLayout.Y_AXIS));
        
        arialBold14 = new Font("Arial",Font.BOLD,14);
        
        makeLabel = new JLabel("Make: ");
        makeLabel.setPreferredSize(new Dimension(200,20));
        makeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        makeLabel.setFont(arialBold14);
        labelPanel.add(makeLabel);
        
        modelLabel = new JLabel("Model: ");
        modelLabel.setPreferredSize(new Dimension(200,20));
        modelLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        modelLabel.setFont(arialBold14);
        labelPanel.add(modelLabel);
        
        ownerLabel = new JLabel("Owner: ");
        ownerLabel.setPreferredSize(new Dimension(200,20));
        ownerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        ownerLabel.setFont(arialBold14);
        labelPanel.add(ownerLabel);
        
        licensePlateLabel = new JLabel("LP: ");
        licensePlateLabel.setPreferredSize(new Dimension(200,20));
        licensePlateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        licensePlateLabel.setFont(arialBold14);
        labelPanel.add(licensePlateLabel);
    } 
}
