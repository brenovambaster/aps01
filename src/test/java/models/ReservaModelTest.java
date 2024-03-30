/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.Equipamento;
import entidades.Professor;
import entidades.Reserva;
import entidades.Sala;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReservaModelTest {
    private ReservaModel reservaModel;
    private Reserva reserva;
    private Sala sala;

    @BeforeEach
    void setUp() {
        reservaModel = new ReservaModel();
        sala = new Sala(1, 23, null);
        LocalDate data = LocalDate.of(2024, 10, 10);
        LocalTime horainicio = LocalTime.of(8, 0);
        LocalTime horaFim = LocalTime.of(12, 0);

        reserva = new Reserva(
                data,
                horainicio,
                horaFim,
                "reuniao",
                null,
                sala,
                "reuniao"
        );
    }

    @AfterEach
    void tearDown() {
        reservaModel.remove(reserva);
        reserva = null;
        reservaModel = null;
    }

    @Test
    void create() {
        Integer id = reservaModel.create(reserva);
        reserva.setId(id);
        assertEquals(reserva, reservaModel.get(id));
    }

    @Test
    void remove() {
        Integer id = reservaModel.create(reserva);
        reservaModel.remove(reserva);
        assertEquals(null, reservaModel.get(id));
    }

    @Test
    void update() {

        // cria uma reserva no "banco de dados"
        Integer id = reservaModel.create(reserva);
        reserva.setId(id);

        // Cria equipamentos e adiciona à uma lista
        ArrayList<Equipamento> equipamentos = new ArrayList<>();
        equipamentos.add(new Equipamento("notebook", "123"));
        equipamentos.add(new Equipamento("projetor", "456"));
        reserva.setEquipamentos(equipamentos);

        // Cria um professor e adiciona à reserva
        reserva.setUsuario(new Professor("breno", "professor adjunto", "1234", null));
        reserva.setDataAlocacao(LocalDate.now());

        // Atualiza a reserva
        reservaModel.update(reserva);

        assertEquals(reserva, reservaModel.get(id));

    }

    @Test
    void get() {
        Integer id = reservaModel.create(reserva);
        reserva.setId(id);
        assertEquals(reserva, reservaModel.get(id));
    }

    @Test
    void getAll() {
        assertEquals(0, reservaModel.getAll().size());

    }

    @Test
    @DisplayName("Teste de conflito de horário")
    void testeConflitoHorario() {

        // Cria uma reserva
        Integer id = reservaModel.create(reserva);
        reserva.setId(id);

        // Cria uma nova reserva com horário conflitante
        Reserva reservaConflitante = new Reserva(
                LocalDate.of(2024, 10, 10),
                LocalTime.of(9, 0),
                LocalTime.of(11, 0),
                "reuniao",
                null,
                sala,
                "reuniao"
        );

        // Verifica se houve conflito
        assertThrows(RuntimeException.class, () -> reservaModel.create(reservaConflitante), "Conflito de horário!");
    }
}