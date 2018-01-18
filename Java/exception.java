class exception
{
	public static void main(String[] args) {
		int res;
		try{
		int[] num = {1,0,4};
		/*num[0]=1;
		num[1]=0;
		num[3]=4;*/

		res = num[0] /num[4];
		System.out.println(res);
		throw new ArithmeticException("test");
		}
		catch(ArithmeticException err)
		{
			System.out.println(err.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException er)
		{
			System.out.println(er.getMessage());
		}
		catch(Exception err1)
		{
			System.out.println(err1.getMessage());
		}
		finally
		{
			System.out.println("always execute");
		}
	}
}