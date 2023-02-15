package array;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0; // two pointers

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(nums, fast, slow);
                slow++;
            }
            fast++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

