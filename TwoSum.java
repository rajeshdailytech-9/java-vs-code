
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {

        // Automatically closes the Scanner after execution.
        try (Scanner scanner = new Scanner(System.in)) {

            // Read the total number of test cases.
            int testCases = scanner.nextInt();

            // Execute each test case independently.
            for (int testCase = 1; testCase <= testCases; testCase++) {

                // Read the array size.
                int n = scanner.nextInt();

                // Read array elements.
                int[] nums = new int[n];

                for (int i = 0; i < n; i++) {
                    nums[i] = scanner.nextInt();
                }

                // Read the target sum.
                int target = scanner.nextInt();

                // Find two indices whose elements add up to the target.
                int[] result = twoSum(nums, target);

                // Display test case details and result.
                System.out.println("Test Case " + testCase);
                System.out.println("Input Array : " + Arrays.toString(nums));
                System.out.println("Target      : " + target);

                if (result[0] != -1) {
                    System.out.println("Result      : " + Arrays.toString(result));
                    System.out.println("Numbers     : " +
                            nums[result[0]] + " + " + nums[result[1]]
                            + " = " + target);
                } else {
                    System.out.println("Result      : No valid pair found");
                }

                System.out.println();
            }
        }
    }

    /**
     * Finds two distinct indices such that their corresponding
     * array elements add up to the given target.
     *
     * Approach: HashMap
     *
     * Key   : Previously visited array element.
     * Value : Index of that element.
     *
     * @param nums   Input integer array.
     * @param target Required sum of two elements.
     * @return Two indices if a valid pair exists;
     *         otherwise returns {-1, -1}.
     *
     * Time Complexity  : O(n) average.
     * Space Complexity : O(n).
     */
    private static int[] twoSum(int[] nums, int target) {

        // Store previously visited numbers and their indices.
        Map<Integer, Integer> indexMap = new HashMap<>();

        // Traverse the array only once.
        for (int i = 0; i < nums.length; i++) {

            // Calculate the number needed to reach the target.
            int complement = target - nums[i];

            // Check whether the required number already exists.
            if (indexMap.containsKey(complement)) {

                // Return the matching previous index and current index.
                return new int[] {
                    indexMap.get(complement),
                    i
                };
            }

            // Store the current number and its index.
            // putIfAbsent preserves the first occurrence of duplicates.
            indexMap.putIfAbsent(nums[i], i);
        }

        // Return {-1, -1} when no valid pair is found.
        return new int[] {-1, -1};
    }
}
