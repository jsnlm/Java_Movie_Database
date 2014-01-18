package EveryClass;
/*
 *editRecordProcedure is a Class that allows the user to edit a record that is already in the database
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

import EveryClass.deleteRecordProcedure.okayButtonProcedure;
import EveryClass.deleteRecordProcedure.selectRecordTextfieldProcedure;
import EveryClass.newRecordProcedure.movieDirectorTextfieldProcedure;
import EveryClass.newRecordProcedure.movieLengthTextfieldProcedure;
import EveryClass.newRecordProcedure.movieNameTextfieldProcedure;

public class editRecordProcedure {
	//=============================================== all the GUI components are declared
	private JFrame frame;
	private JPanel p;
	private JLabel instructionsToUser;
	private JTextField selectRecordTextfield;
	private JButton okayButton;	
	public int indexNumberToBeInputedIntoERW;
	//=============================================== all the GUI components are redeclared 
	//=============================================== all of the GUI components are given names( if names are needed
	public editRecordProcedure()
	{	
		instructionsToUser = new JLabel("enter the IDNumber of the record you want to edit");
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

		frame = new JFrame("Delete Record");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.setResizable(false);
		frame.add(p);
		frame.setSize(300, 10);
		frame.setVisible(true);
		frame.pack();
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
			String text = selectRecordTextfield.getText();
			//=============================================== tests if what the user entered in is an integer
			try
			{				
				//GUI.IDNumber[0] = 1;
				spareInteger = Integer.parseInt(text);	
				doesUserInputRecordExist = false;
				//=============================================== tests if the integer that the user entered in an index number that exists at that time
				for (int i = 0; i < 100; i++)
				{
					if ((doesUserInputRecordExist== false)&&(GUI.IDNumber[i]==spareInteger))
					{
						doesUserInputRecordExist = true;
					}
				}				
				if (doesUserInputRecordExist== false)
				{
					//=============================================== This joptionPane will be shown to the user if the user entered in a integer but does not exist as one of the ID#s
					//selectRecordTextfield.setText("");
					//okayButton.setEnabled(false);
					JOptionPane.showMessageDialog(null, "That record doesn't exist", "alert",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					//okayButton.setEnabled(true);
					//messageToUser.setText("_____");
				}
			}
			catch (Exception error) {System.out.println("Exception at "+error);
			//=============================================== if user entered in a value that is not an integer into the textfield. This JOption pane will pop up
			//messageToUser.setText("invalid Input");
			JOptionPane.showMessageDialog(null, "That is not a valid record number", "alert",JOptionPane.ERROR_MESSAGE);
			selectRecordTextfield.setText("");			
			}
		}
	}
	/* okayButtonProcedure function
	 * This will make sure that the value that the user enters into the textfield is a valid indexnumber(that exists)   
	 * Pre: User presses okay
	 * Post: If what the user enters is valid, then editRecordWindow will be initiated. If the user enters something invalid, a warning message will pop up to the user 
	 */
	public class okayButtonProcedure implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			int spareInteger;
			boolean doesUserInputRecordExist;
			String text = selectRecordTextfield.getText();
			//=============================================== tests if what the user entered in is an integer
			try
			{				
				//GUI.IDNumber[0] = 1;
				spareInteger = Integer.parseInt(text);	
				doesUserInputRecordExist = false;
				//=============================================== tests if the integer that the user entered in an index number that exists at that time
				for (int i = 0; i < 100; i++)
				{
					if ((doesUserInputRecordExist== false)&&(GUI.IDNumber[i]==spareInteger))
					{
						doesUserInputRecordExist = true;
					}
				}				
				if (doesUserInputRecordExist== false)
				{
					//=============================================== This joptionPane will be shown to the user if the user entered in a integer but does not exist as one of the ID#s
					//selectRecordTextfield.setText("");
					//okayButton.setEnabled(false);
					JOptionPane.showMessageDialog(null, "That record doesn't exist", "alert",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					//===============================================editRecordWindow will pop up if what the user entered is a valid index number
					int IDNumberInputed = Integer.parseInt(selectRecordTextfield.getText());
					for (int i = 0; i<100; i++)
					{
						if (GUI.IDNumber[i] == IDNumberInputed)
						{
							indexNumberToBeInputedIntoERW = i;
						}
					}
					editRecordWindow eRW = new editRecordWindow();
					//System.out.println("indexNumberToBeInputedIntoERW = " + indexNumberToBeInputedIntoERW);
					//=============================================== make edit record procedure invisible to make it seem as though it has closed
					frame.setVisible(false);
				}
			}
			catch (Exception error) {System.out.println("Exception at "+error);
			//messageToUser.setText("invalid Input");
			JOptionPane.showMessageDialog(null, "That is not a valid record number", "alert",JOptionPane.ERROR_MESSAGE);
			selectRecordTextfield.setText("");			
			}

		}
	}
	public class editRecordWindow extends JFrame{
		//----------------------------------------- introduces all of the GUI components 
		public int theIndexNumbertoBeChanged =2;
		private JFrame newRecordframe;
		private JPanel p;
		private JLabel messageToUser;
		private JLabel IDNumberLabel;

		private JLabel movieNameLabel;
		private JTextField movieNameTextfield;
		private JLabel movieLengthLabel;
		private JTextField movieLengthTextfield;
		private JLabel movieDirectorLabel;
		private JTextField movieDirectorTextfield;
		private JLabel movieRatingLabel;
		private JComboBox movieRatingComboBox;
		private JLabel movieReleaseYearLabel;
		private JComboBox movieReleaseYearComboBox;
		private JLabel movieReviewRatingYearLabel;
		private JComboBox movieReviewRatingComboBox;
		private JButton okayButton;

		public editRecordWindow()
		{		

			int counter;
			theIndexNumbertoBeChanged = indexNumberToBeInputedIntoERW;
			System.out.println("editRecordWindow has been initiated");
			System.out.println("theIndexNumbertoBeChanged = " + theIndexNumbertoBeChanged);
			//=============================================== These array of strings will be used to fill the comboboxes
			String [] movieRatingComboBoxOptions = {"N/A", "G", "PG","PG-13","R", "NC-17", "NR"};
			String [] movieReleaseYearComboBoxOptions = {"2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900", "1899", "1898", "1897", "1896", "1895", "1894", "1893", "1892", "1891", "1890", "1889", "1888", "1887", "1886", "1885", "1884", "1883", "1882", "1881", "1880", "1879", "1878", "1877", "1876", "1875", "1874", "1873", "1872", "1871",};
			String [] movieReviewRatingComboBoxOptions = {"10.0", "9.9 ", "9.8 ", "9.7 ", "9.6 ", "9.5 ", "9.4 ", "9.3 ", "9.2 ", "9.1 ", "9.0 ", "8.9 ", "8.8 ", "8.7 ", "8.6 ", "8.5 ", "8.4 ", "8.3 ", "8.2 ", "8.1 ", "8.0 ", "7.9 ", "7.8 ", "7.7 ", "7.6 ", "7.5 ", "7.4 ", "7.3 ", "7.2 ", "7.1 ", "7.0 ", "6.9 ", "6.8 ", "6.7 ", "6.6 ", "6.5 ", "6.4 ", "6.3 ", "6.2 ", "6.1 ", "6.0 ", "5.9 ", "5.8 ", "5.7 ", "5.6 ", "5.5 ", "5.4 ", "5.3 ", "5.2 ", "5.1 ", "5.0 ", "4.9 ", "4.8 ", "4.7 ", "4.6 ", "4.5 ", "4.4 ", "4.3 ", "4.2 ", "4.1 ", "4.0 ", "3.9 ", "3.8 ", "3.7 ", "3.6 ", "3.5 ", "3.4 ", "3.3 ", "3.2 ", "3.1 ", "3.0 ", "2.9 ", "2.8 ", "2.7 ", "2.6 ", "2.5 ", "2.4 ", "2.3 ", "2.2 ", "2.1 ", "2.0 ", "1.9 ", "1.8 ", "1.7 ", "1.6 ", "1.5 ", "1.4 ", "1.3 ", "1.2 ", "1.1 ", "1.0 ", "0.9 ", "0.8 ", "0.7 ", "0.6 ", "0.5 ", "0.4 ", "0.3 ", "0.2 ", "0.1 ", "0.0 ",};
			//=============================================== redeclare the GUI Components (GUI syntax)
			p = new JPanel();
			messageToUser = new JLabel("Enter in information of the new record");
			IDNumberLabel = new JLabel("The record being edited is " + Integer.toString(GUI.IDNumber[theIndexNumbertoBeChanged]));

			movieNameLabel= new JLabel("Enter the new name of the movie");
			movieNameTextfield = new JTextField(GUI.movieName[theIndexNumbertoBeChanged]);
			movieLengthLabel= new JLabel("Enter the new length of the movie(in minutes)");
			//=============================================== if the movie length is -1(meaning blank) then the edit window should show nothing for that textfield
			if (GUI.movieLength[theIndexNumbertoBeChanged] == -1)
			{
				movieLengthTextfield = new JTextField("");
			}
			else
			{
				movieLengthTextfield = new JTextField(Integer.toString(GUI.movieLength[theIndexNumbertoBeChanged]));	
			}
			movieDirectorLabel= new JLabel("Enter the new Director's Name");
			//=============================================== if the movie Director is "null"(meaning blank) then the edit window should show nothing for that textfield
			if (GUI.movieDirector[theIndexNumbertoBeChanged].equalsIgnoreCase("null"))
			{
				movieDirectorTextfield = new JTextField("");
			}
			else
			{
				movieDirectorTextfield = new JTextField(GUI.movieDirector[theIndexNumbertoBeChanged]);
			}

			movieRatingLabel= new JLabel("Select the new movie rating (G, PG, PG-13, etc.)");
			movieRatingComboBox = new JComboBox (movieRatingComboBoxOptions);
			//=============================================== This algorithm finds the previous movieRating and shows it back on the edit window  
			counter = 0;
			while (((GUI.movieRating[theIndexNumbertoBeChanged].equalsIgnoreCase(movieRatingComboBoxOptions[counter]))==false)&&((GUI.movieRating[theIndexNumbertoBeChanged].equalsIgnoreCase("null")) == false))
			{
				System.out.println("GUI.movieRating[theIndexNumbertoBeChanged]" + GUI.movieRating[theIndexNumbertoBeChanged]);
				System.out.println("movieRatingComboBoxOptions[counter])" + movieRatingComboBoxOptions[counter]);

				counter +=1;
			}			
			//System.out.println(counter);
			movieRatingComboBox.setSelectedIndex(counter);

			movieReleaseYearLabel= new JLabel("select the new year the movie was released");
			//=============================================== This algorithm finds the previous movieReleaseYearand shows it back on the edit window
			movieReleaseYearComboBox= new JComboBox (movieReleaseYearComboBoxOptions);
			counter = 0;
			
			while
				(
						((Integer.toString(GUI.movieReleaseYear[theIndexNumbertoBeChanged]).equalsIgnoreCase(movieReleaseYearComboBoxOptions[counter]))==false)
						&&
						(GUI.movieReleaseYear[theIndexNumbertoBeChanged] != -1)
				)
			{
				counter +=1;
			}			
			//System.out.println(counter);
			movieReleaseYearComboBox.setSelectedIndex(counter);

			movieReviewRatingYearLabel= new JLabel("Select the new movie review Rating");
			movieReviewRatingComboBox= new JComboBox (movieReviewRatingComboBoxOptions);
			counter = 0;
			//=============================================== This algorithm finds the previous movieReviewRating and shows it back on the edit window
			while( 
					((GUI.movieReviewRating[theIndexNumbertoBeChanged]==(Double.parseDouble(movieReviewRatingComboBoxOptions[counter])))==false)&&
					((GUI.movieReviewRating[theIndexNumbertoBeChanged]==-0.1)==false)
			)
			{				
				//System.out.println(counter);
				//System.out.println(Double.toString(GUI.movieReviewRating[theIndexNumbertoBeChanged]).equalsIgnoreCase(movieReviewRatingComboBoxOptions[counter]));
				//System.out.println("Double.toString(GUI.movieReviewRating[theIndexNumbertoBeChanged] = " + Double.toString(GUI.movieReviewRating[theIndexNumbertoBeChanged]));
				//System.out.println("movieReviewRatingComboBoxOptions[counter] = " + movieReviewRatingComboBoxOptions[counter]);
				counter +=1;
			}				
			movieReviewRatingComboBox.setSelectedIndex(counter);

			//=============================================== adds the GUI components to the panel
			okayButton = new JButton("Okay");

			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			p.add(messageToUser);
			p.add(IDNumberLabel);

			p.add(movieNameLabel);
			p.add(movieNameTextfield);
			p.add(movieLengthLabel);
			p.add(movieLengthTextfield);
			p.add(movieDirectorLabel);
			p.add(movieDirectorTextfield);
			p.add(movieRatingLabel);
			p.add(movieRatingComboBox);
			p.add(movieReleaseYearLabel);
			p.add(movieReleaseYearComboBox);
			p.add(movieReviewRatingYearLabel);
			p.add(movieReviewRatingComboBox);
			p.add(okayButton);

			movieNameTextfield.addActionListener(new movieNameTextfieldProcedure());
			movieLengthTextfield.addActionListener(new movieLengthTextfieldProcedure());
			movieDirectorTextfield.addActionListener(new movieDirectorTextfieldProcedure());
			okayButton.addActionListener(new okayButtonProcedure());

			newRecordframe = new JFrame("Edit Record");
			newRecordframe.setDefaultCloseOperation(newRecordframe.DISPOSE_ON_CLOSE);
			//frame.setResizable(false);
			newRecordframe.add(p);
			newRecordframe.setSize(1, 1);
			newRecordframe.setVisible(true);
			newRecordframe.pack();
		}	
		/* movieNameTextfieldProcedure function
		 * This will trim off the excess spaces of the string that the user enters into movieNameTextfield  
		 * Pre: User must have entered something into the movieName Textfield and then press enter  
		 * Post: The String for movieNameTextfield will be trimmed to cut off any excess spaces. This will be redisplayted back to the user 
		 */
		public class movieNameTextfieldProcedure implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				movieNameTextfield.setText((movieNameTextfield.getText()).trim());
			}
		}
		/* movieLengthTextfieldProcedure function
		 * This will make sure that movieLengthTextfieldProcedure that the user enters is a valid time period  
		 * Pre: User must have entered something into the movielength Textfield and then press enter  
		 * Post: A warning will pop up if the movieLength is invalid. Otherwise, nothing will happen
		 */
		public class movieLengthTextfieldProcedure implements ActionListener
		{
			int spareInteger; 		
			public void actionPerformed(ActionEvent e)
			{
				String text = movieLengthTextfield.getText();
				try
				{				
					spareInteger = Integer.parseInt(text);				
					if (spareInteger < 0)
					{
						JOptionPane.showMessageDialog(null, "That record doesn't exist", "alert",JOptionPane.ERROR_MESSAGE);
						//messageToUser.setText("invalid Input");
						movieLengthTextfield.setText("");
					}
				}
				catch (Exception error) {System.out.println("Exception at "+error);
				JOptionPane.showMessageDialog(null, "invalid Input", "alert",JOptionPane.ERROR_MESSAGE);
				movieLengthTextfield.setText("");
				}
			}
		}
		/* movieDirectorTextfieldProcedure function
		 * This will trim off the excess spaces of the string that the user enters into movieDirectorTextfield  
		 * Pre: User must have entered something into the movieDirector Textfield and then press enter  
		 * Post: The String for movieDirectorTextfield will be trimmed to cut off any excess spaces. This will be redisplayed back to the user 
		 */	
		public class movieDirectorTextfieldProcedure implements ActionListener
		{ 		
			public void actionPerformed(ActionEvent e)
			{
				movieDirectorTextfield.setText((movieDirectorTextfield.getText()).trim());
			}
		}
		/* okayButtonProcedure function
		 * This function checks if everything the user entered is valid. If it is valid, it will change the record arrays accordingly. If it is not valid, a warning will pop up   
		 * Pre: User must press the okay button on the New Record Window  
		 * Post: A warning will be given to the user if the information they entered is invalid. Otherwise, the records will be changed accordingly 
		 */
		public class okayButtonProcedure implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				//===============================================  test if user entered in a movie title. This is the one thing that the user must enter
				if (movieNameTextfield.getText().equals("")==false)
				{
					//===============================================  the point of the try and catch is to test if movielength that the user entered is an integer or not
					try{
						//===============================================   if the user enter nothing into movielength textfield, the movielength year will be changed to -1
						int theIntToTestIfReleaseYearIsValid;
						if (movieLengthTextfield.getText().equals(""))
						{
						//System.out.println("movieLengthTextfield is equel to nothing");
							theIntToTestIfReleaseYearIsValid = -1;
						}
						else
						//===============================================  if the user entered in a valid number, then the correspinding index of movielength will be changed to it
						{
							theIntToTestIfReleaseYearIsValid = Integer.parseInt(movieLengthTextfield.getText());
						}
						//===============================================  If the year entered is larger then 0, then the user it means that all the record
						//===============================================  parameters that the user entered is valid.The correspinding arrays of what the 
						//===============================================  user entered will be changed accordingly 						
						if ((theIntToTestIfReleaseYearIsValid >=0)||movieLengthTextfield.getText().equals(""))
						//if (theIntToTestIfReleaseYearIsValid >=-1)
						{
							//===============================================  finds what the new index number is
							int i = indexNumberToBeInputedIntoERW;
							//===============================================  finds what the new IDNumber is
							//GUI.IDNumber[i] = GUI.lastIDNumber + 1 ;
							//===============================================  changes the rest of the arrays according to what the user entered
							GUI.movieName[i] = (movieNameTextfield.getText()).trim();
							GUI.movieLength[i] = theIntToTestIfReleaseYearIsValid;
							//=============================================== if the user entere nothing into movieDirectorTextfield, then the array value will be changed to null
							if (movieDirectorTextfield.getText().equals(""))
							{
								GUI.movieDirector[i] = "null";
							}
							else
							{
								GUI.movieDirector[i] = movieDirectorTextfield.getText();
							}
							GUI.movieRating[i] = (String)movieRatingComboBox.getSelectedItem();
							GUI.movieReleaseYear[i] =  Integer.parseInt((String)movieReleaseYearComboBox.getSelectedItem());
							GUI.movieReviewRating[i] = Double.parseDouble((String)movieReviewRatingComboBox.getSelectedItem());
							newRecordframe.setVisible(false);

							System.out.println("GUI.IDNumber[" + i + "] = " + GUI.IDNumber[i]);
							System.out.println("GUI.movieName[i] = " + GUI.movieName[i]);
							System.out.println("GUI.movieLength[i] = " + GUI.movieLength[i]);
							System.out.println("GUI.movieDirector[i]" + GUI.movieDirector[i]);
							System.out.println("GUI.movieRating[i]" + GUI.movieRating[i]);
							System.out.println("GUI.movieReleaseYear[i]" + GUI.movieReleaseYear[i]);
							System.out.println("GUI.movieReviewRating[i]" + GUI.movieReviewRating[i]);
							//===============================================The lastIndexNumber and LastIDNumber are changed accordingly
							GUI.reloadArrayValuesToGUI();
						}
						else
						{
							//=============================================== a joption pane will pop up if the user entered a negative number for movie length textfield
							JOptionPane.showMessageDialog(null, "Movies are not that short, re-type the movie year", "alert",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (Exception error) 
					{
						//=============================================== a joption pane will pop up if the user entered value that is not an integer into the movie length textfield
						System.out.println("Exception at "+error);
						JOptionPane.showMessageDialog(null, "That is not a valid year", "alert",JOptionPane.ERROR_MESSAGE);
						//messageToUser.setText("invalid Input");
					}
				}
				else
				{
					//===============================================  a joption pane will pop up if the user entered nothing into the movie name textfield
					JOptionPane.showMessageDialog(null, "You must enter the name of the movie", "alert",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}


}
