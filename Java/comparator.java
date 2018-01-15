import java.util.*;
import java.io.*;

class comparator
{
	public static void main(String[] args) {
	ArrayList<Student1> stdDetails = new ArrayList<Student1>();
	stdDetails.add(new Student1(100,"tim",22));
	stdDetails.add(new Student1(101,"rim",28));
	stdDetails.add(new Student1(102,"dim",23));
	
	System.out.println("sort the data by age....");
	Collections.sort(stdDetails,new AgeComparator());

	Iterator itr = stdDetails.iterator();
	while(itr.hasNext())
	{
		Student1 st= (Student1)itr.next();
		System.out.println(st.stdID+" "+st.stdName+" "+st.stdAge);
	}	

	}
}

class Student1
{
	int stdID;
	String stdName;
	int stdAge;

	Student1(int stdID,String stdName,int stdAge)
	{
		this.stdID=stdID;
		this.stdName=stdName;
		this.stdAge=stdAge;
	}
}

class AgeComparator implements comparator
{
	public int compare(Object o1,Object o2)
	{
		Student1 s1 = (Student1)o1;
		Student1 s2 = (Student1)o2;

		if(s1.stdAge==s2.stdAge)
		{
			return 0;
		}
		else if(s1.stdAge>s2.stdAge)
		{
			return 1;
		}
		else
		{
			return -1;
		}

		
	}
}