package hashtable;

import java.util.Arrays;

public class ImplHashMap {
    class MyHashMap {
        int[] vals = new int[1000001];

        public MyHashMap() {
            Arrays.fill(vals, -1);
        }

        public void put(int key, int value) {
            vals[key] = value;
        }

        public int get(int key) {
            return vals[key];
        }

        public void remove(int key) {
            vals[key] = -1;
        }
    }
}
