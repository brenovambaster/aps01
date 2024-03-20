/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.campus.Campus;

import java.util.ArrayList;

public class CampusModel {
    private ArrayList<Campus> campusList = new ArrayList<>();

    public CampusModel() {

    }

    public void create(Campus campus) {
        campusList.add(campus);
    }

    public void remove(Campus campus) {
        campusList.remove(campus);
    }

    public void update(Campus campus) {
        campusList.set(campusList.indexOf(campus), campus);
    }

    public Campus get(int index) {
        return campusList.get(index);
    }

    public ArrayList<Campus> getAll() {
        return campusList;
    }
}
