package EveryClass;
/*
 * Program Name: Movie Database	Contributors: Jason Lam 	Due Date: June 1, 2012 	Class: ICS3U1-01, Ms. Wun
 * 
 * Program Description: This program allows the user to have an organized user friendly way of organizing and storing information about movies
 * 						The many functions of this program include, saving, loading, sorting, searching
 * 						This program also is capable of accepting new records, deleting record and editing records
 * 						It is important to remember that the the maximum number of records that can be kept in this database is 100  
 */

import java.awt.*;

import java.io.*;	
import javax.swing.*;

import java.awt.event.*;
import java.io.FileReader;
import java.util.Scanner;
public class GUI extends JFrame{
	//----------------------------------------------- Declares all the components of the Main GUI
	private JButton search;
	private JButton clearSearchParameters;
	private JButton help;
	private JButton resetDatabase;
	public static JButton fieldNames[];
	private JButton newRecordButton;
	private JButton editRecordButton;
	private JButton deleteRecordButton;
	public static JTextField textfield[][];
	public static JTextField searchTextfield[];
	public static JLabel indexes[];
	private JLabel messageToUser;
	private JLabel emptyLabel[];
	private JPanel RecordsFieldButtons;
	private JScrollPane scrollPane;
	//=============================================== Declares the arrays that will hold the information of each record.
	public static int IDNumber [] = new int[100];
	public static String movieName [] = new String [100];
	public static int movieLength [] = new int [100];
	public static String movieDirector [] = new String [100];
	public static String movieRating [] = new String [100];
	public static int movieReleaseYear [] = new int [100];
	public static double movieReviewRating [] = new double [100];
	//=============================================== These variables keep track of what the last indexNumber is and what the last IDNumber is
	//=============================================== This helps a great deal with making sure new records are placed in the correct index of each array with the correct IDNumber
	public static int lastIndexNumber;
	public static int lastIDNumber;
	//=============================================== This array keeps track of the order that the records will be presented onto the screen
	
	public static int arrayIndexes [] = new int [100];  //to keep track of the indexes of a sorted or searched array



	public GUI(){
	//===============================================loads data from savefiles (textfiles) 
		Classes.LoadData();
		//=========================================== resets the arrayIndexes array so that the the GUI will first show the records according to IDNumber
		Classes.resetArrayIndexes();
		//=========================================== Redeclaring GUI Components (this is part of GUI Syntax for some reason)
		//=========================================== This also gives text to those GUI Components
		search = new JButton("search");
		clearSearchParameters = new JButton("clear Parameters");
		help = new JButton("Help");
		resetDatabase = new JButton("Reset Database");
		messageToUser = new JLabel("");
		emptyLabel = new JLabel [3];
		newRecordButton  = new JButton(" New Record");
		editRecordButton  = new JButton(" Edit Record");
		deleteRecordButton  = new JButton("Delete Record");		

		searchTextfield = new JTextField[7];
		fieldNames = new JButton[7];
		textfield = new JTextField[6][100];
		indexes = new JLabel [100];
		RecordsFieldButtons = new JPanel();
		scrollPane = new JScrollPane();

		emptyLabel[0] = new JLabel ("");
		emptyLabel[1] = new JLabel ("");
		emptyLabel[2] = new JLabel ("");
		fieldNames[0] = new JButton ("ID#");
		fieldNames[1] = new JButton ("Movie Name");
		fieldNames[2] = new JButton ("Movie Length");
		fieldNames[3] = new JButton ("Movie Director");
		fieldNames[4] = new JButton ("Movie Rating");
		fieldNames[5] = new JButton ("Movie Release Year");
		fieldNames[6] = new JButton ("Movie Review"+"Rating");
		//=========================================== All the searchTextfields will be preset to the text "enter Search Parameter"
		for (int x = 0; x < 7; x ++)
		{
			searchTextfield[x] = new JTextField("enter Search Parameter");
		}
		//=========================================== This for loop attaches the correct array value to the GUI Components
		for (int x = 0; x < 7; x ++)
		{
			for (int y = 0; y < 100; y ++)
			{
				switch (x) {
				case 0:  
					//=============================== This checks if the value of IDNumber[xxx] is blank (which is noted by a -1)
					//=============================== If it is, then it will set the text of its corresponding Textfield to blank
					if (IDNumber[arrayIndexes[y]] == -1)
					{
						indexes[y] = new JLabel ("");
					}
					else
					{
						indexes[y] = new JLabel (Integer.toString(IDNumber[arrayIndexes[y]]));
					}
					break;
				case 1:  
					//=============================== This checks if the value of movieName[xxx] is blank (which is noted by a "null")
					//=============================== If it is, then it will set the text of its corresponding Textfield to blank
					if (movieName[arrayIndexes[y]].equals("null") == true)
					{
						textfield[x-1][y] = new JTextField("");
					}
					else
					{
						textfield[x-1][y] = new JTextField(movieName[arrayIndexes[y]]);
					}
					break;
				case 2:  
					//=============================== This checks if the value of movieLength[xxx] is blank (which is noted by a -1)
					//=============================== If it is, then it will set the text of its corresponding Textfield to blank
					if (movieLength [arrayIndexes[y]]==-1 )
					{
						textfield[x-1][y]= new JTextField("");
					}
					else
					{
						textfield[x-1][y]= new JTextField(Integer.toString(movieLength [arrayIndexes[y]]) + " minutes");
					}
					break;
				case 3:  
					//=============================== This checks if the value of movieDirector[xxx] is blank (which is noted by a "null")
					//=============================== If it is, then it will set the text of its corresponding Textfield to blank
					if (movieDirector [arrayIndexes[y]].equals("null") == true)
					{
						textfield[x-1][y]= new JTextField("");
					}
					else
					{
						textfield[x-1][y]= new JTextField(movieDirector [arrayIndexes[y]]);
					}					
					break;
				case 4:
					//=============================== This checks if the value of movieRating[xxx] is blank (which is noted by a "null") or if it is unavailable "N/A"
					//=============================== If it is, then it will set the text of its corresponding Textfield to blank
					if ((movieRating [arrayIndexes[y]].equals("null") == true)||(movieRating [arrayIndexes[y]].equals("N/A") == true))
					{
						textfield[x-1][y]= new JTextField("");
					}
					else
					{
						textfield[x-1][y]= new JTextField(movieRating [arrayIndexes[y]]);
					}	
					break;
				case 5:
					//=============================== This checks if the value of movieReleaseYear[xxx] is blank (which is noted by a -1)
					//=============================== If it is, then it will set the text of its corresponding Textfield to blank
					if (movieReleaseYear [arrayIndexes[y]]==-1 )
					{
						textfield[x-1][y]= new JTextField("");
					}
					else
					{
						textfield[x-1][y]= new JTextField(Integer.toString(movieReleaseYear[arrayIndexes[y]]));
					}	
					break;
				case 6:
					//=============================== This checks if the value of movieReviewRating[xxx] is blank (which is noted by a -0.1)
					//=============================== If it is, then it will set the text of its corresponding Textfield to blank
					if (movieReviewRating[arrayIndexes[y]]==-0.1 )
					{
						textfield[x-1][y]= new JTextField("");
					}
					else
					{
						textfield[x-1][y]= new JTextField(Double.toString(movieReviewRating[arrayIndexes[y]]));
					}
					break;
				}
				//=============================== This disables the ability for the all the textfields to be edited.
				if ((x<=6)&&(x>=1))
				{
					textfield[x-1][y].setEditable(false);   
				}
			}
		}
		//======================================= Makes the layout of the panel (gridlayout)
		RecordsFieldButtons.setLayout (new GridLayout(103, 7));
		//======================================= adds the GUI components to the GUI
		RecordsFieldButtons.add(newRecordButton);
		RecordsFieldButtons.add(editRecordButton);
		RecordsFieldButtons.add(deleteRecordButton);
		//RecordsFieldButtons.add(messageToUser);
		//RecordsFieldButtons.add(emptyLabel[0]);
		//RecordsFieldButtons.add(emptyLabel[1]);
		//RecordsFieldButtons.add(emptyLabel[2]);
		RecordsFieldButtons.add(search);
		RecordsFieldButtons.add(clearSearchParameters);
		RecordsFieldButtons.add(resetDatabase);
		RecordsFieldButtons.add(help);
		
		//======================================= places the searchTextfield onto the GUI
		for (int x = 0; x < 7; x ++)
		{
			RecordsFieldButtons.add(searchTextfield[x]);
		}
		//======================================= places the fieldnames onto the GUI. (the fieldnames are also the buttons for sort)
		for (int x = 0; x < 7; x ++)
		{
			//fieldNames[x].setLineWrap(true);
			RecordsFieldButtons.add(fieldNames[x]);
		}
		//======================================= places the rest of the array values( textfields) onto the GUI
		for (int y = 0; y < 100; y ++)
		{
			for (int x = 0; x < 7; x ++)
			{			
				if (x==0)
				{
					RecordsFieldButtons.add(indexes[y]);
				}
				else
				{					
					RecordsFieldButtons.add(textfield[x-1][y]);
				}
			}
		}
		//======================================= changes the color of the fields names to orange
		//======================================= the point of this is to give a separation between the arrayvalues and the function buttons
		for (int i = 0; i<7; i++)
		{
			fieldNames[i].setBackground(Color.ORANGE);	
		}
		//======================================= adds actions to all the GUI Components( if any)
		fieldNames[0].addActionListener(new whenUserClickIDNumberButton());
		fieldNames[1].addActionListener(new whenUserClickMovieNameButton());
		fieldNames[2].addActionListener(new whenUserClickMovieLengthButton());
		fieldNames[3].addActionListener(new whenUserClickMovieDirectorButton());
		fieldNames[4].addActionListener(new whenUserClickMovieRatingButton());
		fieldNames[5].addActionListener(new whenUserClickMovieReleaseYearButton());
		fieldNames[6].addActionListener(new whenUserClickMovieReviewButton());
		search.addActionListener(new whenUserClickSearchButton());
		clearSearchParameters.addActionListener(new whenUserClickClearParametersButton());
		help.addActionListener(new helpFunction());
		resetDatabase.addActionListener(new whenUserClicksResetDatabse());
		newRecordButton.addActionListener(new whenUserClicksNewButton());
		editRecordButton.addActionListener(new whenUserClicksEditButton());
		deleteRecordButton.addActionListener(new whenUserClicksDeleteButton());
		JFrame frame = new JFrame("Movie Database");
		frame.addWindowListener( new whenUserClicksXOnTheCornerOfWindow());
		frame.setResizable(true);
		frame.add(new JScrollPane(RecordsFieldButtons));
		frame.setSize(100, 100);
		frame.setVisible(true);
		frame.pack();
	}
	//======================================= These are the actionlisteners attached to each button
	
	/* whenUserClicksXOnTheCornerOfWindow function
	 * This function is called up when the user exits out of the program   
	 * Pre: User must press the x on the corner of the window button on the New Record Window  
	 * Post: This will close the window, and it will save all the data of the program to save files (textfiles) 
	 */
	private class whenUserClicksXOnTheCornerOfWindow extends WindowAdapter{
		public void windowClosing( WindowEvent e){
			//System.out.println("whenUserClicksXOnTheCornerOfWindow was run");
			try {				
				FileWriter outFile = new FileWriter("saveDataIDNumber.txt");
				PrintWriter out = new PrintWriter(outFile);					//Prepares the file to be written on
				for (int y = 0; y < 100; y ++)
				{
					out.write((Integer.toString(IDNumber[y])) + "\r\n");
				}
				out.close();
				outFile = new FileWriter("saveDatamovieName.txt");
				out = new PrintWriter(outFile);					//Prepares the file to be written on
				for (int y = 0; y < 100; y ++)
				{
					out.write(movieName [y]+ "\r\n");
				}
				out.close();				
				outFile = new FileWriter("saveDatamovieLength.txt");
				out = new PrintWriter(outFile);					//Prepares the file to be written on
				for (int y = 0; y < 100; y ++)
				{
					out.write(Integer.toString(movieLength [y])+ "\r\n");
				}
				out.close();				
				outFile = new FileWriter("saveDatamovieDirector.txt");
				out = new PrintWriter(outFile);					//Prepares the file to be written on
				for (int y = 0; y < 100; y ++)
				{
					out.write(movieDirector [y]+ "\r\n");
				}
				out.close();				
				outFile = new FileWriter("saveDatamovieRating.txt");
				out = new PrintWriter(outFile);					//Prepares the file to be written on
				for (int y = 0; y < 100; y ++)
				{
					out.write(movieRating[y]+ "\r\n");
				}
				out.close();				
				outFile = new FileWriter("saveDatamovieReleaseYear.txt");
				out = new PrintWriter(outFile);					//Prepares the file to be written on
				for (int y = 0; y < 100; y ++)
				{
					out.write(Integer.toString(movieReleaseYear [y])+ "\r\n");
				}		
				out.close();
				outFile = new FileWriter("saveDatamovieReviewRating.txt");
				out = new PrintWriter(outFile);					//Prepares the file to be written on
				for (int y = 0; y < 100; y ++)
				{
					out.write(Double.toString(movieReviewRating [y])+ "\r\n");
				}
				outFile.close();												//Stops the program from printing any more
				outFile = new FileWriter("IDNumberAndIndexNumber.txt");
				out = new PrintWriter(outFile);					//Prepares the file to be written on
				out.write(Integer.toString(lastIndexNumber)+ "\r\n");
				out.write(Integer.toString(lastIDNumber));				
				outFile.close();
				System.out.println("data has been saved successfully");
			} 
			catch (Exception error){										
				System.out.println("ERROR : " + error);
				System.out.println("The System could not succesfully save the data");
			}		
			System.exit(0);
		}
	}
	/* helpFunction function
	 * This function will load up instructions when the user presses the help button   
	 * Pre: This is run when the user clicks the help button  
	 * Post: This will initiate the helpMenu which loads up the instructions for the program 
	 */	
public class helpFunction implements ActionListener
	{
	public void actionPerformed(ActionEvent e)
		{
			new helpMenu();
		}
	}
	/* whenUserClicksNewButton function
	 * This function allows a user to make a new file when the user clocks the newrecord button   
	 * Pre: This function is run when the user clicks new button  
	 * Post: A warning will be given to the user if the information they entered is invalid. Otherwise, the records will be changed accordingly 
	 */	
public class whenUserClicksNewButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{		
			//=================================== this if statement prevents the user from entering more records then the program can hold
			if (GUI.IDNumber[99] == -1)
			{
				//=============================== The new RecordProcedure is run if there is space in the array
				new newRecordProcedure();
			}			
			else
			{
				JOptionPane.showMessageDialog(null, "You have reached the maximum number of records", "alert",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	/* whenUserClicksEditButton function
	 * This function will let the user edit a record when the press the edit record button   
	 * Pre: When user clicks the edit record button  
	 * Post: the editRecordProcedure will be called up 
	 */	
public class whenUserClicksEditButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (GUI.IDNumber[0] != -1)
			{
				//=============================== The new RecordProcedure is run if there is space in the array
				new editRecordProcedure();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "There are no records to edit", "alert",JOptionPane.ERROR_MESSAGE);
			}
		}
	}	
	/* whenUserClicksDeleteButton function
	 * THe user can delete a record when they press the delete button   
	 * Pre: when the user clicks the delete button
	 * Post: the deleteRecordProcedure will be called up
	 */	
public class whenUserClicksDeleteButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (GUI.IDNumber[0] != -1)
			{
				//=============================== The new RecordProcedure is run if there is space in the array
				new deleteRecordProcedure();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "There are no records to delete", "alert",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	/* whenUserClickIDNumberButton function
	 * The records will be sorted according to IDNumber when this buttons is pressed.   
	 * Pre: When the IDNumber buttons is pressed
	 * Post: The Records will be sorted according to IDNumber and then the GUI will be refreshed for the user to see the sorted array
	 */	
public class whenUserClickIDNumberButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Classes.sortArray(IDNumber);
			reloadArrayValuesToGUI();
		}
	}
/* whenUserClickMovieNameButton function
 * The records will be sorted according to MovieName when this buttons is pressed.   
 * Pre: When the MovieName buttons is pressed
 * Post: The Records will be sorted according to MovieName and then the GUI will be refreshed for the user to see the sorted array
 */	
public class whenUserClickMovieNameButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{


			Classes.sortArray(movieName );
			reloadArrayValuesToGUI();
		}
	}
/* whenUserClickMovieLengthButton function
 * The records will be sorted according to MovieLength when this buttons is pressed.   
 * Pre: When the MovieLength buttons is pressed
 * Post: The Records will be sorted according to MovieLength and then the GUI will be refreshed for the user to see the sorted array
 */		
public class whenUserClickMovieLengthButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Classes.sortArray(movieLength );
			reloadArrayValuesToGUI();
		}
	}
/* whenUserClickMovieDirectorButton function
 * The records will be sorted according to movieDirector when this buttons is pressed.   
 * Pre: When the movieDirector buttons is pressed
 * Post: The Records will be sorted according to movieDirector and then the GUI will be refreshed for the user to see the sorted array
 */	
public class whenUserClickMovieDirectorButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Classes.sortArray(movieDirector );
			reloadArrayValuesToGUI();
		}
	}
/* whenUserClickMovieRatingButton function
 * The records will be sorted according to movieRating when this buttons is pressed.   
 * Pre: When the movieRating buttons is pressed
 * Post: The Records will be sorted according to movieRating and then the GUI will be refreshed for the user to see the sorted array
 */	
public class whenUserClickMovieRatingButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Classes.sortArrayMovieRating(movieRating );
			reloadArrayValuesToGUI();
		}
	}
/* whenUserClickMovieReleaseYearButton function
 * The records will be sorted according to movieReleaseYear when this buttons is pressed.   
 * Pre: When the movieReleaseYear buttons is pressed
 * Post: The Records will be sorted according to movieReleaseYear and then the GUI will be refreshed for the user to see the sorted array
 */	
public class whenUserClickMovieReleaseYearButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Classes.sortArray(movieReleaseYear );
			reloadArrayValuesToGUI();
		}
	}
/* whenUserClickMovieReviewButton function
 * The records will be sorted according to movieReviewRating when this buttons is pressed.   
 * Pre: When the movieReviewRating buttons is pressed
 * Post: The Records will be sorted according to movieReviewRating and then the GUI will be refreshed for the user to see the sorted array
 */	
public class whenUserClickMovieReviewButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Classes.sortArray(movieReviewRating );
			reloadArrayValuesToGUI();
		}
	}
	/* whenUserClicksResetDatabse function
	 * This function will reset the database and clear all the data.   
	 * Pre: when the user clicks the ResetDatabse button  
	 * Post: the records will be Reset and the GUI will be refreshed for the user to see the sorted array 
	 */	
public class whenUserClicksResetDatabse implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			Classes.ResetRecords();
			reloadArrayValuesToGUI();
		}
	}
	/* whenUserClickSearchButton function
	 * The will let the user search through records   
	 * Pre: when the user clicks the Search button
	 * Post: the records will be searched based on the parameters entered and the GUI will be refreshed for the user to see the sorted array
	 */	
public class whenUserClickSearchButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//This if statement prevents the the program from searching the records when no parameters had been entered( because that would be pointless)
			if(
					((searchTextfield[0].getText().equalsIgnoreCase("enter Search Parameter"))||(searchTextfield[0].getText().equalsIgnoreCase("")))&&
					((searchTextfield[1].getText().equalsIgnoreCase("enter Search Parameter"))||(searchTextfield[1].getText().equalsIgnoreCase("")))&&
					((searchTextfield[2].getText().equalsIgnoreCase("enter Search Parameter"))||(searchTextfield[2].getText().equalsIgnoreCase("")))&&
					((searchTextfield[3].getText().equalsIgnoreCase("enter Search Parameter"))||(searchTextfield[3].getText().equalsIgnoreCase("")))&&
					((searchTextfield[4].getText().equalsIgnoreCase("enter Search Parameter"))||(searchTextfield[4].getText().equalsIgnoreCase("")))&&
					((searchTextfield[5].getText().equalsIgnoreCase("enter Search Parameter"))||(searchTextfield[5].getText().equalsIgnoreCase("")))&&
					((searchTextfield[6].getText().equalsIgnoreCase("enter Search Parameter"))||(searchTextfield[6].getText().equalsIgnoreCase("")))
			)
			{				
			}
			//If a search parameters has been entered, then the records will be searched, reloaded back to the GUI, and the buttons will be disabled. 
			// The buttons are disabled because it is one of the limitations of the program
			else
			{
				Classes.search();
				Classes.makeSearchArrayIndexesLookNicer();
				reloadArrayValuesToGUI();
				Classes.EnableSortButtons(false);
			}

		}
	}
	/* whenUserClickClearParametersButton function
	 * This function allows a user to search through records through the use of the search parameters   
	 * Pre: When the user clicks the ClearParameters Button  
	 * Post: All the parameters for the search will be cleared, and the Sort button will be enabled. The Gui will also be refreshed 
	 */	
public class whenUserClickClearParametersButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// The searchTextfields will be reset
			for (int i = 0; i<7; i++)
			{
				searchTextfield[i].setText("enter Search Parameter");
			}
			// arrayIndexes will be reset
			Classes.resetArrayIndexes();
			reloadArrayValuesToGUI();
			//the sorting buttons will be enabled again
			Classes.EnableSortButtons(true);
		}
	}
	/* helpMenu function
	 * This allows a user to read isntructions when they can't figure out hot to use the program   
	 * Pre: This class is run when the helpfunction is initiated which is when the user clicks the help button  
	 * Post: This class open up instructions 
	 */	
public static class helpMenu extends JFrame{
		//=================================== This class is run when the helpfunction is initiated which is when the user clicks the help button
		//=================================== This class opens up Instructions

		//----------------------------------------- introduces all of the GUI components
		private JFrame helpFrame;
		private JPanel helpMenuPanel;
		private JButton back;		
		private JScrollPane Scroll;
		private JTextArea TextArea;

		public helpMenu(){			
			helpMenuPanel = new JPanel();
			back = new JButton();
			back = new JButton("back");
			//----------------------------------------- The instructions that will be displayed
			String str = new String (
					"MOVIE DATABASE\n" + 
					"This program is to allow you to personally keep track of movies \n" + 
					"This functionalities of this database are\n" + 
					"- Adding a new record\n" + 
					"- Editing a record\n" + 
					"- Deleting a record\n" + 
					"- Sorting records\n" + 
					"- Searching records\n" + 
					"- Saving and Loading the data of the database\n" + 
					"\n" + 
					"To make a NEW RECORD\n" +  
					"Click ‘new record’ on the top left of the screen\n" + 
					"a new window will pop up where you can fill in information about the movie.\n" + 
					"Make sure to fill in the name of the movie, this is the piece of information that MUST be filled in\n" + 
					"\n" + 
					"To EDIT A RECORD\n" + 
					"\n" + 
					"Click ‘edit record’ on the top left of the screen\n" + 
					"A window will appear where you can enter the ID Number of the record you want to edit.\n" + 
					"Another window will appear with the information of that record. At this point, you can begin editing\n" +  
					"the information of that record\n" + 
					"\n" + 
					"To DELETE RECORD\n" + 
					"\n" + 
					"Click 'delete record’ on the top left of the screen\n" + 
					"A Window will appear where you can enter the ID Number of the record you want to delete\n" + 
					"After entering the ID Number of the record you want to delete, you can press okay and that record will\n" +  
					"be deleted\n" + 
					"\n" + 
					"To SORT RECORDS\n" + 
					"\n" + 
					"The column name of each field is also a Button.\n" +  
					"By pressing any of the column labels, you sort the records by the label you clicked\n" +
					"e.g. if you want to sort the records by release year, you would click the release year header\n"+
					"\n" + 
					"NOTE: If you have searched through records and want to sort the records again, you have to click the\n" +  
					"“Clear Parameters button”. This will allow you to see all the records again and allow the sort\n" +  
					"functions to work again.\n" + 
					"\n" + 
					"To SEARCH RECORDS\n" + 
					"\n" + 
					"There is a text field above each field name. Over the field you can type in what you want to search\n" +  
					"for in that field. e.g. if you wanted to search for movies that were made in 1999, you would type 1999\n" +
					"in the textfield above release year\n" +
					"Afterwards, click the Search Button and the program will return all of the records\n" +  
					"that match your search.\n" +
					"\n" +
					"This search is also capable of searching with multiple parameters,e.g. if you wanted to search for movies \n" +
					"with the word 'the' in it, that also have a movie rating of R, you would type in 'the' in the textfield \n" +
					"above the moviename header and a 'R' in the textfield above movie rating. After clicking search This will \n" +
					"return all movies rated R with a 'the' in the name of its movie"
					);
			TextArea = new JTextArea(str,35,55);// sets up the text area where the intructions will be
			TextArea.setEditable(false);
			Scroll = new JScrollPane(TextArea);	//set up the text area so that you can scroll up and down it
			Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			//----------------------------------------- adds the components to the Panel
			helpMenuPanel.add(Scroll);
			helpMenuPanel.add(back);
			helpFrame = new JFrame("HELP");

			back.addActionListener(new ActionListener() {
				/* back
				 * the method will make the instructions window invisible as if the user exit out of it
				 * Pre: the user clicks back in the instructions window
				 * Post: the instructions window will become invisible
				 */
				public void actionPerformed(ActionEvent e)
				{
					//this is executed when the button is pressed
					helpFrame.setVisible(false);
				}
			});
			helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//frame.setResizable(false);
			helpFrame.add(helpMenuPanel);
			//frame.setSize(200, 300);
			helpFrame.setVisible(true);
			helpFrame.pack();
		}
	}
	/* reloadArrayValuesToGUI function
	 * This is run whenever the program is required to refresh the data to the GUI   
	 * Pre: The program has to have just finished any sort of function including delete, new record, edit record, sort record, search record, cear parmeters, reset records  
	 * Post: The updated array values will be shown on the GUI 
	 */	
public static void reloadArrayValuesToGUI()
	{
		//System.out.println("reloadArrayValuesToGUI has been initiated");
		for (int x = 0; x < 7; x ++)
		{
			for (int y = 0; y < 100; y ++)
			{
				switch (x) {
				case 0:  
					if ((arrayIndexes[y] == 999)||(IDNumber[arrayIndexes[y]] == -1))
					{
						indexes[y].setText("");
					}
					else
					{
						indexes[y].setText(Integer.toString(IDNumber[arrayIndexes[y]]));
					}
					break;
				case 1:  
					if ((arrayIndexes[y] == 999)||(movieName[arrayIndexes[y]].equals("null") == true))
					{
						textfield[x-1][y].setText("");
					}
					else
					{
						textfield[x-1][y].setText(movieName[arrayIndexes[y]]);
					}
					break;
				case 2:  
					if ((arrayIndexes[y] == 999)||(movieLength [arrayIndexes[y]]==-1 ))
					{
						textfield[x-1][y].setText("");
					}
					else
					{
						textfield[x-1][y].setText(Integer.toString(movieLength [arrayIndexes[y]]) + " minutes");
					}
					break;
				case 3:  
					if ((arrayIndexes[y] == 999)||(movieDirector [arrayIndexes[y]].equals("null") == true))
					{
						textfield[x-1][y].setText("");
					}
					else
					{
						textfield[x-1][y].setText(movieDirector [arrayIndexes[y]]);
					}					
					break;
				case 4:
					if ((arrayIndexes[y] == 999)||(movieRating [arrayIndexes[y]].equals("null") == true)||(movieRating [arrayIndexes[y]].equals("N/A") == true))
					{
						textfield[x-1][y].setText("");
					}
					else
					{
						textfield[x-1][y].setText(movieRating [arrayIndexes[y]]);
					}	
					break;
				case 5:
					if ((arrayIndexes[y] == 999)||(movieReleaseYear [arrayIndexes[y]]==-1 ))
					{
						textfield[x-1][y].setText("");
					}
					else
					{
						textfield[x-1][y].setText(Integer.toString(movieReleaseYear[arrayIndexes[y]]));
					}	
					break;
				case 6:
					if ((arrayIndexes[y] == 999)||(movieReviewRating[arrayIndexes[y]]==-0.1 ))
					{
						textfield[x-1][y].setText("");
					}
					else
					{
						textfield[x-1][y].setText(Double.toString(movieReviewRating[arrayIndexes[y]]));
					}
					break;
				}
			}
		}
	}
	/* main function
	 * This function initiates the GUI which is the start of the program   
	 * Pre: User must start the program  
	 * Post: Program will have started. After program has run, data will have been saved into the textfiles (as save files) 
	 */	
public static void main(String[]args){
		//Classes.createOrResetNewRecords();
		new GUI();
	}
}
