import java.util.Scanner;
 
public class VPS {
 
    public static void main(String[] args) 
    {
        Scanner key = new Scanner(System.in) ;
        int no_cases = key.nextInt() ;
         
        while(true)
        {
            String vps = key.next() ;
            int left = 0 , right = 0 ; // 괄호 갯수
            boolean error = true ; // 에러 검출
            
            if(vps.charAt(0) != '(' || vps.charAt(vps.length()-1) != ')' )  // 처음과 끝에 대해서 정의
            {
            	System.out.println("NO") ;
            	no_cases-- ;
            	if(no_cases == 0) break ;
            	continue ;    
            }
            
            for(int x=0 ; x<vps.length() ; x++)
            {
            	if( vps.charAt(x) == '(') 
            		left++ ;
            	else
            		right++ ;
            	
            	if(left < right) // left < right 이면 성립핮 ㅣ않는다.
            	{
            		error = false ;
            		System.out.println("NO") ;
            		break ;
            	}
            }
            
            if(left != right && error == true ) // error는 이미 출력했을 경우를 대비하는것.
            	System.out.println("NO") ;
            else if (error == true )
            	System.out.println("YES") ;
            
            no_cases-- ;
            if(no_cases == 0) break ;
        }
 
    }
 
}