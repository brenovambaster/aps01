/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import interfaces.IMetodos;
import entidades.professor.Professor;

import java.util.ArrayList;

public class ProfessorModel implements IMetodos<Professor> {
    private ArrayList<Professor> professorList = new ArrayList<>();
    private Integer id = 0;

    /**
     * @param professor
     * @return ID criado para o professor no banco de dados
     */
    @Override
    public Integer create(Professor professor) {
        professor.setId(id);
        professorList.add(professor);
        return id++;
    }

    /**
     * @param object
     */
    @Override
    public void remove(Professor object) {
        for (Professor p : professorList) {
            if (p.getId().equals(object.getId())) {
                professorList.remove(p);
                break;
            }
        }
    }

    /**
     * @param object
     */
    @Override
    public void update(Professor object) {
        for (Professor p : professorList) {
            if (p.getId().equals(object.getId())) {
                p.setNome(object.getNome());
                p.setCargo(object.getCargo());
                p.setRamal(object.getRamal());
                p.setCampus(object.getCampus());
                break;
            }
        }
    }

    /**
     * @param id
     * @return {@code Professor | NULL}
     */
    @Override
    public Professor get(int id) {
        for (Professor p : professorList) {
            if (p.getId().equals(id)) {
                return p;
            }

        }
        return null;
    }

    /**
     * @return {@code ArrayList<Professor>}
     */
    @Override
    public ArrayList<Professor> getAll() {
        return professorList;
    }
}
