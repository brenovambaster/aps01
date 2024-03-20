/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package professor;

import entidades.campus.Campus;
import entidades.professor.Professor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entidades.usuario.Usuario;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest extends Usuario {
    private Professor professor;

    @BeforeEach
    void setUp() {
        professor = new Professor("Breno", "Professor Mestre", "1234",
                new Campus("Gama", "Rua 3, vilage"));
    }

    @AfterEach
    void tearDown() {
        professor = null;
    }

    @Test
    void testGetNome() {
        assertEquals("Breno", professor.getNome());
    }

    @Test
    void testSetNome() {
        professor.setNome("Lucas");
        assertEquals("Lucas", professor.getNome());
    }

    @Test
    void testGetCargo() {
        assertEquals("Professor Mestre", professor.getCargo());
    }

    @Test
    void testSetCargo() {
        professor.setCargo("Professor Doutor");
        assertEquals("Professor Doutor", professor.getCargo());
    }

    @Test
    void testGetRamal() {
        assertEquals("1234", professor.getRamal());
    }

    @Test
    void testSetRamal() {
        professor.setRamal("5678");
        assertEquals("5678", professor.getRamal());
    }

    @Test
    void testGetCampus() {
        assertEquals("Gama", professor.getCampus().getNome());
    }

    @Test
    void testSetCampus() {
        professor.setCampus(new Campus("Taguatinga", "Rua 3, vilage"));
        assertEquals("Taguatinga", professor.getCampus().getNome());
    }
}