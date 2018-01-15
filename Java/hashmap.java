import java.util.*;

class hashmap
{
	public static void main(String[] args) {
		
		HashMap<Integer,String> c1 = new HashMap<Integer,String>();
		c1.put(1001,"john");
		c1.put(1002,"david");
		c1.put(1003,"vijay");
		c1.put(1004,"tim");
		c1.put(1005,"srini");
		c1.put(1006,"kish");

		Set set = c1.entrySet();
		Iterator itr = set.iterator();
		while(itr.hasNext())
		{
			Map.Entry mapentry = (Map.Entry)itr.next();
			System.out.println("key is :"+mapentry.getKey());
			System.out.println("value is "+mapentry.getValue());
		}

		Set set1 =c1.entrySet();
		Iterator itr1 = set1.iterator();
		while(itr1.hasNext())
		{
			Map.Entry a2 = (Map.Entry)itr1.next();
			System.out.println("key is :"+a2.getKey());
			System.out.println("value is :"+a2.getValue());
		}
	}
}