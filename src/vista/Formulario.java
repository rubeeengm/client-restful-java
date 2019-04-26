package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulario extends javax.swing.JFrame {
    
    public Formulario() {
        initComponents();
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JLabel getLblApellidoMaterno() {
        return lblApellidoMaterno;
    }

    public JLabel getLblApellidoPaterno() {
        return lblApellidoPaterno;
    }

    public JLabel getLblCarrera() {
        return lblCarrera;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public JLabel getLblSemestre() {
        return lblSemestre;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTxfApellidoMaterno() {
        return txfApellidoMaterno;
    }

    public JTextField getTxfApellidoPaterno() {
        return txfApellidoPaterno;
    }

    public JTextField getTxfCarrera() {
        return txfCarrera;
    }

    public JTextField getTxfNombre() {
        return txfNombre;
    }

    public JTextField getTxfSemestre() {
        return txfSemestre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblCarrera = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txfNombre = new javax.swing.JTextField();
        txfApellidoPaterno = new javax.swing.JTextField();
        txfCarrera = new javax.swing.JTextField();
        txfApellidoMaterno = new javax.swing.JTextField();
        txfSemestre = new javax.swing.JTextField();

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblNombre.setText("Nombre:");

        lblApellidoPaterno.setText("Apellido Paterno:");

        lblApellidoMaterno.setText("Apellido Materno:");

        lblCarrera.setText("Carrera:");

        lblSemestre.setText("Semestre:");

        btnRegistrar.setText("Registrar");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblApellidoPaterno)
                    .addComponent(lblApellidoMaterno)
                    .addComponent(lblCarrera)
                    .addComponent(lblSemestre))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txfNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(txfApellidoPaterno, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfApellidoMaterno, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfCarrera, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfSemestre, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(192, 192, 192))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPaterno)
                    .addComponent(txfApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoMaterno)
                    .addComponent(txfApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarrera)
                    .addComponent(txfCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemestre)
                    .addComponent(txfSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(btnRegistrar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txfApellidoMaterno;
    private javax.swing.JTextField txfApellidoPaterno;
    private javax.swing.JTextField txfCarrera;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfSemestre;
    // End of variables declaration//GEN-END:variables
}
