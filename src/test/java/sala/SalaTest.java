/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package sala;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import predio.Predio;

class SalaTest {
    private Sala sala;


    @BeforeEach
    void setUp() {
        Predio predio = new Predio("Predio 1", null);
        sala = new Sala(1, 10, predio);
    }

    @AfterEach
    void tearDown() {
        sala.setPredio(null);
        sala = null;
    }

    @Test
    @DisplayName("getNumeroSala")
    void getNumeroSala() {
        assertEquals(1, sala.getNumeroSala());
    }

    @Test
    @DisplayName("setNumeroSala")
    void setNumeroSala() {
        sala.setNumeroSala(2);
        assertEquals(2, sala.getNumeroSala());
    }

    @Test
    @DisplayName("getQtdLugares")
    void getQtdLugares() {
        assertEquals(10, sala.getQtdLugares());
    }

    @Test
    @DisplayName("setQtdLugares")
    void setQtdLugares() {
        sala.setQtdLugares(20);
        assertEquals(20, sala.getQtdLugares());
    }

    @Test
    @DisplayName("getPredio")
    void getPredio() {
        assertEquals("Predio 1", sala.getPredio().getNome());
    }

    @Test
    @DisplayName("setPredio")
    void setPredio() {
        sala.setPredio(null);
        assertEquals(null, sala.getPredio());
    }

}