package EveryClass;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import EveryClass.GUI.whenUserClickIDNumberButton;
import EveryClass.GUI.whenUserClickMovieDirectorButton;
import EveryClass.GUI.whenUserClickMovieLengthButton;
import EveryClass.GUI.whenUserClickMovieNameButton;
import EveryClass.GUI.whenUserClickMovieRatingButton;
import EveryClass.GUI.whenUserClickMovieReleaseYearButton;

/*
 *Classes is a Class that stores many methods that are used in the running of the Movie Database Program
 *Some methods that are included in loading data, reseting data, sorting records, and searching through records
 */

public class Classes {
	/* LoadData Function 
	 * This method is run when the program needs to load the arrays from the savefiles
	 * Pre: The program must be initiated(this is the only time that the data needs to be loaded)
	 * Post: The data will be loaded from the savefiles
	 */
	public static void LoadData() {

		try {
			//======================================= the program loads the data from the savefile on savefile at a time
			
			//======================================= since all of the syntax for loading each savefile is the same, I will olny comment on one of them
			
			FileReader fr= new FileReader("saveDataIDNumber.txt"); 	// a new filereader is declared which will read from the saveDataIDNumber.txt 
			Scanner src= new Scanner(fr);							// A scanner is declared which will let it read from the specified save file
			for (int k = 0; k<100; k++) 
			{
				GUI.IDNumber[k] = src.nextInt();					// Now each index of the array can be read from each line of the savefile 
			}
			fr= new FileReader("saveDatamovieName.txt");
			src= new Scanner(fr);
			for (int k = 0; k<100; k++) 
			{				
				GUI.movieName[k] = src.nextLine();
			}
			fr= new FileReader("saveDatamovieLength.txt");
			src= new Scanner(fr);
			for (int k = 0; k<100; k++) 
			{		
				GUI.movieLength[k] = src.nextInt();
			}
			fr= new FileReader("saveDatamovieDirector.txt");
			src= new Scanner(fr);
			for (int k = 0; k<100; k++) 
			{				
				GUI.movieDirector[k]=src.nextLine();
			}
			fr= new FileReader("saveDatamovieRating.txt");
			src= new Scanner(fr);
			for (int k = 0; k<100; k++) 
			{				
				GUI.movieRating[k] = src.nextLine();
			}
			fr= new FileReader("saveDatamovieReleaseYear.txt");
			src= new Scanner(fr);
			for (int k = 0; k<100; k++) 
			{				
				GUI.movieReleaseYear[k] = src.nextInt();
			}
			fr= new FileReader("saveDatamovieReviewRating.txt");
			src= new Scanner(fr);
			for (int k = 0; k<100; k++) 
			{				
				GUI.movieReviewRating[k] = src.nextDouble();
			}
			fr= new FileReader("IDNumberAndIndexNumber.txt");
			src= new Scanner(fr);
			GUI.lastIndexNumber = src.nextInt();
			GUI.lastIDNumber = src.nextInt();
			src.close();
		}
		catch (Exception e) {System.out.println("Exception at: "+e);}	
	}
	/* createOrResetNewRecordsTextFile Function
	 * This method is used for debugging purposes, it will manually reset all the textfiles so that they are blank
	 * Pre: When there is a bug in the program that alters the savefiles, this can be used to reset the textfiles
	 * Post: The savefiles will be reset to a blank states
	 */
	public static void createOrResetNewRecordsTextFile()
	{
		//======================================= Since the syntax for reseting each savefiles is the same, I will only comment on one of them
		try {				
			FileWriter outFile = new FileWriter("saveDataIDNumber.txt");//a fileWriter is created that is directed to the savefile that is being reset (in this case it is saveDataIDNumber)
			PrintWriter out = new PrintWriter(outFile);					//a printWriter is created that is directed the the FileWriter (meaning it will write to the sepcified save file)
			for (int y = 0; y < 100; y ++)
			{
				out.write("-1 \r\n");									//now, new values can be written to the savefile ( in the case of IDNumber, -1 means a blank record
			}
			out.close();												//closes the fileWriter which end any printing to that savefile
			outFile = new FileWriter("saveDatamovieName.txt");
			out = new PrintWriter(outFile);	
			for (int y = 0; y < 100; y ++)
			{
				out.write("null"+ "\r\n");
			}
			out.close();				
			outFile = new FileWriter("saveDatamovieLength.txt");
			out = new PrintWriter(outFile);
			for (int y = 0; y < 100; y ++)
			{
				out.write("-1"+ "\r\n");
			}
			out.close();				
			outFile = new FileWriter("saveDatamovieDirector.txt");
			out = new PrintWriter(outFile);
			for (int y = 0; y < 100; y ++)
			{
				out.write("null"+ "\r\n");
			}
			out.close();				
			outFile = new FileWriter("saveDatamovieRating.txt");
			out = new PrintWriter(outFile);	
			for (int y = 0; y < 100; y ++)
			{
				out.write("null"+ "\r\n");
			}
			out.close();				
			outFile = new FileWriter("saveDatamovieReleaseYear.txt");
			out = new PrintWriter(outFile);
			for (int y = 0; y < 100; y ++)
			{
				out.write( "-1" + "\r\n");
			}		
			out.close();
			outFile = new FileWriter("saveDatamovieReviewRating.txt");
			out = new PrintWriter(outFile);	
			for (int y = 0; y < 100; y ++)
			{
				out.write("-0.1" + "\r\n");
			}
			out.close();
			outFile = new FileWriter("IDNumberAndIndexNumber.txt");
			out = new PrintWriter(outFile);	
			out.write("-1"+ "\r\n");
			out.write("0");
			outFile.close();
			//System.out.println("records have been created/reset");
		} 
		catch (Exception error){										
			System.out.println("ERROR : " + error);
			//System.out.println("The System could not create/reset the records");
		}
	}
	/* ResetRecords Function
	 * This method is used for when the user wants to reset/clear the values of the records
	 * Pre: When the whenUserClicksResetDatabse method is run which is when the user clicks the Reset Database button
	 * Post: The array values will be reset to a values that represents blank field
	 */
	public static void ResetRecords()
	{

		for (int y = 0; y < 100; y ++)
		{
			GUI.IDNumber[y] = -1;
			GUI.movieName[y] = "null";
			GUI.movieLength[y] = -1;
			GUI.movieDirector[y] = "null";
			GUI.movieRating[y] = "null";
			GUI.movieReleaseYear[y] = -1;
			GUI.movieReviewRating[y]= -0.1;
		}
		GUI.lastIndexNumber = -1;
		GUI.lastIDNumber = 0;

		System.out.println("records have been created/reset");
	} 		
	/* sortArray Function (int array)
	 * This sortAttay function is used whenever an integer array needs to be sorted
	 * Pre: The ID#, Movie Length or the Movie Release Year must be clicked to innitiate this function
	 * Post: The integer array will be sorted by increasing order
	 */
	public static int[] sortArray (int arrayToBeSorted[])
	{
		int storagePlaceForSwitchingNumbers;		
		int lastIndexOfRecordToBeExchanged = 0;
		//======================================== This portion of the sort places indexes that are not blank to the near the top of the array ArrayIndexes. 
		//======================================== This makes the search results look nicer
		for(int x=0; x<100; x++)
		{
			if (arrayToBeSorted[GUI.arrayIndexes[x]]!=-1)
			{
				storagePlaceForSwitchingNumbers = GUI.arrayIndexes[x];
				GUI.arrayIndexes[x] = GUI.arrayIndexes[lastIndexOfRecordToBeExchanged];
				GUI.arrayIndexes[lastIndexOfRecordToBeExchanged] = storagePlaceForSwitchingNumbers;
				lastIndexOfRecordToBeExchanged += 1;				
			}			
		}		
		//======================================== This sorts the a integer array by increasing order. It also places blank records at the back of the ArrayIndexes
		//======================================== This is Selection Sort btw
		for(int x=0; x<100; x++)
		{
			for(int y=x; y<100; y++)
			{
				if((arrayToBeSorted[GUI.arrayIndexes[y]]) < (arrayToBeSorted[GUI.arrayIndexes[x]])&&(arrayToBeSorted[GUI.arrayIndexes[y]]!=-1))
					//finds which array is the next smallest so that it can switch with the bottom index.
					// checks if the array value is blank
				{
					storagePlaceForSwitchingNumbers = GUI.arrayIndexes[x];
					GUI.arrayIndexes[x] = GUI.arrayIndexes[y];
					GUI.arrayIndexes[y] = storagePlaceForSwitchingNumbers;
				}
			}
		}	

		return arrayToBeSorted;
	}
	/* sortArray Function (Double array)
	 * This sortAttay function is used whenever an Double array needs to be sorted
	 * Pre: The Movie Review Rating must be clicked to innitiate this function
	 * Post: The double array will be sorted by increasing order
	 */
	public static double[] sortArray (double arrayToBeSorted[])
	{
		//======================================== This sorts the a Double array by increasing order. It also places blank records at the back of the ArrayIndexes
		//======================================== This is Selection Sort btw
		int storagePlaceForSwitchingNumbers;
		for(int x=0; x<100; x++)
		{
			for(int y=x; y<100; y++)
			{
				if((arrayToBeSorted[GUI.arrayIndexes[y]]) < (arrayToBeSorted[GUI.arrayIndexes[x]])&&(arrayToBeSorted[GUI.arrayIndexes[y]]!=-0.1))
					//finds which array is the next smallest so that it can switch with the bottom index.
					// checks if the array value is blank
				{
					storagePlaceForSwitchingNumbers = GUI.arrayIndexes[x];
					GUI.arrayIndexes[x] = GUI.arrayIndexes[y];
					GUI.arrayIndexes[y] = storagePlaceForSwitchingNumbers;
				}
			}
		}	
		return arrayToBeSorted;
	}
	/* sortArray Function (String array)
	 * This sortAttay function is used whenever a String array needs to be sorted
	 * Pre: The Movie Name,or Movie Director must be clicked to innitiate this function
	 * Post: The String array will be sorted by increasing alphabetical order (a will be at the top of the list while z is at the bottom of the list)
	 */
	public static String[] sortArray (String arrayToBeSorted[])
	{
		int storagePlaceForSwitchingNumbers;
		int lastIndexOfRecordToBeExchanged = 0;
		//======================================== This portion of the sort places indexes that are not blank to the near the top of the array ArrayIndexes. 
		//======================================== This makes the search results look nicer
		for(int x=0; x<100; x++)
		{
			if (arrayToBeSorted[GUI.arrayIndexes[x]].equalsIgnoreCase("null")==false)
			{
				storagePlaceForSwitchingNumbers = GUI.arrayIndexes[x];
				GUI.arrayIndexes[x] = GUI.arrayIndexes[lastIndexOfRecordToBeExchanged];
				GUI.arrayIndexes[lastIndexOfRecordToBeExchanged] = storagePlaceForSwitchingNumbers;
				lastIndexOfRecordToBeExchanged += 1;				
			}			
		}
		//======================================== This sorts the integer array by increasing alphabetical order. It also places blank records at the back of the ArrayIndexes
		//======================================== This is Selection Sort btw
		for(int x=0; x<100; x++)
		{
			for(int y=x; y<100; y++)
			{
				//while ((x!=0) && ((arrayToBeSorted[GUI.arrayIndexes[x]]).compareToIgnoreCase(arrayToBeSorted[GUI.arrayIndexes[x-1]])) < -1)
				if(
						(arrayToBeSorted[GUI.arrayIndexes[x]]).compareTo(arrayToBeSorted[GUI.arrayIndexes[y]]) > 0	//compares two array indexes to check which one if greater lexicographically
						&&
						(arrayToBeSorted[GUI.arrayIndexes[y]].equalsIgnoreCase("null"))==false						//checks if array value is blank
				)
				{
					storagePlaceForSwitchingNumbers = GUI.arrayIndexes[x];
					GUI.arrayIndexes[x] = GUI.arrayIndexes[y];
					GUI.arrayIndexes[y] = storagePlaceForSwitchingNumbers;
				}
			}
		}	
		return arrayToBeSorted;
	}
	/* sortArrayMovieRating Function (String array)
	 * This sortAttay function is used whenever a movie Rating array needs to be sorted.
	 * What is special about this sort is that it ignores ("N/A") as one of the blank results (because that means "N/A" must be treated as if it were a blank array value
	 * Pre: movie Rating must be clicked to innitiate this function
	 * Post: the movie Rating array will be sorted by increasing alphabetical order (a will be at the top of the list while z is at the bottom of the list)
	 */
	public static String[] sortArrayMovieRating (String arrayToBeSorted[])
	{
		//======================================== This portion of the sort places indexes that are not blank near the top of the array ArrayIndexes. 
		//======================================== This makes the search results look nicer
		int storagePlaceForSwitchingNumbers;
		int lastIndexOfRecordToBeExchanged = 0;
		for(int x=0; x<100; x++)
		{
			if (
					(arrayToBeSorted[GUI.arrayIndexes[x]].equalsIgnoreCase("null")==false)&&
					(arrayToBeSorted[GUI.arrayIndexes[x]].equalsIgnoreCase("N/A")==false))
			{
				storagePlaceForSwitchingNumbers = GUI.arrayIndexes[x];
				GUI.arrayIndexes[x] = GUI.arrayIndexes[lastIndexOfRecordToBeExchanged];
				GUI.arrayIndexes[lastIndexOfRecordToBeExchanged] = storagePlaceForSwitchingNumbers;
				lastIndexOfRecordToBeExchanged += 1;				
			}			
		}
		//======================================== This sorts the MovieRating array by increasing alphabetical order. It also places blank records at the back of the ArrayIndexes
		//======================================== This is Selection Sort btw
		for(int x=0; x<100; x++)
		{
			for(int y=x; y<100; y++)
			{
				//while ((x!=0) && ((arrayToBeSorted[GUI.arrayIndexes[x]]).compareToIgnoreCase(arrayToBeSorted[GUI.arrayIndexes[x-1]])) < -1)
				if(
						(arrayToBeSorted[GUI.arrayIndexes[x]]).compareTo(arrayToBeSorted[GUI.arrayIndexes[y]]) > 1
						&&
						(arrayToBeSorted[GUI.arrayIndexes[y]].equalsIgnoreCase("null"))==false
						&&
						(arrayToBeSorted[GUI.arrayIndexes[y]].equalsIgnoreCase("N/A"))==false
				)
				{
					storagePlaceForSwitchingNumbers = GUI.arrayIndexes[x];
					GUI.arrayIndexes[x] = GUI.arrayIndexes[y];
					GUI.arrayIndexes[y] = storagePlaceForSwitchingNumbers;
				}
			}
		}	
		return arrayToBeSorted;
	}
	/* makeSearchArrayIndexesLookNicer Function 
	 * This method organizes results after a search so that all the results are at the top of the apge
	 * Pre: The whenUserClickSearchButton method must have been initiated 
	 * Post: the movie Rating array will be sorted by increasing alphabetical order (a will be at the top of the list while z is at the bottom of the list)
	 */
	public static void makeSearchArrayIndexesLookNicer ()
	{
		int storagePlaceForSwitchingNumbers;
		int lastIndexOfRecordToBeExchanged = 0;
		// This will place any arrayIndex value with a value of 999 to the top of bottom of the array
		for(int x=0; x<100; x++)
		{
			//if (arrayToBeSorted[GUI.arrayIndexes[x]].equalsIgnoreCase("null")==false)
			if (GUI.arrayIndexes[x] != 999)
			{
				storagePlaceForSwitchingNumbers = GUI.arrayIndexes[x];
				GUI.arrayIndexes[x] = GUI.arrayIndexes[lastIndexOfRecordToBeExchanged];
				GUI.arrayIndexes[lastIndexOfRecordToBeExchanged] = storagePlaceForSwitchingNumbers;
				lastIndexOfRecordToBeExchanged += 1;				
			}			
		}

	}	
	/* EnableSortButtons
	 * This function enables or disables the search buttons so that they can not be pressed. This is useful for when the user is using search. 
	 * Search prevents a proper sort from happening, and hence, a function that enables or disables the sort buttons
	 * Pre: user must clock the search button or clear parameters  button. This will initiate the whenUserClickSearchButton function which will activate this  
	 * Post: The sort buttons will be enabled or disabled according to what the value of the boolean parameter is
	 */
	public static void EnableSortButtons (Boolean ifSortButtonsShouldWork)
	{
		GUI.fieldNames[0].setEnabled(ifSortButtonsShouldWork);
		GUI.fieldNames[1].setEnabled(ifSortButtonsShouldWork);
		GUI.fieldNames[2].setEnabled(ifSortButtonsShouldWork);
		GUI.fieldNames[3].setEnabled(ifSortButtonsShouldWork);
		GUI.fieldNames[4].setEnabled(ifSortButtonsShouldWork);
		GUI.fieldNames[5].setEnabled(ifSortButtonsShouldWork);
		GUI.fieldNames[6].setEnabled(ifSortButtonsShouldWork);

	}	
	/* resetArrayIndexes function
	 * This function will reset the arrayIndexValues in the order of IDNumber. This also allows the Sort function to function properly again 
	 * Pre: clearParamter button must be pressed which initiates This function  
	 * Post: The arrayIndexes array will be reset from 0-99
	 */
	public static void resetArrayIndexes ()
	{
		for(int i = 0; i < 100; i++)
		{
			GUI.arrayIndexes[i] = i;
		}
	}
	/* search function
	 * This function will search the records based on the search parameters that were entered 
	 * Pre: Search parameters must have been entered  
	 * Post: arrayIndexes will be changed so that records do not fit the search will be set to 999 while nothing happens to the records that do fit 
	 */
	public static void search ()
	{
		//===========================================This will reset array indexes in case the user had done a previous 
		//===========================================search (which would prevent the search function from doing a complete search)
		
		resetArrayIndexes();
		//=========================================== This will retrieve all the search parameters that the user entered
		String searchParameterIDNumber = GUI.searchTextfield[0].getText();
		String searchParametermovieName = GUI.searchTextfield[1].getText();
		String searchParametermovieLength = GUI.searchTextfield[2].getText();
		String searchParametermovieDirector = GUI.searchTextfield[3].getText();
		String searchParametermovieRating = GUI.searchTextfield[4].getText();
		String searchParametermovieReleaseYear = GUI.searchTextfield[5].getText();
		String searchParametermovieReviewRating = GUI.searchTextfield[6].getText();
		/*
		System.out.println(GUI.searchParameterIDNumber);
		System.out.println(GUI.searchParametermovieName);
		System.out.println(GUI.searchParametermovieLength);
		System.out.println(GUI.searchParametermovieDirector);
		System.out.println(GUI.searchParametermovieRating);
		System.out.println(GUI.searchParametermovieReleaseYear);
		System.out.println(GUI.searchParametermovieReviewRating);

		System.out.println(Integer.toString(GUI.IDNumber[GUI.arrayIndexes[0]]));
		System.out.println((GUI.movieName[GUI.arrayIndexes[0]]));
		System.out.println(Integer.toString(GUI.movieLength[GUI.arrayIndexes[0]]));
		System.out.println((GUI.movieDirector[GUI.arrayIndexes[0]]));
		System.out.println((GUI.movieRating[GUI.arrayIndexes[0]]));
		System.out.println(Integer.toString(GUI.movieReleaseYear[GUI.arrayIndexes[0]]));
		System.out.println(Double.toString(GUI.movieReviewRating[GUI.arrayIndexes[0]]));*/
		for (int i = 0; i <100; i++)
		{
			//=========================================== This will check if the record that is being searched is blank
			if ((GUI.IDNumber[GUI.arrayIndexes[i]] == -1)
					&&(GUI.movieName[GUI.arrayIndexes[i]].equals("null"))
					&&(GUI.movieLength[GUI.arrayIndexes[i]] == -1)
					&&(GUI.movieDirector[GUI.arrayIndexes[i]].equals("null"))
					&&(GUI.movieRating[GUI.arrayIndexes[i]].equals("null"))
					&&(GUI.movieReleaseYear[GUI.arrayIndexes[i]] == -1)
					&&(GUI.movieReviewRating[GUI.arrayIndexes[i]] == -0.1))
			{
				//System.out.println(i + "Blank Record");
				//GUI.arrayIndexes[i] = 999;
			}
			else
			{
				//System.out.println(GUI.arrayIndexes[i]);
				// This will check if the IDNumber search parameter that was entered 
				// is blank of if it matches the IDNumber arrayvalue 
				if 
				(
						searchParameterIDNumber.equalsIgnoreCase(Integer.toString(GUI.IDNumber[GUI.arrayIndexes[i]])) == false
						//&& (GUI.IDNumber[GUI.arrayIndexes[i]] != 0)
						&&(searchParameterIDNumber.equalsIgnoreCase("enter Search Parameter") == false)
						&&(searchParameterIDNumber.equals("") == false)

				)
				{
					GUI.arrayIndexes[i] = 999;
					//System.out.println(0);
				}
				else{
					if
					// This will check if the movieName search parameter that was entered 
					//is blank of if it matches the movieName arrayvalue 
					(
							(GUI.movieName[GUI.arrayIndexes[i]].toLowerCase()).indexOf(searchParametermovieName.toLowerCase()) == -1
							//&&(GUI.movieName[GUI.arrayIndexes[i]] != "") 							 
							&&(searchParametermovieName.equalsIgnoreCase("enter Search Parameter") == false)
							&&(searchParametermovieName.equals("") == false)
					)
					{
						GUI.arrayIndexes[i] = 999;
						//System.out.println(1);
					}
					else{
						// This will check if the movieLength search parameter that was entered 
						//is blank of if it matches the movieLength arrayvalue 
						if 
						(
								((Integer.toString(GUI.movieLength[GUI.arrayIndexes[i]]).toLowerCase()).indexOf(searchParametermovieLength.toLowerCase()) == -1)
								//&& (GUI.movieLength[GUI.arrayIndexes[i]] != 0)
								&& (searchParametermovieLength.equalsIgnoreCase("enter Search Parameter") == false)
								&&(searchParametermovieLength.equals("") == false)
						)
						{
							GUI.arrayIndexes[i] = 999;
							//System.out.println(2);
						}
						else{
							if 
							//This will check if the movieDirector search parameter that was entered 
							//is blank of if it matches the movieDirector arrayvalue 
							((((GUI.movieDirector[GUI.arrayIndexes[i]]).toLowerCase()).indexOf(searchParametermovieDirector.toLowerCase()) == -1)
									//&& (GUI.movieDirector[GUI.arrayIndexes[i]] != "")
									&& (searchParametermovieDirector.equalsIgnoreCase("enter Search Parameter") == false)
									&&(searchParametermovieDirector.equals("") == false)
							)

							{
								GUI.arrayIndexes[i] = 999;
								//System.out.println(3);
							}
							else{
								//This will check if the the movieRating search parameter that was entered 
								//is blank of if it matches the movieRating arrayvalue 
								if (
										((GUI.movieRating[GUI.arrayIndexes[i]]).toLowerCase().contains(searchParametermovieRating.toLowerCase()) == false)
										//&& (GUI.movieRating[GUI.arrayIndexes[i]]!= "")
										&& (searchParametermovieRating.equalsIgnoreCase("enter Search Parameter") == false)
										&&(searchParametermovieRating.equals("") == false)
								)
								{
									GUI.arrayIndexes[i] = 999;
									//System.out.println(4);
								}
								else{
									// This will check if the the movieReleaseYear search parameter that was entered 
									//is blank of if it matches the movieReleaseYear arrayvalue 
									if (
											((Integer.toString(GUI.movieReleaseYear[GUI.arrayIndexes[i]]).toLowerCase()).indexOf(searchParametermovieReleaseYear.toLowerCase()) == -1)
											//&& (GUI.movieReleaseYear[GUI.arrayIndexes[i]] != 0)
											&& (searchParametermovieReleaseYear.equalsIgnoreCase("enter Search Parameter") == false)
											&&(searchParametermovieReleaseYear.equals("") == false)
									)
									{
										GUI.arrayIndexes[i] = 999;
										//System.out.println(5);
									}
									else{
										//This will check if the the movieReviewRating search parameter that was entered 
										//is blank of if it matches the movieReviewRating arrayvalue 
										if (
												(Double.toString(GUI.movieReviewRating[GUI.arrayIndexes[i]]).indexOf(searchParametermovieReviewRating) == -1)
												//&& (GUI.movieReviewRating[GUI.arrayIndexes[i]] != -0.1)
												&& (searchParametermovieReviewRating.equalsIgnoreCase("enter Search Parameter") == false)
												&&(searchParametermovieReviewRating.equals("") == false)
										)
										{
											GUI.arrayIndexes[i] = 999;
											//System.out.println(6);
										}
										else
										{
											//System.out.println(GUI.arrayIndexes[i]+ "has passed");
										}
									}}}}}}}
		}
	}
}

