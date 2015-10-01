import java.util.Scanner;
 
public class VPS {
 
    public static void main(String[] args) 
    {
        Scanner key = new Scanner(System.in) ;
        int no_cases = key.nextInt() ;
         
        while(true)
        {
            String vps = key.next() ;
            int left = 0 , right = 0 ; // ��ȣ ����
            boolean error = true ; // ���� ����
            
            if(vps.charAt(0) != '(' || vps.charAt(vps.length()-1) != ')' )  // ó���� ���� ���ؼ� ����
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
            	
            	if(left < right) // left < right �̸� �����F �Ӿʴ´�.
            	{
            		error = false ;
            		System.out.println("NO") ;
            		break ;
            	}
            }
            
            if(left != right && error == true ) // error�� �̹� ������� ��츦 ����ϴ°�.
            	System.out.println("NO") ;
            else if (error == true )
            	System.out.println("YES") ;
            
            no_cases-- ;
            if(no_cases == 0) break ;
        }
 
    }
 
}