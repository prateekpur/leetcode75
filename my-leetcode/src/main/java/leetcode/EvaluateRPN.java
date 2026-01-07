package leetcode;

import java.util.Stack;

public class EvaluateRPN {
    public static void main(String args[])  {
        String s1[] = {"1","2","+","3","*","4","-"};
        System.out.println(evalRPN(s1));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        int tmp, tmp1;
        for (String s : tokens) {
            switch (s)  {
                case "+" :
                    tmp = nums.pop();
                    tmp1 = nums.pop();
                    nums.push(tmp1 + tmp);
                    break;
                case "-" :
                    tmp = nums.pop();
                    tmp1 = nums.pop();
                    nums.push(tmp1 - tmp);
                    break;
                case "*" :
                    tmp = nums.pop();
                    tmp1 = nums.pop();
                    nums.push(tmp1 * tmp);
                    break;
                case "/" :
                    tmp = nums.pop();
                    tmp1 = nums.pop();
                    nums.push(tmp1 / tmp);
                    break;
                default :
                    nums.push(Integer.parseInt(s));
            }
        }
        return nums.pop();
    }

}
