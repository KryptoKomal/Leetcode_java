class Solution {
    public int maxVowels(String s, int k) {
        int count =0;

        //first slide
        for(int i = 0;i<k;i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        int max= count;
         // Slide window
        for (int i = k; i < s.length(); i++) {

            // Remove left character
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            // Add right character
            if (isVowel(s.charAt(i))) {
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public boolean isVowel(char ch) {
        return ch == 'a' ||
               ch == 'e' ||
               ch == 'i' ||
               ch == 'o' ||
               ch == 'u';
    
    }
}