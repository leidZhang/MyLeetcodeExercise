package greedy;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    /**
     * We have to find the max value in the current jump range
     * 2, 3, 1, 1, 4
     * |  |  |            <- range (1st jump)
     *    |  |  |  |      <- range (2nd jump)
     * */
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true; // corner case
        int cover = 0;

        for (int i=0; i<=cover; i++) {
            cover = Math.max(cover, i + nums[i]); // select the max value in the range
            if (cover >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
