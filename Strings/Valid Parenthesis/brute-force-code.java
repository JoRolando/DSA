class Solution {

    public boolean isValid(String s) {

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening brackets
            if(ch == '(' || ch == '{' || ch == '[') {

                str.append(ch);
            }

            // Closing brackets
            else {

                // No opening bracket available
                if(str.length() == 0) {
                    return false;
                }

                char top = str.charAt(str.length() - 1);

                if(ch == ')' && top != '(') {
                    return false;
                }

                else if(ch == ']' && top != '[') {
                    return false;
                }

                else if(ch == '}' && top != '{') {
                    return false;
                }

                // Remove matched opening bracket
                str.deleteCharAt(str.length() - 1);
            }
        }

        // All brackets should be matched
        return str.length() == 0;
    }
}
