/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades;

import entidades.Campus;
import entidades.Equipamento;
import entidades.Professor;
import entidades.Reserva;
import entidades.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entidades.Predio;
import entidades.Sala;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {
    private Reserva reserva;

    @BeforeEach
    void setUp() {

        Campus campus = new Campus("Gama", "FGA");
        Usuario user = new Professor("breno", "diretor", "123", campus);
        Sala sala = new Sala(1, 50, new Predio("FGA", campus));

        reserva = new Reserva(
                LocalDate.of(2023, 3, 1),
                LocalTime.of(20, 32),
                LocalTime.of(21, 32),
                "Reunião",
                user,
                sala,
                "Reunião");
    }

    @AfterEach
    void tearDown() {
        reserva = null;
    }


    @Test
    void testGetDataAlocacao() {
        assertEquals(LocalDate.of(2023, 3, 1), reserva.getDataAlocacao());
    }

    @Test
    void testSetDataAlocacao() {
        reserva.setDataAlocacao(LocalDate.of(2023, 3, 2));
        assertEquals(LocalDate.of(2023, 3, 2), reserva.getDataAlocacao());
    }

    @Test
    void testGetHoraInicio() {
        assertEquals(LocalTime.of(20, 32), reserva.getHoraInicio());
    }

    @Test
    void testSetHoraInicio() {
        reserva.setHoraInicio(LocalTime.of(20, 33));
        assertEquals(LocalTime.of(20, 33), reserva.getHoraInicio());
    }

    @Test
    void testGetHoraFim() {
        assertEquals(LocalTime.of(21, 32), reserva.getHoraFim());
    }

    @Test
    void testSetHoraFim() {
        reserva.setHoraFim(LocalTime.of(22, 33));
        assertEquals(LocalTime.of(22, 33), reserva.getHoraFim());
    }

    @Test
    void testGetAssunto() {
        assertEquals("Reunião", reserva.getAssunto());
    }

    @Test
    void testSetAssunto() {
        reserva.setAssunto("Reunião de trabalho");
        assertEquals("Reunião de trabalho", reserva.getAssunto());
    }

    @Test
    void testGetUsuario() {
        assertEquals("breno", reserva.getUsuario().getNome());
    }

    @Test
    void testSetUsuario() {
        Usuario user = new Professor("Junio", "diretor", "123", new Campus("Gama", "FGA"));
        reserva.setUsuario(user);
        assertEquals("Junio", reserva.getUsuario().getNome());
    }

    @Test
    void testAddEquipamento() {
        Equipamento equipamento = new Equipamento("Projetor", "Projetor de alta qualidade");
        reserva.addEquipamento(equipamento);
    }


    @Test
    void setAtivo() {
        reserva.setAtivo(true);
        assertEquals(true, reserva.isAtivo());
    }

    @Test
    void testDeleteEquipamento() {
        Equipamento equipamento = new Equipamento("Projetor", "Projetor de alta qualidade");
        reserva.addEquipamento(equipamento);
        reserva.deleteEquipamento(equipamento);
    }
}