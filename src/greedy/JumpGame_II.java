package greedy;

public class JumpGame_II {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int cur = 0,next = 0, res = 0;
        for (int i=0; i<nums.length; i++) {
            next = Math.max(next, i+nums[i]);
            if (i == cur) {
                if (cur != nums.length - 1) {
                    res++; cur = next;
                } else {
                    break;
                }
            }

            if (cur >= nums.length - 1) {
                break;
            }
        }

        return res;
    }
}
