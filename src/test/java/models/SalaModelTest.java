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

    @BeforeEach
    void setUp() {
        salaModel = new SalaModel();

    }

    @AfterEach
    void tearDown() {
        salaModel = null;
    }

    @Test
    void create() {
        Campus campus = new Campus("Campus 1", "Endereco 1");
        campus.setId(1);

        Predio predio = new Predio("Predio 1", campus);
        predio.setId(1);

        Predio predio2 = new Predio("Predio 2", campus);
        predio2.setId(2);

        Sala sala = new Sala(1, 100, predio);

        sala.setId(salaModel.create(sala));
        assertEquals(sala, salaModel.getAll().get(0));
    }

    @Test
    void remove() {
        Campus campus = new Campus("Campus 1", "Endereco 1");
        campus.setId(1);
        Predio predio = new Predio("Predio 1", campus);
        predio.setId(1);

        Sala sala = new Sala(1, 100, predio);
        sala.setId(salaModel.create(sala));
        salaModel.remove(sala);

        assertEquals(0, salaModel.getAll().size());
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