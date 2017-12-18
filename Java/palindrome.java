import java.util.*;
 
class palindrome
{
   public static void main(String args[])
   {
      String a, b = "";
      Scanner s1 = new Scanner(System.in);
 
      System.out.println("Enter a string to check if it is a palindrome");
      a = s1.nextLine();
 
      int length = a.length();
 
      for ( int i = length - 1; i >= 0; i-- )
         b = b + a.charAt(i);
 
      if (a.equals(b))
         System.out.println("Entered string is a palindrome.");
      else
         System.out.println("Entered string is not a palindrome.");
 
   }
}	