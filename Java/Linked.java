import java.util.LinkedList;
import java.util.Iterator;
import java.util.*;

public class Linked
{
	public static void main(String[] args) {
		LinkedList mydata = new LinkedList();

		mydata.add("tim");
		mydata.add(12);
		mydata.add("Delhi");
		mydata.add("PG");
		mydata.add("Male");

		System.out.println(mydata);

		Iterator itr = mydata.iterator();

		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

		mydata.addFirst("Uid001");
		mydata.addLast("no experience");

		Iterator itr1 = mydata.iterator();

		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
		}

		ListIterator ltr = mydata.listIterator();

		while(ltr.hasNext())
		{
			System.out.println(ltr.next());
		}
		while(ltr.hasPrevious())
		{
			System.out.println(ltr.previous());
		}
	}
}