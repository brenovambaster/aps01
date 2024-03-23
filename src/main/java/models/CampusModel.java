/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.campus.Campus;

import java.util.ArrayList;

public class CampusModel {
    private ArrayList<Campus> campusList = new ArrayList<>();
    private Integer id = 0;

    public CampusModel() {

    }

    /**
     * @param campus
     * @return ID of the created campus
     */
    public Integer create(Campus campus) {
        campus.setId(id);
        campusList.add(campus);
        return id++;
    }

    public void remove(Campus campus) {
        for (Campus c : campusList) {
            if (c.getId().equals(campus.getId())) {
                campusList.remove(c);
                break;
            }
        }
    }

    public void update(Campus campus) {
        for (Campus c : campusList) {
            if (c.getId().equals(campus.getId())) {
                c.setNome(campus.getNome());
                c.setEndereco(campus.getEndereco());
                break;
            }
        }
    }

    /**
     * @param id This is the index of the Campus object in the campusList ArrayList.
     * @return Campus object  | NULL
     * @sumaary Return campus if found, else return null
     * @see Campus
     */
    public Campus get(int id) {
        for (Campus c : campusList) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    /**
     * @return ArrayList<Campus>
     * @brief Get all Campus objects
     */
    public ArrayList<Campus> getAll() {
        return campusList;
    }
}
