/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades;

/**
 * Classe que representa um equipamento
 *
 * @attribute {@code String nome}
 * @attribute {@code String patrimonio}
 * @attribute {@code Integer id}
 */
public class Equipamento {
    private String nome;
    private String patrimonio;
    private Integer id;

    public Equipamento() {
        this.nome = null;
        this.patrimonio = null;
    }

    public Equipamento(String nome, String patrimonio) {
        this.nome = nome;
        this.patrimonio = patrimonio;
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

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                " id=" + id +
                ", nome='" + nome + '\'' +
                ", patrimonio='" + patrimonio + '\'' +
                '}';
    }
}
