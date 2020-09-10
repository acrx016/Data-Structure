package org.example.base;

/**
 * Created By Jwj@04668 on 2020/9/7
 */
public class Heap {


    public static void downAdjust(int[] array,int parentIndex,int length){
        int temp=array[parentIndex];
        int childIndex=parentIndex<<1+1;
        while(childIndex<length){
            if(childIndex+1<length && array[childIndex+1]<array[childIndex]){
                childIndex++;
            }
            if (temp < array[childIndex]) {
                break;
            }
            array[parentIndex]=array[childIndex];
            parentIndex=childIndex;
            childIndex=childIndex<<1+1;
        }
        array[parentIndex]=temp;
    }

    public static void buildHeap(int array[]){
        for(int i = (array.length-2)>>1;i>=0;i--){
            downAdjust(array,i, array.length);
        }
    }

    public static  void main(String[] args){
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
    }
}

