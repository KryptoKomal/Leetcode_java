class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            if(map.get(a).equals(map.get(b))){
                return b.compareTo(a);
            }
            return map.get(a) - map.get(b);
        });
        for(String word : map.keySet()){
            pq.offer(word);
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
    }
}