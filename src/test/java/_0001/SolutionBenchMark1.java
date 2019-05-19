package _0001;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author zlc1994
 * create at 2019-05-19 15:21
 **/
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class SolutionBenchMark1 {
    @Param({"100", "1000", "10000"})
    private int length;

    private int[] nums;

    private int target;

    private Solution solution;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SolutionBenchMark1.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .resultFormat(ResultFormatType.CSV)
                .build();

        new Runner(opt).run();
    }


    @Setup
    public void setUp() {
        solution = new Solution();
        nums = new int[length];
        target = 2 * length - 3;

        for (int i = 0; i < length; i++) {
            nums[i] = i;
        }
    }

    @Benchmark
    public int[] benchMarkTwoSum1() {
        return solution.twoSum1(nums, target);
    }

    @Benchmark
    public int[] benchMarkTwoSum2() {
        return solution.twoSum2(nums, target);
    }
}
