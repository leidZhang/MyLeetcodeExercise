package prefix_sum;

public class OddSubArrSum {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];

        for (int i=0; i<n; i++) {
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }

        int sum = 0;
        for (int start=0; start<n; start++) {
            for (int len=1; start+len<=n; len+=2) { // 0 + 3 = 3, for instance
                int end = start + len;
                sum += prefixSum[end] - prefixSum[start];
            }
        }

        return sum;
    }
}
