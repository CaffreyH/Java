package Z23_Algorithm_Efficiency;

import java.util.Scanner;

/**
 * Created by Caffrey on 2017/4/7.
 */
public class GreatestCommonDivisor2 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.print(gcd(a,b));
    }
    public static int gcd(int m,int n)       //欧几里得算法
    {
        if(m % n==0)                    //   如果可以整除，返回小的数
        {
            return n;
        }
        else                            //   不能整除，调用gcd（n , m % n)即可
            return gcd(n,m % n);
    }
}
