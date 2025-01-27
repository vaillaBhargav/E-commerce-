import java.util.Scanner;
import java.util.Stack;
public class Mainn {
    public static void main(String[] args) {
        System.out.println("Program started... waiting for input.");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next(); // Corrected input syntax
            System.out.println("Processing input: " + input); // Proper concatenation of string
            System.out.println(isBalanced(input)); // Checking if input is balanced
        }
        scanner.close(); 
        System.out.println("Program ended.");
    }
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If it's a closing bracket, check if the stack is not empty and matches the top
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; 
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false; 
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');                                                                                                                                        //2311CS020674
    }
}
