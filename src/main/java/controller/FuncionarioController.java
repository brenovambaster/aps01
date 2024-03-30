/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package controller;

import entidades.Campus;
import entidades.Funcionario;
import models.CampusModel;
import models.FuncionarioModel;

import java.util.ArrayList;

public class FuncionarioController {
    private Funcionario funcionario;
    private FuncionarioModel funcionarioModel = new FuncionarioModel();
    private Campus campus;

    public Integer create(String nome, String cargo, String ramal, Integer campusId) throws IllegalArgumentException {
        funcionario = new Funcionario();
        campus = new Campus();
        criaFuncionarioParcial(nome, cargo, ramal, campusId);
        return funcionarioModel.create(funcionario);
    }

    public void remove(Integer id) {
        this.funcionario = funcionarioModel.get(id);
        if (funcionario == null)
            throw new IllegalArgumentException("Funcionário não encontrado");

        funcionarioModel.remove(this.funcionario);
    }

    public Boolean update(Integer id, String nome, String cargo, String ramal, Integer campusId) {
        this.funcionario = funcionarioModel.get(id);
        if (funcionario == null)
            throw new IllegalArgumentException("Funcionário não encontrado");

        criaFuncionarioParcial(nome, cargo, ramal, campusId);
        return funcionarioModel.update(funcionario);
    }

    public Funcionario get(Integer id) {
        return funcionarioModel.get(id);
    }

    public ArrayList<Funcionario> getAll() {
        return funcionarioModel.getAll();
    }

    /**
     * This method is used to create a partial Funcionario object.
     * It first retrieves the Campus object associated with the provided campusId.
     * If the Campus object is not found, it throws an IllegalArgumentException.
     *
     * @param nome     The name of the Funcionario.
     * @param cargo    The cargo of the Funcionario.
     * @param ramal    The ramal of the Funcionario.
     * @param campusId The ID of the Campus associated with the Funcionario.
     * @throws IllegalArgumentException If the Campus object is not found.
     */
    private void criaFuncionarioParcial(String nome, String cargo, String ramal, Integer campusId) {
        CampusModel campusmodel = new CampusModel();
        this.campus = campusmodel.get(campusId);
        if (this.campus == null)
            throw new IllegalArgumentException("Campus não encontrado");

        this.funcionario.setNome(nome);
        this.funcionario.setCargo(cargo);
        this.funcionario.setRamal(ramal);
        this.funcionario.setCampus(this.campus);
    }
}
