package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String args[])  {
        //System.out.println(isValid("[(])"));
        System.out.println(isValid("[]"));
    }
    public static boolean isValid(String s) {
        Stack<Character> bracket = new Stack<>();
        char c1;
        for (char c : s.toCharArray())  {
            switch(c)   {
                case '(' :
                    bracket.push(c);
                    break;
                case '{' :
                    bracket.push(c);
                    break;
                case '[' :
                    bracket.push(c);
                    break;
                case ')' :
                    if (bracket.isEmpty())  {
                        return false;
                    }
                    c1 = bracket.pop();
                    if (c1 != '(')  {
                        return false;
                    }
                    break;
                case '}' :
                    if (bracket.isEmpty())  {
                        return false;
                    }
                    c1 = bracket.pop();
                    if (c1 != '{')  {
                        return false;
                    }
                    break;
                case ']' :
                    if (bracket.isEmpty())  {
                        return false;
                    }
                    c1 = bracket.pop();
                    if (c1 != '[')  {
                        return false;
                    }
                    break;
            }
        }
        return bracket.isEmpty();
    }

    public static boolean isValid1(String s) {
        Stack<Character> roundBracket = new Stack<>(), squareBracket = new Stack<>(), curlyBracket = new Stack<>();
        for (char c: s.toCharArray())   {
            switch(c)   {
                case '(' :
                    roundBracket.push(c);
                    break;
                case '{' :
                    curlyBracket.push(c);
                    break;
                case '[' :
                    squareBracket.push(c);
                    break;
                case ')' :
                    if (roundBracket.isEmpty()) {
                        return false;
                    }
                    roundBracket.pop();
                    break;
                case '}' :
                    if (curlyBracket.isEmpty()) {
                        return false;
                    }
                    curlyBracket.pop();
                    break;
                case ']' :
                    if (squareBracket.isEmpty())    {
                        return false;
                    }
                    squareBracket.pop();
                    break;
            }
        }
        return roundBracket.isEmpty() && curlyBracket.isEmpty() && squareBracket.isEmpty();
    }
}
