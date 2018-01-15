import java.util.*;

class ex
{
	public static void main(String args[])
	{
		Student std1 = new Student(1,"tim",12);
		Student std2 = new Student(1,"tim",12);
		Student std3 = new Student(1,"tim",12);

		ArrayList<Student> StdDetails = new ArrayList<Student>();

		StdDetails.add(std1);
		StdDetails.add(std2);
		StdDetails.add(std3);

		Iterator itr = StdDetails.iterator();

		while(itr.hasNext())
		{
			Student st = (Student)itr.next();
			System.out.println(st.ID+ "    "+st.Name+"   "+st.Age);
		}
	}
}