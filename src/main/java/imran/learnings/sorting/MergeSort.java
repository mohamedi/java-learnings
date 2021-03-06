package imran.learnings.sorting;

import java.util.Arrays;

/*
* This class demonstrates the merge sort
 */
public class MergeSort
{
    private int[] merge(int[] arrayToMerge, int[] leftArray, int[] rightArray)
    {
        int iLeft = 0;
        int jRight = 0;
        int kArray = 0;

        while (iLeft < leftArray.length && jRight < rightArray.length)
        {
            if (leftArray[iLeft] <= rightArray[jRight])
            {
                arrayToMerge[kArray] = leftArray[iLeft];
                iLeft++;
            }
            else
            {
                arrayToMerge[kArray] = rightArray[jRight];
                jRight++;
            }
            kArray++;
        }

        while (iLeft < leftArray.length)
        {
            arrayToMerge[kArray] = leftArray[iLeft];
            iLeft++;
            kArray++;
        }
        while (jRight < rightArray.length)
        {
            arrayToMerge[kArray] = rightArray[jRight];
            jRight++;
            kArray++;
        }
        return arrayToMerge;
    }

    public void mergeSort(int[] arrayToSort)
    {
        int size = arrayToSort.length;
        if (size < 2)
            return;
        int mid = size / 2;
        int left[] = Arrays.copyOfRange(arrayToSort, 0, mid);
        int right[] = Arrays.copyOfRange(arrayToSort, mid, size);

        mergeSort(left);
        mergeSort(right);
        merge(arrayToSort, left, right);
    }

    public static void main(String args[])
    {
        int[] myArray = {1, 4, 5, 2, 3, 0, 0, 0};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
