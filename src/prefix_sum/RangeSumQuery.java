package prefix_sum;

public class RangeSumQuery {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery r = new RangeSumQuery(nums);
        System.out.println(sumRange(0, 2));
        System.out.println(sumRange(2, 5));
        System.out.println(sumRange(0,5));
    }

    static int[] nums;
    static int[] prefixSum;

    RangeSumQuery(int[] nums) {
        this.nums = nums;
        numArray(nums);
    }

    public static void numArray(int[] nums) {
        int n = nums.length;

        prefixSum = new int[n+1];
        for (int i = 0; i<n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
    }

    public static int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
