package MergeSort;

import java.util.Arrays;
public class SelectionSorter
{
    public static void sort(int[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            int minPos = minimumPosition(a, i);
            ArrayUtil.swap(a, minPos, i);
        }
    }
    public static void sortString(String[] s)
    {
        for(int i = 0; i < s.length; i++)
        {
            int minPos = minimumPosition(a, i);
            ArrayUtil.swap(a, minPos, i);
        }
    }
    private static int minimumPosition(int[] a, int form)
    {
        int minPos = form;
        for(int i = form + 1; i < a.length; i++)
        {
            if( a[i] < a[minPos])
            {
                minPos = i;
            }
        }
        return minPos;
    }
    public static void main(String[] args)
    {
        // int[] a = ArrayUtil.randomIntArray(20, 100);
        // System.out.println(Arrays.toString(a));
        
        // SelectionSorter.sort(a);
        // System.out.println(Arrays.toString(a));
        
        String[] s = ArrayUtil.randomStringArray(20, 5);
        System.out.println(Arrays.toString(s));
        
        SelectionSorter.sortString(s);
        System.out.println(Arrays.toString(s));
        
    }
}