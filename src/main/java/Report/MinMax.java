package Report;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MinMax<T> {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> minMax = new ArrayList<>(Arrays.asList(null, null));
        stream.forEach(n -> {
            if (minMax.get(0)== null || order.compare(n, minMax.get(0)) < 0) {
                minMax.set(0, n);
            }
            if (minMax.get(1) == null || order.compare(n, minMax.get(1)) > 0) {
                minMax.set(1, n);
            }
        });
        minMaxConsumer.accept(minMax.get(0), minMax.get(1));
    }


    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(5, 7, 9, 2, 56, 0, -5);
        findMinMax(numbers, Integer::compareTo, (min, max) ->
                System.out.println("Min: " + min + ", Max: " + max));
    }
}
// можно было бы ещё вот так, но на степике метод findMinMax статический.
//private T min = null;
//private T max = null;
//public static <T> void findMinMax(
//        Stream<? extends T> stream,
//        Comparator<? super T> order,
//        BiConsumer<? super T, ? super T> minMaxConsumer) {
//      stream.forEach(t -> {
//            if (order.compare(t, this.min) == -1) {
//                min = t;
//            }
//            if (order.compare(t, this.max) == 1) {
//                max = t;
//            }
//        });
//        minMaxConsumer.accept(min, max);
// }


