package _0003;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class SolutionBenchMark3 {
    private StringBuilder stringBuilder;

    private Solution solution;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SolutionBenchMark3.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        solution = new Solution();
        Random r = new Random();
        stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append((char) (r.nextInt(128)));
        }
    }

    @Benchmark
    public int benchLengthOfLongestSubstring1() {
        return solution.lengthOfLongestSubstring1(stringBuilder.toString());
    }

    @Benchmark
    public int benchLengthOfLongestSubstring2() {
        return solution.lengthOfLongestSubstring2(stringBuilder.toString());
    }

    @Benchmark
    public int benchLengthOfLongestSubstring3() {
        return solution.lengthOfLongestSubstring3(stringBuilder.toString());
    }

    @Benchmark
    public int benchLengthOfLongestSubstring4() {
        return solution.lengthOfLongestSubstring4(stringBuilder.toString());
    }

}