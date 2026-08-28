/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import DAO.FertilizanteDAO;
import java.util.List;
import model.Fertilizante;
 
/**
 *
 * @author anagi
 */
public class FertilizanteController {
 
    private final FertilizanteDAO dao = new FertilizanteDAO();
 
    public void cadastrar(Fertilizante f) {
        validar(f);
        dao.inserir(f);
    }
 
    public List<Fertilizante> listarTodos() {
        return dao.listarTodos();
    }
 
    public Fertilizante buscarPorId(int pk_fertilizante) {
        return dao.buscarPorId(pk_fertilizante);
    }
 
    public List<Fertilizante> listarPorTerra(int fk_terra) {
        return dao.listarPorTerra(fk_terra);
    }
 
    public void atualizar(Fertilizante f) {
        validar(f);
        dao.atualizar(f);
    }
 
    public void deletar(int pk_fertilizante) {
        dao.deletar(pk_fertilizante);
    }
 
    private void validar(Fertilizante f) {
        if (f == null) {
            throw new IllegalArgumentException("Fertilizante não pode ser nulo.");
        }
        if (f.getNomeFertilizante() == null || f.getNomeFertilizante().isBlank()) {
            throw new IllegalArgumentException("Nome do fertilizante é obrigatório.");
        }
        if (f.getQuantidadeAplicada() == null || f.getQuantidadeAplicada() <= 0) {
            throw new IllegalArgumentException("Quantidade aplicada deve ser maior que zero.");
        }
        if (f.getFk_proprietario() <= 0 || f.getFk_terra() <= 0) {
            throw new IllegalArgumentException("Proprietário e área de plantio são obrigatórios.");
        }
    }
}
