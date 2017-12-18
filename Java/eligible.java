/*
program to accept the details of 10 students.display the details of student who will be eligible for voting after 3 yrs.
*/
import java.util.Scanner;

class eligible
{
	public static void main(String args[])
	{
		Scanner x = new Scanner(System.in);
		int age;
		String name;
		int a,i=1;
		while(i<=10)
		{
			System.out.println("Enter the Student Details");
			System.out.println("Student name");
			name = x.next();
			System.out.println("Student Age");
			age = x.nextInt();
			if(age>=3)
			{
				System.out.println(name+" is eligible for voting ");
			}
			else
			{
				System.out.println(name+" is not eligible for voting");
			}
			i++;
		}

	}
}