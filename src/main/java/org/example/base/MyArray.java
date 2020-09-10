package org.example.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Created By Jwj@04668 on 2020/9/7
 */

public class MyArray {
    private Logger logger = LoggerFactory.getLogger(MyArray.class);
    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 数组插入元素
     *
     * @param element 元素值
     * @param index   索引
     * @throws Exception 越界异常
     */
    public void insert(int element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Element Out Of Array Bounds! ");
        }
        if (size >= array.length) {
            resize();
        }
        // 从右往左遍历，元素右移
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    /**
     * 输出数组
     */
    public void output() {
        for (int i = 0; i < size; i++) {
            logger.info("数组输出: {}", array[i]);
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(3);
        myArray.insert(3, 0);
        myArray.insert(7, 1);
        myArray.insert(8, 2);
        myArray.insert(9, 3);
        myArray.delete(3);
        myArray.output();
    }

    /**
     * 数组扩容两倍
     */
    public void resize() {
        int[] arrayNew = new int[array.length << 1];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * 删除
     */
    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index Out Of Array Bound");
        }
        int deleteElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deleteElement;
    }

}
