package models;

import entidades.equipamento.Equipamento;
import interfaces.IMetodos;

import java.util.ArrayList;

/**
 * Classe que representa o modelo de Equipamento
 */
public class EquipamentoModel implements IMetodos<Equipamento> {
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
    private Integer id = 0;

    /**
     * Cria um novo equipamento e adiciona à lista
     *
     * @param equipamento O equipamento a ser criado
     * @return O id do equipamento criado
     */
    @Override
    public Integer create(Equipamento equipamento) {
        equipamento.setId(id);
        equipamentos.add(equipamento);
        return id++;
    }


    /**
     * Remove um equipamento da lista
     *
     * @param equipamento O equipamento a ser removido
     */
    @Override
    public void remove(Equipamento equipamento) {
        equipamentos.removeIf(e -> e.getId().equals(equipamento.getId()));
    }


    /**
     * Atualiza um equipamento na lista
     *
     * @param equipamento O equipamento com os dados atualizados
     */
    @Override
    public void update(Equipamento equipamento) {
        for (Equipamento e : equipamentos) {
            if (e.getId().equals(equipamento.getId())) {
                e.setNome(equipamento.getNome());
                e.setPatrimonio(equipamento.getPatrimonio());
                break;
            }
        }
    }


    /**
     * Obtém um equipamento pelo id
     *
     * @param id O id do equipamento
     * @return O equipamento, ou null se não encontrado
     */
    @Override
    public Equipamento get(int id) {
        return equipamentos.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }


    /**
     * Obtém todos os equipamentos
     *
     * @return Uma lista de equipamentos
     */
    @Override
    public ArrayList<Equipamento> getAll() {
        return equipamentos;
    }
}