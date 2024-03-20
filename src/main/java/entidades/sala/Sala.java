/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades.sala;

import entidades.predio.Predio;

public class Sala {
    private Integer numeroSala;
    private Integer qtdLugares;
    private Predio predio;

    public Sala(Integer numeroSala, Integer qtdLugares, Predio predio) {
        this.numeroSala = numeroSala;
        this.qtdLugares = qtdLugares;
        this.predio = predio;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public Integer getQtdLugares() {
        return qtdLugares;
    }

    public void setQtdLugares(Integer qtdLugares) {
        this.qtdLugares = qtdLugares;
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }
}
