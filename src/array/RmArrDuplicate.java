package array;

public class RmArrDuplicate {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.print(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int j = 0; // slow

        for (int i=1; i<nums.length; i++) { // fast
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
                count++;
            }
        }

        return count;
    }
}
