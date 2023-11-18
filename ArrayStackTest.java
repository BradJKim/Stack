public class ArrayStackTest {
    public static void main(String[] args){
        String input = "23*42-/56*+";
        String result = evaluatePostfix(input);
        System.out.println(result);

    }

    public static String evaluatePostfix(String input){
        
        String postfix = input;
        // Evaluates a postfix expression
        ResizeableArrayStack<String> valueStack = new ResizeableArrayStack<String>();
        while(postfix != ""){
            String operandTwo = "";
            String operandOne = "";
            String result = "";
            String nextChar = postfix.substring(0,1);
            switch(nextChar){
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "0":
                    valueStack.push(nextChar);
                    break;
                case "^":
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = Integer.toString((int) Math.pow(Integer.parseInt(operandOne), Integer.parseInt(operandTwo)));
                    valueStack.push(result);
                    break;
                case "+":
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = Integer.toString((int) (Integer.parseInt(operandOne) + Integer.parseInt(operandTwo)));
                    valueStack.push(result);
                    break;
                case "-":
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = Integer.toString((int) (Integer.parseInt(operandOne) - Integer.parseInt(operandTwo)));
                    valueStack.push(result);
                    break;
                case "*":
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = Integer.toString((int) (Integer.parseInt(operandOne) * Integer.parseInt(operandTwo)));
                    valueStack.push(result);
                    break;
                case "/":        
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = Integer.toString((int) (Integer.parseInt(operandOne) / Integer.parseInt(operandTwo)));
                    valueStack.push(result);
                    break;
                default: break;
            }
            postfix=postfix.substring(1);
        }
        return valueStack.peek();
    }

}
