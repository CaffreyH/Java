package Z23_Algorithm_Efficiency;

import java.util.Scanner;

/**
 * Created by Caffrey on 2017/4/7.
 */
public class GreatestCommonDivisor1 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        System.out.print(gcd(m,n));
    }
    public static int gcd(int m,int n)
    {
        if(m%n==0)
        {
            return n;
        }
        else
        {
            for(int k = m/2;k >=1;k--)
            {
                if(m%k==0 && n%k==0)
                {
                    return k;
                }
            }
        }
        return 0;
    }

}
