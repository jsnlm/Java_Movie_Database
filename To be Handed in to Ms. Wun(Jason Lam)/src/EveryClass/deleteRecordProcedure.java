package EveryClass;
/*
 *deleteRecordProcedure is a class of the movie database program that lets the user delete a record out of the database
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class deleteRecordProcedure {
	//=============================================== all the GUI components are declared
	public static JFrame deleteRecordFrame1;
	private JPanel p;
	private JLabel instructionsToUser;
	private JTextField selectRecordTextfield;
	private JButton okayButton;	

	public deleteRecordProcedure()
	{
		//=============================================== all the GUI components are redeclared 
		//=============================================== all of the GUI components are given names( if names are needed
		instructionsToUser = new JLabel("enter the IDNumber of the record you want to delete");
		selectRecordTextfield = new JTextField();
		okayButton = new JButton("Okay");
		//okayButton.setEnabled(false);
		p = new JPanel();

		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		p.add(instructionsToUser);
		p.add(selectRecordTextfield);		
		p.add(okayButton);

		selectRecordTextfield.addActionListener(new selectRecordTextfieldProcedure());
		okayButton.addActionListener(new okayButtonProcedure());

		deleteRecordFrame1 = new JFrame("Delete Record");
		deleteRecordFrame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.setResizable(false);
		deleteRecordFrame1.add(p);
		deleteRecordFrame1.setSize(300, 10);
		deleteRecordFrame1.setVisible(true);
		deleteRecordFrame1.pack();
	}
	/* okayButtonProcedure function
	 * This will make sure that the value that the user enters into the textfield is a valid indexnumber(that exists)   
	 * Pre: User presses okay
	 * Post: If what the user enters is valid, then confirmation frame will be innitiated. If the user enters something invalid, a warning message will pop up to the user 
	 */
	public class okayButtonProcedure implements ActionListener
	{
		int spareInteger;
		boolean doesUserInputRecordExist;	
		public void actionPerformed(ActionEvent e)
		{
			String text = selectRecordTextfield.getText();
			//=============================================== tests if what the user entered in is an integer
			try
			{				
				spareInteger = Integer.parseInt(text);	
				doesUserInputRecordExist = false;
				//=============================================== tests if the integer that the user entered in an index number that exists at that time
				for (int i = 0; i < 100; i++)
				{
					if ((doesUserInputRecordExist== false)&&(GUI.IDNumber[i]==spareInteger))
					{
						doesUserInputRecordExist = true;
						//System.out.println("GUI.IDNumber[i] = " + GUI.IDNumber[i]);
						//System.out.println("spareInteger = " + spareInteger);
					}
				}				
				
				if (doesUserInputRecordExist== false)
				{
					//selectRecordTextfield.setText("");
					//=============================================== This joptionPane will be shown to the user if the user entered in a integer but does not exist as one of the ID#s
					JOptionPane.showMessageDialog(null, "That record doesn't exist", "alert",JOptionPane.ERROR_MESSAGE);
					//messageToUser.setText("That record doesn't exist");
					//okayButton.setEnabled(false);
				}
				else
				{
					//===============================================confirmationFrame will pop up if what the user entered is a valid index number
					confirmationFrame cfr = new confirmationFrame();
					cfr.text = selectRecordTextfield.getText();
					{
						//okayButton.setEnabled(true);
					}
				}
			}

			catch (Exception error) 
			{System.out.println("Exception at "+error);
			//=============================================== if user entered in a value that is not an integer into the textfield. This JOption pane will pop up
			JOptionPane.showMessageDialog(null, "invalid Input", "alert",JOptionPane.ERROR_MESSAGE);
			//messageToUser.setText("invalid Input");
			//selectRecordTextfield.setText("");			
			}
		}
	}
	/* selectRecordTextfieldProcedure function
	 * This will make sure that the value that the user enters into the textfield is a valid indexnumber(that exists)   
	 * Pre: User must have entered something into the selectRecordTextfield and then press enter  
	 * Post: If what the user enters is valid, then nothing will happen. If the user enters something invalid, a warning message will pop up to the user 
	 */
	public class selectRecordTextfieldProcedure implements ActionListener
	{
		int spareInteger;
		boolean doesUserInputRecordExist;
		//int counter = 0;
		public void actionPerformed(ActionEvent e)
		{
			//=============================================== tests if what the user entered in is an integer
			String text = selectRecordTextfield.getText();
			try
			{				
				spareInteger = Integer.parseInt(text);	
				doesUserInputRecordExist = false;
				//=============================================== tests if the integer that the user entered in an index number that exists at that time
				for (int i = 0; i < 100; i++)
				{
					if ((doesUserInputRecordExist== false)&&(GUI.IDNumber[i]==spareInteger))
					{
						doesUserInputRecordExist = true;
						//System.out.println("GUI.IDNumber[i] = " + GUI.IDNumber[i]);
						//System.out.println("spareInteger = " + spareInteger);
					}
				}				
				if (doesUserInputRecordExist== false)
				{
					//selectRecordTextfield.setText("");
					//=============================================== This joptionPane will be shown to the user if the user entered in a integer but does not exist as one of the ID#s
					JOptionPane.showMessageDialog(null, "That record doesn't exist", "alert",JOptionPane.ERROR_MESSAGE);
					//messageToUser.setText("That record doesn't exist");
					//okayButton.setEnabled(false);
				}
				else
				{
					//okayButton.setEnabled(true);
				}
			}
			catch (Exception error)
			{
			System.out.println("Exception at "+error);
			//=============================================== if user entered in a value that is not an integer into the textfield. This JOption pane will pop up
			JOptionPane.showMessageDialog(null, "invalid Input", "alert",JOptionPane.ERROR_MESSAGE);
			//messageToUser.setText("invalid Input");
			//selectRecordTextfield.setText("");			
			}
		}
	}
	/* confirmationFrame function
	 * This will pop up to confirm if the user wants to indeed delete the specified record   
	 * Pre: User must have entered in a vlid index number into the selectrecord Textfield and then press oaky  
	 * Post: getRidOfARecord function will be used to the corresponding array index of each field 
	 */
	public static class confirmationFrame extends JFrame{
		//=============================================== all the GUI components are declared
		private JFrame frame;
		private JPanel p;
		private JLabel messageToUser;
		private JButton okayButton;
		private String text;	
		private int IDNumberOfRecordToBeDeleted;
		private int indexOfRecordToBeDeleted = 0;
		public confirmationFrame()
		{
			//=============================================== all the GUI components are redeclared 
			//=============================================== all of the GUI components are given names( if names are needed
			messageToUser = new JLabel("Are you sure you want to delete this record?");
			okayButton = new JButton("Okay");
			p = new JPanel();
			//=============================================== GUI components are added to the panel

			p.add(messageToUser);
			p.add(okayButton);
			/* okayButton function
			 * This function will delete the record that the user specified   
			 * Pre: User must press okay on the confirmation frame  
			 * Post: The record will have been deleted 
			 */
			okayButton.addActionListener(new ActionListener() 
			{ 
				public void actionPerformed(ActionEvent e) 
				{ 					
					//=============================================== This algorythym will convert the index that the user entered into an integer
					//=============================================== afterwards, the corresponding indexvalue will be located
					IDNumberOfRecordToBeDeleted = Integer.parseInt(text);
					for (int i = 0; i <100; i++)
					{
						if (GUI.IDNumber[i] == IDNumberOfRecordToBeDeleted)
						{
							indexOfRecordToBeDeleted = i;
						}
					}		
					//=============================================== Using delete functions(that I made) The array is deleted accordingly 
					getRidOfARecord(indexOfRecordToBeDeleted, GUI.IDNumber);
					getRidOfARecord(indexOfRecordToBeDeleted, GUI.movieName);
					getRidOfARecord(indexOfRecordToBeDeleted, GUI.movieLength);
					getRidOfARecord(indexOfRecordToBeDeleted, GUI.movieDirector);
					getRidOfARecord(indexOfRecordToBeDeleted, GUI.movieRating);
					getRidOfARecord(indexOfRecordToBeDeleted, GUI.movieReleaseYear);
					getRidOfARecord(indexOfRecordToBeDeleted, GUI.movieReviewRating);	
					//=============================================== 1 is subtracted from lastIndexNumber to give the new and correct lastIndexNumber 
					GUI.lastIndexNumber  = GUI.lastIndexNumber - 1;
					frame.setVisible(false);
					deleteRecordFrame1.setVisible(false);
					//=============================================== Refresh the GUI
					GUI.reloadArrayValuesToGUI();


				}
			});
			frame = new JFrame("Confirmation ");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.add(p);
			frame.setSize(300, 10);
			frame.setVisible(true);
			frame.pack();
		}
	}
	/* getRidOfARecord function (int or String or Double)
	 * This function will delete the record that with the input of the index to be deleted   
	 * Pre: okay button in the Confirmation frame must be clicked
	 * Post: The array will be deleted, the last value of the array(someArray [99]) will be replaced with what ever represents a blank record 
	 * -1 = blank integer
	 * "null = blank string
	 * -0.1 = blank double 
	 */
	public static void getRidOfARecord (int indexOfRecordToBeDeleted, int IntArray[])
	{
		for (int i = 0; i<100; i ++)
		{
			//=============================================== change the end array to -1 which represents a blank record
			if (i >= indexOfRecordToBeDeleted)
			{
				if (i== 99)
				{
					IntArray[i] = -1;
				}
				//=============================================== move the replace the array with the array value above (essentially erasing the record)
				else
				{
					IntArray[i] = IntArray[(i+1)];
				}
			}
		}
	}
	public static void getRidOfARecord (int indexOfRecordToBeDeleted, String StringArray[])
	{
		for (int i = 0; i<100; i ++)
		{
			//=============================================== change the end array to "null" which represents a blank record
			if (i >= indexOfRecordToBeDeleted)
			{
				if (i== 99)
				{
					StringArray[i] = "null";
				}
				//=============================================== move the replace the array with the array value above (essentially erasing the record)
				else
				{
					StringArray[i] = StringArray[(i+1)];
				}
			}
		}
	}
	public static void getRidOfARecord (int indexOfRecordToBeDeleted, double DoubleArray[])
	{
		for (int i = 0; i<100; i ++)
		{
			//=============================================== change the end array to -0.01 which represents a blank record
			if (i >= indexOfRecordToBeDeleted)
			{
				if (i== 99)
				{
					DoubleArray[i] = -0.1;
				}
				//=============================================== move the replace the array with the array value above (essentially erasing the record)
				else
				{
					DoubleArray[i] = DoubleArray[(i+1)];
				}
			}
		}
	}
	/*
	public static void main(String[]args)
	{
		new deleteRecordProcedure();
	}
	 */
}
