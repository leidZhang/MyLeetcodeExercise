package monotonic_stack;

import java.util.Map;

public class TrapRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,1,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
}
