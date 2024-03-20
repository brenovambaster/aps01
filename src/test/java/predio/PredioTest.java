/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package predio;

import campus.Campus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredioTest {
    private Predio predio;
    @BeforeEach
    void setUp() {
        predio= new Predio("Predio 1", new Campus("Campus 1", "R. Juca Prates, centro"));
    }

    @AfterEach
    void tearDown() {
        predio.setCampus(null);
        predio = null;
    }

    @Test
    void getNome() {
        assertEquals("Predio 1", predio.getNome());
    }

    @Test
    void setNome() {
        predio.setNome("Predio 2");
        assertEquals("Predio 2", predio.getNome());
    }

    @Test
    void getCampus() {
        assertEquals("Campus 1", predio.getCampus().getNome());
    }

    @Test
    void setCampus() {
        predio.setCampus(new Campus("Campus 2", "R. Juca Prates, centro"));
        assertEquals("Campus 2", predio.getCampus().getNome());
    }
}