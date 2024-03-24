/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades.sala;

import entidades.predio.Predio;

/**
 * Classe Sala
 *
 * @atribute {@code Integer id}
 * @atribute {@code Integer numeroSala}
 * @atribute {@code Integer qtdLugares}
 * @atribute {@code Predio predio}
 * @see Predio
 */
public class Sala {
    private Integer id;
    private Integer numeroSala;
    private Integer qtdLugares;
    private Predio predio;

    public Sala() {
    }

    public Sala(Integer numeroSala, Integer qtdLugares, Predio predio) {
        this.numeroSala = numeroSala;
        this.qtdLugares = qtdLugares;
        this.predio = predio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", numeroSala=" + numeroSala +
                ", qtdLugares=" + qtdLugares +
                ", predio=" + predio +
                '}';
    }
}
