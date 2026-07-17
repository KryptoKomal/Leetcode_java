class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0 ;
        int right = (int)Math.sqrt(c);
        while(left<=right){
            long sum = (long) left*left + right*right ;
            if(c == sum )   return true;
            else if(sum<c)  left++ ;
            else    right--;
        }
        return false ;
    }
}