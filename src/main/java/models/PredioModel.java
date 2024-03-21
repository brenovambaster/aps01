/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;
import  java.util.ArrayList;
import entidades.predio.Predio;

public class PredioModel {
    private ArrayList<Predio> predioList = new ArrayList<>();

    public PredioModel() {

    }

    public void create(Predio predio) {
        predioList.add(predio);
    }

    public void remove(Predio predio) {
        predioList.remove(predio);
    }

    public void update(Predio predio) {
        predioList.set(predioList.indexOf(predio), predio);
    }

    public Predio get(int index) {
        return predioList.get(index);
    }

    public ArrayList<Predio> getAll() {
        return predioList;
    }
}
