/**
  @author Nolan Parmar <a
  href= "mailto: Nolan.parmar@ucalgary.ca">Nolan.parmar@ucalgary.ca</a>
  @version 1.1
  @since   1.0
  UCID: 30132281
 */


import java.io.*;
import java.util.*;

public class CPSC319S22A4
{
    public static File readFile()
	{
		while(true)
		{
			System.out.print("Please enter an input file name: ");
	        BufferedReader bfreader = new BufferedReader(new InputStreamReader(System.in));
	        String fileName = null;
			try {
				fileName = bfreader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("File name doesnt exist.");
			}
			File file = new File(fileName);
			
				if ((file.exists() && file.isFile())) 
				{
					return file;
				}
				else
				{
					System.err.println(fileName + " does not exist. Please enter a valid file name.");
				}
		}
	}
	
	public static void menu(BST list)
	{
		while(true)
		{
		    System.out.println("\n Please enter a number from 1-3 for which program you want to run");
            System.out.println("1. Search for list item");
            System.out.println("2. Display entire list");
            System.out.println("3. Quit(Terminate the program)");
		    Scanner userinput = new Scanner(System.in);
		    String input = userinput.nextLine();
		    int menu = Integer.parseInt(input);
		switch(menu)
			{
				case 1: //if they pick 1
					System.out.print("Please enter a word you are looking for: ");
					String name = userinput.nextLine();
					if(list.findWord(name) != -1)
					{
						System.out.println("Found! it appears " + list.findWord(name) + " times in the input text file.");
					}
					else
						System.out.println("Word not found!");
					
					break;
				case 2: //if they pick 2
						System.out.print("Please enter a traversal method: 1 = IN-ORDER, 2 = PRE-ORDER, 3 = POST-ORDER. ");
						String traversal = userinput.nextLine();
						traversal = traversal.toUpperCase();
						switch(traversal)
							{
								case "1":
									list.inOrderPrint();
									break;
								
								case "2":
									list.preOrderPrint();
									break;
									
								case "3":
									list.postOrderPrint();
									break;
									
								default:
									System.out.println("Invalid traversal method. Please try again.");
									break;
							}
					break;
				case 3:
					return;				
				default:
					System.err.println("Error: invalid menu access.");
					break;
			}
		}
	} 
	
    public static void populateTree(ArrayList<String> list, BST words) //creates the tree by adding the words in their specific order
	{
		for(int i = 0; i < list.size(); i++)
		{
			words.add(list.get(i));
		}
	}
	
	
	public static ArrayList<String> toStringArray(File file) throws IOException
	{
		String line  = null;
		String line2 = null;
		String line3 = null;
		String line4 = null;
		FileReader fReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fReader);
		ArrayList<String> list = new ArrayList<String>();
		while((line = reader.readLine()) != null)
		{
			if(line.length() > 0)
			{
				line2 = line.replace('-', ' ');
				line3 =line2.replaceAll("[^a-zA-Z0-9 \n]", "");
				line4 = line3.toLowerCase();
				for(String s:line4.split("\\s+"))
				{
					if(s!="")
					{
					list.add(s);
					}
				}
			}
		}
		reader.close();
		return list;
	}
	
	
	
	public static void main(String args[]) throws IOException
	{
		int Lfrequency;
		File inputFile = readFile();	
        BST words = new BST();
		ArrayList<String> list = toStringArray(inputFile);		
		populateTree(list,words);
		System.out.println("The total number of words in " + inputFile.toString() + " = " + words.countPreorder());
		System.out.println("Number of unique words in " + inputFile.toString() + " = " + words.uniquePreorder());
		Lfrequency = words.largestPreorder();
		System.out.println("The word(s) which occur(s) most often and the number of times that it/they occur(s) =");
		words.findLargest(Lfrequency);
		System.out.println("The maximum height of the tree = " + words.maximumDepth());
		menu(words);
		
	}
	
}