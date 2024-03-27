/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades.predio;

import entidades.campus.Campus;

public class Predio {
    private String nome;
    private Campus campus;
    private Integer id;

    public Predio() {

    }

    public Predio(String nome, Campus campus) {
        this.nome = nome;
        this.campus = campus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "Predio{" +
                " id=" + id +
                ", nome='" + nome + '\'' +
                ", campus=" + campus +
                '}';
    }
}
