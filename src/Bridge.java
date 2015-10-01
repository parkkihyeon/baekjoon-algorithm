import java.util.* ;
 
public class Bridge {
 
    public static void main(String[] args) 
    {
        Scanner key = new Scanner(System.in) ;
        int no_cases = key.nextInt() ;
         
        while(true)
        {
            int west = key.nextInt() ;
            int east = key.nextInt() ;          
            int [][]arr = new int[east+2][east+2] ;
             
            for (int x=0 ; x <= east+1 ; x++)
                for (int y=0 ; y<= east+1 ; y++)
                    arr[x][y] = 0 ;
             
            arr[1][1] = 1 ;
             
            for (int x = 2 ; x <= east+1 ; x++)
                for (int y = 1 ; y <= x ; y++)
                    arr[x][y] = arr[x-1][y-1]+arr[x-1][y] ;
 
            System.out.println(arr[east+1][west+1]);
             
            no_cases-- ;
            if(no_cases == 0) break ;
        }
 
    }
 
}