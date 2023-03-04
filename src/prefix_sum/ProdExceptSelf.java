package prefix_sum;

public class ProdExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i=1; i<n; i++) { // prefix product, i.e. product before nums[i];
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        int[] postfix = new int[n];
        postfix[n-1] = 1;
        for (int i=n-2; i>=0; i--) { // postfix product, i.e. product after nums[i];
            postfix[i] = postfix[i+1] * nums[i+1];
        }

        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = prefix[i] * postfix[i]; // prefix * postfix is the result
        }

        return res;
    }
}
