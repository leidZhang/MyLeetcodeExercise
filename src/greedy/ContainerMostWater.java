package greedy;

public class ContainerMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (right - left);

        while (left < right) {
            int vol = Math.min(height[left], height[right]) * (right - left);

            if (vol > max) {
                max = vol;
            }

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    /**
     * brute force, exceed time limit
     * */
    public static int maxAreaBF(int[] height) {
        int maxWidth = height.length - 1;
        int maxVol = Math.min(height[0], height[maxWidth]) * maxWidth;

        for (int i=0; i<=maxWidth; i++) {
            for (int j=i+1; j<=maxWidth; j++) {
                int h1 = height[i];
                int h2 = height[j];
                int width = j - i;

                int vol = Math.min(h1, h2) * width;

                if (vol > maxVol) {
                    maxVol = vol;
                }
            }
        }

        return maxVol;
    }
}
