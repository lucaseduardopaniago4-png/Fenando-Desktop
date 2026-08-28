package VIEW;

/**
 * Tela inicial do sistema. Dá acesso aos cadastros de Proprietário,
 * Área de Plantio, Fertilizante e Plantio.
 */
public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnProprietario = new javax.swing.JButton();
        btnAreas = new javax.swing.JButton();
        btnFertilizante = new javax.swing.JButton();
        btnPlantio = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plant - Gestão de Plantio e Fertilidade do Solo");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("PLANT");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 30));

        btnProprietario.setText("Proprietários");
        btnProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProprietarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 220, 35));

        btnAreas.setText("Áreas de Plantio");
        btnAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAreas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 115, 220, 35));

        btnFertilizante.setText("Fertilizantes");
        btnFertilizante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFertilizanteActionPerformed(evt);
            }
        });
        jPanel1.add(btnFertilizante, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 220, 35));

        btnPlantio.setText("Plantio");
        btnPlantio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlantioActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlantio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 205, 220, 35));

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 220, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProprietarioActionPerformed
        new ProprietarioView().setVisible(true);
    }//GEN-LAST:event_btnProprietarioActionPerformed

    private void btnAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreasActionPerformed
        new AreaPlantioView().setVisible(true);
    }//GEN-LAST:event_btnAreasActionPerformed

    private void btnFertilizanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFertilizanteActionPerformed
        new FertilizanteView().setVisible(true);
    }//GEN-LAST:event_btnFertilizanteActionPerformed

    private void btnPlantioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlantioActionPerformed
        new PlantioView().setVisible(true);
    }//GEN-LAST:event_btnPlantioActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAreas;
    private javax.swing.JButton btnFertilizante;
    private javax.swing.JButton btnPlantio;
    private javax.swing.JButton btnProprietario;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
