package _0003;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import util.StringUtil;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class SolutionBenchMark3 {
    private static final String s = StringUtil.newRandomString(1000);

    private static final Solution solution = new Solution();

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SolutionBenchMark3.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public int benchLengthOfLongestSubstring1() {
        return solution.lengthOfLongestSubstring1(s);
    }

    @Benchmark
    public int benchLengthOfLongestSubstring2() {
        return solution.lengthOfLongestSubstring2(s);
    }

    @Benchmark
    public int benchLengthOfLongestSubstring3() {
        return solution.lengthOfLongestSubstring3(s);
    }

    @Benchmark
    public int benchLengthOfLongestSubstring4() {
        return solution.lengthOfLongestSubstring4(s);
    }

}