/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.reserva.Reserva;
import entidades.sala.Sala;
import helpers.HelperUtil;
import interfaces.IMetodos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import helpers.ReservaHelper;

import javax.swing.text.html.HTMLEditorKit;

public class ReservaModel implements IMetodos<Reserva> {
    private static ArrayList<Reserva> reservasList = new ArrayList<>();
    private static Integer id = 0;

    /**
     * @param reserva
     * @return
     */
    @Override
    public Integer create(Reserva reserva) {
        HelperUtil.validateObject(reserva);

        if (ReservaHelper.ConflitaHorario(this.reservasList, reserva))
            throw new RuntimeException("Conflito de horário!");

        reserva.setId(id);
        reservasList.add(reserva);
        return id++;
    }

    /**
     * @param reserva
     */
    @Override
    public void remove(Reserva reserva) {
        HelperUtil.validateObject(reserva);

        reservasList.removeIf(r -> r.getId().equals(reserva.getId()));
    }

    /**
     * @param reserva
     */
    @Override
    public Boolean update(Reserva reserva) {
        HelperUtil.validateObject(reserva);

        for (Reserva r : reservasList) {
            if (r.getId().equals(reserva.getId())) {
                r.setEquipamentos(reserva.getEquipamentos());
                r.setSala(reserva.getSala());
                r.setUsuario(reserva.getUsuario());
                r.setUsuario(reserva.getUsuario());
                r.setTipo(reserva.getTipo());
                r.setDataAlocacao(reserva.getDataAlocacao());
                r.setHoraInicio(reserva.getHoraInicio());
                r.setHoraFim(reserva.getHoraFim());
                r.setAssunto(reserva.getAssunto());
                r.setAtivo(reserva.isAtivo());
                return true;
            }
        }
        return false;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Reserva get(int id) {
        return reservasList.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * A partir de uma data, hora de início e hora de fim, verifica quais salas estão disponíveis
     * para uma reserva. Retorna uma lista vazia ou não.
     *
     * @param horaInicio   - Hora de início da reserva  (Exemplo: 10:00)
     * @param horaFim      - Hora de fim da reserva (Exemplo: 12:00)
     * @param dataAlocacao - Data da reserva (Exemplo: 2024-12-12)
     * @return ArrayList<Sala> - Lista de salas disponíveis
     */
    public ArrayList<Sala> obterSalasLivres(LocalTime horaInicio, LocalTime horaFim, LocalDate dataAlocacao) {
        // copia da lista de reservas
        ArrayList<Reserva> reservas = this.getAll();

        ArrayList<Sala> salasOcupadas = new ArrayList<>();
        // copia da lista de salas
        SalaModel salaModel = new SalaModel();
        ArrayList<Sala> salasPersistidas = salaModel.getAll();

        for (Reserva r : reservas) {
            if (r.getDataAlocacao().equals(dataAlocacao) && HelperUtil.isHorarioConflitante(r, horaInicio, horaFim)) {
                salasOcupadas.add(r.getSala());
            }
        }
        salasPersistidas.removeAll(salasOcupadas);
        return salasPersistidas;
    }


    /**
     * A partir de uma data, hora de início e hora de fim, verifica quais salas estão reservadas
     *
     * @param horaInicio
     * @param horaFim
     * @param dataAlocacao
     * @return ArrayList<Sala> - Lista de salas reservadas
     */
    public ArrayList<Sala> obterSalasReservadas(LocalTime horaInicio, LocalTime horaFim, LocalDate dataAlocacao) {
        // copia da lista de reservas
        ArrayList<Reserva> reservas = this.getAll();
        ArrayList<Sala> salasReservadas = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getDataAlocacao().equals(dataAlocacao) && HelperUtil.isHorarioConflitante(r, horaInicio, horaFim)) {
                salasReservadas.add(r.getSala());
            }
        }
        return salasReservadas;
    }

    /**
     * @return
     */
    @Override
    public ArrayList<Reserva> getAll() {
        return reservasList;
    }
}
