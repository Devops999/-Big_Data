/*
write a program to accept the details of 10 students.
Display the total characters in their name as output without using string fuctions.
*/

import java.util.Scanner;

class totalchar
{
	public static void main(String args[])
	{
		Scanner x = new Scanner(System.in);
		String name;
		int a=0,i=1;
		while(i<=10)
		{
			System.out.println("Enter the Student Details");
			System.out.println("Student name");
			name = x.next();
			for(char c : name.toCharArray()){
				a++;
			}
			System.out.println("Total characters are "+a);
		}
		i++;

	}
}