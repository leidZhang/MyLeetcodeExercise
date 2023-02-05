package array;

public class SqSortedArr {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] res = sortedSquares(nums);

        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int k = nums.length - 1; // res pointer
        int l = 0, r = nums.length - 1;

        while (l <= r) { // double pointers
            if (nums[l] * nums[l] >= nums[r] * nums[r]) {
                res[k--] = nums[l] * nums[l]; l++;
            } else {
                res[k--] = nums[r] * nums[r]; r--;
            }
        }

        return res;
    }
}
