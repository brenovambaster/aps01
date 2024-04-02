/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package controller;

import entidades.Predio;
import entidades.Sala;
import models.PredioModel;
import models.SalaModel;

import java.util.ArrayList;

public class SalaController {
    private Sala sala;
    private SalaModel salaModel = new SalaModel();
    private PredioModel predioModel = new PredioModel();

    public Integer create(Integer numero, Integer idPredio, Integer capacidade) {
        sala = new Sala();
        criaSalaParcial(numero, idPredio, capacidade);
        return salaModel.create(sala);
    }

    public void remove(Integer id) {
        this.sala = salaModel.get(id);
        if (sala == null)
            throw new IllegalArgumentException("Sala não encontrada");
        salaModel.remove(this.sala);
    }

    public Boolean update(Integer id, Integer numero, Integer idPredio, Integer capacidade) {
        this.sala = salaModel.get(id);
        if (sala == null)
            throw new IllegalArgumentException("Sala não encontrada");

        criaSalaParcial(numero, idPredio, capacidade);
        return salaModel.update(sala);
    }

    public Sala get(Integer id) {
        return salaModel.get(id);
    }

    public ArrayList<Sala> getAll() {
        return salaModel.getAll();
    }

    public void criaSalaParcial(Integer numero, Integer idPredio, Integer capacidade) {
        Predio predio = new Predio();
        predio = predioModel.get(idPredio);
        if (predio == null)
            throw new IllegalArgumentException("Prédio não encontrado");

        this.sala.setNumeroSala(numero);
        this.sala.setPredio(predio);
        this.sala.setQtdLugares(capacidade);
    }
}
