class Solution {
    public void reverseWords(char[] str) {
        int length = str.length;
        //reverse the string completely
        reverse(str,0,length - 1);
        
        int start = 0;
        //reverse each word
        for (int index = 0; index < str.length; index++) {
            if (str[index] == ' ') {
                reverse(str,start,index-1);
                start = index + 1;
            }
        }
        reverse(str,start,length - 1);
    }
    
    private void reverse(char[] str, int start, int end) {
        while(start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
