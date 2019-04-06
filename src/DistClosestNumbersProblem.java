import java.util.Arrays;

public class DistClosestNumbersProblem {

    static int bruteForceSolution(int[] numbers) {
        // try to implement it!
        int minDistance = 999;
        int iterationCount = 0;

        // brute force is O(N * N)..
        for (int i = 0, numbersLength = numbers.length; i < numbersLength; i++) {
            int currentNumber = numbers[i];
            for (int j = 1; j < numbers.length; j++) {
                int nextNumber = numbers[j];

                System.out.println("currentNumber = " + currentNumber + " nextNumber = " + nextNumber);

                int distance = nextNumber - currentNumber;
                if (distance > 0 && distance < minDistance) {
                    minDistance = distance;
                    System.out.println("now minDistance is: " + minDistance);
                }

                iterationCount++;
            }
        }

        System.out.println("Total iteration count = " + iterationCount);
        return minDistance;
    }

    static int absBasedSolution(int[] numbers) {
        int minDistance = 999;
        int iterationCount = 0;

        for (int i = 0, numbersLength = numbers.length; i < numbersLength; i++) {
            int currentNumber = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int nextNumber = numbers[j];

                System.out.println("currentNumber = " + currentNumber + " nextNumber = " + nextNumber);

                int distance = Math.abs(nextNumber - currentNumber);
                if (distance < minDistance) {
                    minDistance = distance;
                    System.out.println("now minDistance is: " + minDistance);
                }

                iterationCount++;
            }
        }

        System.out.println("Total iteration count = " + iterationCount);
        return minDistance;
    }

    static int sortedArraySolution(int[] numbers) {
        int minDistance = 999;
        int iterationCount = 0;

        Arrays.sort(numbers);
        System.out.println("sorted array = " + Arrays.toString(numbers));
        for (int i = 1; i < numbers.length; i++) {
            int currentNumber = numbers[i - 1];
            int nextNumber = numbers[i];
            int distance = nextNumber - currentNumber;

            if (distance < minDistance) {
                minDistance = distance;
            }

            iterationCount++;
        }

        System.out.println("Total iteration count = " + iterationCount);
        return minDistance;
    }

    // Returns the distance between the two closest numbers.
    public static void main(String[] args) {
        int[] testArray = {3, 9, 50, 15, 99, 7, 98, 65};
//        int result = bruteForceSolutionDistClosestNumbers(testArray);
        int result = sortedArraySolution(testArray);
        System.out.println(result); // Expected result is 1 (the 2 closest numbers are 98 and 99)
    }
}