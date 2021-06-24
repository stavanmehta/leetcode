class Solution {
    public boolean isValid(String s) {
        if (s == null || s== "")
            return true;
        Stack<String> bracket = new Stack<String>();
        
        for (int index = 0; index < s.length(); index++) {
            String temp = ""+s.charAt(index);
            if (temp.equals("{") || temp.equals("(") || temp.equals("[")) 
                bracket.push(temp);
            else {
                if (!bracket.isEmpty())  {
                    String brace = bracket.peek();
                    if ((brace.equals("{") && temp.equals("}")) || (brace.equals("(") && temp.equals(")")) || (brace.equals("[") && temp.equals("]")))
                       bracket.pop();
                    else 
                        return false;
                    
                } else {
                return false;
                }
            }
        }
        return bracket.isEmpty();
    }
}
