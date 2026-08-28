package VIEW;

import CONTROLLER.AreasController;
import CONTROLLER.FertilizanteController;
import CONTROLLER.ProprietarioController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Areas;
import model.Fertilizante;
import model.Proprietario;
import util.ComboItem;
import util.Util;

/**
 * Tela de cadastro, listagem, edição e exclusão de Fertilizantes aplicados
 * em uma área de plantio de um proprietário.
 */
public class FertilizanteView extends javax.swing.JFrame {

    private final FertilizanteController controller = new FertilizanteController();
    private final ProprietarioController proprietarioController = new ProprietarioController();
    private final AreasController areasController = new AreasController();
    private DefaultTableModel modeloTabela;
    private int pkSelecionado = 0;

    public FertilizanteView() {
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
        modeloTabela = new DefaultTableModel(new Object[]{"Código", "Nome", "Tipo", "Quantidade", "Data Aplicação", "Área", "Proprietário", "fk_proprietario", "fk_terra"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela.setModel(modeloTabela);
        tabela.removeColumn(tabela.getColumnModel().getColumn(8));
        tabela.removeColumn(tabela.getColumnModel().getColumn(7));
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabela.getSelectedRow() >= 0) {
                carregarLinhaSelecionada();
            }
        });
        cbProprietario.addActionListener(e -> carregarAreasDoProprietario());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblProprietario = new javax.swing.JLabel();
        cbProprietario = new javax.swing.JComboBox<>();
        lblArea = new javax.swing.JLabel();
        cbArea = new javax.swing.JComboBox<>();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        lblDataAplicacao = new javax.swing.JLabel();
        txtDataAplicacao = new javax.swing.JTextField();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        scrollTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fertilizantes");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProprietario.setText("Proprietário:");
        jPanel1.add(lblProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, -1));
        jPanel1.add(cbProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 15, 200, -1));

        lblArea.setText("Área de Plantio:");
        jPanel1.add(lblArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 18, -1, -1));
        jPanel1.add(cbArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 15, 220, -1));

        lblNome.setText("Nome do Fertilizante:");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, -1, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 50, 180, -1));

        lblTipo.setText("Tipo:");
        jPanel1.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 53, -1, -1));

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Químico", "Orgânico", "Mineral", "Foliar" }));
        jPanel1.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 50, 120, -1));

        lblDataAplicacao.setText("Data Aplicação (dd/mm/aaaa):");
        jPanel1.add(lblDataAplicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, -1));
        jPanel1.add(txtDataAplicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 85, 90, -1));

        lblQuantidade.setText("Quantidade Aplicada:");
        jPanel1.add(lblQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 88, -1, -1));
        jPanel1.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 85, 80, -1));

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
        } else {
            carregarAreasDoProprietario();
        }
    }

    private void carregarAreasDoProprietario() {
        cbArea.removeAllItems();
        ComboItem proprietarioSelecionado = (ComboItem) cbProprietario.getSelectedItem();
        if (proprietarioSelecionado == null) {
            return;
        }
        List<Areas> areas = areasController.listarPorProprietario(proprietarioSelecionado.getId());
        for (Areas a : areas) {
            cbArea.addItem(new ComboItem(a.getPk_terra(), "Área #" + a.getPk_terra() + " - " + a.getSementePlantada()));
        }
    }

    private void cadastrar() {
        try {
            Fertilizante f = lerFormulario();
            controller.cadastrar(f);
            Util.exibirInfo(this, "Fertilizante cadastrado com sucesso.");
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
            Util.exibirErro(this, "Selecione um fertilizante na tabela para atualizar.");
            return;
        }
        try {
            Fertilizante f = lerFormulario();
            f.setPk_fertilizante(pkSelecionado);
            controller.atualizar(f);
            Util.exibirInfo(this, "Fertilizante atualizado com sucesso.");
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
            Util.exibirErro(this, "Selecione um fertilizante na tabela para excluir.");
            return;
        }
        if (!Util.confirmar(this, "Deseja realmente excluir este fertilizante?")) {
            return;
        }
        try {
            controller.deletar(pkSelecionado);
            Util.exibirInfo(this, "Fertilizante excluído com sucesso.");
            limpar();
            listar();
        } catch (RuntimeException ex) {
            Util.exibirErro(this, "Erro ao excluir: " + ex.getMessage());
        }
    }

    private void limpar() {
        Util.limparCampos(txtNome, txtDataAplicacao, txtQuantidade);
        cbTipo.setSelectedIndex(0);
        pkSelecionado = 0;
        tabela.clearSelection();
    }

    private void listar() {
        modeloTabela.setRowCount(0);
        List<Fertilizante> lista = controller.listarTodos();
        for (Fertilizante f : lista) {
            modeloTabela.addRow(new Object[]{
                f.getPk_fertilizante(), f.getNomeFertilizante(), f.getTipoFertilizante(),
                f.getQuantidadeAplicada(), Util.formatarData(f.getDataAplicacao()),
                nomeArea(f.getFk_terra()), nomeProprietario(f.getFk_proprietario()),
                f.getFk_proprietario(), f.getFk_terra()
            });
        }
    }

    private String nomeProprietario(int pk) {
        Proprietario p = proprietarioController.buscarPorId(pk);
        return p == null ? "Proprietário #" + pk : p.getNomeProprietario();
    }

    private String nomeArea(int pk) {
        Areas a = areasController.buscarPorId(pk);
        return a == null ? "Área #" + pk : "Área #" + a.getPk_terra() + " - " + a.getSementePlantada();
    }

    private void carregarLinhaSelecionada() {
        int linha = tabela.getSelectedRow();
        pkSelecionado = (int) modeloTabela.getValueAt(linha, 0);
        int fkProprietario = (int) modeloTabela.getValueAt(linha, 7);
        int fkTerra = (int) modeloTabela.getValueAt(linha, 8);

        selecionarComboPorId(cbProprietario, fkProprietario);
        carregarAreasDoProprietario();
        selecionarComboPorId(cbArea, fkTerra);

        txtNome.setText(String.valueOf(modeloTabela.getValueAt(linha, 1)));
        cbTipo.setSelectedItem(String.valueOf(modeloTabela.getValueAt(linha, 2)));
        txtQuantidade.setText(String.valueOf(modeloTabela.getValueAt(linha, 3)));
        txtDataAplicacao.setText(String.valueOf(modeloTabela.getValueAt(linha, 4)));
    }

    private void selecionarComboPorId(javax.swing.JComboBox<ComboItem> combo, int id) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (combo.getItemAt(i).getId() == id) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    private Fertilizante lerFormulario() {
        ComboItem proprietarioSelecionado = (ComboItem) cbProprietario.getSelectedItem();
        ComboItem areaSelecionada = (ComboItem) cbArea.getSelectedItem();
        if (proprietarioSelecionado == null) {
            throw new IllegalArgumentException("Cadastre um proprietário antes de cadastrar um fertilizante.");
        }
        if (areaSelecionada == null) {
            throw new IllegalArgumentException("Cadastre uma área de plantio para este proprietário antes de cadastrar um fertilizante.");
        }
        Fertilizante f = new Fertilizante();
        f.setFk_proprietario(proprietarioSelecionado.getId());
        f.setFk_terra(areaSelecionada.getId());
        f.setNomeFertilizante(txtNome.getText().trim());
        if (f.getNomeFertilizante().isBlank()) {
            throw new IllegalArgumentException("Nome do fertilizante é obrigatório.");
        }
        f.setTipoFertilizante((String) cbTipo.getSelectedItem());
        f.setDataAplicacao(Util.parseData(txtDataAplicacao.getText(), "Data de aplicação"));
        f.setQuantidadeAplicada(Util.parseDoublePositivo(txtQuantidade.getText(), "Quantidade aplicada"));
        return f;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<ComboItem> cbArea;
    private javax.swing.JComboBox<ComboItem> cbProprietario;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblDataAplicacao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblProprietario;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtDataAplicacao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
