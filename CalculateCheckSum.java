import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

// Assumptions:
// considered the input table as integer type for simplicity
// we can overload the methods to allow multiple data types for our table
// assuming our input will not overflow (for examples if we have to store the difference between Integer.MAX_VALUE and Integer.MIN_VALUE)
// considered single 0 in a row as a valid input, more than 1 0s as invalid input

public class CalculateCheckSum {
    public static void main(String[] args) {
        // Test the mim max checksum for the first table
        List<List<Integer>> table1 = new ArrayList<List<Integer>>();
        table1.add(Arrays.asList(5, 1, 9, 5));
        table1.add(Arrays.asList(7, 5, 3));
        table1.add(Arrays.asList(2, 4, 6, 8));
        CheckSum checkSum1 = new MinMaxSum(table1);
        checkSum1.getCheckSum();

        CheckSum checkSum_e = new DivisibleSum(table1);

        // Test that the correct exception is thrown for invalid input for the second checkSum
        whenExceptionThrown_thenAssertionSucceeds(checkSum_e);

        // check both the checksum calculations using second table
        List<List<Integer>> table2 = new ArrayList<List<Integer>>();
        table2.add(Arrays.asList(5,9,2,8));
        table2.add(Arrays.asList(9,4,7,3));
        table2.add(Arrays.asList(3,8,6,5));

        CheckSum checkSum2 = new MinMaxSum(table2);
        checkSum2.getCheckSum();

        CheckSum checkSum3 = new DivisibleSum(table2);
        checkSum3.getCheckSum();

    }

    @Test
    public static void whenExceptionThrown_thenAssertionSucceeds(CheckSum checksum) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            checksum.getCheckSum();
        });

        String expectedMessage = "has invalid input with no possible answers";
        String actualMessage = exception.getMessage();

        if (actualMessage.contains(expectedMessage)) {
            System.out.println("The right exception is thrown for invalid input \n");
        }
    }
}
