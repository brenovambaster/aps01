/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.sala.Sala;
import helpers.HelperUtil;

import java.util.ArrayList;

/**
 * Classe Sala que Simula um Banco de Dados
 *
 * @atribute {@code ArrayList<Sala> salaList}
 * @atribute {@code Integer id}
 * @see Sala
 */
public class SalaModel {
    private ArrayList<Sala> salaList = new ArrayList<>();
    private Integer id = 0;

    public Integer create(Sala sala) {
        HelperUtil.validateObject(sala);

        sala.setId(id);
        salaList.add(sala);
        return id++;
    }

    public void remove(Sala sala) {
        HelperUtil.validateObject(sala);
        if (salaList.isEmpty()) {
            throw new IllegalArgumentException("Não há salas cadastradas");
        }
        if (get(sala.getId()) == null) {
            throw new IllegalArgumentException("Sala não encontrada");
        }

        salaList.removeIf(s -> s.getId().equals(sala.getId()));
    }

    //TODO: Revisar essa parte
    public void update(Sala sala) {
        HelperUtil.validateObject(sala);

        for (Sala s : salaList) {
            if (s.getId().equals(sala.getId())) {
                s.setQtdLugares(sala.getQtdLugares());
                s.setNumeroSala(sala.getNumeroSala());
                s.setPredio(sala.getPredio());
                break;
            }
        }
    }

    public Sala get(int id) {
        return salaList.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public ArrayList<Sala> getAll() {
        return salaList;
    }

}
