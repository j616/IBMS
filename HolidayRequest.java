import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class HolidayRequest //extends JFrame implements ActionListener
{
  public static void main(String[] args)
  {
    String[] colours = {"b","g","y"};
    JComboBox box = new JComboBox(colours);
    int result;
    do
    {
      String[] choice = {"Enter Your UserName", "Holidays Avaliblity", "Quit"};
      result = JOptionPane.showOptionDialog
	       (null,"Choose an option", "Holiday Request",
		JOptionPane.DEFAULT_OPTION,
		JOptionPane.PLAIN_MESSAGE,
		null, choice, "Enter a word");
      
      switch(result)
      {
      case 0: enterUserName();
	break;
      case 1: HolidaysAvaliblity();
	break;
      }
    }
    while(result != 2);
    System.exit(0);
  }
  
  /*String[] colours = {"b","g","y"};
    JComboBox box = new JComboBox(colours);
    
    public HolidayRequest()
    {
    setTitle("Combom Box");
    setLayout(new FlowLayout());
    add(box);
    box.addActionListener(this);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(250, 250);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
    String item = (String) box.getSelectedItem();
    if(item.equals("b"))
    {
    getContentPane().setBackground(Color.red);
    }
    box.setSelectedIndex(0);
    }*/
  
  
  private static void enterUserName()
  {
    char first, last;
    String word, message;
    word = JOptionPane.showInputDialog(null, "EnterUserID",null,
                                       JOptionPane.PLAIN_MESSAGE);
    if(word != null)
    {
      if(word.length() != 0)
      {
	word = word.toUpperCase();
	first = word.charAt(0);
	last = word.charAt(word.length() -1);
	if(first == last)
	{
	  message = "You entered the Correct ID \n StartDate Request \n EndDate";
	}
	else
	{
	  message = "you did not enter the Correct ID";
	}
	JOptionPane.showMessageDialog(null, message, null, 
				      JOptionPane.INFORMATION_MESSAGE);
      }
      else
      {
	message = "you did not enter the Correct ID!";
	JOptionPane.showMessageDialog(null, message, null, 
				      JOptionPane.ERROR_MESSAGE);
      }      
    }
  }
  private static void HolidaysAvaliblity()
  {
    int answer;
    answer = JOptionPane.showConfirmDialog(null, 
	                                   "are you sure you want to know the avaliblities?", 
	                                   null, 
	                                   JOptionPane.YES_NO_OPTION,
	                                   JOptionPane.QUESTION_MESSAGE);
    if(answer == JOptionPane.YES_OPTION)
    {
      JOptionPane.showMessageDialog(null, 
				    "The Avaliblity Table is listed below");
    }
  }
}