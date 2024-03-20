/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades.reserva;
import entidades.sala.Sala;

public class ReservaSala {
    private Sala sala;
    private  Reserva reserva;
    private String tipo; // reserva para aula ou para reuniao

    public ReservaSala(Sala sala, Reserva reserva, String tipo) {
        this.sala = sala;
        this.reserva = reserva;
        this.tipo = tipo;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
