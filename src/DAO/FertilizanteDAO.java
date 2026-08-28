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
import model.Fertilizante;
import util.Conexao;
 
/**
 *
 * @author anagi
 */
public class FertilizanteDAO {
 
    public void inserir(Fertilizante f) {
        String sql = "INSERT INTO fertilizante (nomeFertilizante, tipoFertilizante, dataAplicacao, "
                + "quantidadeAplicada, fk_proprietario, fk_terra) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, f.getNomeFertilizante());
            stmt.setString(2, f.getTipoFertilizante());
            stmt.setDate(3, f.getDataAplicacao());
            stmt.setDouble(4, f.getQuantidadeAplicada());
            stmt.setInt(5, f.getFk_proprietario());
            stmt.setInt(6, f.getFk_terra());
            stmt.executeUpdate();
 
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    // ATENÇÃO: só funciona depois de corrigir o bug do setPk_fertilizante no Model (ver observações)
                    f.setPk_fertilizante(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir fertilizante.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    public List<Fertilizante> listarTodos() {
        String sql = "SELECT * FROM fertilizante ORDER BY pk_fertilizante";
        List<Fertilizante> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(montarFertilizante(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar fertilizantes.", e);
        } finally {
            Conexao.fechar(con);
        }
        return lista;
    }
 
    public Fertilizante buscarPorId(int pk_fertilizante) {
        String sql = "SELECT * FROM fertilizante WHERE pk_fertilizante = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk_fertilizante);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return montarFertilizante(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar fertilizante.", e);
        } finally {
            Conexao.fechar(con);
        }
        return null;
    }
 
    public List<Fertilizante> listarPorTerra(int fk_terra) {
        String sql = "SELECT * FROM fertilizante WHERE fk_terra = ? ORDER BY pk_fertilizante";
        List<Fertilizante> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, fk_terra);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(montarFertilizante(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar fertilizantes da área.", e);
        } finally {
            Conexao.fechar(con);
        }
        return lista;
    }
 
    public void atualizar(Fertilizante f) {
        String sql = "UPDATE fertilizante SET nomeFertilizante = ?, tipoFertilizante = ?, dataAplicacao = ?, "
                + "quantidadeAplicada = ?, fk_proprietario = ?, fk_terra = ? WHERE pk_fertilizante = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getNomeFertilizante());
            stmt.setString(2, f.getTipoFertilizante());
            stmt.setDate(3, f.getDataAplicacao());
            stmt.setDouble(4, f.getQuantidadeAplicada());
            stmt.setInt(5, f.getFk_proprietario());
            stmt.setInt(6, f.getFk_terra());
            stmt.setInt(7, f.getPk_fertilizante());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar fertilizante.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    public void deletar(int pk_fertilizante) {
        String sql = "DELETE FROM fertilizante WHERE pk_fertilizante = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk_fertilizante);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar fertilizante.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    private Fertilizante montarFertilizante(ResultSet rs) throws SQLException {
        // Usa o construtor cheio de propósito, para não depender do setPk_fertilizante (que tem bug no Model)
        return new Fertilizante(
                rs.getInt("pk_fertilizante"),
                rs.getInt("fk_proprietario"),
                rs.getInt("fk_terra"),
                rs.getString("nomeFertilizante"),
                rs.getString("tipoFertilizante"),
                rs.getDate("dataAplicacao"),
                rs.getDouble("quantidadeAplicada")
        );
    }
}
