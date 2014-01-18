package EveryClass;

public class Testing_Stuff
{
	public static int findLastIndexNumber()
	{
		int lastIndexNumber=0;
		//System.out.println("GUI.IDNumber[99] = " + GUI.IDNumber[99]);
		if (GUI.IDNumber[99] == 999)
		{
			if (GUI.IDNumber[0] == 999)
			{
				lastIndexNumber = 0;
			}
			else 
			{
				//System.out.println("asdfasdfasdfasdf");
				while (GUI.IDNumber[lastIndexNumber+1] != 999)
				{
					lastIndexNumber+=1;
				}
				//lastIndexNumber+=1;
			}
		}
		else//GUI.IDNumber[0] != 999
		{
			System.out.println("asdfasdfasdfasdf");
			lastIndexNumber = 999;
		}		
		//System.out.println("lastIDNumber = " + lastIndexNumber);
		return (lastIndexNumber) ;
	}
	public static void main(String[]args)
	{
		{
			//System.out.println(findLastIndexNumber());
			String jason = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			Boolean b =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains("aBC");
			System.out.println(b);
		}
	}
}
