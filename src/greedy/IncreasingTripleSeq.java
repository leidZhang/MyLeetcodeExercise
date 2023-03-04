package greedy;

public class IncreasingTripleSeq {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i]; // replace old first
            } else if (nums[i] <= second) {
                second = nums[i]; // replace old second
            } else {
                return true; // first < second < nums[i]
            }
        }

        return false;
    }

    public boolean increasingTriplet2(int[] nums) { // exceed time limit
        for (int j=1; j<nums.length-1; j++) {
            boolean first = false;
            for (int i=0; i<j; i++) {
                if (nums[i] < nums[j]) {
                    first = true;
                    break;
                }
            }
            if (!first) continue;

            boolean second = false;
            for (int k=j+1; k<nums.length; k++) {
                if (nums[j] < nums[k]) {
                    second = true;
                    break;
                }
            }
            if (!second) continue;

            if (first && second) return true;
        }

        return false;
    }
}
