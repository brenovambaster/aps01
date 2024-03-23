/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.campus.Campus;
import entidades.professor.Professor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorModelTest {
    private ProfessorModel professorModel;
    private Professor professor;

    @BeforeEach
    void setUp() {
        Campus campus = new Campus("Campus 1", "Rua 1");
        campus.setId(0);
        professor = new Professor("Breno", "Professor", "1234", campus);
        professorModel = new ProfessorModel();
    }

    @AfterEach
    void tearDown() {
        professorModel = null;
    }

    @Test
    void create() {
        professor.setId(professorModel.create(professor));
        assertEquals(professor, professorModel.get(professor.getId()));
    }

    @Test
    void remove() {
        professor.setId(professorModel.create(professor));
        professorModel.remove(professor);
        assertNull(professorModel.get(professor.getId()));
    }

    @Test
    void update() {
        Campus campus2 = new Campus("Campus 2", "Rua 2");

        professor.setId(professorModel.create(professor));
        professor.setNome("Breno Vambaster");
        professor.setCampus(campus2);

        professorModel.update(professor);
        assertEquals(professor, professorModel.get(professor.getId()));
    }

    @Test
    void get() {
        professor.setId(professorModel.create(professor));
        assertEquals(professor, professorModel.get(professor.getId()));
    }

    @Test
    void getAll() {
        professor.setId(professorModel.create(professor));
        ArrayList<Professor> professorList = new ArrayList<>();
        professorList.add(professor);

        assertEquals(professorList, professorModel.getAll());

    }
}