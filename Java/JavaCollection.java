import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class JavaCollection
{
	public static void main(String aa[])
	{
		ArrayList al = new ArrayList();
		al.add("kishan");
		al.add("pooja");
		al.add("lakshmi");
		al.add("harshitha");
		al.add("bangalore");
		al.add(7);
		al.add(44);
		al.add("pune");

		System.out.println(al);

		//Traversing the data
		Iterator itr = al.iterator();

		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

		/*
		//Generic collection
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("kish");
		al1.add("kish");
		al1.add("kish");
		al1.add("kish");
		al1.add(5); //it will show error because object is string

		for(String obj:al1)
		{
			System.out.println(obj);
		}

		*/

	}
}