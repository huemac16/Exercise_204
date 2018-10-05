
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AvModel extends AbstractTableModel {

    private ArrayList<Anlage> anlagen = new ArrayList<>();

    private static String[] colNames = {"Bezeichnung", "AK", "Inbetr.na...", "ND", "bish. ND",
        "AfA bisher", "Wert vor ...", "AfA d. J.", "BW 31.12"};

    public void add(Anlage a) {
        anlagen.add(a);
        fireTableRowsInserted(anlagen.size() - 1, anlagen.size() - 1);
    }

    public void load(File f) {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            br.readLine();
            String s;

            while ((s = br.readLine()) != null) {
                String[] split = s.split(";");
                anlagen.add(new Anlage(split[0], Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3])));
                fireTableDataChanged();

            }

        } catch (Exception e) {
        }
    }

    public void update(int year) {

    }

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
        Anlage a = anlagen.get(i);
        return a;
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

}
