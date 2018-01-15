import java.io.*;
import java.util.*;

class Comparable
{
	public static void main(String[] args) {
	ArrayList<Student> stdDetails = new ArrayList<Student>();
	stdDetails.add(new Student(100,"tim",22));
	stdDetails.add(new Student(101,"rim",28));
	stdDetails.add(new Student(102,"dim",23));
	

	Collections.sort(stdDetails);

	for(Student ss:stdDetails)
	{
		System.out.println(ss.stdID+""+ss.stdName+""+ss.stdAge);
	}	

	}
}

class Student implements Comparable<Student>
{
	int stdID;
	String stdName;
	int stdAge;

	Student(int stdID,String stdName,int stdAge)
	{
		this.stdID=stdID;
		this.stdName=stdName;
		this.stdAge=stdAge;
	}

	public int compareTo(Student sobj)
	{
		if(stdAge==sobj.stdAge)
		{
			return 0;
		}
		else if(stdAge>sobj.stdAge)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}

