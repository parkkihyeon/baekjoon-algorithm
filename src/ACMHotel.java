import java.util.* ;
 
public class ACMHotel
{
 
    public static void main(String[] args) 
    {
        Scanner key = new Scanner(System.in) ;
        int no_cases = key.nextInt() ;
         
        while(true)
        {
            int h = key.nextInt() ;
            int w = key.nextInt() ;
            int n = key.nextInt() ;
            int H = 0 , W = 0 ;
            int ncount = 0 ;
             
            int [][]arr = new int[h][w] ;
             
            for(int y=0 ;  y<w ; y++)
            {
                for(int x=h-1 ; x>=0 ; x--)
                {
                    ncount++ ;
                    arr[x][y] = ncount ;
                    if(ncount == n) 
                    {
                        H = h-x ;
                        W = y+1 ;
                        break ;
                    }
                }
                if(ncount == n) break ;
            }
             
            if( W < 10 )
                System.out.println(H+"0"+W) ;
            else
                System.out.println(H+""+W);
             
            no_cases-- ;
            if (no_cases == 0) break ;
        }
    }
 
}