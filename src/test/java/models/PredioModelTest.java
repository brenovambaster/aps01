/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.predio.Predio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PredioModelTest {
    private PredioModel predioModel;

    @BeforeEach
    void setUp() {
        Predio predio = new Predio("Predio 1", null);
        predioModel = new PredioModel();
    }

    @Test
    void create() {
        predioModel.create(new Predio("Predio 2", null));
        assertEquals(1, predioModel.getAll().size());
    }

    @Test
    void remove() {
        predioModel.create(new Predio("Predio 1", null));
        predioModel.remove(new Predio("Predio 1", null));
    }

    @Test
    void update() {
        Predio predio = new Predio("Predio 1", null);
        predioModel.create(predio);
        predio.setNome("Predio Dois");
        predioModel.update(predio);
        assertEquals("Predio Dois", predioModel.get(0).getNome());
    }

    @Test
    void get() {
        Predio predio = new Predio("Predio 1", null);
        predioModel.create(predio);
        assertEquals(predio, predioModel.get(0));
    }

    @Test
    void getAll() {
        ArrayList<Predio> predioList = new ArrayList<>();
        Predio predio1 = new Predio("Predio 1", null);
        Predio predio2 = new Predio("Predio 2", null);

        predioList.add(predio1);
        predioList.add(predio2);

        predioModel.create(predio1);
        predioModel.create(predio2);

        assertEquals(predioList, predioModel.getAll());
    }
}