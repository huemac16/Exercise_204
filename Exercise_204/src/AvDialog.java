
import javax.swing.JOptionPane;

public class AvDialog extends javax.swing.JDialog {

    private Anlage anlage;
    private boolean ok;

    public AvDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tftext = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfak = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfyear = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfduration = new javax.swing.JTextField();
        btok = new javax.swing.JButton();
        btdeny = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(5, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Text");
        jPanel1.add(jLabel1);
        jPanel1.add(tftext);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Anschaffungskosten");
        jPanel1.add(jLabel2);
        jPanel1.add(tfak);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inbetriebnahme (Jahr)");
        jPanel1.add(jLabel3);
        jPanel1.add(tfyear);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nutzungsdauer");
        jPanel1.add(jLabel4);
        jPanel1.add(tfduration);

        btok.setText("Ok");
        btok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btokActionPerformed(evt);
            }
        });
        jPanel1.add(btok);

        btdeny.setText("Abbrechen");
        btdeny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdenyActionPerformed(evt);
            }
        });
        jPanel1.add(btdeny);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btokActionPerformed
        ok = true;
        if (tftext.getText().equals("") || tfak.getText().equals("") || tfyear.getText().equals("") || tfduration.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Bitte füllen Sie alle Felder aus!");
        } else {
            try {
                anlage = new Anlage(tftext.getText(), Double.parseDouble(tfak.getText()), Double.parseDouble(tfyear.getText()), Double.parseDouble(tfduration.getText()));
                dispose();
            } catch (NumberFormatException fe) {
                JOptionPane.showMessageDialog(null, "Fehler bei der Formatierung!");
            }
        }

    }//GEN-LAST:event_btokActionPerformed

    private void btdenyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdenyActionPerformed
        ok = false;
        dispose();
    }//GEN-LAST:event_btdenyActionPerformed

    public Anlage getAnlage() {
        return anlage;
    }

    public boolean isOk() {
        return ok;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdeny;
    private javax.swing.JButton btok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfak;
    private javax.swing.JTextField tfduration;
    private javax.swing.JTextField tftext;
    private javax.swing.JTextField tfyear;
    // End of variables declaration//GEN-END:variables
}
