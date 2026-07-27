class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit  = new ArrayList<>();
        separateLetterDigit(logs,letter,digit);
        sortLetters(letter);
        return output(letter,digit);
    }
    static void separateLetterDigit(String logs[],List<String> letter,List<String> digit)
    {
        for(String str : logs)
            {
                if(Character.isDigit(str.charAt(str.length()-1)))
                       digit.add(str);
                else
                    letter.add(str);
            }
    }
    static void sortLetters(List<String> letter)
    {
        Collections.sort(letter,new Comparator<String>(){
            public int compare(String o1,String o2)
            {
                String s1 = o1.substring(o1.indexOf(" ")+1);
                String s2 = o2.substring(o2.indexOf(" ")+1);

                return s1.equals(s2)?o1.compareTo(o2):s1.compareTo(s2);
            }
        });
    }
    static String[] output(List<String> letter , List<String> digit)
    {
        int n = letter.size()+digit.size();
        String arr[]=new String[n];
        for(int i=0;i<letter.size();i++)
            {
                arr[i]=letter.get(i);
            }
        for(int i=letter.size();i<n;i++)
            {
                arr[i]=digit.get(i-letter.size());
            }
        return arr;
    }
}