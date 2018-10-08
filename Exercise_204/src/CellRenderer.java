
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        
        Anlage a = (Anlage) o;
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(bln ? new Color(60, 63, 65) : new Color(240, 240, 240));
        label.setForeground(Color.BLACK);

        switch (i1) {
            case 0:
                label.setText(a.getText());
                break;
            case 1:
                label.setText("" + a.getAk());
                break;
            case 2:
                label.setText("" + a.getYear());
                break;
            case 3:
                label.setText("" + a.getDuration());
                break;
            case 4:
                label.setText("" + a.calcDurUntilNow(AvGUI.year));
                break;
            case 5:
                label.setText("" + a.calcAfAUntilNow(AvGUI.year));
                break;
            case 6:
                label.setText("" + a.calcValueBefore(AvGUI.year));
                break;
            case 7:
                label.setText("" + a.calcAfA(AvGUI.year));
                break;
            case 8:
                label.setText("" + a.calcBW(AvGUI.year));
                break;

        }

        return label;
    }

}
