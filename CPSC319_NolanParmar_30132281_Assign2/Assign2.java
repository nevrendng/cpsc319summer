
	/** 
	@author Nolan Parmar <a
	href= "mailto: Nolan.parmar@ucalgary.ca">Nolan.parmar@ucalgary.ca</a>
	30132281 
	CPSC 319 
	Assignment 2
	*/ 

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;

public class Assign2
{
    public static void main(String[] args)throws IOException
		{
		   
			int size = Integer.parseInt(args[1]);
			if(size <= 0) //if the size inputted is a negative
			{
				System.out.println("Error, cannot have a negative size.");
				System.exit(0);

			}
			String order = args[0].toLowerCase();
			String algorithm = args[2].toLowerCase();
			String outputfile = args[3].toLowerCase();
			int[] array = new int[size]; 
			Sort sorting = new Sort();
			Order selection = new Order();
			array = selection.populateArray(size);
			
			if(order.equals("ascending")) //if ascending order is called
			 {
			   
				Order.acsArray(array); //creates a random integer array into ascending order
			   
			 }
			else if(order.equals("descending")) //if ascending order is called
			{
				
				Order.dscArray(array); //creates a random integer array into descending order
			   
				
			}
			else if(order.equals("random")) //if ascending order is called
			{
				
			} 
			
			if(algorithm.equals("selection")) //if statement for if seleciton is called
			{
				long startTime =  System.nanoTime();
				sorting.selectionSort(array);
				PrintWriter myWriter = new PrintWriter(outputfile + ".txt"); //creates the output file
				for(int i = 0; i < array.length; i++)
				{
					myWriter.println(array[i]); //prints the sorted array into the output file
				}
				myWriter.close();
				long timeElasped = System.nanoTime() - startTime;
			   double elapsedTime = (double)timeElasped /1_000_000_000; //converts the time from nano seconds to seconds
				System.out.println(elapsedTime + " seconds have elapsed.");
				
			}
			else if(algorithm.equals("insertion")) //else if statement for if insertion is called
			{
				long startTime =  System.nanoTime();
				sorting.insertionSort(array);
				PrintWriter myWriter = new PrintWriter(outputfile + ".txt"); //creates the output file
				for(int i = 0; i < array.length; i++)
				{
					myWriter.println(array[i]); //prints the sorted array into the output file
				}
				myWriter.close();
				long timeElasped = System.nanoTime() - startTime;
				double elapsedTime = (double)timeElasped /1_000_000_000; //converts the time from nano seconds to seconds
				System.out.println(elapsedTime  + " seconds have elapsed.");
				
				
			}
			else if(algorithm.equals("merge")) //else if statement for if merge is called 
			{
				long startTime =  System.nanoTime();    
				sorting.mergeSort(array,0, array.length - 1);
				PrintWriter myWriter = new PrintWriter(outputfile + ".txt"); //creates the output file
				for(int i = 0; i < array.length; i++)
				{
					myWriter.println(array[i]); //prints the sorted array into the output file 
				}
				myWriter.close();
				long timeElasped = System.nanoTime() - startTime;
				double elapsedTime = (double)timeElasped /1_000_000_000; //converts the time from nano seconds to seconds
				System.out.println(elapsedTime  + " seconds have elapsed."); 
				
				
			}
			else if(algorithm.equals("bubble")) //else if statement for if bubble is called
			{
				long startTime =  System.nanoTime();
				sorting.bubbleSort(array);
				PrintWriter myWriter = new PrintWriter(outputfile + ".txt"); //creates the output file
				for(int i = 0; i < array.length; i++)
				{
					myWriter.println(array[i]); //prints the sorted array into the output file
				}
				myWriter.close();
				long timeElasped = System.nanoTime() - startTime;
				double elapsedTime = (double)timeElasped /1_000_000_000; //converts the time from nano seconds to seconds
				System.out.println(elapsedTime  + " seconds have elapsed.");
				
				
			}

			

		}  
}