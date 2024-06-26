/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades;

import entidades.Campus;

/**
 * @atribute id: Integer
 * @atribute nome: String
 * @atribute cargo: String
 * @atribute ramal: String
 * @atribute campus: Campus
 * @see Campus
 */
public abstract class Usuario {
    protected Integer id;
    protected String nome;
    protected String cargo;
    protected String ramal;
    protected Campus campus;

    public Usuario() {
        this(null, null, null, null);
    }

    public Usuario(String nome, String cargo, String ramal, Campus campus) {
        this.setNome(nome);
        this.setCargo(cargo);
        this.setRamal(ramal);
        this.setCampus(campus);
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", ramal='" + ramal + '\'' +
                ", campus=" + campus +
                '}';
    }
}
