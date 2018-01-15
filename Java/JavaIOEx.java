import java.io.*;

class JavaIOEx
{
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;

		try
		{
			in = new FileInputStream("infile.txt");
			out = new FileOutputStream("outfile.txt");

		}
		catch(IOException e)
		{
			
		}
	}
}