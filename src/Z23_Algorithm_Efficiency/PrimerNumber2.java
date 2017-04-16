package Z23_Algorithm_Efficiency;

import java.util.Scanner;

/**
 * Created by Caffrey on 2017/4/7.
 */
public class PrimerNumber2 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println("Finding prime number...");
        boolean[] primes = new boolean[N+1];
        for(int i=0;i<primes.length;i++)
        {
            primes[i]=true;
        }

        for(int k = 2;k<= N/k;k++)
        {
            if(primes[k])
            {
                for(int i =k;i<=N/k;i++)
                {
                    primes[k*i] = false;
                }
            }
        }
        int count = 0;
        for(int i =2;i<primes.length;i++)
        {
            if(primes[i])
            {
                count++;
                if(count % 10 ==0)
                {
                    System.out.printf("%7d\n",i);
                }
                else
                {
                    System.out.printf("%7d",i);
                }
            }
        }
        System.out.println();
        System.out.println("Found "+count+" prime numbers");
    }
}
