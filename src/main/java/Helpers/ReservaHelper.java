/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package Helpers;

import entidades.reserva.Reserva;
import models.ReservaModel;

import java.net.Inet4Address;
import java.util.ArrayList;

public class ReservaHelper {
    /**
     * Verifica se a reserva conflita com outra reserva no mesmo horário e data
     *
     * @return true se houver conflito, false se não houver
     */
    public static Boolean ConflitaHorario(ArrayList<Reserva> reservasExistentes, Reserva novaReserva) {
        //TODO: Refatorar esse método para melhorar a legibilidade e manuntenção
        // TODO: Cirar teste unitário para esse método

        for (Reserva reserva : reservasExistentes) {
            if (reserva.getDataAlocacao().equals(novaReserva.getDataAlocacao())) {
                // Verifica se a hora de início da nova reserva está entre a hora de início e fim da reserva existente
                if (reserva.getHoraInicio().isBefore(novaReserva.getHoraInicio()) && reserva.getHoraFim().isAfter(novaReserva.getHoraInicio())) {
                    return true;
                }
                // Verifica se a hora de fim da nova reserva está entre a hora de início e fim da reserva existente
                if (reserva.getHoraInicio().isBefore(novaReserva.getHoraFim()) && reserva.getHoraFim().isAfter(novaReserva.getHoraFim())) {
                    return true;
                }
                // Verifica se a nova reserva está dentro da reserva existente
                if (reserva.getHoraInicio().isAfter(novaReserva.getHoraInicio()) && reserva.getHoraFim().isBefore(novaReserva.getHoraFim())) {
                    return true;
                }

                if ((reserva.getHoraInicio().equals(novaReserva.getHoraInicio()) || reserva.getHoraFim().equals(novaReserva.getHoraFim()))) {
                    return true;
                }
            }
        }
        return false;
    }

}
