/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import java.util.ArrayList;

import entidades.predio.Predio;

public class PredioModel {
    private ArrayList<Predio> predioList = new ArrayList<>();
    private Integer id = 0;

    public PredioModel() {

    }

    public Integer create(Predio predio) {
        predio.setId(id);
        predioList.add(predio);
        return id++;
    }

    public void remove(Predio predio) {
        for (Predio p : predioList) {
            if (p.getId().equals(predio.getId())) {
                predioList.remove(p);
                break;
            }
        }
    }

    //TODO: Encontrar outra forma de fazer o update. Se Predio ter mais atributos o código ficará muito grande.
    public void update(Predio predio) {

        for (Predio p : predioList) {
            if (p.getId().equals(predio.getId())) {
                p.setNome(predio.getNome());
                p.setCampus(predio.getCampus());
                break;
            }
        }
    }

    public Predio get(int id) {
        for (Predio p : predioList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Predio> getAll() {
        return predioList;
    }
}
