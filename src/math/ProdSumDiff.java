package math;

public class ProdSumDiff {
    public int subtractProductAndSum(int n) {
        int sum = 0, prod = 1;
        int temp = n;

        while (temp != 0) {
            int dig = temp % 10;
            sum += dig;
            temp /= 10;
        }

        while (n != 0) {
            int dig = n % 10;
            prod *= dig;
            n /= 10;
        }
        System.out.println(prod);
        return prod - sum;
    }
}
