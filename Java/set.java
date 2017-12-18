import java.util.*;

class set
{
	public static void main(String[] args) {
		HashSet mydata = new HashSet();

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
	}
}

