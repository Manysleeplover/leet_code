package РешенныеМнойЗадачи.old.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * <p>
 * Пример 1:
 * <p>
 * Входные данные: tokens = ["2","1","+","3","*"]
 * Выходные данные: 9
 * Объяснение: ((2 + 1) * 3) = 9
 * Пример 2:
 * <p>
 * Входные данные: tokens = ["4","13","5","/","+"]
 * Выходные данные: 6
 * Объяснение: (4 + (13 / 5)) = 6
 * Пример 3:
 * <p>
 * Ввод: tokens = ["10","6","9","3","+","-11","*","/","*","17","+", "5","+"]
 * Выход: 22
 * Объяснение: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6/-132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class evalRPN {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+", "5","+"}));
    }


    public static int evalRPN(String[] tokens) {
        if(tokens.length ==1 ){
            return Integer.parseInt(tokens[0]);
        }
        int eval = 0;
        Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
            char c = token.charAt(0);
            if (Character.isDigit(c) || (!Character.isDigit(c) && token.length()>1) ) {
                stack.add(Integer.parseInt(token));
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch (token) {
                    case "+":
                        eval = op1 + op2;
                        break;
                    case "-":
                        eval = op1 - op2;
                        break;
                    case "*":
                        eval = op1 * op2;
                        break;
                    case "/":
                        eval = op1 / op2;
                        break;
                }
                stack.push(eval);
            }
        }
        return eval;
    }
}
