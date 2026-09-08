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

// 3. Bucket Sort
// Intuition
// Each number in the array appears a certain number of times, and the maximum possible frequency is the length of the array.
// We can use this idea by creating a list where the index represents a frequency, and at each index we store all numbers that appear exactly that many times.

// For example:

// All numbers that appear 1 time go into group freq[1].
// All numbers that appear 2 times go into group freq[2].
// And so on.
// After we build these groups, we look from the highest possible frequency down to the lowest and collect numbers from these groups until we have k of them.
// This way, we directly jump to the most frequent numbers without sorting all the elements by frequency.

// Algorithm
// Build a frequency map that counts how many times each number appears.
// Create a list of groups freq, where freq[i] will store all numbers that appear exactly i times.
// For each number and its frequency in the map, add the number to freq[frequency].
// Initialize an empty result list.
// Loop from the largest possible frequency down to 1:
// For each number in freq[i], add it to the result list.
// Once the result contains k numbers, return it.
