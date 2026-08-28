package VIEW;

import CONTROLLER.ProprietarioController;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Proprietario;
import util.Util;

/**
 * Tela de cadastro, listagem, edição e exclusão de Proprietários.
 */
public class ProprietarioView extends javax.swing.JFrame {

    private final ProprietarioController controller = new ProprietarioController();
    private DefaultTableModel modeloTabela;
    private int pkSelecionado = 0;

    public ProprietarioView() {
        initComponents();
        configurarTabela();
        setLocationRelativeTo(null);
        listar();
    }

    private void configurarTabela() {
        modeloTabela = new DefaultTableModel(new Object[]{"Código", "Nome", "CNPJ", "Idade", "Sexo", "Estado Civil", "Escritura Estadual"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela.setModel(modeloTabela);
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
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCnpj = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        lblEstadoCivil = new javax.swing.JLabel();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        lblEscritura = new javax.swing.JLabel();
        txtEscritura = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        scrollTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proprietários");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setText("Nome:");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 15, 220, -1));

        lblCnpj.setText("CNPJ:");
        jPanel1.add(lblCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 18, -1, -1));
        jPanel1.add(txtCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 15, 150, -1));

        lblIdade.setText("Idade:");
        jPanel1.add(lblIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, -1, -1));
        jPanel1.add(txtIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 50, -1));

        lblSexo.setText("Sexo:");
        jPanel1.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 53, -1, -1));

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        jPanel1.add(cbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 50, 110, -1));

        lblEstadoCivil.setText("Estado Civil:");
        jPanel1.add(lblEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 53, -1, -1));

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viúvo(a)" }));
        jPanel1.add(cbEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 50, 150, -1));

        lblEscritura.setText("Escritura Estadual:");
        jPanel1.add(lblEscritura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, -1));
        jPanel1.add(txtEscritura, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 85, 200, -1));

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

        jPanel1.add(scrollTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 700, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
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

    private void cadastrar() {
        try {
            Proprietario p = lerFormulario();
            controller.cadastrar(p);
            Util.exibirInfo(this, "Proprietário cadastrado com sucesso.");
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
            Util.exibirErro(this, "Selecione um proprietário na tabela para atualizar.");
            return;
        }
        try {
            Proprietario p = lerFormulario();
            p.setPk_proprietario(pkSelecionado);
            controller.atualizar(p);
            Util.exibirInfo(this, "Proprietário atualizado com sucesso.");
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
            Util.exibirErro(this, "Selecione um proprietário na tabela para excluir.");
            return;
        }
        if (!Util.confirmar(this, "Deseja realmente excluir este proprietário?")) {
            return;
        }
        try {
            controller.deletar(pkSelecionado);
            Util.exibirInfo(this, "Proprietário excluído com sucesso.");
            limpar();
            listar();
        } catch (RuntimeException ex) {
            Util.exibirErro(this, "Erro ao excluir: " + ex.getMessage());
        }
    }

    private void limpar() {
        Util.limparCampos(txtCnpj, txtEscritura, txtIdade, txtNome);
        cbEstadoCivil.setSelectedIndex(0);
        cbSexo.setSelectedIndex(0);
        pkSelecionado = 0;
        tabela.clearSelection();
    }

    private void listar() {
        modeloTabela.setRowCount(0);
        List<Proprietario> lista = controller.listarTodos();
        for (Proprietario p : lista) {
            modeloTabela.addRow(new Object[]{
                p.getPk_proprietario(), p.getNomeProprietario(), p.getCnpj(),
                p.getIdadeProprietario(), p.getSexo(), p.getEstadoCivil(), p.getEscrituraEstadual()
            });
        }
    }

    private void carregarLinhaSelecionada() {
        int linha = tabela.getSelectedRow();
        pkSelecionado = (int) modeloTabela.getValueAt(linha, 0);
        txtNome.setText(String.valueOf(modeloTabela.getValueAt(linha, 1)));
        txtCnpj.setText(String.valueOf(modeloTabela.getValueAt(linha, 2)));
        txtIdade.setText(String.valueOf(modeloTabela.getValueAt(linha, 3)));
        cbSexo.setSelectedItem(String.valueOf(modeloTabela.getValueAt(linha, 4)));
        cbEstadoCivil.setSelectedItem(String.valueOf(modeloTabela.getValueAt(linha, 5)));
        txtEscritura.setText(String.valueOf(modeloTabela.getValueAt(linha, 6)));
    }

    private Proprietario lerFormulario() {
        Proprietario p = new Proprietario();
        p.setNomeProprietario(txtNome.getText().trim());
        p.setCnpj(txtCnpj.getText().trim());
        p.setIdadeProprietario(Util.parseInteiroPositivo(txtIdade.getText(), "Idade"));
        p.setSexo((String) cbSexo.getSelectedItem());
        p.setEstadoCivil((String) cbEstadoCivil.getSelectedItem());
        p.setEscrituraEstadual(txtEscritura.getText().trim());
        return p;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbEstadoCivil;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblEscritura;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtEscritura;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
