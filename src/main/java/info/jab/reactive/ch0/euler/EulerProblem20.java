package info.jab.reactive.ch0.euler;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Problem 20: Factorial digit sum
 * n! means n (n 1) ... 3 2 1
 * <p>
 * For example, 10! = 10   9   ...   3   2   1 = 3628800,
 * <p>
 * and the sum of the digits in the number 10! is
 * 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p>
 * Find the sum of the digits in the number 100!
 */
public class EulerProblem20 {

    Function<Long, BigDecimal> multiplyFactorial = number -> LongStream.range(1, number).mapToObj(BigDecimal::valueOf)
            .reduce(BigDecimal.valueOf(1), BigDecimal::multiply);

    Function<BigDecimal, List<Long>> listDigitsFactorial = number -> number.toString().chars().
            mapToObj(x -> String.valueOf((char) x)).map(Long::valueOf).collect(Collectors.toList());

    public Long JavaStreamSolution(Long number) {
        return listDigitsFactorial.apply(multiplyFactorial.apply(number)).stream().reduce(0L, Long::sum);
    }

    public Mono<Long> ReactorSolution(Long number) {
        return Flux.fromStream(listDigitsFactorial.apply(multiplyFactorial.apply(number)).stream()).reduce(0L, Long::sum);
    }

}
