package util;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class SortUtilBenchMark {
    private int length = 10000;

    private int[] randomArray;

    private int[] sortedArray;

    private int[] almostSortedArray;

    private int[] reversedArray;

    private static final int[] seq1 = {1, 5, 19, 41, 109, 209, 505, 929};

    private static final int[] seq2 = {1, 8, 23, 77, 281, 1073, 4193};

    private static final int[] seq3 = {1, 4, 13, 40, 121, 364, 1093, 3280};

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SortUtilBenchMark.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .resultFormat(ResultFormatType.CSV)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setUp() {
        randomArray = SortUtil.newRandomArray(length);
        sortedArray = SortUtil.newSortedArray(length);
        almostSortedArray = SortUtil.newAlmostSortedArray(length, 0.1);
        reversedArray = SortUtil.newReversedArray(length);
    }

//    @Benchmark
//    public void benchMarkSelectionSortWithRandomArray() {
//        SortUtil.selectionSort(randomArray);
//    }
//
//    @Benchmark
//    public void benchMarkSelectionSortWithSortedArray() {
//        SortUtil.selectionSort(sortedArray);
//    }
//
//    @Benchmark
//    public void benchMarkSelectionSortWithAlmostSortedArray() {
//        SortUtil.selectionSort(almostSortedArray);
//    }
//
//    @Benchmark
//    public void benchMarkSelectionSortWithReversedArray() {
//        SortUtil.selectionSort(reversedArray);
//    }
//
//    @Benchmark
//    public void benchMarkInsertionSortWithRandomArray() {
//        SortUtil.insertionSort(randomArray);
//    }
//
//    @Benchmark
//    public void benchMarkInsertionSortWithSortedArray() {
//        SortUtil.insertionSort(sortedArray);
//    }
//
//    @Benchmark
//    public void benchMarkInsertionSortWithAlmostSortedArray() {
//        SortUtil.insertionSort(almostSortedArray);
//    }
//
//    @Benchmark
//    public void benchMarkInsertionSortWithReversedArray() {
//        SortUtil.insertionSort(reversedArray);
//    }

    @Benchmark
    public void benchMarkShellSortWithRandomArray1() {
        SortUtil.shellSort(randomArray, seq1);
    }

    @Benchmark
    public void benchMarkShellSortWithRandomArray2() {
        SortUtil.shellSort(randomArray, seq2);
    }

    @Benchmark
    public void benchMarkShellSortWithRandomArray3() {
        SortUtil.shellSort(randomArray, seq3);
    }


//    @Benchmark
//    public void benchMarkShellSortWithSortedArray() {
//        SortUtil.shellSort(sortedArray);
//    }
//
//    @Benchmark
//    public void benchMarkShellSortWithAlmostSortedArray() {
//        SortUtil.shellSort(almostSortedArray);
//    }
//
//    @Benchmark
//    public void benchMarkShellSortWithReversedArray() {
//        SortUtil.shellSort(reversedArray);
//    }
}
