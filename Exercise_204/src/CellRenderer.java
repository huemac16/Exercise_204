
import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class CellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {

        Anlage a = (Anlage) o;
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(bln ? new Color(150, 150, 150) : new Color(240, 240, 240));
        label.setForeground(Color.BLACK);
        String formatPattern = "###,###.##";
        DecimalFormat df = new DecimalFormat(formatPattern);

        switch (i1) {
            case 0:
                label.setText(a.getText());
                break;
            case 1:
                label.setText(getFormattedStr(df.format(a.getAk())));
                break;
            case 2:
                label.setText("" + a.getYear());
                break;
            case 3:
                label.setText(df.format(a.getDuration()));
                break;
            case 4:
                label.setText(getFormattedStr(df.format(a.calcDurUntilNow(AvGUI.year))));
                break;
            case 5:
                label.setText(getFormattedStr(df.format(a.calcAfAUntilNow(AvGUI.year))));
                break;
            case 6:
                label.setText(getFormattedStr(df.format(a.calcValueBefore(AvGUI.year))));
                break;
            case 7:
                label.setText(getFormattedStr(df.format(a.calcAfA(AvGUI.year))));
                break;
            case 8:
                label.setText(getFormattedStr(df.format(a.calcBW(AvGUI.year))));
                break;

        }
        if (i1 == 0) {
            label.setHorizontalAlignment(SwingConstants.LEFT);
        } else {
            label.setHorizontalAlignment(SwingConstants.RIGHT);
        }

        return label;
    }

    private String getFormattedStr(String str) {
        if (!str.contains((","))) {
            return str + ",00";
        } else if (str.split(",")[1].length() < 2) {
            return str += "0";
        }
        return str;
    }

}
