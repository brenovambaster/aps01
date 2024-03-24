/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.campus.Campus;
import helpers.CampusHelper;

import java.util.ArrayList;

public class CampusModel {
    private static ArrayList<Campus> campusList = new ArrayList<>();
    private static Integer id = 0;

    public CampusModel() {

    }

    /**
     * @param campus
     * @return ID of the created campus
     */
    public static Integer create(Campus campus) throws IllegalArgumentException {
        CampusHelper.validateCampus(campus);
        campus.setId(id);
        campusList.add(campus);
        return id++;
    }

    public static void remove(Campus campus) throws IllegalArgumentException {
        CampusHelper.validateCampus(campus);
        campusList.removeIf(c -> c.getId().equals(campus.getId()));
    }

    public static Boolean update(Campus campus) throws IllegalArgumentException {
        CampusHelper.validateCampus(campus);
        for (Campus c : campusList) {
            if (c.getId().equals(campus.getId())) {
                c.setNome(campus.getNome());
                c.setEndereco(campus.getEndereco());
                return true;
            }
        }
        return false;
    }

    /**
     * @param id This is the index of the Campus object in the campusList ArrayList.
     * @return Campus object  | null
     * @sumaary Return campus if found, else return null
     * @see Campus
     */
    public static Campus get(int id) {
        return campusList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * @return ArrayList<Campus>
     * @brief Get all Campus objects
     */
    public static ArrayList<Campus> getAll() {
        return campusList;
    }
}
