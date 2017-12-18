
import java.util.Iterator;
import java.util.*;

public class linklist
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

		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}