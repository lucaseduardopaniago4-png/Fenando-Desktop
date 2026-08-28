/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import DAO.PlantioDAO;
import java.util.List;
import model.Plantio;
 
/**
 *
 * @author anagi
 */
public class PlantioController {
 
    private final PlantioDAO dao = new PlantioDAO();
 
    public void cadastrar(Plantio p) {
        validar(p);
        dao.inserir(p);
    }
 
    public List<Plantio> listarTodos() {
        return dao.listarTodos();
    }
 
    public Plantio buscarPorId(int pk_plantio) {
        return dao.buscarPorId(pk_plantio);
    }
 
    public void atualizar(Plantio p) {
        validar(p);
        dao.atualizar(p);
    }
 
    public void deletar(int pk_plantio) {
        dao.deletar(pk_plantio);
    }
 
    private void validar(Plantio p) {
        if (p == null) {
            throw new IllegalArgumentException("Plantio não pode ser nulo.");
        }
        if (p.getNomeSemente() == null || p.getNomeSemente().isBlank()) {
            throw new IllegalArgumentException("Nome da semente é obrigatório.");
        }
        if (p.getFk_proprietario() <= 0 || p.getFk_terra() <= 0 || p.getFk_fertilizante() <= 0) {
            throw new IllegalArgumentException("Proprietário, área de plantio e fertilizante são obrigatórios.");
        }
    }
}
 
