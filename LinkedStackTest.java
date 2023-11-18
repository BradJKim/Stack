public class LinkedStackTest {

    public static void main(String[] args){
        String infix = "a*b/(c-a)+d*e";
        System.out.println("Infix: " + infix);
        String postfix = convertToPostfix(infix);
        System.out.println("Postfix: " + postfix);
    }

    public static String convertToPostfix(String input){
        // Converts an infix expression to an equivalent postfix expression.
        LinkedStack<String> operatorStack = new LinkedStack<>();
        String postfix = "";
        String infix = input;
        String nextChar;

        while(infix.length() != 0){
            //System.out.println("Stack: " + operatorStack.show());
            //System.out.println("Infix: " + infix);
            //System.out.println("Postfix: " + postfix + "\n");

            nextChar = infix.substring(0, 1);
            infix = infix.substring(1);
            switch(nextChar){
                case "a":
                case "b":
                case "c":
                case "d":
                case "e":
                case "f":
                case "g":
                case "h":
                case "i":
                case "j":
                case "k":
                case "l":
                case "m":
                case "n":
                case "o":
                case "p":
                case "q":
                case "r":
                case "s":
                case "t":
                case "u":
                case "v":
                case "w":
                case "x":
                case "y":
                case "z":
                    postfix += nextChar;
                    break;
                case "^":
                    operatorStack.push(nextChar);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":                               
                    while(!operatorStack.isEmpty() &&  precedence(nextChar.charAt(0)) <= precedence(operatorStack.peek().charAt(0))){
                        postfix += operatorStack.peek();
                        operatorStack.pop();
                    }
                    operatorStack.push(nextChar);
                    break;
                case "(":
                    operatorStack.push(nextChar);
                    break;
                case ")":
                    String topOperator = operatorStack.pop();
                    while(!topOperator.equals("(")){
                        postfix += topOperator;
                        topOperator = operatorStack.pop();
                    }
                    break;
                default: break;
            }
        }

        while(!operatorStack.isEmpty()){
            postfix += operatorStack.pop();
        }

        return postfix;
    }

    private static int precedence(char character){
        int prec =0;
        if(character == '*' || character == '/'){
            prec =2;
        }
        else if(character == '+' || character == '-'){
            prec =1;
        }
        return prec;
    }
}
