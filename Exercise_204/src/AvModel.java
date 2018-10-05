
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AvModel extends AbstractTableModel {

    private ArrayList<Anlage> anlagen = new ArrayList<>();

    private static String[] colNames = {"Bezeichnung", "AK", "Inbetr.na...", "ND", "bish. ND",
        "AfA bisher", "Wert vor ...", "AfA d. J.", "BW 31.12"};

    @Override
    public int getRowCount() {
        return anlagen.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return colNames[i];

    }

}
