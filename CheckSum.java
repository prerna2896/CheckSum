import java.util.*;

public abstract class CheckSum {
    final List<List<Integer>> table;

    public CheckSum(List<List<Integer>> table) {
        if (table == null || table.size() == 0) {
            throw new IllegalArgumentException("The input is empty");
        }
        this.table = table;
    }

    /**
     * Function which would calculate the checksum for the table and return it.
     */
    public void getCheckSum() {
        System.out.println("For the table: ");
        for (int i = 0; i < table.size(); i++) {
            System.out.println(table.get(i).toString());
        }

        Integer sum = 0;
        for (List<Integer> row: table) {
            if (row == null || row.size() == 0) {
                throw new IllegalArgumentException("The input row is null");
            }
            sum += rowCheckSum(row);
        }

        System.out.println("The output of checksum is: " + sum + '\n');
    }

    /**
     * Function which would calculate the checksum for the row and return it.
     *
     * @param row - Row of inputs to calculate checksum for
     */
    public abstract Integer rowCheckSum(List<Integer> row);
}
