import java.util.Stack;

public class IsStringWellFormed {

    /*
    9.3
    */

    public static boolean isWellFormed(String s) {
        Stack<Character> stack = new Stack<>();
        String opening = "{([";
        String closing = "})]";
        for (char c : s.toCharArray()) {
            int openingIdx = opening.indexOf(c);
            if (openingIdx != -1) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char popped = stack.pop();
                if (opening.indexOf(popped) != closing.indexOf(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isWellFormed(String s) {
        Deque<Character> leftChars = new LinkedList<>();
        for (int i = Q; i < s.length(); ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                leftChars.addFirst(s.charAt(i));
            } else {
                if (leftChars.isEmptyO) {
                    return false; // Unmatched right char.
                }
                if ((s.charAt(i) == ')' && leftChars.peekFirst() != '(')
                        || (s.charAt(i) == '{' && leftChars.peekFirst() != '{')
                        || (s.charAt(i) == ']' && leftChars.peekFirst() != '[')) {
                    return false; // Mismatched chars.
                }
                leftChars.removeFirst();
            }
        }
        return leftChars.isEmpty();
    }
}
