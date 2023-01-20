import java.util.Collections;
import java.util.*;

public class DivisibleSum extends CheckSum {

    public DivisibleSum(List<List<Integer>> table) {
        super(table);
        System.out.println("Checksum using divisible numblers");
    }

    @Override
    public Integer rowCheckSum(List<Integer> row) {
        List<Integer> unsortedRow = new ArrayList<Integer>(row);
        Collections.sort(row);
        int numZeroes = 0;
        for (int i = 0; i < row.size() - 1; i++) {
            if (row.get(i) == null) {
                throw new NullPointerException("The entry in the table is null");
            }
            // if the input is 0, record it and continue
            if (row.get(i) == 0) {
                numZeroes++;
                continue;
            }
            for (int j = row.size() - 1; j >= i && row.get(j) >= 2 * row.get(i); j--) {
                if (row.get(i) != 0 && row.get(j) % row.get(i) == 0) {
                    return (row.get(j) / row.get(i));
                }
            }
        }
        // If there is single 0 in the row, we consider it valid and return 0 as the result of division of 0 by any input
        if (numZeroes == 1) {
            return 0;
        } else {
            throw new IllegalArgumentException("The row " + unsortedRow.toString() + " has invalid input with no possible answers");
        }
    }
}
