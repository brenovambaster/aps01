/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package controller;

import entidades.Campus;
import entidades.Predio;
import models.CampusModel;
import models.PredioModel;

import java.util.ArrayList;

public class PredioController {
    private Predio predio;
    private PredioModel predioModel = new PredioModel();
    private CampusModel campusModel = new CampusModel();

    public Integer create(String nome, Integer idCampus) {
        predio= new Predio();
        criaPredioParcial(nome, idCampus);
        return predioModel.create(predio);
    }

    public void remove(Integer id) {
        this.predio = predioModel.get(id);
        if (predio == null)
            throw new IllegalArgumentException("Prédio não encontrado");

        predioModel.remove(this.predio);
    }

    public Boolean update(Integer id, String nome) {
        this.predio = predioModel.get(id);
        if (predio == null)
            throw new IllegalArgumentException("Prédio não encontrado");

        criaPredioParcial(nome, predio.getCampus().getId());
        return predioModel.update(predio);
    }

    public Predio get(Integer id) {
        return predioModel.get(id);
    }

    public ArrayList<Predio> getAll() {
        return predioModel.getAll();
    }

    public void criaPredioParcial(String nome, Integer idCampus) {
        Campus campus = new Campus();
        campus = campusModel.get(idCampus);
        if (campus == null)
            throw new IllegalArgumentException("Campus não encontrado");

        this.predio.setNome(nome);
        this.predio.setCampus(campus);
    }
}
