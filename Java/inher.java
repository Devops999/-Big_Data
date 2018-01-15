/*write a pgm in java to accept employee details like emp name,emp address,emp salary,emp wage using three classes implement inheritance and overriding*/

package myjavaapplication;

public class Polyprogram
{
	public static void main(String[] aa)
	{
		FTEmployee e1 = new FTEmployee();
		e1.accept();
		PTEmployee e2 = new PTEmployee();
		e2.accept();

	}
}

class Employee
{
	String EName;
	int EAge;

	public void accept(String ename, int eage)
	{
		EName = ename;
		EAge = eage;	
	}

	public void display()
	{
		System.out.println("Name : "+EName);
		System.out.println("EAge : "+EAge);
	}
}

class FTEmployee extends Employee
{
	float sal;
	@override
	public void accept()
	{
		System.out.println("salary :");
	}
}

class PTEmployee extends Employee
{
	float wage;
	@override
	public void accept()
	{

	}
}