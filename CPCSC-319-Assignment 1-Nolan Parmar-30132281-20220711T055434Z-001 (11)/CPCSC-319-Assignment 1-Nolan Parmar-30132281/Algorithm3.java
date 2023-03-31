/**
  @author Nolan Parmar <a
  href= "mailto: Nolan.parmar@ucalgary.ca">Nolan.parmar@ucalgary.ca</a>
  @version 1.1
  @since   1.0
  UCID: 30132281
 */
public class Algorithm3
{
    public int fibIter(int n)
    {
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return 1;
        }
        else
        {
            int fn_minus_1 = 1;
            int fn_minus_2 = 0;
            int fn_current = fn_minus_1 + fn_minus_2;
            
            for(int i = 2; i < n; i++)
            {
                fn_minus_2 = fn_minus_1;
                fn_minus_1 = fn_current;
                fn_current = fn_minus_1 + fn_minus_2;
            }
            return fn_current;

        }
    }

    
}
