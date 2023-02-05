package divide_and_conquer;

public class SortArrQS {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        nums = sort(nums);

        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");
    }

    private static int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start > end) return;
        int i = partition(nums, start, end);
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= right && nums[left] <= nums[start]) left++; // find the number should in the right of the pivot
            while (left <= right && nums[right] >= nums[start]) right--; // find the number should in the left of the pivot
            if (left <= right) swap(nums, left, right); // swap these 2 numbers to put them into the correct part
        }
        swap(nums, start, right); // swap the pivot to the right place

        return right;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
