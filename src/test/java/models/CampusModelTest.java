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
    private Campus campus;

    @BeforeEach
    void setUp() {
        this.campusModel = new CampusModel();
        this.campus = new Campus("Gama", "Rua 3, vilage");
    }

    @AfterEach
    void tearDown() {
        campusModel.remove(campus);
        campus = null;
        campusModel = null;
    }

    @Test
    void create() {
        Integer id = campusModel.create(campus);
        campus.setId(id);
        assertEquals(campus, campusModel.get(id));
    }

    @Test
    void remove() {
        Integer id = campusModel.create(campus);
        campus.setId(id);
        campusModel.remove(campus);
        assertEquals(null, campusModel.get(campus.getId()));
    }

    @Test
    void update() {
        Integer id = campusModel.create(campus);
        campus.setId(id);

        campus.setNome("Taguatinga");
        campusModel.update(campus);
        assertEquals("Taguatinga", campusModel.get(campus.getId()).getNome());
    }

    @Test
    void get() {
        campus.setId(campusModel.create(campus));
        assertEquals(campus, campusModel.get(campus.getId()));
    }

    @Test
    void getAll() {
        assertEquals(0, campusModel.getAll().size());
    }
}