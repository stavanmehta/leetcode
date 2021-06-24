class Solution {
    public String reverseString(String s) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < s.length(); index++) {
            int jindex = s.length() - index -1;
            result.append(s.charAt(jindex)+"");
        }
        return result.toString();
    }
}
