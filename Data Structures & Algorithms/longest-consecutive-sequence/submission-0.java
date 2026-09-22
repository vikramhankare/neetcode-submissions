class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> m = new HashSet<>();
        int n = nums.length;

        for(int i = 0; i<n; i++){
            m.add(nums[i]);
        }

        int count = 0;
        int maxCount = 0;

        for(int i = 0; i<n; i++){
            if(m.contains(nums[i]-1) == true){
                continue;
            }
            else{
                count = 1;
                int ele = nums[i]+1;
                while(m.contains(ele) == true){
                    count++;
                    ele++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
