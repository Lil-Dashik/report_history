package Report;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.toList();

        Optional<? extends T> min = list.stream().min(order);
        Optional<? extends T> max = list.stream().max(order);

        minMaxConsumer.accept(min.orElse(null), max.orElse(null));
    }

    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(5,7,9,2,56,0, -5);
        findMinMax(numbers, Integer::compareTo, (min, max) ->
                System.out.println("Min: " + min + ", Max: " + max));
    }
}
