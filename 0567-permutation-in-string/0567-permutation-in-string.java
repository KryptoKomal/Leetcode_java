class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int l = 0;
        
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];
        
        for(Character s: s1.toCharArray()) {
            counter1[s - 'a']++;
        }

        for(int r = 0; r < s2.length(); r++) {
            int index = s2.charAt(r) - 'a';
            counter2[index]++;

            while(r-l+1 > s1.length()) {
                counter2[s2.charAt(l++) - 'a']--;
            }
            
            if(Arrays.equals(counter1, counter2)) return true;
            
        }
        return false;
    }
}