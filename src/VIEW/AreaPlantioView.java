package VIEW;

import CONTROLLER.AreasController;
import CONTROLLER.ProprietarioController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Areas;
import model.Proprietario;
import util.ComboItem;
import util.Util;

/**
 * Tela de cadastro, listagem, edição e exclusão de Áreas de Plantio.
 */
public class AreaPlantioView extends javax.swing.JFrame {

    private final AreasController controller = new AreasController();
    private final ProprietarioController proprietarioController = new ProprietarioController();
    private DefaultTableModel modeloTabela;
    private int pkSelecionado = 0;

    public AreaPlantioView() {
        initComponents();
        configurarTabela();
        setLocationRelativeTo(null);
        carregarProprietarios();
        listar();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                carregarProprietarios();
            }
        });
    }

    private void configurarTabela() {
        modeloTabela = new DefaultTableModel(new Object[]{"Código", "Proprietário", "Semente", "Qtd Hectares", "Produção/Hectare", "Qualidade Solo", "Data Plantio", "Data Colheita", "fk_proprietario"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela.setModel(modeloTabela);
        tabela.removeColumn(tabela.getColumnModel().getColumn(8));
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabela.getSelectedRow() >= 0) {
                carregarLinhaSelecionada();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblProprietario = new javax.swing.JLabel();
        cbProprietario = new javax.swing.JComboBox<>();
        lblSemente = new javax.swing.JLabel();
        txtSemente = new javax.swing.JTextField();
        lblDataPlantio = new javax.swing.JLabel();
        txtDataPlantio = new javax.swing.JTextField();
        lblDataColheita = new javax.swing.JLabel();
        txtDataColheita = new javax.swing.JTextField();
        lblQualidadeSolo = new javax.swing.JLabel();
        cbQualidadeSolo = new javax.swing.JComboBox<>();
        lblQtdHectares = new javax.swing.JLabel();
        txtQuantidadeHectares = new javax.swing.JTextField();
        lblProducao = new javax.swing.JLabel();
        txtProducaoHectare = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        scrollTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Áreas de Plantio");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProprietario.setText("Proprietário:");
        jPanel1.add(lblProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, -1));
        jPanel1.add(cbProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 15, 220, -1));

        lblSemente.setText("Semente Plantada:");
        jPanel1.add(lblSemente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 18, -1, -1));
        jPanel1.add(txtSemente, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 15, 150, -1));

        lblDataPlantio.setText("Data Plantio (dd/mm/aaaa):");
        jPanel1.add(lblDataPlantio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, -1, -1));
        jPanel1.add(txtDataPlantio, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 50, 90, -1));

        lblDataColheita.setText("Data Colheita (dd/mm/aaaa):");
        jPanel1.add(lblDataColheita, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 53, -1, -1));
        jPanel1.add(txtDataColheita, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 50, 90, -1));

        lblQualidadeSolo.setText("Qualidade do Solo:");
        jPanel1.add(lblQualidadeSolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, -1));

        cbQualidadeSolo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente", "Boa", "Regular", "Ruim" }));
        jPanel1.add(cbQualidadeSolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 85, 120, -1));

        lblQtdHectares.setText("Quantidade Hectares:");
        jPanel1.add(lblQtdHectares, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 88, -1, -1));
        jPanel1.add(txtQuantidadeHectares, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 85, 80, -1));

        lblProducao.setText("Produção/Hectare:");
        jPanel1.add(lblProducao, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 88, -1, -1));
        jPanel1.add(txtProducaoHectare, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 85, 80, -1));

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 25));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 120, 90, 25));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 90, 25));

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 120, 90, 25));

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 90, 25));

        scrollTabela.setViewportView(tabela);

        jPanel1.add(scrollTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 780, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void carregarProprietarios() {
        Object selecionadoAntes = cbProprietario.getSelectedItem();
        cbProprietario.removeAllItems();
        List<Proprietario> lista = proprietarioController.listarTodos();
        for (Proprietario p : lista) {
            cbProprietario.addItem(new ComboItem(p.getPk_proprietario(), p.getNomeProprietario()));
        }
        if (selecionadoAntes != null) {
            cbProprietario.setSelectedItem(selecionadoAntes);
        }
    }

    private void cadastrar() {
        try {
            Areas a = lerFormulario();
            controller.cadastrar(a);
            Util.exibirInfo(this, "Área de plantio cadastrada com sucesso.");
            limpar();
            listar();
        } catch (IllegalArgumentException ex) {
            Util.exibirErro(this, ex.getMessage());
        } catch (RuntimeException ex) {
            Util.exibirErro(this, "Erro ao cadastrar: " + ex.getMessage());
        }
    }

    private void atualizar() {
        if (pkSelecionado == 0) {
            Util.exibirErro(this, "Selecione uma área na tabela para atualizar.");
            return;
        }
        try {
            Areas a = lerFormulario();
            a.setPk_terra(pkSelecionado);
            controller.atualizar(a);
            Util.exibirInfo(this, "Área de plantio atualizada com sucesso.");
            limpar();
            listar();
        } catch (IllegalArgumentException ex) {
            Util.exibirErro(this, ex.getMessage());
        } catch (RuntimeException ex) {
            Util.exibirErro(this, "Erro ao atualizar: " + ex.getMessage());
        }
    }

    private void excluir() {
        if (pkSelecionado == 0) {
            Util.exibirErro(this, "Selecione uma área na tabela para excluir.");
            return;
        }
        if (!Util.confirmar(this, "Deseja realmente excluir esta área de plantio?")) {
            return;
        }
        try {
            controller.deletar(pkSelecionado);
            Util.exibirInfo(this, "Área de plantio excluída com sucesso.");
            limpar();
            listar();
        } catch (RuntimeException ex) {
            Util.exibirErro(this, "Erro ao excluir: " + ex.getMessage());
        }
    }

    private void limpar() {
        Util.limparCampos(txtSemente, txtDataPlantio, txtDataColheita, txtQuantidadeHectares, txtProducaoHectare);
        cbQualidadeSolo.setSelectedIndex(0);
        if (cbProprietario.getItemCount() > 0) {
            cbProprietario.setSelectedIndex(0);
        }
        pkSelecionado = 0;
        tabela.clearSelection();
    }

    private void listar() {
        modeloTabela.setRowCount(0);
        List<Areas> lista = controller.listarTodos();
        for (Areas a : lista) {
            modeloTabela.addRow(new Object[]{
                a.getPk_terra(), nomeProprietario(a.getFk_proprietario()), a.getSementePlantada(),
                a.getQuantidadeHectare(), a.getProducaoHectare(), a.getQualidadeSolo(),
                Util.formatarData(a.getDataPlantada()), Util.formatarData(a.getDataColheita()),
                a.getFk_proprietario()
            });
        }
    }

    private String nomeProprietario(int pk) {
        Proprietario p = proprietarioController.buscarPorId(pk);
        return p == null ? "Proprietário #" + pk : p.getNomeProprietario();
    }

    private void carregarLinhaSelecionada() {
        int linha = tabela.getSelectedRow();
        pkSelecionado = (int) modeloTabela.getValueAt(linha, 0);
        int fkProprietario = (int) modeloTabela.getValueAt(linha, 8);
        selecionarProprietarioNoCombo(fkProprietario);
        txtSemente.setText(String.valueOf(modeloTabela.getValueAt(linha, 2)));
        txtQuantidadeHectares.setText(String.valueOf(modeloTabela.getValueAt(linha, 3)));
        txtProducaoHectare.setText(String.valueOf(modeloTabela.getValueAt(linha, 4)));
        cbQualidadeSolo.setSelectedItem(String.valueOf(modeloTabela.getValueAt(linha, 5)));
        txtDataPlantio.setText(String.valueOf(modeloTabela.getValueAt(linha, 6)));
        txtDataColheita.setText(String.valueOf(modeloTabela.getValueAt(linha, 7)));
    }

    private void selecionarProprietarioNoCombo(int pk) {
        for (int i = 0; i < cbProprietario.getItemCount(); i++) {
            if (cbProprietario.getItemAt(i).getId() == pk) {
                cbProprietario.setSelectedIndex(i);
                return;
            }
        }
    }

    private Areas lerFormulario() {
        ComboItem itemProprietario = (ComboItem) cbProprietario.getSelectedItem();
        if (itemProprietario == null) {
            throw new IllegalArgumentException("Cadastre um proprietário antes de cadastrar uma área de plantio.");
        }
        Areas a = new Areas();
        a.setFk_proprietario(itemProprietario.getId());
        a.setSementePlantada(txtSemente.getText().trim());
        if (a.getSementePlantada().isBlank()) {
            throw new IllegalArgumentException("Semente plantada é obrigatória.");
        }
        a.setDataPlantada(Util.parseData(txtDataPlantio.getText(), "Data de plantio"));
        a.setDataColheita(Util.parseData(txtDataColheita.getText(), "Data de colheita"));
        a.setQualidadeSolo((String) cbQualidadeSolo.getSelectedItem());
        a.setQuantidadeHectare(Util.parseDoublePositivo(txtQuantidadeHectares.getText(), "Quantidade de hectares"));
        a.setProducaoHectare(Util.parseDoublePositivo(txtProducaoHectare.getText(), "Produção por hectare"));
        return a;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<ComboItem> cbProprietario;
    private javax.swing.JComboBox<String> cbQualidadeSolo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDataColheita;
    private javax.swing.JLabel lblDataPlantio;
    private javax.swing.JLabel lblProducao;
    private javax.swing.JLabel lblProprietario;
    private javax.swing.JLabel lblQtdHectares;
    private javax.swing.JLabel lblQualidadeSolo;
    private javax.swing.JLabel lblSemente;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtDataColheita;
    private javax.swing.JTextField txtDataPlantio;
    private javax.swing.JTextField txtProducaoHectare;
    private javax.swing.JTextField txtQuantidadeHectares;
    private javax.swing.JTextField txtSemente;
    // End of variables declaration//GEN-END:variables
}
