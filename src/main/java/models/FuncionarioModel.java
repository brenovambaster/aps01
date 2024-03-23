/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.funcionario.Funcionario;
import interfaces.IMetodos;

import java.util.ArrayList;

public class FuncionarioModel implements IMetodos<Funcionario> {
    private ArrayList<Funcionario> funcionarioList = new ArrayList<>();
    private Integer id = 0;

    /**
     * @param funcionario
     * @return Integer id
     */
    @Override
    public Integer create(Funcionario funcionario) {
        funcionario.setId(id);
        funcionarioList.add(funcionario);
        return id++;
    }

    /**
     * @param funcionario
     */
    @Override
    public void remove(Funcionario funcionario) {
        funcionarioList.removeIf(e -> e.getId().equals(funcionario.getId()));
    }

    /**
     * @param funcionario
     */
    @Override
    public void update(Funcionario funcionario) {
        for (Funcionario f : funcionarioList) {
            if (f.getId().equals(funcionario.getId())) {
                f.setNome(funcionario.getNome());
                f.setCargo(funcionario.getCargo());
                f.setRamal(funcionario.getRamal());
                f.setCampus(funcionario.getCampus());
                break;
            }
        }
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
