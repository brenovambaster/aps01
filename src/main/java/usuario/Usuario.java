/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package usuario;

import campus.Campus;

public abstract class Usuario {
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
}
