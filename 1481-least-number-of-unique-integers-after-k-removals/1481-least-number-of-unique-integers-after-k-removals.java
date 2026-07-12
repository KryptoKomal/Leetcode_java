class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<Integer> A = new ArrayList<>();
        int c = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i-1]){
                c++;
            }else{
                A.add(c);
                c = 1;
            }
        }
        A.add(c);
        Collections.sort(A);
        c = 0;
        while(k > 0){
            if(A.get(c) <= k){
                k -= A.get(c);
                c++;
            }else{
                k = 0;
            }
        }
        return A.size()-c;
    }
}