package array;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int[] res = new int[nums.length];

        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                res[j++] = nums[i];
            }
        }

        for (int i=0; i<res.length; i++) {
            nums[i] = res[i];
        }
    }
}
