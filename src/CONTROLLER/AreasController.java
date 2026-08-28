/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import DAO.AreasDAO;
import java.util.List;
import model.Areas;
 
/**
 *
 * @author anagi
 */
public class AreasController {
 
    private final AreasDAO dao = new AreasDAO();
 
    public void cadastrar(Areas a) {
        validar(a);
        dao.inserir(a);
    }
 
    public List<Areas> listarTodos() {
        return dao.listarTodos();
    }
 
    public Areas buscarPorId(int pk_terra) {
        return dao.buscarPorId(pk_terra);
    }
 
    public List<Areas> listarPorProprietario(int fk_proprietario) {
        return dao.listarPorProprietario(fk_proprietario);
    }
 
    public void atualizar(Areas a) {
        validar(a);
        dao.atualizar(a);
    }
 
    public void deletar(int pk_terra) {
        dao.deletar(pk_terra);
    }
 
    private void validar(Areas a) {
        if (a == null) {
            throw new IllegalArgumentException("Área de plantio não pode ser nula.");
        }
        if (a.getSementePlantada() == null || a.getSementePlantada().isBlank()) {
            throw new IllegalArgumentException("Semente plantada é obrigatória.");
        }
        if (a.getDataPlantada() == null || a.getDataColheita() == null) {
            throw new IllegalArgumentException("Data de plantio e de colheita são obrigatórias.");
        }
        if (a.getQuantidadeHectare() == null || a.getQuantidadeHectare() <= 0) {
            throw new IllegalArgumentException("Quantidade de hectares deve ser maior que zero.");
        }
        if (a.getFk_proprietario() <= 0) {
            throw new IllegalArgumentException("Proprietário é obrigatório.");
        }
    }
}
