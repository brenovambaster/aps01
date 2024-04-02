/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades;

import models.PredioModel;

import java.util.ArrayList;

/**
 * @summary This class is responsible for creating a Campus object
 * @attribute {@code String nome}
 * @attribute {@code String endereco}
 * @attribute {@code Integer id}
 */
public class Campus {
    private String nome, endereco;
    private Integer id;
    private ArrayList<Predio> predios = new ArrayList<Predio>();

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

    public void addPredioAoCampus(Predio predio) {
        this.predios.add(predio);
    }

    /**
     * @param nome
     * @param campus
     * @return Predio
     * @summary Cria um prédio e salva no banco de dados
     */
    public Predio criarPredio(String nome, Campus campus) {
        Predio predio = new Predio(nome, campus);
        PredioModel predioModel = new PredioModel();
        predioModel.create(predio);
        return predio;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
