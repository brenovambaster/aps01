/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.predio.Predio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PredioModelTest {
    private PredioModel predioModel;
    private Predio predio;

    @BeforeEach
    void setUp() {
        predio = new Predio("Predio 1", null);
        predioModel = new PredioModel();
    }

    @AfterEach
    void tearDown() {
        predioModel.remove(predio);
        predioModel = null;
        predio = null;
    }

    @Test
    void create() {
        predio.setId(predioModel.create(predio));
        assertEquals(predio, predioModel.get(predio.getId()));
    }

    @Test
    void remove() {

        predio.setId(predioModel.create(predio));
        predioModel.remove(predio);
        assertEquals(null, predioModel.get(predio.getId()));
    }

    // TODO: Fix this test
    @Test
    void update() {
        predio.setId(predioModel.create(predio));
        predio.setNome("Predio Dois");
        predioModel.update(predio);
        assertEquals("Predio Dois", predioModel.get(predio.getId()).getNome());
    }


    @Test
    void get() {

        predio.setId(predioModel.create(predio));
        assertEquals(predio, predioModel.get(predio.getId()));
    }

    @Test
    void getAll() {

        assertEquals(0, predioModel.getAll().size());
    }
}