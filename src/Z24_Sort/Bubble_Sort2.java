package Z24_Sort;

import java.util.Scanner;

/**
 * Created by Caffrey on 2017/4/9.
 */                                                     //----------------冒泡排序的复杂度为O(N^2)---------------
public class Bubble_Sort2 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[5];
        for(int  i=0;i<5;i++)
        {
            data[i] = scanner.nextInt();
        }

        boolean needNextPass = true;                    //如果有一次没有发生交换，则说明顺序以及排好
        for(int i=0;i<data.length && needNextPass;i++)
        {
            needNextPass = false;
            for(int j = 0;j<data.length -1-i;j++)        //每次排序好一次，只需要比较前 n-i 个即可
            {

                if (data[j] > data[j+1])
                {
                    // swap data[i] with data[i+1];
                    int temp = data[j];
                    data[j] =  data[j+1];
                    data[j+1] = temp;
                    needNextPass = true;
                }
            }
        }
        for(int  i=0;i<5;i++)
        {
            System.out.println(data[i]);
        }

    }
}
