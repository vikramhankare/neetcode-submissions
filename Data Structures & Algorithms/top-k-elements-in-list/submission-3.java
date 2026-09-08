class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i<n; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
        }

        List<Integer> [] freq = new List[n+1];
        for(int i = 0; i<freq.length; i++){
            freq[i] = new ArrayList<>();
        }


        for(Map.Entry<Integer, Integer> entry: m.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] ans = new int[k];
        int idx = 0;
        for(int i = freq.length-1; i>0 && idx<k; i--){
            for(int ele: freq[i]){
                ans[idx++] = ele;
                if(idx == k)
                    return ans;
            }
        }

        return ans;
    }
}
