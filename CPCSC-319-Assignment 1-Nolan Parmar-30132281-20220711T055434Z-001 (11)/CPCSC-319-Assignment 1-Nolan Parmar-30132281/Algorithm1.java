/**
  @author Nolan Parmar <a
  href= "mailto: Nolan.parmar@ucalgary.ca">Nolan.parmar@ucalgary.ca</a>
  @version 1.1
  @since   1.0
  UCID: 30132281
 */


public class Algorithm1
{
    public int fibRec(int n)
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
            return fibRec(n - 1) + fibRec(n - 2); 

        }

    }

}