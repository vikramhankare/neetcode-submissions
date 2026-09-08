class Solution {
    class Pair{
        int freq;
        int num;

        Pair(int freq, int num){
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

        List<Pair> l = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: m.entrySet()){
            l.add(new Pair(entry.getValue(), entry.getKey()));
        }

        l.sort((a, b) -> b.freq - a.freq);

        int[] ans = new int[k];
        for(int i = 0; i<k; i++){
            ans[i] = l.get(i).num;
        }

        return ans;
    }
}
