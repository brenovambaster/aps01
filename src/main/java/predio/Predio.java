package predio;

import campus.Campus;

public class Predio {
    private String nome;
    private Campus campus;

    public Predio(String nome, Campus campus) {
        this.nome = nome;
        this.campus = campus;
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
}
