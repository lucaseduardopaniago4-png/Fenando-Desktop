/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import DAO.ProprietarioDAO;
import java.util.List;
import model.Proprietario;
 
/**
 *
 * @author anagi
 */
public class ProprietarioController {
 
    private final ProprietarioDAO dao = new ProprietarioDAO();
 
    public void cadastrar(Proprietario p) {
        validar(p);
        dao.inserir(p);
    }
 
    public List<Proprietario> listarTodos() {
        return dao.listarTodos();
    }
 
    public Proprietario buscarPorId(int pk_proprietario) {
        return dao.buscarPorId(pk_proprietario);
    }
 
    public void atualizar(Proprietario p) {
        validar(p);
        dao.atualizar(p);
    }
 
    public void deletar(int pk_proprietario) {
        dao.deletar(pk_proprietario);
    }
 
    private void validar(Proprietario p) {
        if (p == null) {
            throw new IllegalArgumentException("Proprietário não pode ser nulo.");
        }
        if (p.getCnpj() == null || p.getCnpj().isBlank()) {
            throw new IllegalArgumentException("CNPJ é obrigatório.");
        }
        if (p.getNomeProprietario() == null || p.getNomeProprietario().isBlank()) {
            throw new IllegalArgumentException("Nome do proprietário é obrigatório.");
        }
        if (p.getIdadeProprietario() <= 0) {
            throw new IllegalArgumentException("Idade do proprietário deve ser maior que zero.");
        }
    }
}
