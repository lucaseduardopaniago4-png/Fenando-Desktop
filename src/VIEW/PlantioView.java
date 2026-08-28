package VIEW;

import CONTROLLER.AreasController;
import CONTROLLER.FertilizanteController;
import CONTROLLER.PlantioController;
import CONTROLLER.ProprietarioController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Areas;
import model.Fertilizante;
import model.Plantio;
import model.Proprietario;
import util.ComboItem;
import util.Util;

/**
 * Tela de cadastro, listagem, edição e exclusão de Plantios: a semente
 * plantada em uma área, usando um fertilizante já aplicado nela.
 */
public class PlantioView extends javax.swing.JFrame {

    private final PlantioController controller = new PlantioController();
    private final ProprietarioController proprietarioController = new ProprietarioController();
    private final AreasController areasController = new AreasController();
    private final FertilizanteController fertilizanteController = new FertilizanteController();
    private DefaultTableModel modeloTabela;
    private int pkSelecionado = 0;

    public PlantioView() {
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
        modeloTabela = new DefaultTableModel(new Object[]{"Código", "Semente", "Profundidade", "Área", "Fertilizante", "Proprietário", "fk_proprietario", "fk_terra", "fk_fertilizante"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela.setModel(modeloTabela);
        tabela.removeColumn(tabela.getColumnModel().getColumn(8));
        tabela.removeColumn(tabela.getColumnModel().getColumn(7));
        tabela.removeColumn(tabela.getColumnModel().getColumn(6));
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabela.getSelectedRow() >= 0) {
                carregarLinhaSelecionada();
            }
        });
        cbProprietario.addActionListener(e -> carregarAreasDoProprietario());
        cbArea.addActionListener(e -> carregarFertilizantesDaArea());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblProprietario = new javax.swing.JLabel();
        cbProprietario = new javax.swing.JComboBox<>();
        lblArea = new javax.swing.JLabel();
        cbArea = new javax.swing.JComboBox<>();
        lblFertilizante = new javax.swing.JLabel();
        cbFertilizante = new javax.swing.JComboBox<>();
        lblSemente = new javax.swing.JLabel();
        txtSemente = new javax.swing.JTextField();
        lblProfundidade = new javax.swing.JLabel();
        txtProfundidade = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        scrollTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Plantio");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProprietario.setText("Proprietário:");
        jPanel1.add(lblProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, -1));
        jPanel1.add(cbProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 15, 200, -1));

        lblArea.setText("Área de Plantio:");
        jPanel1.add(lblArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 18, -1, -1));
        jPanel1.add(cbArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 15, 220, -1));

        lblFertilizante.setText("Fertilizante:");
        jPanel1.add(lblFertilizante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, -1, -1));
        jPanel1.add(cbFertilizante, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 50, 220, -1));

        lblSemente.setText("Nome da Semente:");
        jPanel1.add(lblSemente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 53, -1, -1));
        jPanel1.add(txtSemente, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 50, 150, -1));

        lblProfundidade.setText("Profundidade Plantada (ex: 4 cm):");
        jPanel1.add(lblProfundidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, -1));
        jPanel1.add(txtProfundidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 85, 100, -1));

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
            carregarFertilizantesDaArea();
            return;
        }
        List<Areas> areas = areasController.listarPorProprietario(proprietarioSelecionado.getId());
        for (Areas a : areas) {
            cbArea.addItem(new ComboItem(a.getPk_terra(), "Área #" + a.getPk_terra() + " - " + a.getSementePlantada()));
        }
        carregarFertilizantesDaArea();
    }

    private void carregarFertilizantesDaArea() {
        cbFertilizante.removeAllItems();
        ComboItem areaSelecionada = (ComboItem) cbArea.getSelectedItem();
        if (areaSelecionada == null) {
            return;
        }
        List<Fertilizante> fertilizantes = fertilizanteController.listarPorTerra(areaSelecionada.getId());
        for (Fertilizante f : fertilizantes) {
            cbFertilizante.addItem(new ComboItem(f.getPk_fertilizante(), f.getNomeFertilizante() + " (" + f.getTipoFertilizante() + ")"));
        }
    }

    private void cadastrar() {
        try {
            Plantio p = lerFormulario();
            controller.cadastrar(p);
            Util.exibirInfo(this, "Plantio cadastrado com sucesso.");
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
            Util.exibirErro(this, "Selecione um plantio na tabela para atualizar.");
            return;
        }
        try {
            Plantio p = lerFormulario();
            p.setPk_plantio(pkSelecionado);
            controller.atualizar(p);
            Util.exibirInfo(this, "Plantio atualizado com sucesso.");
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
            Util.exibirErro(this, "Selecione um plantio na tabela para excluir.");
            return;
        }
        if (!Util.confirmar(this, "Deseja realmente excluir este plantio?")) {
            return;
        }
        try {
            controller.deletar(pkSelecionado);
            Util.exibirInfo(this, "Plantio excluído com sucesso.");
            limpar();
            listar();
        } catch (RuntimeException ex) {
            Util.exibirErro(this, "Erro ao excluir: " + ex.getMessage());
        }
    }

    private void limpar() {
        Util.limparCampos(txtSemente, txtProfundidade);
        pkSelecionado = 0;
        tabela.clearSelection();
    }

    private void listar() {
        modeloTabela.setRowCount(0);
        List<Plantio> lista = controller.listarTodos();
        for (Plantio p : lista) {
            modeloTabela.addRow(new Object[]{
                p.getPk_plantio(), p.getNomeSemente(), p.getProfundidadePlantada(),
                nomeArea(p.getFk_terra()), nomeFertilizante(p.getFk_fertilizante()), nomeProprietario(p.getFk_proprietario()),
                p.getFk_proprietario(), p.getFk_terra(), p.getFk_fertilizante()
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

    private String nomeFertilizante(int pk) {
        Fertilizante f = fertilizanteController.buscarPorId(pk);
        return f == null ? "Fertilizante #" + pk : f.getNomeFertilizante();
    }

    private void carregarLinhaSelecionada() {
        int linha = tabela.getSelectedRow();
        pkSelecionado = (int) modeloTabela.getValueAt(linha, 0);
        int fkProprietario = (int) modeloTabela.getValueAt(linha, 6);
        int fkTerra = (int) modeloTabela.getValueAt(linha, 7);
        int fkFertilizante = (int) modeloTabela.getValueAt(linha, 8);

        selecionarComboPorId(cbProprietario, fkProprietario);
        carregarAreasDoProprietario();
        selecionarComboPorId(cbArea, fkTerra);
        carregarFertilizantesDaArea();
        selecionarComboPorId(cbFertilizante, fkFertilizante);

        txtSemente.setText(String.valueOf(modeloTabela.getValueAt(linha, 1)));
        txtProfundidade.setText(String.valueOf(modeloTabela.getValueAt(linha, 2)));
    }

    private void selecionarComboPorId(javax.swing.JComboBox<ComboItem> combo, int id) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (combo.getItemAt(i).getId() == id) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    private Plantio lerFormulario() {
        ComboItem proprietarioSelecionado = (ComboItem) cbProprietario.getSelectedItem();
        ComboItem areaSelecionada = (ComboItem) cbArea.getSelectedItem();
        ComboItem fertilizanteSelecionado = (ComboItem) cbFertilizante.getSelectedItem();
        if (proprietarioSelecionado == null) {
            throw new IllegalArgumentException("Cadastre um proprietário antes de cadastrar um plantio.");
        }
        if (areaSelecionada == null) {
            throw new IllegalArgumentException("Cadastre uma área de plantio para este proprietário antes de cadastrar um plantio.");
        }
        if (fertilizanteSelecionado == null) {
            throw new IllegalArgumentException("Cadastre um fertilizante para esta área antes de cadastrar um plantio.");
        }
        Plantio p = new Plantio();
        p.setFk_proprietario(proprietarioSelecionado.getId());
        p.setFk_terra(areaSelecionada.getId());
        p.setFk_fertilizante(fertilizanteSelecionado.getId());
        p.setNomeSemente(txtSemente.getText().trim());
        if (p.getNomeSemente().isBlank()) {
            throw new IllegalArgumentException("Nome da semente é obrigatório.");
        }
        String profundidade = txtProfundidade.getText().trim();
        if (profundidade.isBlank()) {
            throw new IllegalArgumentException("Profundidade plantada é obrigatória.");
        }
        p.setProfundidadePlantada(profundidade);
        return p;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<ComboItem> cbArea;
    private javax.swing.JComboBox<ComboItem> cbFertilizante;
    private javax.swing.JComboBox<ComboItem> cbProprietario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblFertilizante;
    private javax.swing.JLabel lblProfundidade;
    private javax.swing.JLabel lblProprietario;
    private javax.swing.JLabel lblSemente;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtProfundidade;
    private javax.swing.JTextField txtSemente;
    // End of variables declaration//GEN-END:variables
}
