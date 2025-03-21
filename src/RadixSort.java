import java.util.*;

public class RadixSort {
    public static void radixSort(String[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int max = getMax(array);

        for (int i = max - 1; i >= 0; i--) {
            countSort(array, i);
        }
    }

    private static int getMax(String[] array) {
        int max = 0;
        for (int i = 0; i< array.length; i++){
            if (max < array[i].length()){
                max = array[i].length();
            }
        }
        return max;
    }

    private static void countSort(String[] array, int index) {
        List<String>[] buckets = new ArrayList[256];
        for (int i = 0; i < 256; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (String s : array) {
            char key = '\0';
            if (index < s.length()) {
                key = s.charAt(index);
            }
            buckets[key].add(s);
        }

        int idx = 0;
        for (int i = 0; i < 256; i++) {
            for (String s : buckets[i]) {
                array[idx++] = s;
            }
        }
    }

    public static void main(String[] args) {
        String[] array = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino", "amaterasu",
                "amazon", "puppy", "hydra", "amazonia", "vueltiao"};

        radixSort(array);

        System.out.println(String.join(", ", array));
    }
}
