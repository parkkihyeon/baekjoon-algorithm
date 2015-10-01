import java.util.Scanner;
 
public class baechoo
{
 
    public static void main(String[] args) 
    {
         
        Scanner key = new Scanner(System.in) ;
        int no_cases = key.nextInt() ;
         
        while(true)
        {
            int garo = key.nextInt() ;
            int sero = key.nextInt() ;
            int NumOfData = key.nextInt() ;
             
            algorithm baechoo = new algorithm(sero,garo) ;
             
            for (int x=0 ; x<NumOfData ; x++)
            {
                int a = key.nextInt() ;
                int b = key.nextInt() ;     
                baechoo.SetFarm(b,a);
            } // 
             
            System.out.println(baechoo.Counting()) ;
             
            no_cases-- ;
            if(no_cases == 0) break ;
        }
 
    }
 
}
 
class algorithm
{
    int count = 0 ;
    int [][]Farm ;
     
    public algorithm(int sero, int garo) // 클래스 초기화 하면서 팜과 테스트 2차원 배열을 
    {
        this.count = 0 ;
         
        Farm = new int[sero+1][garo+1] ;
         
        for(int i=0; i<sero; i++)
            for(int j=0; j<garo; j++)
            {
                Farm[i][j] = 0 ;
            }
    }
     
    public void SetFarm(int a, int b) // 배추가 심어져 놓은 배열에 저장한다.
    {
                Farm[a][b] = 1 ;    
    }
 
    public void recursive(int a, int b)
    {
        if ( a < 0 || b < 0 || a > Farm.length || b > Farm[0].length ) ; 
        else if (Farm[a][b] == 0) ;
        else
        {
            Farm[a][b] = 0 ;
            recursive(a-1,b) ;
            recursive(a, b-1) ;
            recursive(a, b+1) ;
            recursive(a+1,b) ;
        }
    }
     
    public int Counting()
    {
        for(int i=0; i<Farm.length-1; i++)
            for(int j=0; j<Farm[i].length-1; j++)
            {
                if(Farm[i][j] == 1) 
                {       
                    recursive(i,j) ;                    
                                     
                    this.count++ ;
                }
            }
         
        return this.count ;
    }
     
}