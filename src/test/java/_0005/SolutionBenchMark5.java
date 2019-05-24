package _0005;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import util.StringUtil;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class SolutionBenchMark5 {
    private Solution solution = new Solution();

    private String s = "babcbabcbaccba";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SolutionBenchMark5.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public String benchLongestPalindrome1() {
        return solution.longestPalindrome1(s);
    }

    @Benchmark
    public String benchLongestPalindrome2() {
        return solution.longestPalindrome2(s);
    }

    @Benchmark
    public String benchLongestPalindrome3() {
        return solution.longestPalindrome3(s);
    }
}
