import java.util.*;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening brackets
            if(ch == '(' || ch == '{' || ch == '[') {

                st.push(ch);
            }

            // Closing brackets
            else {

                // No matching opening bracket
                if(st.isEmpty()) {
                    return false;
                }

                char top = st.pop();

                // Check matching pair
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // Stack should be empty
        return st.isEmpty();
    }
}
