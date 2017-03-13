import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;


/**
 * builds a GUI that implements the Fraction class
 * 
 * @author Juan Valenzuela
 * @version 05.15.2016
 */
public class GuiFraction
{
	private HashMap<String, JTextField> textboxes; //Hashmap that holds the textboxes (input/output)
	private JFrame frame;
	private static final int height = 200;
	private static final int width = 400;

	public static void main(String[] args)
	{
		GuiFraction app = new GuiFraction();
	}
	
	public GuiFraction()
	{
		textboxes = new HashMap<>(); //creates HashMap to hold/organize text boxes
		
		buildFrame();
	}
	
	/**
	 * builds the GUI frame
	 */
	public void buildFrame()
	{	
		frame = new JFrame("Fraction Evaluator");
		
		buildContentPane(); //builds the content pane and add nested panes (input/output panes)
		
		//frame.pack();
		frame.setSize(width, height); //fixes the size of the window upon execution
		frame.setVisible(true);       //makes the window visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminates the program when 'X' is clicked
	}
	
	/**
	 * builds the content pane and add nested panes (input/output panes)
	 */
	public void buildContentPane()
	{
		Container contentPane = frame.getContentPane();
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		contentPane.add(makeInputArea()); //sets the layout for the input fractions' text boxes
		contentPane.add(makeOutputArea()); //sets the layout for the output fractions' text boxes and labels
		contentPane.add(makeCalcButton()); //creates/adds a calculate button 
		
	}
	
	/**
	 * sets the layout for the input fractions text boxes
	 */
	public Container makeInputArea()
	{
		Container inputPane = new Container();
		
		inputPane.setLayout(new FlowLayout());
		
		addInputField(inputPane, "fraction1"); //adds an editable text field for the user to input fractions
		addOutputField(inputPane, "comparison"); //adds an uneditable text field for the output under the HashMap key Comparison
		addInputField(inputPane, "fraction2");
		
		return(inputPane);
	}
	
	/**
	 * creates the output area of the frame using a grid layout
	 */
	public Container makeOutputArea()
	{
		Container calculationPane = new Container();
		calculationPane.setLayout(new GridLayout(4,2)); //4 rows, 2 columns
		
		createOutputLabels(calculationPane); //creates/add text that labels output text boxes

		return calculationPane;
	}
	
	/**
	 * creates a calculate button
	 * @return
	 */
	private Component makeCalcButton()
	{
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new CalculateActionListener());
		return calculate;
	}
	
	/**
	 * adds an editable text field for the user to input fractions
	 * 
	 * @param pane : Container that the filed will be put into
	 * @param fieldName : the key that the text box will put with in the HashMap (Corresponds to kind of calculation output)
	 * @return
	 */
	public Container addInputField(Container pane, String fieldName)
	{
		JTextField inputText = new JTextField(10);
		pane.add(inputText);
		
		textboxes.put(fieldName, inputText); //adds the textfield to the HashMap under the key (fieldName) which correspond to the kind of calculation
		
		return pane;
	}
	
	/**
	 * adds an uneditiable text field that will show the output of the calculation
	 * 
	 * @param pane : Container that the filed will be put into
	 * @return
	 */
	public Container addOutputField(Container pane, String fieldName)
	{
		JTextField outputText = new JTextField(2);
		pane.add(outputText);
		
		textboxes.put(fieldName, outputText); //adds the textfield to the HashMap under the key (fieldName) which correspond to the kind of calculation
		
		outputText.setEditable(false);
		
		return pane;
	}	
	
	/**
	 * creates the labels for the output fields, 
	 * adds uneditable text boxes for the output
	 * and adds it to the Grid Layout Pane
	 * 
	 * @param pane : Container that the filed will be put into
	 * @return
	 */
	private Container createOutputLabels(Container pane)
	{	
		JLabel sumLabel = new JLabel("sum");
		pane.add(sumLabel); //adds the textbox to the pane
		addOutputField(pane, "sum"); //adds an uneditable text field for the user to input fractions and adds it to the HashMao under the key "sum"
		
		JLabel diffLabel = new JLabel("Difference");
		pane.add(diffLabel);
		addOutputField(pane, "difference");
		
		JLabel prodLabel = new JLabel("Product");
		pane.add(prodLabel);
		addOutputField(pane, "product");
		
		JLabel divLabel = new JLabel("Division");
		pane.add(divLabel);
		addOutputField(pane, "division");
		
		return pane;
	}
	
	//****************here is where the program performs actions**************************
	
	/**
	 * tells the program what to do when the calculate button is clicked
	 * 
	 * @author Juan Valenzuela 
	 *
	 */
	class CalculateActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				Fraction fraction1 = new Fraction(getFraction("fraction1")); //creates an object of type Fraction
				Fraction fraction2 = new Fraction(getFraction("fraction2"));
				
				printResult(fraction1, fraction2, compare(fraction1, fraction2), "comparison");
				printResult(fraction1, fraction2, fraction1.add(fraction2).toString(), "sum");
				printResult(fraction1, fraction2, fraction1.sub(fraction2).toString(), "difference");
				printResult(fraction1, fraction2, fraction1.mult(fraction2).toString(), "product");
				printResult(fraction1, fraction2, fraction1.div(fraction2).toString(), "division");
			}
			
			catch(IllegalArgumentException e)
			{
				System.out.println(e.getMessage());
			}
			
		}
	}
	
	/**
	 * gets the string from the textbox pulled from the hashmap
	 * 
	 * @param fractionName : the key of the textbox being accessed
	 * @return fractionName
	 */
	public String getFraction(String fractionName)
	{
		fractionName = textboxes.get(fractionName).getText(); 
		return fractionName;
	}
	
	/**
	 * compares the two fractions
	 * 
	 * @param fraction1
	 * @param fraction2
	 * @return
	 */
	public String compare(Fraction fraction1, Fraction fraction2)
	{
		if(fraction1.equals(fraction2))
		{
			return "=";
		}
		
		if(fraction1.greaterThan(fraction2))
		{
			return ">";
		}
		
		if(fraction1.lessThan(fraction2))
		{
			return "<";
		}
		
		return "";
	}
	
	/**
	 * sets texts in the text box
	 * 
	 * @param fraction1
	 * @param fraction2
	 * @param result : result of the calculation performed
	 * @param key : key of the text box being acccesed
	 */
	public void printResult(Fraction fraction1, Fraction fraction2, String result, String key)
	{
		textboxes.get(key).setText(result);
		textboxes.get(key).setHorizontalAlignment(JTextField.CENTER);
	}
	
	
}