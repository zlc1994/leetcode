package _0004;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class SolutionBenchMark4 {
    private int[] nums1 = new int[1000000];

    private int[] nums2 = new int[100000];

    private Solution solution = new Solution();

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SolutionBenchMark4.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setUp() {
        Random r = new Random();

        for (int i = 0; i < 1000000; i++) {
            nums1[i] = r.nextInt(0x7fffffff);
        }

        for (int i = 0; i < 100000; i++) {
            nums2[i] = r.nextInt(0x7fffffff);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    @Benchmark
    public double benchMarkFindMedianSortedArrays1() {
        return solution.findMedianSortedArrays1(nums1, nums2);
    }

    @Benchmark
    public double benchMarkFindMedianSortedArrays2() {
        return solution.findMedianSortedArrays2(nums1, nums2);
    }
}
