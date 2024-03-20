/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.campus.Campus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampusModelTest {
    private CampusModel campusModel;

    @BeforeEach
    void setUp() {
        Campus campus = new Campus("Gama", "Rua 3, vilage");
        campusModel = new CampusModel();
    }

    @AfterEach
    void tearDown() {
        campusModel = null;
    }

    @Test
    void create() {
        Campus campus = new Campus("Gama2", "Rua 3, vilage");
        campusModel.create(campus);
        assertEquals(1, campusModel.getAll().size());
    }

    @Test
    void remove() {
        Campus campus = new Campus("Gama2", "Rua 3, vilage");
        campusModel.create(campus);
        campusModel.remove(campus);
        assertEquals(0, campusModel.getAll().size());
    }

    @Test
    void update() {
        Campus campus = new Campus("Gama2", "Rua 3, vilage");
        campusModel.create(campus);
        campus.setNome("Gama3");
        campusModel.update(campus);
        assertEquals("Gama3", campusModel.get(0).getNome());
    }

    @Test
    void get() {
        Campus campus = new Campus("Gama2", "Rua 3, vilage");
        campusModel.create(campus);
        assertEquals(campus, campusModel.get(0));
    }

    @Test
    void getAll() {
        Campus campus = new Campus("Gama2", "Rua 3, vilage");
        campusModel.create(campus);
        assertEquals(1, campusModel.getAll().size());
    }
}