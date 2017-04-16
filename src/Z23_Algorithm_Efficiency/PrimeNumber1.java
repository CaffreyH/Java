package Z23_Algorithm_Efficiency;

import java.util.Scanner;

/**
 * Created by Caffrey on 2017/4/7.
 */
public class PrimeNumber1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        final int NUMBER_PER_LINE = 10;
        int count =0;
        int number = 2;
        System.out.println("Finding prime numbers less then "+ N+"......");
        System.out.println("The prime numbers are:");
        while(number <=  N)
        {
            boolean isPrime = true;
            for(int divisor = 2;divisor<=(int)(Math.sqrt(number));divisor++)
            {
                if(number % divisor == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
            {
                count ++;
                if(count % NUMBER_PER_LINE ==0 )
                {
                    System.out.printf("%7d\n",number);
                }
                else
                {
                    System.out.printf("%7d",number);
                }
            }
            number++;
        }
        System.out.println();
        System.out.println("Find "+ count +" prime numbers");
    }

}
