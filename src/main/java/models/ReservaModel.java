/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.reserva.Reserva;
import interfaces.IMetodos;

import java.util.ArrayList;

import Helpers.ReservaHelper;

public class ReservaModel implements IMetodos<Reserva> {
    private ArrayList<Reserva> reservasList = new ArrayList<>();
    private Integer id = 0;

    /**
     * @param reserva
     * @return
     */
    @Override
    public Integer create(Reserva reserva) {
        if (id == null || id > 0)
            throw new RuntimeException("Reserva já existe!");
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
        reservasList.removeIf(r -> r.getId().equals(reserva.getId()));
    }

    /**
     * @param reserva
     */
    @Override
    public void update(Reserva reserva) {
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
                break;
            }
        }
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
     * @return
     */
    @Override
    public ArrayList<Reserva> getAll() {
        return reservasList;
    }
}
