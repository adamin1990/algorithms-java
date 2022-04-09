package com.adamin.algorithms.sort;

import java.util.Arrays;

/**
 * @Classname QuickSortHoare
 * @Description 快排Hoare's partition 方案
 * 该方案从数组两端初始化两个索引，两个索引彼此移动
 *
 * @Date 2022/4/9 15:33
 * @Created by Adam(https://www.lixiaopeng.top)
 */
public class QuickSortHoare implements Isort{
    @Override
    public void sortElement(int[] elements) {

        quickSortHoare(elements,0,elements.length-1);

    }

    private void quickSortHoare(int[] elements, int low, int high) {
        if(low<high){
          int pivotIndex=  partition(elements,low,high);
          //分别对pivot前后元素排序
          quickSortHoare(elements,low,pivotIndex);
          quickSortHoare(elements,pivotIndex+1,high);
        }
    }

    private int partition(int[] elements, int low, int high) {
        int pivot =elements[low];
        int i=low-1,j=high+1;
        while (true) {
            // 找到最左侧大于等于pivot的元素
            do {
                i++;
            } while (elements[i] < pivot);

            //找到最右侧小于等于pivot的元素
            do {
                j--;
            } while (elements[j] > pivot);

            // 左右索引重合，返回
            if (i >= j)
                return j;

            swap(elements,i,j);
            // swap(arr[i], arr[j]);
        }
    }

    private void swap(int[] elements, int i, int j) {
        int temp=elements[i];
        elements[i]=elements[j];
        elements[j]=temp;
    }

    public static void main(String[] args) {
        int [] test=new int[]{2,0,7,4,3};
        new QuickSortHoare().sortElement(test);
        System.out.println("QuickSort result = " + Arrays.toString(test));
    }
}
