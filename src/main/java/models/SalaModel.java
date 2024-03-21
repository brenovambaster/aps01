/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.sala.Sala;

import java.util.ArrayList;

public class SalaModel {
    private ArrayList<Sala> salaList = new ArrayList<>();

    public void create(Sala sala) {
        salaList.add(sala);
    }

    public void remove(Sala sala) {
        salaList.remove(sala);
    }

    public void update(Sala sala) {
        salaList.set(salaList.indexOf(sala), sala);
    }

    public void get(int index) {
        salaList.get(index);
    }

    public ArrayList<Sala> getAll() {
        return salaList;
    }

}
