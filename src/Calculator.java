
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class Calculator extends JFrame implements ActionListener{
	
	
	JTextField number_field = new JTextField("0");
	String number_string = "";
	double number;
	char jbutton[] = {'7','8','9','/','4','5','6','*','1','2','3','-','0','.','=','+'};// Add buttons to the panel
	JButton button[] = new JButton[16];
	char operator;
	boolean point;
  
	public Calculator() {
		
		// Create panel p1 for the buttons and set GridLayout
		JPanel p1 = new JPanel();
		Container c=getContentPane();
        c.setLayout(new BorderLayout());
		p1.setLayout(new GridLayout(4,4));
		
		number_field.setHorizontalAlignment(JTextField.RIGHT);
		
		for(int i=0;i<16;i++){// Add buttons to the panel
            button[i]=new JButton(jbutton[i]+"");
            p1.add(button[i]);
            button[i].addActionListener(this);
        }
        c.add("North",number_field);//Define the location to the string
        c.add("Center",p1);//Define the location to the button

    
  }
    public void actionPerformed(ActionEvent event)
    {   
    	//Declare the action
    	//Declare button 0~9 and calculation
        if(((JButton)event.getSource()).getText().charAt(0)=='.'){
            if(!point){
                if(number_string.equals(""))
                    number_string="0";
                    
                number_string+=".";
                number_field.setText(number_string);
                point=true; 
           }
        }else if(((JButton)event.getSource()).getText().charAt(0)<='9'&&
                 ((JButton)event.getSource()).getText().charAt(0)>='0'){
            number_string+=((JButton)event.getSource()).getText().charAt(0)+"";
            number_field.setText(number_string);
        }else{
            point=false;
            number_string="";
            number_field.setText(operation(number,
                    Double.parseDouble(number_field.getText()),operator)+"");
            operator=((JButton)event.getSource()).getActionCommand().charAt(0);
            
            if(((JButton)event.getSource()).getText().charAt(0)!='=')                  
                number=Double.parseDouble(number_field.getText());               
        }         
    }
   
    public double operation(double number1,double number2,char operator)
    {      
    	//Declare button +, -, *, and / 
        switch(operator)
        {        
            case '+':
                return number1+number2;
            case '-':
                return number1-number2;
            case '*':
                return number1*number2;
            case '/':
                return number1/number2;
            default:
                return number2; 
        }
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
