import java.util.Scanner;
 
public class DistributingSystem
{
 
    public static void main(String[] args) 
    {
        Scanner key = new Scanner(System.in) ;
        int no_cases = key.nextInt() ;
         
        while(true)
        {
            int INT = key.nextInt() ;
            int Exponent = key.nextInt() ;
            int sum = 1 ;
             
            for(int x=0 ; x<Exponent ; x++)
            {
                sum *= INT ;
                sum %= 10 ;
            }
             
            if (sum == 0) 
                System.out.println(10) ;
            else
                System.out.println(sum) ;
             
            no_cases-- ;
            if(no_cases == 0) break ;
             
        }
 
    }
 
}