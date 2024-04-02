/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import java.util.ArrayList;

import entidades.Predio;
import helpers.HelperUtil;
import interfaces.IMetodos;

public class PredioModel implements IMetodos<Predio> {
    private static ArrayList<Predio> predioList = new ArrayList<>();
    private static Integer id = 0;

    public PredioModel() {

    }

    public Integer create(Predio predio) {
        HelperUtil.validateObject(predio);

        predio.setId(id);
        predioList.add(predio);
        return id++;
    }

    public void remove(Predio predio) {
        HelperUtil.validateObject(predio);

        for (Predio p : predioList) {
            if (p.getId().equals(predio.getId())) {
                predioList.remove(p);
                break;
            }
        }
    }

    //TODO: Encontrar outra forma de fazer o update. Se Predio ter mais atributos o código ficará muito grande.
    public Boolean update(Predio predio) {
        HelperUtil.validateObject(predio);

        for (Predio p : predioList) {
            if (p.getId().equals(predio.getId())) {
                p.setNome(predio.getNome());
                p.setCampus(predio.getCampus());
                return true;
            }
        }
        return false;
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
