import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        System.out.println(array);

        List<Integer> listInt = new ArrayList<>();
        for(int x : array) {
            if (x > 0 && x % 2 == 0) {
                listInt.add(x);
            }
        }
        Collections.sort(listInt);
        System.out.println(listInt);
    }
}