package leetcode;

import java.util.*;

public class MinStack {
    List<Integer> li;
    PriorityQueue<Integer> minHeap;

    public static void main(String args[])  {
        MinStack min = new MinStack();
        min.push(1); min.push(2); min.push(0);
        System.out.println(min.getMin());
        min.pop();
        System.out.println(min.top());
        System.out.println(min.getMin());
    }

    public MinStack() {
        li = new ArrayList<Integer>();
        minHeap = new PriorityQueue<Integer>();
    }

    public void push(int val) {
        li.add(0, val);
        minHeap.add(val);
    }

    public void pop() {
        int i = li.remove(0);
        minHeap.remove(i);
    }

    public int top() {
        return li.get(0);
    }

    public int getMin() {
        return minHeap.peek();
    }
}
