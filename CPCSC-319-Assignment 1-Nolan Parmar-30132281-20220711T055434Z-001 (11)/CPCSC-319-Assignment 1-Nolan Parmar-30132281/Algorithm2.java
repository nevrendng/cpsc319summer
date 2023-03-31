/**
  @author Nolan Parmar <a
  href= "mailto: Nolan.parmar@ucalgary.ca">Nolan.parmar@ucalgary.ca</a>
  @version 1.1
  @since   1.0
  UCID: 30132281
 */

import java.util.*;
//the following code has references from 
//https://www.javabrahman.com/gen-java-programs/recursive-fibonacci-in-java-with-memoization/
public class Algorithm2 
{
    public static long fibArray [] = new long[1000];
    public long fibMem(long n)
    {
        long fibVal;
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return 1;
        }
        else if(fibArray[(int) n] != 0)
        {
            return fibArray[(int) n];
        

        }
        else
        {
            fibVal = fibMem(n - 1) + fibMem(n - 2);
            fibArray[(int) n] = fibVal;
            return fibVal;
        }




    }
    
}
