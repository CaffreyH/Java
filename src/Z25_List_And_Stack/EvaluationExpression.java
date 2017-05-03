package Z25_List_And_Stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Caffrey on 2017/4/23.
 */
public class EvaluationExpression {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
       // String args1 = scanner.nextLine();
        if(args.length <1)
        {
            System.out.println("Usage: java Evaluation expression");
            System.exit(0);
        }
        String expression = "";
        for(int i=0;i<args.length;i++)
        {
           // expression += args1.charAt(i);
            expression += args[i];
        }
        try
        {
            System.out.println(evaluateExpression(expression));
        }
        catch (Exception ex)
        {
            System.out.println("Wrong expresion");
        }
    }

    private static int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<Integer>();
        Stack<Character> operatorStack = new Stack<Character>();
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(expression,"()+-*/",true);
        while(tokens.hasMoreTokens())
        {
            String token = tokens.nextToken().trim();
            if(token.length()==0)
            {
                continue;
            }
            else if(token.charAt(0)=='+'   ||  token.charAt(0)=='-' )
            {
                while(!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                                operatorStack.peek() == '-'||
                                operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/'))
                {
                        processAnOperator(operandStack,operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }
            else if(token.charAt(0)=='*'  || token.charAt(0)=='/')
            {
                while(!operatorStack.isEmpty()  && (operatorStack.peek()=='*' || operatorStack.peek()=='/'))
                {
                    processAnOperator(operandStack,operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }
            else if(token.trim().charAt(0)=='(')
            {
                operatorStack.push('(');
            }
            else if(token.trim().charAt(0)==')')
            {
                while(operatorStack.peek()!='(')
                {
                    processAnOperator(operandStack,operatorStack);
                }
                operatorStack.pop();
            }
            else
            {
                operandStack.push(new Integer(token));
            }
        }
        while(!operatorStack.isEmpty())
        {
            processAnOperator(operandStack,operatorStack);
        }
        return operandStack.pop();
    }

    private static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if(op== '+')
        {
            operandStack.push(op1+op2);
        }
        if(op== '-')
        {
            operandStack.push(op1-op2);
        }
        if(op== '*')
        {
            operandStack.push(op1*op2);
        }
        if(op== '/')
        {
            operandStack.push(op1/op2);
        }
    }

}
