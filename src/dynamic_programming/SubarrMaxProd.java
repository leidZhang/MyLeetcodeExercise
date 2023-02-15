package dynamic_programming;

public class SubarrMaxProd {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    /**
     * 3 possibilities:
     * dpMax[i], dpMax[i] * dpMax[i-1], dpMax[i] * dpMin[i-1] for dpMax.
     * dpMin is similar to dpMax, but store the min values
     *
     * dpMax 2 max(3, 2*3, 2*3) -2 4
     * dpMin 2 min(3, 2*3, 2*3) -2 4
     *
     * dpMax 2 6 max(-2, -2*6, 3*-2) 4
     * dpMin 2 3 min(-2, -2*6, 3*-2) 4
     *
     * dpMax 2 6  -2 max(4, -2*4, 4*-12)
     * dpMin 2 3 -12 min(4, -2*4, 4*-12)
     *
     * dpMax 2 6  -2  4
     * dpMin 2 3 -12 -48
     * */
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        for (int i=0; i<n; i++) {
            dpMax[i] = nums[i];
            dpMin[i] = nums[i];
        }

        for (int i=1; i<n; i++) {
            dpMax[i] = findMax(dpMax[i], dpMax[i] * dpMax[i-1], dpMax[i] * dpMin[i-1]);
            dpMin[i] = findMin(dpMin[i], dpMin[i] * dpMin[i-1], dpMin[i] * dpMax[i-1]);
        }

        printArray(dpMax);
        printArray(dpMin);

        return Math.max(maxInArray(dpMax), maxInArray(dpMin));
    }

    private static int maxInArray(int[] dp) {
        int max = dp[0];
        for (int i=1; i<dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int findMax(int i, int j, int k) {
        int max1 = Math.max(i, j);
        return Math.max(max1, k);
    }

    private static int findMin(int i, int j, int k) {
        int min1 = Math.min(i, j);
        return Math.min(min1, k);
    }

    private static void printArray(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
}
