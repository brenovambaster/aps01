/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package helpers;

import entidades.reserva.Reserva;

import javax.lang.model.type.NullType;
import java.time.LocalTime;

public class HelperUtil<T> {

    public static <T> void validateObject(T object) throws IllegalArgumentException {
        if (object == null)
            throw new IllegalArgumentException("O objeto  não pode ser null");
    }

    //TODO: Criar testes unitários para esse método para todos os casos.
    public static boolean isHorarioConflitante(Reserva r, LocalTime horaInicio, LocalTime horaFim) {
        if (r.getHoraInicio().isBefore(horaInicio) && r.getHoraFim().isAfter(horaInicio)) {
            return true;
        } else if (r.getHoraInicio().isBefore(horaFim) && r.getHoraFim().isAfter(horaFim)) {
            return true;
        } else if (r.getHoraInicio().isAfter(horaInicio) && r.getHoraFim().isBefore(horaFim)) {
            return true;
        } else
            return r.getHoraInicio().equals(horaInicio) || r.getHoraFim().equals(horaFim);
    }
}