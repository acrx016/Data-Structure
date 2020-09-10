package org.example.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created By Jwj@04668 on 2020/9/7
 */
public class MyQueue {
    private Logger logger= LoggerFactory.getLogger(MyQueue.class);
    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     * @param element 入队元素
     */
    public void enQueue(int element) {
        if ((rear + 1) % array.length == front) {
            throw new ArrayIndexOutOfBoundsException("Queue Filled");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 头元素出队
     * @return deQueueElement 头元素
     */
    public int deQueue() {
        if (rear == front) {
            throw new NullPointerException("Queue Null");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    /**
     * 输出队列
     */
    public void  output(){
        for (int i=front;i!=rear;i=(i+1)%array.length){
            logger.info("{}",array[i]);
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue(6);
        myQueue.enQueue(7);
        myQueue.deQueue();
        myQueue.output();
    }


}
