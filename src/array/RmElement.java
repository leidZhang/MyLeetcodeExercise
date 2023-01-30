package array;

public class RmElement {
    public static void main(String[] args) {
        int[] nums = {1,1};
        int val = 1;

        System.out.println(removeElement(nums, val));
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        int count = 0;

        for (int i=0; i<nums.length; i++) { // scan from left
            while (j>=0 && nums[j] == val) j--; // scan from right

            if(nums[i] == val && j>i) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        for (int i=0; i<nums.length; i++) { // count non-vals
            if (nums[i] != val) {
                count++;
            }
        }
        return count;
    }
}
