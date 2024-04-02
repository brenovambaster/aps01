/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.Funcionario;
import interfaces.IMetodos;
import helpers.HelperUtil;

import java.util.ArrayList;

public class FuncionarioModel implements IMetodos<Funcionario> {
    private static ArrayList<Funcionario> funcionarioList = new ArrayList<>();
    private static Integer id = 0;

    /**
     * @param funcionario
     * @return Integer id
     */
    @Override
    public Integer create(Funcionario funcionario) {
        HelperUtil.validateObject(funcionario);
        funcionario.setId(id);
        funcionarioList.add(funcionario);
        return id++;
    }

    /**
     * @param funcionario
     */
    @Override
    public void remove(Funcionario funcionario) {
        HelperUtil.validateObject(funcionario);
        funcionarioList.removeIf(e -> e.getId().equals(funcionario.getId()));
    }

    /**
     * @param funcionario
     */
    @Override
    public Boolean update(Funcionario funcionario) {
        HelperUtil.validateObject(funcionario);
        for (Funcionario f : funcionarioList) {
            if (f.getId().equals(funcionario.getId())) {
                f.setNome(funcionario.getNome());
                f.setCargo(funcionario.getCargo());
                f.setRamal(funcionario.getRamal());
                f.setCampus(funcionario.getCampus());
                return true;
            }
        }
        return false;
    }

    /**
     * @param id
     * @return Funcionario | null
     */
    @Override
    public Funcionario get(int id) {
        return funcionarioList.stream().filter(e -> e.getId().equals(id))
                .findFirst().orElse(null);
    }

    /**
     * @return ArrayList<Funcionario>
     */
    @Override
    public ArrayList<Funcionario> getAll() {
        return funcionarioList;
    }
}
