import java.util.*;

class exam
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter 1 to insert and 2 to display");
		int a = sc.nextInt();
		String e1,e2,e3;

		switch(a)
		{
			case 1:
			
			System.out.println("enter the employee name");
			e1 = sc.next();
			System.out.println("enter the employee Id");
			e2 = sc.next();
			System.out.println("enter the employee city");
			e3 = sc.next();
			break;

			case 2:
			System.out.println("employee name: "+e1+"employee id: "+e2+"employee city: "+e3);
			break;
		}		

	}
}