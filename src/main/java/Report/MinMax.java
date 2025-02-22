package Report;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MinMax<T> {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        Optional<List<T>> minMax = stream.reduce(
                Optional.empty(),
                (acc, n) -> Optional.of(Arrays.asList(
                        acc.map(list -> order.compare(n, list.get(0)) < 0 ? n : list.get(0)).orElse(n),
                        acc.map(list -> order.compare(n, list.get(1)) > 0 ? n : list.get(1)).orElse(n)
                )),
                (a, b) -> a
        );
        minMaxConsumer.accept(
                minMax.map(list -> list.get(0)).orElse(null),
                minMax.map(list -> list.get(1)).orElse(null)
        );
    }


    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(5, 7, 9, 2, 56, 0, -5);
        findMinMax(numbers, Integer::compareTo, (min, max) ->
                System.out.println("Min: " + min + ", Max: " + max));
    }
}

