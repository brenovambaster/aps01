/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package equipamento;

import entidades.equipamento.Equipamento;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipamentoTest {
    private Equipamento equipamento;

    @BeforeEach
    void setUp() {
        equipamento = new Equipamento("Computador", "123456");
    }

    @AfterEach
    void tearDown() {
        equipamento = null;
    }

    @Test
    void getNome() {
        assertEquals("Computador", equipamento.getNome());
    }

    @Test
    void setNome() {
        equipamento.setNome("Projetor");
        assertEquals("Projetor", equipamento.getNome());
    }

    @Test
    void getPatrimonio() {
        assertEquals("123456", equipamento.getPatrimonio());
    }

    @Test
    void setPatrimonio() {
        equipamento.setPatrimonio("654321");
        assertEquals("654321", equipamento.getPatrimonio());
    }
}