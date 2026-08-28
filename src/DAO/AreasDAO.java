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
import model.Areas;
import util.Conexao;
 
/**
 *
 * @author anagi
 */
public class AreasDAO {
 
    public void inserir(Areas a) {
        String sql = "INSERT INTO area_plantio (sementePlantada, dataPlantio, dataColeita, qualidadeSolo, "
                + "quantidadeHectares, producaoHectare, fk_proprietario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, a.getSementePlantada());
            stmt.setDate(2, a.getDataPlantada());
            stmt.setDate(3, a.getDataColheita());
            stmt.setString(4, a.getQualidadeSolo());
            stmt.setDouble(5, a.getQuantidadeHectare());
            stmt.setDouble(6, a.getProducaoHectare());
            stmt.setInt(7, a.getFk_proprietario());
            stmt.executeUpdate();
 
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    a.setPk_terra(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir área de plantio.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    public List<Areas> listarTodos() {
        String sql = "SELECT * FROM area_plantio ORDER BY pk_terra";
        List<Areas> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(montarAreas(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar áreas de plantio.", e);
        } finally {
            Conexao.fechar(con);
        }
        return lista;
    }
 
    public Areas buscarPorId(int pk_terra) {
        String sql = "SELECT * FROM area_plantio WHERE pk_terra = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk_terra);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return montarAreas(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar área de plantio.", e);
        } finally {
            Conexao.fechar(con);
        }
        return null;
    }
 
    public List<Areas> listarPorProprietario(int fk_proprietario) {
        String sql = "SELECT * FROM area_plantio WHERE fk_proprietario = ? ORDER BY pk_terra";
        List<Areas> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, fk_proprietario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(montarAreas(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar áreas de plantio do proprietário.", e);
        } finally {
            Conexao.fechar(con);
        }
        return lista;
    }
 
    public void atualizar(Areas a) {
        String sql = "UPDATE area_plantio SET sementePlantada = ?, dataPlantio = ?, dataColeita = ?, "
                + "qualidadeSolo = ?, quantidadeHectares = ?, producaoHectare = ?, fk_proprietario = ? "
                + "WHERE pk_terra = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getSementePlantada());
            stmt.setDate(2, a.getDataPlantada());
            stmt.setDate(3, a.getDataColheita());
            stmt.setString(4, a.getQualidadeSolo());
            stmt.setDouble(5, a.getQuantidadeHectare());
            stmt.setDouble(6, a.getProducaoHectare());
            stmt.setInt(7, a.getFk_proprietario());
            stmt.setInt(8, a.getPk_terra());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar área de plantio.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    public void deletar(int pk_terra) {
        String sql = "DELETE FROM area_plantio WHERE pk_terra = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk_terra);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar área de plantio.", e);
        } finally {
            Conexao.fechar(con);
        }
    }
 
    private Areas montarAreas(ResultSet rs) throws SQLException {
        Areas a = new Areas(
                rs.getInt("pk_terra"),
                rs.getInt("fk_proprietario"),
                rs.getString("sementePlantada"),
                rs.getDate("dataPlantio"),
                rs.getDate("dataColeita"),
                rs.getString("qualidadeSolo"),
                rs.getDouble("quantidadeHectares"),
                rs.getDouble("producaoHectare")
        );
        return a;
    }
}
