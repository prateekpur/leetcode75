package leetcode;

import java.util.Stack;

public class DailyTempraturese {
    public static void main (String args[]) {
        //int temp[] = {30,38,30,36,35,40,28};
        int temp[] = {22,21,20};
        dailyTemperatures(temp);
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int res[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; ++i)   {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
    }
}
