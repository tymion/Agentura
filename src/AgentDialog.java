import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.beans.*; //property change stuff
import java.awt.*;
import java.awt.event.*;
 
/* 1.4 example used by DialogDemo.java. */
class AgentDialog extends JDialog
                   implements ActionListener,
                              PropertyChangeListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = -767166383369109519L;
	private String typedText = null;
    private JTextField agentNameTextField;
 
    private JOptionPane optionPane;
 
    private String okButtonText = "OK";
    private String cancelButtonText = "Cancel";

    public String getValidatedText() {
        return typedText;
    }
 
    /** Creates the reusable dialog. */
    public AgentDialog(Frame aFrame, String aWord) {
        super(aFrame, true);
        setTitle("Log in");
 
        agentNameTextField = new JTextField(10);
 
        String dialogText = "Podaj proszę imię i nazwisko agenta:";
        Object[] array = {dialogText, agentNameTextField};
        Object[] options = {okButtonText, cancelButtonText};
 
        optionPane = new JOptionPane(array,
                                    JOptionPane.QUESTION_MESSAGE,
                                    JOptionPane.YES_NO_OPTION,
                                    null,
                                    options,
                                    options[0]);
 
        setContentPane(optionPane);
 
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                /*
                 * Instead of directly closing the window,
                 * we're going to change the JOptionPane's
                 * value property.
                 */
                    optionPane.setValue(new Integer(
                                        JOptionPane.CLOSED_OPTION));
            }
        });
 
        //Ensure the text field always gets the first focus.
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent ce) {
            	agentNameTextField.requestFocusInWindow();
            }
        });
 
        agentNameTextField.addActionListener(this);
        optionPane.addPropertyChangeListener(this);
    }
 
    /** This method handles events for the text field. */
    public void actionPerformed(ActionEvent e) {
    	System.out.println("actionPerformed 2");
        optionPane.setValue(okButtonText);
    }
 
    /** This method reacts to state changes in the option pane. */
    public void propertyChange(PropertyChangeEvent e) {
    	System.out.println("propertyChange");
        String prop = e.getPropertyName();
    	System.out.println(prop);
        if (isVisible()
         && (e.getSource() == optionPane)
         && (JOptionPane.VALUE_PROPERTY.equals(prop) ||
             JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
            Object value = optionPane.getValue();
 
            if (value == JOptionPane.UNINITIALIZED_VALUE) {
                //ignore reset
                return;
            }
 
            //Reset the JOptionPane's value.
            //If you don't do this, then if the user
            //presses the same button next time, no
            //property change event will be fired.
            optionPane.setValue(
                    JOptionPane.UNINITIALIZED_VALUE);
 
            if (okButtonText.equals(value)) {
                typedText = agentNameTextField.getText();
                CharSequence space = " ";
                if (typedText.contains(space)) {
                    clearAndHide();
                } else {
                    //text was invalid
                	agentNameTextField.selectAll();
                    JOptionPane.showMessageDialog(
                    		AgentDialog.this,
                                    "Sorry, \"" + typedText + "\" "
                                    + "isn't a valid response.\n"
                                    + "Please enter ",
                                    "Try again",
                                    JOptionPane.ERROR_MESSAGE);
                    typedText = null;
                    agentNameTextField.requestFocusInWindow();
                }
            } else {
                typedText = null;
                clearAndHide();
            }
        }
    }
 
    /** This method clears the dialog and hides it. */
    public void clearAndHide() {
    	agentNameTextField.setText(null);
        setVisible(false);
    }
}