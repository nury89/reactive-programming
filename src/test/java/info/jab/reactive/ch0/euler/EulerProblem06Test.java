package info.jab.reactive.ch0.euler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EulerProblem06Test extends BaseEulerProblemTest {

    @Disabled
    @Test
    public void given_JavaSolution_when_executeMethod_then_expectedResultsTest() {

    }

    @Test
    public void given_JavaStreamSolution_when_executeMethod_then_expectedResultsTest() {

        EulerProblem06 problem6 = new EulerProblem06();

        assertThat(problem6.JavaStreamSumSquare.apply(10L)).isEqualTo(385);
        assertThat(problem6.JavaStreamSquareSum.apply(10L)).isEqualTo(3025);

        assertThat(problem6.JavaStreamSolution(10L)).isEqualTo(2640);
        assertThat(problem6.JavaStreamSolution(100L)).isEqualTo(euler.getAnswerToLong(6));
    }

    @Disabled
    @Test
    public void given_ReactorSolution_when_executeMethod_then_expectedResultsTest() {

        EulerProblem06 problem6 = new EulerProblem06();

        assertThat(problem6.square.apply(2L)).isEqualTo(4L);

        StepVerifier
                .create(problem6.reactorSumSquare(10))
                .expectNext(385L)
                .expectComplete()
                .verify();

        StepVerifier
                .create(problem6.reactorSquareSum(10))
                .expectNext(3025L)
                .expectComplete()
                .verify();

        StepVerifier
                .create(problem6.ReactorSolution(10))
                .expectNext(2640L)
                .expectComplete()
                .verify();

        StepVerifier
                .create(problem6.ReactorSolution(100))
                .expectNext(euler.getAnswerToLong(6))
                .expectComplete()
                .verify();
    }

}