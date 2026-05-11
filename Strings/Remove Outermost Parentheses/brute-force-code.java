import java.util.*;

class Solution {
    public String removeOuterParentheses(String s) {
        // Your code goes here
        int counter = 0;
        String out = "";
        for(int i=0; i<s.length();i++){
            char temp = s.charAt(i);
            if(temp == '('){
                if(counter > 0){
                    out = out + temp;
                }
                counter++;
            }
            if(temp == ')'){
                counter--;
                if(counter > 0){
                    out = out + temp;
                }
            }
        }
        return out;
    }
}
