class Solution {
    public class Pair{
        int freq;
        int num;

        public Pair(int freq, int num){
            this.freq = freq;
            this.num = num;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i<n; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for(Map.Entry<Integer, Integer> entry: m.entrySet()){
            minHeap.offer(new Pair(entry.getValue(), entry.getKey()));
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i = 0; i<k; i++){
            ans[i] = minHeap.poll().num;
        }

        return ans;
    }
}
