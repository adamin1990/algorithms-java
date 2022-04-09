package com.adamin.algorithms.sort;

import java.util.Arrays;

/**
 * @Classname QuickSortLomuto
 * @Description 使用Lomuto方案进行partition的快排
 * Lomuto partition方式使用最后一个元素作为pivot
 * @Date 2022/4/9 14:40
 * @Created by Adam(https://www.lixiaopeng.top)
 */
public class QuickSortLomuto implements Isort{
    @Override
    public void sortElement(int[] elements) {
         quickSortLomuto(elements,0,elements.length-1);

    }

    private void quickSortLomuto(int[] elements, int low, int high) {
        if(low<high) {
            int pivotIndex = partition(elements, low, high); //计算pivot的实际未知，并把low到high内的元素分布到pivot的两侧
            quickSortLomuto(elements, low, pivotIndex - 1); //before pivot
            quickSortLomuto(elements, pivotIndex + 1, high);  //after pivot
        }
    }

    /**
     * lomuto方式选取high，即最后一个作为pivot
     * @param elements
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] elements, int low, int high) {
        int left=low-1; //左侧索引，当下面循环内元素小于pivot时候，右移left一次，然后调换元素
        int pivot=elements[high];
        for(int j=low;j<high;j++ ){
            if(elements[j]<pivot){
                left++;
                swap(elements,left,j); //把j值放到left索引位置
            }

        }
        swap(elements,left+1,high); //把pivot放到正确的位置
        return left+1;
    }

    private void swap(int[] elements, int left, int j) {
        int temp=elements[left];
        elements[left]=elements[j];
        elements[j]=temp;
    }

    public static void main(String[] args) {
        int [] test=new int[]{2,0,7,4,3};
        new QuickSortLomuto().sortElement(test);
        System.out.println("QuickSort result = " + Arrays.toString(test));
    }
}
