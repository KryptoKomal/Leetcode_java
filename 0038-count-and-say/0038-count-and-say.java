class Solution {
    public String countAndSay(int n){
        return Fn(n);
    }
    private String Fn(int n){
        if(n == 1){
            return "1";
        }
        String str = Fn(n - 1);
        StringBuilder res = new StringBuilder("");
        int left = 0,right = 0,strLen = str.length(),len = 0;
        char currEle = str.charAt(0);
        while(right <= strLen){
            if(right == strLen || currEle != str.charAt(right)){
                res.append(len+""+currEle);
                if(right == strLen)
                    break;
                currEle = str.charAt(right);
                left = right;
            }
            len = right - left + 1;
            right++;
        }
        return res.toString();
    }
}