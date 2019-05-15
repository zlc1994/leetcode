package _0001;

import org.openjdk.jmh.annotations.*;

public class SolutionBenchMark {
    @State(Scope.Benchmark)
    public static class ExecutionPlan {
        private int[] nums;

        private int target;

        private Solution solution;

        @Setup(Level.Invocation)
        public void setUp() {
            nums = new int[1000000];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = i;
            }
            target = 1999997;
            solution = new Solution();
        }
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 5)
    public void benchTwoSum(ExecutionPlan plan) {
        plan.solution.twoSum(plan.nums, plan.target);
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
