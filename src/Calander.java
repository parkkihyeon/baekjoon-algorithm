import java.util.Scanner;

public class Calander {

	public static void main(String[] args) 
	{
		Scanner key = new Scanner(System.in) ;
        int Dday = key.nextInt() ;
        cal Pcalander = new cal(Dday) ;
        Pcalander.Show();     
	}
}

class cal
{
	private int year ;
	private int month ;
	private int Day ;
	private int plusday ;
	
	cal(int plus)
	{
		this.year = 2014 ;
		this.month = 4 ;
		this.Day = 1 ;
		this.plusday = plus ; // n�� ��.
	}
	
	public boolean LeapYear(int year) // ���� Ȯ�� �Լ�
	{
		if(year % 4 == 0 && ( year % 100 != 0 || year % 400 == 0)) 
			return true ;
		else
			return false ;
	}
	
	public int FinalDayMonth(int month, int year) // �⵵�� ��¥�� ���� �� ���� ������ Day
	{
		if ( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31 ;
		else if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30 ;
		else
		{
			if (LeapYear(year) == false) // ������ �ƴϸ�
				return 28 ;
			else
				return 29 ;
		}
	}
	
	public int PresentDayCount() // ���� �ʱ�ȭ�� ��¥�� ��¥�� 366���� ����.
	{
		int day = 0 ;
		for(int x=1 ; x<this.month ;x++)
			day += FinalDayMonth(this.month,this.year) ;
		day += this.Day ;
		
		return day ;
	} // 4�� 1���̸� ���� 31 + 28(29) + 31 + 1 �̴�.
	
	public void SetYMD() // ũ�� year�� �����Ѵ�.
	{
		int Plus = this.plusday + this.PresentDayCount() ;
		while(true)
		{
			if (LeapYear(this.year) == false && Plus > 365)
			{
				Plus -= 365 ;
				this.year++ ;//������ �ƴϸ�
			}
			else if( LeapYear(this.year) == true && Plus > 366)
			{
				Plus -= 366 ;
				this.year++ ;
			}
			else
			{
				break ;
			}
		}
	
		for(int x=1 ; x<=12 ; x++)
		{
			if( this.FinalDayMonth(x, this.year) < Plus )
				Plus -= this.FinalDayMonth(x, this.year) ;
			else
			{
				this.month = x;
				break ;
			}
		}
		this.Day = Plus ;
	}
	
	public void Show()
	{
		SetYMD() ;
		if(this.month < 10 && this.Day < 10 )
		{
			System.out.println(this.year+"-0"+this.month+"-0"+this.Day) ;
		}
		else if(this.Day < 10)
		{
			System.out.println(this.year+"-"+this.month+"-0"+this.Day) ;
		}
		else if(this.month < 10)
		{
			System.out.println(this.year+"-0"+this.month+"-"+this.Day) ;
		}
		else
			System.out.println(this.year+"-"+this.month+"-"+this.Day) ;
	}
}