/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades;

import entidades.Campus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampusTest {

    private Campus campus;

    @BeforeEach
    void setUp() {
        campus = new Campus("Campus 1", "Rua 1, 123");
    }

    @AfterEach
    void tearDown() {
        campus = null;
    }

    @Test
    void getId() {
        assertEquals(null, campus.getId());
    }

    @Test
    void setId() {
        campus.setId(1);
        assertEquals(1, campus.getId());
    }

    @Test
    void getNome() {
        assertEquals("Campus 1", campus.getNome());
    }

    @Test
    void setNome() {
        campus.setNome("Campus 2");
        assertEquals("Campus 2", campus.getNome());
    }

    @Test
    void getEndereco() {
        assertEquals("Rua 1, 123", campus.getEndereco());
    }

    @Test
    void setEndereco() {
        campus.setEndereco("Rua 2, 123");
        assertEquals("Rua 2, 123", campus.getEndereco());
    }
}