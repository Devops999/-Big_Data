public class travellor
{
	void price(int km,int unitprice)
	{
		int price1 = km*unitprice;
		System.out.println("Total Price : "+price1);	

	}


}
public class car 
{
	travellor tr = new travellor();
	tr.price(5,10);
}

public static void main(String[] args) {
	
}