/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.Equipamento;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipamentoModelTest {
    private EquipamentoModel equipamentoModel;
    private Equipamento equipamento;

    @BeforeEach
    void setUp() {
        equipamento = new Equipamento("Computador", "123456");
        equipamentoModel = new EquipamentoModel();

    }

    @AfterEach
    void tearDown() {
        equipamentoModel.remove(equipamento);
        equipamentoModel = null;
        equipamento = null;
    }

    @Test
    void create() {
        equipamento.setId(equipamentoModel.create(equipamento));
        assertEquals(equipamento, equipamentoModel.get(equipamento.getId()));

    }

    @Test
    void remove() {
        equipamento.setId(equipamentoModel.create(equipamento));
        equipamentoModel.remove(equipamento);
        assertEquals(null, equipamentoModel.get(equipamento.getId()));
    }

    @Test
    void update() {
        equipamento.setId(equipamentoModel.create(equipamento));
        equipamento.setNome("Cadeiras");
        equipamentoModel.update(equipamento);
        assertEquals("Cadeiras", equipamentoModel.get(equipamento.getId()).getNome());
    }

    @Test
    void get() {
        equipamento.setId(equipamentoModel.create(equipamento));
        assertEquals(equipamento, equipamentoModel.get(equipamento.getId()));
    }

    @Test
    void getAll() {

        assertEquals(0, equipamentoModel.getAll().size());
    }
}