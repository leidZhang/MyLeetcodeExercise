package bit_manipulation;

public class HammingDist {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int cnt = 0;

        while (res != 0) {
            int dig = res % 2;
            if (dig == 1) {
                cnt++;
            }
            res /= 2;
        }
        return cnt;
    }
}
