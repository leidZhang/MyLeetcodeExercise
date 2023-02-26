package slidingwindow;

public class SubArrProdLessK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;

        int j = 0, prod = 1; // j is slide window left bound
        for (int i=0; i<nums.length; i++) { // slide window right bound
            prod *= nums[i];
            while (j < i && prod >= k) { // j should not larger than i
                prod /= nums[j++]; // do not use if !!!
            }
            if (prod < k) {
                cnt += i - j + 1; // for example, [10, 2], we have [10, 2] and [2]
            }
        }

        return cnt;
    }
}
