package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBasket {
    public static void main(String[] args) {
        int[] fruits = {1,0,1,4,1,4,1,2,3};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>(); // we can also get the number of types form map
        int j = 0, res = 0; // j is the left pointer

        for (int i=0; i<fruits.length; i++) { // i is the right pointer
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) { // we have to make sure the size of map is 2
                map.put(fruits[j], map.get(fruits[j]) - 1);
                if (map.get(fruits[j]) == 0) map.remove(fruits[j]); // delete from map
                j++; // go right
            }
            res = Math.max(res, i - j + 1); // i - j + 1 is the number of fruit
        }

        return res;
    }

    public static int totalFruitBF(int[] fruits) {
        int sum = 0, max = 0;

        for (int i=0; i<fruits.length; i++) {
            sum = 0;
            Set<Integer> exists = new HashSet<>();
            for (int j=i; j<fruits.length; j++) {
                exists.add(fruits[j]);
                if (exists.size() > 2) break;
                sum += 1;
            }
            max = Math.max(sum, max);
        }

        return max;
    }
}
