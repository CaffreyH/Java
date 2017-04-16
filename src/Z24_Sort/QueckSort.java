package Z24_Sort;

/**
 * Created by Caffrey on 2017/4/13.
 */
public class QueckSort
{
    public static void quickSort(int[] list)
    {
        quickSort(list,0,list.length-1);
    }

    private static void quickSort(int[] list, int first, int last)
    {
        if(last > first)
        {
            int pivotIndex = partition(list,first,last);             //获取主元素的位置，如果主元素交换位置，返回新的下标，否则返回原来的下标
            quickSort(list,first,pivotIndex);                        //前后两部分分别递归继续调用
            quickSort(list,pivotIndex+1,last);
        }
    }

    private static int partition(int[] list, int first, int last)
    {
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while(high > low)                                 //从两头开始找，high>low表示还没有找完，一直找啊找
        {
            while(low <= high && list[low] <= pivot)
            {
                low++;                                      //  一只找到一个比主元素大的位置
            }
            while(low <= high && list[high] >pivot)
            {
                high--;                                     //一直找到比主元小的
            }
            if( high > low)
            {
                int temp = list[high];
                list[high] = list[low];                     //交换 找到的比主元素大的和小的
                list[low] = temp;
            }
        }
        while(high >first && list[high] >= pivot)           //到此表示已经遍历了所有的元素，一直找   直到找到一个比主元素小的
        {
            high--;                                          //high--的位置是主元素应该再得位置
        }
            if(pivot > list[high])                          //判断是否需要交换主元素的位置
            {
                list[first] = list[high];
                list[high] = pivot;
                return high;
            }
            else
            {
                return first;
            }
    }
    public static void main(String[] args)
    {
        int[] list = {2,3,2,5,6,1,-2,3,14,12};
        quickSort(list);
        for(int e:list)
        {
            System.out.print(e+" ");
        }
        System.out.println();
        for(int i=0;i<list.length;i++)
        {
            System.out.print(list[i] + " ");
        }
    }
}
