/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.campus.Campus;
import entidades.predio.Predio;
import entidades.sala.Sala;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SalaModelTest {
    private SalaModel salaModel;
    private Sala sala;
    private Predio predio;

    @BeforeEach
    void setUp() {

        Campus campus = new Campus("Campus 1", "Endereco 1");
        campus.setId(0);
        predio = new Predio("Predio 1", campus);
        predio.setId(0);

        salaModel = new SalaModel();
        sala = new Sala(1, 100, predio);
    }

    @AfterEach
    void tearDown() {
        salaModel = null;
        sala = null;
        predio = null;
    }

    @Test
    void create() {
        sala.setId(salaModel.create(sala));
        assertEquals(sala, salaModel.getAll().get(0));
    }

    @Test
    void remove() {
        sala.setId(salaModel.create(sala));
        salaModel.remove(sala);

        assertEquals(null, salaModel.get(sala.getId()));
    }

    @Test
    void update() {
        Campus campus = new Campus("Campus 1", "Endereco 1");
        campus.setId(1);

        Predio predio = new Predio("Predio 1", campus);
        predio.setId(1);

        Predio predio2 = new Predio("Predio 2", campus);
        predio2.setId(2);

        Sala sala = new Sala(1, 100, predio);

        sala.setId(salaModel.create(sala));
        sala.setPredio(predio2);
        salaModel.update(sala);

        assertEquals(sala.getPredio(), salaModel.get(0).getPredio());
    }

    @Test
    void get() {
        Campus campus = new Campus("Campus 1", "Endereco 1");
        campus.setId(1);

        Predio predio = new Predio("Predio 1", campus);
        predio.setId(1);

        Sala sala = new Sala(1, 100, predio);

        sala.setId(salaModel.create(sala));
        assertEquals(sala, salaModel.get(0));
    }

    @Test
    void getAll() {
        Campus campus = new Campus("Campus 1", "Endereco 1");
        campus.setId(1);

        Predio predio = new Predio("Predio 1", campus);
        predio.setId(1);

        Sala sala = new Sala(1, 100, predio);
        sala.setId(salaModel.create(sala));
        ArrayList<Sala> salas = new ArrayList<>();
        salas.add(sala);

        assertEquals(salas, salaModel.getAll());
    }
}