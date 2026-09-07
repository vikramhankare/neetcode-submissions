class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int i = 0; i<nums.length; i++){
            if(s.contains(nums[i]) == true)
                return true;
            
            s.add(nums[i]);
        }


        return false;
    }
}