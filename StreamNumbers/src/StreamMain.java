import java.util.Arrays;
import java.util.stream.*;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        //System.out.println(array);
        Stream<Integer> stream = array.stream();
        List<Integer> list = stream
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
