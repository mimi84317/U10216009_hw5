
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class Calculator extends JFrame implements ActionListener{
	
	JTextField number_field = new JTextField("0");
	String number_string = "";
	double number;
	char jbutton[] = {'7','8','9','/','4','5','6','*','1','2','3','-','0','.','=','+'};
	JButton button[] = new JButton[16];
	char operator;
	boolean point;
  
	public Calculator() {
		
		JPanel p1 = new JPanel();
		Container c=getContentPane();
        c.setLayout(new BorderLayout());
		p1.setLayout(new GridLayout(4,4));
		
		number_field.setHorizontalAlignment(JTextField.RIGHT);
		
		for(int i=0;i<16;i++){
            button[i]=new JButton(jbutton[i]+"");
            p1.add(button[i]);
            button[i].addActionListener(this);
        }
        c.add("North",number_field);
        c.add("Center",p1);

    
  }
    public void actionPerformed(ActionEvent event)
    {   

    }
       

  /** Main method */
  public static void main(String[] args) {
    Calculator frame = new Calculator();
    frame.setTitle("Calculator");
    frame.setSize(400, 250);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
