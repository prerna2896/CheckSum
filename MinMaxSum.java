import java.util.List;
import java.util.zip.Checksum;

public class MinMaxSum extends CheckSum {

    public MinMaxSum(List<List<Integer>> table) {
        super(table);
        System.out.println("Checksum using minimum and maximum values");
    }

    @Override
    public Integer rowCheckSum(List<Integer> row) {
        Integer min = row.get(0);
        Integer max = row.get(0);
        for (Integer entry: row) {
            if (entry == null) {
                throw new NullPointerException("The entry in the table is null");
            }
            if (entry < min) {
                min = entry;
            }
            if (entry > max) {
                max = entry;
            }
        }
        return (max - min);
    }

}
