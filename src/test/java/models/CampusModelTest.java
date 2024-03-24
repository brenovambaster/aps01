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
        this.campus = new Campus("Gama", "Rua 3, vilage");

    }

    @AfterEach
    void tearDown() {
        campusModel.remove(campus);
    }

    @Test
    void create() {
        Integer id = CampusModel.create(campus);
        campus.setId(id);
        assertEquals(campus, CampusModel.get(id));
    }

    @Test
    void remove() {
        Integer id = CampusModel.create(campus);
        campus.setId(id);
        CampusModel.remove(campus);
        assertEquals(null, CampusModel.get(campus.getId()));
    }

    @Test
    void update() {

        Integer id = campusModel.create(campus);
        campus.setId(id);
        campus.setNome("Gama3");
        CampusModel.update(campus);
        assertEquals("Gama3", campusModel.get(id).getNome());
    }

    @Test
    void get() {
        Integer id = CampusModel.create(campus);
        assertEquals(campus, campusModel.get(id));
    }

    @Test
    void getAll() {
        CampusModel.create(campus);
        assertEquals(1, campusModel.getAll().size());
    }
}