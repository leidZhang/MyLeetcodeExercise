package array;

public class SortColor {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void sortColors(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;

        int mid = len / 2, j = 0;
        int leftArr[] = new int[mid];
        int rightArr[] = new int[len - mid];
        for (int i=0; i<nums.length; i++) {
            if (i < mid) leftArr[i] = nums[i];
            else rightArr[j++] = nums[i];
        }

        sortColors(leftArr);
        sortColors(rightArr);
        merge(leftArr, rightArr, nums);
    }

    public static void merge(int[] leftArr, int[] rightArr, int[] nums) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) nums[k++] = leftArr[i++];
        while (j < rightArr.length) nums[k++] = rightArr[j++];
    }
}
