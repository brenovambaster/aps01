/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.reserva.Reserva;
import helpers.HelperUtil;
import interfaces.IMetodos;

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
     * @return
     */
    @Override
    public ArrayList<Reserva> getAll() {
        return reservasList;
    }
}
