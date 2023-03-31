import java.io.IOException;
import java.util.*;
import java.io.*;

public class main 
{
    private static Algorithm1 algorithm1 = new Algorithm1(); 
    private static Algorithm2 algorithm2 = new Algorithm2();
    private static Algorithm3 algorithm3 = new Algorithm3();
    //helps reduce time disruptions so there can be a better read on the execution time 
    //even if it makes the time shorter when outputted the relationship is shown for the algorithms 
    private static int averagefactor =  95; 
    private static int result1, result2, result3 = 0;

    public static void main(String[] args)throws IOException
{
   int num = Integer.parseInt(args[0]);
   if(num <= 0)
   {
    System.out.println("cannot have a negative size.");
   }
   for(int i =0; i <= num; i++)
   {
    long startTime1 = System.nanoTime();
    
    for(int j = 0; j < averagefactor; j++)
    {
        result1 = (int) algorithm1.fibRec(i);
    }

    long timeElapsed1 = System.nanoTime() - startTime1;
    timeElapsed1 = timeElapsed1 / averagefactor;
    System.out.println(timeElapsed1 + "ns to compute f" + i +  " = " + result1 + " using Algorithm 1"); 
    }   
    System.out.println(" ");
    
   for(int i =0; i <= num; i++)
   {
    long startTime2 = System.nanoTime();
    
    for(int j = 0; j < averagefactor; j++)
    {
        result2 = (int) algorithm2.fibMem(i);
    }

    long timeElapsed2 = System.nanoTime() - startTime2;
    timeElapsed2 = timeElapsed2 / averagefactor;
    System.out.println(timeElapsed2 + "ns to compute f" + i +  " = " + result2 + " using Algorithm 2"); 
    }
    System.out.println(" ");
    for(int i =0; i <= num; i++)
   {
    long startTime3 = System.nanoTime();
    
    for(int j = 0; j < averagefactor; j++)
    {
        result3 = (int) algorithm3.fibIter(i);
    }

    long timeElapsed3 = System.nanoTime() - startTime3;
    timeElapsed3 = timeElapsed3 / averagefactor;
    System.out.println(timeElapsed3 + "ns to compute f" + i +  " = " + result3 + " using Algorithm 3"); 
    }
    
}

    
}
