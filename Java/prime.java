import java.util.Scanner;

public class prime {

    public static void main(String[] args) {

        int i = 2,num;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the number to check the number whether prime or not");
        num = s1.nextInt();
        boolean flag = false;
        while(i <= num/2)
        {
            if(num % i == 0)
            {
                flag = true;
                break;
            }

            ++i;
        }

        if (!flag)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
    }
}