package Z24_Sort;

import java.util.Scanner;

/**
 * Created by Caffrey on 2017/4/10.
 */
public class Merge_Sort {                                   //---------------------时间复杂度为  O(nlogn)----------------------
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        for(int i = 0;i<n;i++)
        {
            list[i] = scanner.nextInt();
        }
        mergeSort(list);
        for(int i=0;i<list.length;i++)
        {
            System.out.print(list[i]);
        }
    }
    public static void mergeSort(int[] list)
    {
        if(list.length > 1)
        {
            int[] firstHalf = new int[list.length /2];
            System.arraycopy(list, 0 ,firstHalf , 0,list.length / 2);
                            // 复制源 ，开始位置，复制目标，复制位置，复制长度
            mergeSort(firstHalf);                   //前半部分递归

            int[] SecondHalf = new int[list.length - list.length/2];
            System.arraycopy(list,list.length/2,SecondHalf,0,list.length - list.length/2);
            mergeSort(SecondHalf);                  //后半部分递归

            int[] temp = merge(firstHalf,SecondHalf);         //将递归的两部分进行排序
            System.arraycopy(temp,0,list,0,temp.length);
        }
    }

    private static int[] merge(int[] list1, int[] list2) {
        int[] temp = new int[list1.length+list2.length];

        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        while(current1 < list1.length && current2<list2.length)
        {
            if (list1[current1] < list2[current2])                      // 这个current1++ 就很机智了，循环对比，一直比啊比
            {
                temp[current3++] = list1[current1++];
            }
            else
            {
                temp[current3++] = list2[current2++];
            }
        }
            while(current1 < list1.length)
            {
                temp[current3++] = list1[current1++];
            }
            while(current2 < list2.length)
            {
                temp[current3++] = list2[current2++];
            }
        return temp;
    }


}
