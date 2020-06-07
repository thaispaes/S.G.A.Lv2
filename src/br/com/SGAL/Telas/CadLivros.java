/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SGAL.Telas;

import java.sql.*;
import br.com.SGAL.dal.ModelConection;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author hylan
 */
public class CadLivros extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void deletar() {
        int confirma;
        confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este livro ?", "Atenção", (JOptionPane.YES_NO_OPTION));
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbcliente where nomelivro=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtNomeLivro.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    txtNomeLivro.setText(null);
                    txtAutorLivro.setText(null);
                    txtEditoraLivro.setText(null);
                    txtGeneroLivro.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }

    public void alterar() {
        String sql = "update tblivros set nomelivro=?, autorlivro=?, editoratlivro=?, generolivro=? where nomelivro=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeLivro.getText());
            pst.setString(2, txtAutorLivro.getText());
            pst.setString(3, txtEditoraLivro.getText());
            pst.setString(4, txtGeneroLivro.getText());
            if ((txtAutorLivro.getText().isEmpty()) || (txtEditoraLivro.getText().isEmpty()) || (txtAutorLivro.getText().isEmpty()) || (txtGeneroLivro.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Por favor digite os campos obrigatórios!");
                txtNomeLivro.setText(null);
                txtAutorLivro.setText(null);
                txtEditoraLivro.setText(null);
                txtGeneroLivro.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
                txtNomeLivro.setText(null);
                txtAutorLivro.setText(null);
                txtEditoraLivro.setText(null);
                txtGeneroLivro.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void procurar() {
        String sql = "select nomelivro, autorlivro, editoratlivro, generolivro from tblivros where nomelivro=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeLivro.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNomeLivro.setText(rs.getString(1));
                txtAutorLivro.setText(rs.getString(2));
                txtEditoraLivro.setText(rs.getString(3));
                txtGeneroLivro.setText(rs.getString(4));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                txtNomeLivro.setText(null);
                txtAutorLivro.setText(null);
                txtEditoraLivro.setText(null);
                txtGeneroLivro.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cadastrar() {
        String sql = "insert into tblivros(nomelivro, autorlivro, editoratlivro,generolivro)values(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeLivro.getText());
            pst.setString(2, txtAutorLivro.getText());
            pst.setString(3, txtEditoraLivro.getText());
            pst.setString(4, txtGeneroLivro.getText());
            if ((txtNomeLivro.getText().isEmpty()) || (txtAutorLivro.getText().isEmpty()) || (txtEditoraLivro.getText().isEmpty()) || (txtGeneroLivro.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Por favor digite os campos obrigatórios!");
                txtNomeLivro.setText(null);
                txtAutorLivro.setText(null);
                txtEditoraLivro.setText(null);
                txtGeneroLivro.setText(null);
            } else {
                int executado = pst.executeUpdate();
                if (executado > 0) {
                    JOptionPane.showMessageDialog(null, "Livro cadastrado com Sucesso!");
                    txtNomeLivro.setText(null);
                    txtAutorLivro.setText(null);
                    txtEditoraLivro.setText(null);
                    txtGeneroLivro.setText(null);
                }

            }
        } catch (Exception e) {
        }

    }

    public CadLivros() {
        conexao = ModelConection.Conector();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeLivro = new javax.swing.JTextField();
        txtAutorLivro = new javax.swing.JTextField();
        txtEditoraLivro = new javax.swing.JTextField();
        txtGeneroLivro = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnProcurar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Nome do Livro:");

        jLabel2.setText("Autor Livro:");

        jLabel3.setText("Editora do Livro:");

        jLabel4.setText("Genero do  Livro:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtGeneroLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEditoraLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAutorLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(169, 169, 169))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletar)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAutorLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditoraLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGeneroLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnProcurar)
                    .addComponent(btnAlterar)
                    .addComponent(btnDeletar))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        procurar();
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        deletar();
    }//GEN-LAST:event_btnDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtAutorLivro;
    private javax.swing.JTextField txtEditoraLivro;
    private javax.swing.JTextField txtGeneroLivro;
    private javax.swing.JTextField txtNomeLivro;
    // End of variables declaration//GEN-END:variables
}
