/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades.campus;

/**
 * @summary This class is responsible for creating a Campus object
 * @attribute {@code String nome}
 * @attribute {@code String endereco}
 * @attribute {@code Integer id}
 */
public class Campus {
    protected String nome, endereco;
    protected Integer id;

    public Campus() {

    }

    public Campus(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", id=" + id +
                '}';
    }
}
