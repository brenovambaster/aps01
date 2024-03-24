/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import helpers.HelperUtil;
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
        HelperUtil.validateObject(professor);

        professor.setId(id);
        professorList.add(professor);
        return id++;
    }

    /**
     * @param professor
     */
    @Override
    public void remove(Professor professor) {
        HelperUtil.validateObject(professor);

        for (Professor p : professorList) {
            if (p.getId().equals(professor.getId())) {
                professorList.remove(p);
                break;
            }
        }
    }

    /**
     * @param professor
     */
    @Override
    public Boolean update(Professor professor) {
        HelperUtil.validateObject(professor);

        for (Professor p : professorList) {
            if (p.getId().equals(professor.getId())) {
                p.setNome(professor.getNome());
                p.setCargo(professor.getCargo());
                p.setRamal(professor.getRamal());
                p.setCampus(professor.getCampus());
                return true;
            }
        }
        return false;
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
