package hashtable;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) { // {3,2,1,5}
        int n = nums.length;
        for (int i=0; i<n; i++) { // let nums be the hash table store the correct position
            while (nums[i] <= n && nums[i] >= 1 && nums[i] != nums[nums[i] - 1]) { // for example, nums[0]=3, nums[2]=1, swap
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i=0; i<n; i++) {
            if (nums[i] != i + 1) return i + 1; // nums[3] = 5 != 4, so return 4
        }
        return n + 1; // scan complete, but did not find a missing positive
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
