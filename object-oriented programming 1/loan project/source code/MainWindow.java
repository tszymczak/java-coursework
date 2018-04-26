package SzymczakLoanInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main file for the loan information system. This is a GUI tool to allow the user to select different loans and
 * then get information about them, like the monthly payment, interest rate, and fees.
 * @author Thomas Szymczak
 * 4/21/2016
 */
public class MainWindow {
    private JFrame window;
    private JPanel mainPanel;
    private JPanel typePanel;
    private JPanel termPanel;

    private ButtonGroup typeButtons;
    private JRadioButton commercial;
    private JRadioButton home;
    private JRadioButton car;
    
    private JLabel termLabel;
    private ButtonGroup termButtonGroup;
    private JRadioButton[] termButtons;
    private JRadioButton term1;
    private JRadioButton term2;
    private JRadioButton term3;
    
    private JLabel interestLabel;
    private JTextField interestField;
    
    private JLabel amountLabel;
    private JTextField amountField;
    
    private JButton applyButton;
       

    public static void main(String[] args) {
        new MainWindow();
    }
    
    public MainWindow()
    {
        window = new JFrame();
        window.setTitle("Loan Information System");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
        
        buildInterface();
        
        window.add(mainPanel);
        window.pack();
        window.setVisible(true);
    }
    
    /**
     * Set up the GUI.
     */
    private void buildInterface()
    {
        mainPanel = new JPanel();
        // Use the Box Layout here. In the way I'm using it, it's similar to the GridLayout, except it doesn't
        // stretch objects vertically, giving the interface a more natural appearance. BoxLayout.PAGE_AXIS means that
        // we align the elements in one column.
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        
        typePanel = new JPanel();
        // Set the alignment for the typePanel to left alignment. When we do this for all the parts of the window,
        // which causes labels and buttons to appear on the left.
        typePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        typePanel.setBorder(BorderFactory.createTitledBorder("Loan Type"));
        
        typeButtons = new ButtonGroup();
        
        commercial = new JRadioButton("Commercial Loan");
        typeButtons.add(commercial);
        commercial.addActionListener(new RadioButtonListener());
        typePanel.add(commercial);
        
        home = new JRadioButton("Home Loan");
        typeButtons.add(home);
        home.addActionListener(new RadioButtonListener());
        typePanel.add(home);
        
        car = new JRadioButton("Car Loan");
        typeButtons.add(car);
        car.addActionListener(new RadioButtonListener());
        typePanel.add(car);
        
        mainPanel.add(typePanel);
        
        termPanel = new JPanel();
        termPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        termPanel.setBorder(BorderFactory.createTitledBorder("Loan Term"));
        
        termButtonGroup = new ButtonGroup();
        
        termButtons = new JRadioButton[3];
        for (int i = 0; i < termButtons.length; i++ )
        {
            termButtons[i] = new JRadioButton("N/A");
            termButtonGroup.add(termButtons[i]);
            termPanel.add(termButtons[i]);            
        }
        
        mainPanel.add(termPanel);
        
        interestLabel = new JLabel("Interest Rate:");
        interestLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(interestLabel);
        
        interestField = new JTextField(10);
        interestField.setEditable(false);
        interestField.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(interestField);
        
        amountLabel = new JLabel("Loan Amount:");
        amountLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(amountLabel);
        
        amountField = new JTextField(10);
        amountField.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(amountField);
        
        applyButton = new JButton("Apply");
        applyButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        applyButton.addActionListener(new ApplyButtonListener());
        mainPanel.add(applyButton);
    }
    
    // We use this listener to update everything that needs to be updated when the user clicks the loan type radio
    // buttons.
    private class RadioButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // When the user changes the type of loan, changes the options for loan term. Changing the text of the
            // radio buttons feels kludgy, but it works.
            if ( commercial.isSelected() )
            {
                for (int i = 0; i < termButtons.length; i++)
                {
                    termButtons[i].setText(CommercialLoan.TERMS[i] + " years");
                }
            }
            else if ( home.isSelected() )
            {
                for (int i = 0; i < termButtons.length; i++)
                {
                    termButtons[i].setText(HomeLoan.TERMS[i] + " years");
                }
            }
            else if ( car.isSelected() )
            {
                for (int i = 0; i < termButtons.length; i++)
                {
                    termButtons[i].setText(CarLoan.TERMS[i] + " years");
                }
            }
            else
            {
                for (int i = 0; i < termButtons.length; i++)
                {
                    termButtons[i].setText("N/A");
                }
            }
            
            // Clear the radio buttons so the user doesn't accidentally select the wrong term.
            termButtonGroup.clearSelection();
            
            // Display the loan's interest rate:
            if ( commercial.isSelected() )
            {
                interestField.setText(CommercialLoan.INTEREST_RATE + "%");
            }
            else if ( home.isSelected() )
            {
                interestField.setText(HomeLoan.INTEREST_RATE + "%");
            }
            else if ( car.isSelected() )
            {
                interestField.setText(CarLoan.INTEREST_RATE + "%");
            }
            else
            {
                interestField.setText("");
            }
        }
    }
    
    // When the user hits the apply button, display all the information about the loan the selected. If the input is
    // invalid, display a relevant error.
    private class ApplyButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            double amount;
            // Here, term is not the length of the term in years, but which choice of term is selected. Each loan
            // subclass has an array of three ints for the three choices of terms, and this variable is the index
            // of the array that should be used.
            int term = 0;
            Loan loan;
            
            // If the user hasn't selected a loan type, show an error.
            if ( !commercial.isSelected() && !home.isSelected() && !car.isSelected() )
            {
                JOptionPane.showMessageDialog(null, "Please select a loan type.");
                return;
            }
            
            // Figure out which term button is selected.
            boolean found = false;
            for ( int i = 0; i < termButtons.length && !found; i++)
            {
                if ( termButtons[i].isSelected() )
                {
                    term = i;
                    found = true;
                }
            }
            
            // If the user hasn't selected a loan term, show an error.
            if ( !found )
            {
                JOptionPane.showMessageDialog(null, "Please select a term for the loan.");
                return;
            }
            
            // Get the amount of the loan, or show an error if the amount is invalid.
            try
            {
                amount = Double.parseDouble(amountField.getText());
            }
            catch (NumberFormatException exc)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for the amount you wish to borrow.");
                return;
            }
            
            // If the amount of the loan is zero or less, show an error.
            if ( amount <= 0 )
            {
                JOptionPane.showMessageDialog(null, "Please enter a loan amount greater than zero.");
                return;
            }
            
            // Create a new loan object.
            if ( commercial.isSelected() )
            {
                loan = new CommercialLoan(amount, term);
            }
            else if ( home.isSelected() )
            {
                loan = new HomeLoan(amount, term);
            }
            else if ( car.isSelected() )
            {
                loan = new CarLoan(amount, term);
            }
            else
            {
                // The conditional should never get to this stage, but I'm leaving this code in for the sake of
                // defensive programming.
                JOptionPane.showMessageDialog(null, "Please select a loan type.");
                return;
            }
            
            new ResultsWindow(loan);
        }
    }
}