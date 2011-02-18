import java.io.*;
/**
 * This class provides a general-purpose commmand-line interface, for testing
 * code before a GUI has been created. It provides a thin wrapper over 
 * System.out.prin(ln) for output and appropriate stream handling for input.
 *
 * It is designed to encourage input validation. Once an input operation
 * has been performed, every subsequent input/output operation  will print a 
 * warning message unless the caller has printed their own warning via the 
 * outputWarning() method, or has claimed to have validated the previous input
 * via the confirmInputValidated() method. It may actually be easier to 
 * produce a suitable GUI (with e.g. drop down lists) than to do validation
 * on every input using this interface.
 * 
 * By default, inputting the string ":q!" terminates the program. This
 * termination string can be changed by the setTerminationString() method.
 * 
 * All methods are static - this class is cannot be instantiated.
 * Hence all calls should be of the form CLI.<methodname><parameters>
 * 
 * @author John Sargeant
 * Based on an idea by Tierry Scheurer
 */
public class CLI {
  
  // The gatekeeper.
  private static boolean _validated = true;
  
  // A stream pipeline which will allow us to take in lines of input.
  private static BufferedReader input = new BufferedReader(
							   new InputStreamReader(System.in));
  
  /**
   * The default termination string. Inputting this will terminate the program
   */
  private static String _terminationString = ":q!";
  
  // Prevent instantiated.
  private CLI() {}
  
  /**
   * Utility method to check validation and issue a warning if necessary
   */
  private static void checkValidation() {
    if (!_validated) outputWarning("Previous input not validated");
  }
  
  /**
   * Utility method to check if the termination string has been input
   * and exit cleanly if it has
   */
  private static void checkTermination(String input) {
    if (input.equals(_terminationString)) System.exit(0);
  }
  
  /**
   * Confirm that the previous input has been validated
   */
  public static void confirmInputValidated() { _validated = true; }
  
  /**
   * Output a warning. The output is of the form "WARNING: " followed by
   * the warning text and a newline. Once this method has been called, the 
   * input is assumed to be validated until the next input operation occurs, 
   * to avoid multiple warnings
   */
  public static void outputWarning(String warningText) {
    System.out.println("Warning: " + warningText);
    _validated = true;
  }
  
  /**
   * Output a string, followed by a newline
   */
  public static void output(String text) {
    checkValidation();
    System.out.println(text);
  }
  
  /**
   * Output an array of strings, each on a separate line
   */
  public static void output(String[] text) {
    checkValidation();
    for (String s: text) System.out.println(s);
  }
  
  /**
   * Output a string without a newline, intended for issuing prompts
   */
  public static void outputPrompt(String text) {
    checkValidation();
    System.out.print(text);
  }
  
  /**
   * Get the current termination string. By default this is the string ":q!"
   */
  public static String getTerminationString() {
    return _terminationString;
  }
  
  /**
   * Set the current termination string
   */
  public static void setTerminationStrng(String newTerminationString) {
    _terminationString = newTerminationString;
  }
  
  /**
   * Input a line of text
   */
  public static String input() {
    String result = "";
    try {
      result = input.readLine();
    }
    catch (IOException e) {
      // Shouldn't happen since we are using System.in!
      System.out.println("Problem with System.in or bug in this code!");
      System.exit(1);
    }
    _validated = false;
    return result;
  }
  
  /**
   * Test program. Requires the user to input the string "forty two" and the
   * number 42. There is a deliberate bug - if the user provides a string
   * which is not a number in the second case, this is not checked.
   */
  public static void main(String[] args) {
    boolean done = false;
    while (!done) {
      output("What is the answer to life, the universe and everything?");
      String answer1 = input();
      checkTermination(answer1);
      if (answer1.equals("forty two")) {
	done = true;
	confirmInputValidated();
	output("Correct, well done");
      }
      else outputWarning("No that's not the answer");
    }
    done = false;
    while (!done) {
      outputPrompt("And as digits? ");
      String answer2 = input();
      checkTermination(answer2);
      try {
        int finalAnswer = Integer.parseInt(answer2);
        if (finalAnswer == 42) {
	  done = true;
	  confirmInputValidated();
	  output("Correct, well done");
        }
        else outputWarning("No that's not the answer");
      }
      catch(NumberFormatException e) {
	// Naughty - do nothing
      }
    }
    output("So long, and thanks for all the fish");
    
  } // main
  
}
