package Z24_Sort;

import java.util.Scanner;

/**
 * Created by Caffrey on 2017/4/13.
 */
public class BucketSort1 {
    public static void main(String[] args)
    {
        int[] bucket = new int[100];
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i=0;i<N;i++)
        {
            bucket[scanner.nextInt()]++;
        }
        for(int i=0;i<100;i++)
        {
            if(bucket[i]>0)
            {
                System.out.print(i+" ");
            }
        }
    }

}
