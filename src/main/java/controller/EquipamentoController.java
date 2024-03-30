/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package controller;

import entidades.Equipamento;
import models.EquipamentoModel;

import java.util.ArrayList;

/**
 * This class is responsible for controlling the operations related to Equipamento.
 * It interacts with the EquipamentoModel to perform CRUD operations.
 */
public class EquipamentoController {
    private Equipamento equipamento;
    private EquipamentoModel equipamentoModel = new EquipamentoModel();

    /**
     * This method is used to create a new Equipamento.
     *
     * @param nome       The name of the Equipamento.
     * @param patrimonio The patrimonio of the Equipamento.
     * @return The ID of the created Equipamento.
     */
    public Integer create(String nome, String patrimonio) {
        equipamento = new Equipamento();
        criaEquipamentoParcial(nome, patrimonio);
        return equipamentoModel.create(equipamento);
    }

    /**
     * This method is used to remove an existing Equipamento.
     *
     * @param id The ID of the Equipamento to be removed.
     */
    public void remove(Integer id) {
        this.equipamento = equipamentoModel.get(id);
        equipamentoModel.remove(this.equipamento);
    }

    /**
     * This method is used to update an existing Equipamento.
     *
     * @param id         The ID of the Equipamento to be updated.
     * @param nome       The new name of the Equipamento.
     * @param patrimonio The new patrimonio of the Equipamento.
     * @return true if the update was successful, false otherwise.
     */
    public Boolean update(Integer id, String nome, String patrimonio) throws IllegalArgumentException {
        this.equipamento = equipamentoModel.get(id);
        if (equipamento == null)
            throw new IllegalArgumentException("Equipamento não encontrado");

        criaEquipamentoParcial(nome, patrimonio);
        return equipamentoModel.update(equipamento);
    }

    /**
     * This method is used to retrieve an Equipamento by its ID.
     *
     * @param id The ID of the Equipamento to be retrieved.
     * @return The Equipamento object.
     */
    public Equipamento get(Integer id) {
        return equipamentoModel.get(id);
    }

    /**
     * This method is used to retrieve all Equipamentos.
     *
     * @return A list of all Equipamentos.
     */
    public ArrayList<Equipamento> getAll() {
        return equipamentoModel.getAll();
    }

    public void criaEquipamentoParcial(String nome, String patrimonio) {
        this.equipamento.setNome(nome);
        this.equipamento.setPatrimonio(patrimonio);
    }
}