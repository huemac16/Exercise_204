
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import javafx.scene.layout.Border;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class CellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {

        Anlage a = (Anlage) o;
        JLabel label = new JLabel();
        label.setOpaque(true);
        if (!a.isLast()) {
            label.setBackground(bln ? new Color(150, 150, 150) : new Color(240, 240, 240));
        }

        label.setForeground(Color.BLACK);
        String formatPattern = "###,###.##";
        DecimalFormat df = new DecimalFormat(formatPattern);
        if (i1 == 0) {
            label.setHorizontalAlignment(SwingConstants.LEFT);
        } else {
            label.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if (AvGUI.year < a.getYear()) {
            label.setBackground(bln ? new Color(150, 150, 150) : Color.ORANGE);
        } else if (AvGUI.year > a.getYear() + a.getDuration()) {
            label.setBackground(bln ? new Color(150, 150, 150) : Color.YELLOW);
        } else {
            label.setBackground(bln ? new Color(150, 150, 150) : new Color(240, 240, 240));
        }
        if (!a.isLast()) {
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

        } else {

            label.setBackground(new Color(240, 240, 240));
            switch (i1) {
                case 1:
                    label.setText(getFormattedStr(df.format(a.getSumAK())));
                    label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                    break;
                case 5:
                    label.setText(getFormattedStr(df.format(a.getSumAfaBisher())));
                    label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                    break;
                case 6:
                    label.setText(getFormattedStr(df.format(a.getSumWertVorAfa())));
                    label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                    break;
                case 7:
                    label.setText(getFormattedStr(df.format(a.getSumAfaDj())));
                    label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                    break;
                case 8:
                    label.setText(getFormattedStr(df.format(a.getSumBw())));
                    label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                    break;

            }

            label.setFont(new Font("Courier New", Font.BOLD, 13));
            label.setBackground(Color.GREEN);

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
