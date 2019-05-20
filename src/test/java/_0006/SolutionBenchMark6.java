package _0006;

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
public class SolutionBenchMark6 {
    private static final String s = StringUtil.newRandomString(10000);

    private static final int numRows = 100;

    private static final Solution solution = new Solution();

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SolutionBenchMark6.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public String benchMarkConvert1() {
        return solution.convert1(s, numRows);
    }

    @Benchmark
    public String benchMarkConvert2() {
        return solution.convert2(s, numRows);
    }
}
