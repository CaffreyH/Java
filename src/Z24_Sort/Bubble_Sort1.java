package Z24_Sort;

import java.util.Scanner;

/**
 * Created by Caffrey on 2017/4/9.
 */
public class Bubble_Sort1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[5];
        for(int  i=0;i<5;i++)
        {
            data[i] = scanner.nextInt();
        }

        for(int i=0;i<data.length;i++)
        {
            for(int j = 0;j<data.length -1-i;j++)        //每次排序好一次，只需要比较前 n-i 个即可
            {
                if (data[j] > data[j+1])
                {
                   // swap data[i] with data[i+1];
                    int temp = data[j];
                    data[j] =  data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        for(int  i=0;i<5;i++)
        {
            System.out.println(data[i]);
        }

    }
}
