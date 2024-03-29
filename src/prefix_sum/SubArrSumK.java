package prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class SubArrSumK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n+1]; // can be integrated into the loop below
        prefix[0] = nums[0];
        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>(); // prefix[i], num of prefix[i]
        int cnt = 0; map.put(0, 1);
        for (int i=0; i<n; i++) { // prefix[i] - prefix[j] = sum of the subarray from i to j
            if (map.containsKey(prefix[i] - k)) { // we have to find a prefix[i] - prefix[j] = k
                cnt += map.get(prefix[i] - k);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1); // add to map
        }

        return cnt;
    }
}
