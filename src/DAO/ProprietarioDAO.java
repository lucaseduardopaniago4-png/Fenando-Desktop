/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Proprietario;
import util.Conexao;

/**
 *
 * @author anagi
 */
public class ProprietarioDAO {
 
    public void inserir(Proprietario p) {
        String sql = "INSERT INTO proprietario (cnpj, escrituraEstadual, estadoCivil, sexo, idadeProprietario, nomeProprietario) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getCnpj());
            stmt.setString(2, p.getEscrituraEstadual());
            stmt.setString(3, p.getEstadoCivil());
            stmt.setString(4, p.getSexo());
            stmt.setInt(5, p.getIdadeProprietario());
            stmt.setString(6, p.getNomeProprietario());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setPk_proprietario(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir proprietário.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    public List<Proprietario> listarTodos() {
        String sql = "SELECT * FROM proprietario ORDER BY pk_proprietario";
        List<Proprietario> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(montarProprietario(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar proprietários.", e);
        } finally {
            Conexao.fechar(con);
        }
        return lista;
    }
 
    public Proprietario buscarPorId(int pk_proprietario) {
        String sql = "SELECT * FROM proprietario WHERE pk_proprietario = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk_proprietario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return montarProprietario(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar proprietário.", e);
        } finally {
            Conexao.fechar(con);
        }
        return null;
    }
 
    public void atualizar(Proprietario p) {
        String sql = "UPDATE proprietario SET cnpj = ?, escrituraEstadual = ?, estadoCivil = ?, sexo = ?, "
                + "idadeProprietario = ?, nomeProprietario = ? WHERE pk_proprietario = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getCnpj());
            stmt.setString(2, p.getEscrituraEstadual());
            stmt.setString(3, p.getEstadoCivil());
            stmt.setString(4, p.getSexo());
            stmt.setInt(5, p.getIdadeProprietario());
            stmt.setString(6, p.getNomeProprietario());
            stmt.setInt(7, p.getPk_proprietario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar proprietário.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    public void deletar(int pk_proprietario) {
        String sql = "DELETE FROM proprietario WHERE pk_proprietario = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk_proprietario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar proprietário.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    private Proprietario montarProprietario(ResultSet rs) throws SQLException {
        Proprietario p = new Proprietario();
        p.setPk_proprietario(rs.getInt("pk_proprietario"));
        p.setCnpj(rs.getString("cnpj"));
        p.setEscrituraEstadual(rs.getString("escrituraEstadual"));
        p.setEstadoCivil(rs.getString("estadoCivil"));
        p.setSexo(rs.getString("sexo"));
        p.setIdadeProprietario(rs.getInt("idadeProprietario"));
        p.setNomeProprietario(rs.getString("nomeProprietario"));
        return p;
    }
}
