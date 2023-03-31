/** 
	@author Nolan Parmar <a
	href= "mailto: Nolan.parmar@ucalgary.ca">Nolan.parmar@ucalgary.ca</a>
	30132281 
	CPSC 319 
	Assignment 2
*/

public class Order 
{
    public static void acsArray(int[] array) //orders the array into ascending order
    {
      for (int i = 0; i < array.length; i++)   
      {  
          for (int j = i + 1; j < array.length; j++)   
          {  
              int tmp = 0;  
              if (array[i] > array[j])   
              {  
                  tmp = array[i];  
                  array[i] = array[j];  
                  array[j] = tmp;  
              }  
          } 
      } 
    }
    public static void dscArray(int[] array) //orders the array into descending order 
    {
      int temp;
      for (int i = 0; i < array.length; i++)   
      {  
          for (int j = i + 1; j < array.length; j++)   
          {  
              if (array[i] < array[j])   
              {  
                  temp = array[i];  
                  array[i] = array[j];  
                  array[j] = temp;  
              }  
          }  
      } 
    }
    public int[] populateArray(int size) //Populates the array with random integers between 1 and 1000.
      {
          
          int[] intArray = new int[size];
          
          for(int i = 0; i < size; i++)
          {
              
              intArray[i] = (int)(Math.random()*1000) + 1;
              
              
          }
          return intArray;
      }
    
}
