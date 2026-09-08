class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] leftToRightProd = new int[n];
        Arrays.fill(leftToRightProd, 1);

        int[] rightToLeftProd = new int[n];
        Arrays.fill(rightToLeftProd, 1);

        for(int i = 1; i<n; i++){
            leftToRightProd[i] = leftToRightProd[i-1] * nums[i-1];
        }

        for(int i = n-2; i>=0; i--){
            rightToLeftProd[i] = rightToLeftProd[i+1] * nums[i+1];
        }

        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            ans[i] = leftToRightProd[i]*rightToLeftProd[i];
        }

        return ans;
    }
}  
