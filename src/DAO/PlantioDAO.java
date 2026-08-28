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
import model.Plantio;
import util.Conexao;
 
/**
 *
 * @author anagi
 *
 * OBS: este DAO assume que o campo profundidadePlantada do Model Plantio foi
 * alterado de Double para String, para bater com a coluna TEXT do banco
 * (que guarda valores como "4 cm"). Ver observações enviadas no chat.
 */
public class PlantioDAO {
 
    public void inserir(Plantio p) {
        String sql = "INSERT INTO plantio (nomeSemente, profundidadePlantada, fk_proprietario, fk_terra, fk_fertilizante) "
                + "VALUES (?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNomeSemente());
            stmt.setString(2, p.getProfundidadePlantada());
            stmt.setInt(3, p.getFk_proprietario());
            stmt.setInt(4, p.getFk_terra());
            stmt.setInt(5, p.getFk_fertilizante());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setPk_plantio(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir plantio.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    public List<Plantio> listarTodos() {
        String sql = "SELECT * FROM plantio ORDER BY pk_plantio";
        List<Plantio> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(montarPlantio(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar plantios.", e);
        } finally {
            Conexao.fechar(con);
        }
        return lista;
    }
 
    public Plantio buscarPorId(int pk_plantio) {
        String sql = "SELECT * FROM plantio WHERE pk_plantio = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk_plantio);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return montarPlantio(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar plantio.", e);
        } finally {
            Conexao.fechar(con);
        }
        return null;
    }
 
    public void atualizar(Plantio p) {
        String sql = "UPDATE plantio SET nomeSemente = ?, profundidadePlantada = ?, fk_proprietario = ?, "
                + "fk_terra = ?, fk_fertilizante = ? WHERE pk_plantio = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNomeSemente());
            stmt.setString(2, p.getProfundidadePlantada());
            stmt.setInt(3, p.getFk_proprietario());
            stmt.setInt(4, p.getFk_terra());
            stmt.setInt(5, p.getFk_fertilizante());
            stmt.setInt(6, p.getPk_plantio());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar plantio.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    public void deletar(int pk_plantio) {
        String sql = "DELETE FROM plantio WHERE pk_plantio = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk_plantio);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar plantio.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    private Plantio montarPlantio(ResultSet rs) throws SQLException {
        return new Plantio(
                rs.getInt("pk_plantio"),
                rs.getInt("fk_proprietario"),
                rs.getInt("fk_terra"),
                rs.getInt("fk_fertilizante"),
                rs.getString("nomeSemente"),
                rs.getString("profundidadePlantada")
        );
    }
}
