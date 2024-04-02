/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package controller;

import entidades.Campus;
import models.CampusModel;

import java.util.ArrayList;

/**
 * This class is a controller for the Campus entity.
 * It provides methods to create, remove, update, get and get all campuses.
 */
public class CampusController {
    private Campus campus;
    private CampusModel campusModel = new CampusModel();


    public Integer create(String nome, String endereco) {
        campus = new Campus();
        criaCampusParcial(nome, endereco);
        return campusModel.create(campus);
    }

    /**
     * Removes the campus with the given ID.
     *
     * @param id The ID of the campus to remove.
     */
    public void remove(Integer id) {
        this.campus = campusModel.get(id);
        campusModel.remove(this.campus);
    }

    /**
     * Updates the campus with the given name and address.
     *
     * @param nome     The new name of the campus.
     * @param endereco The new address of the campus.
     * @return True if the update was successful, false otherwise.
     */
    public Boolean update(Integer id, String nome, String endereco) {
        this.campus = campusModel.get(id);
        if (campus == null)
            throw new IllegalArgumentException("Campus não encontrado");
        criaCampusParcial(nome, endereco);
        return campusModel.update(this.campus);
    }

    /**
     * Gets the campus with the given ID.
     *
     * @param id The ID of the campus to get.
     * @return The campus with the given ID.
     */
    public Campus get(int id) {
        return campusModel.get(id);
    }

    /**
     * Gets all campuses.
     *
     * @return A list of all campuses.
     */
    public ArrayList<Campus> getAll() {
        return campusModel.getAll();
    }

    public Campus get(Integer id) {
        return campusModel.get(id);
    }

    private void criaCampusParcial(String nome, String endereco) {
        this.campus.setNome(nome);
        this.campus.setEndereco(endereco);
    }
}