/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

import entidades.Campus;
import entidades.Funcionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioModelTest {
    private FuncionarioModel funcionarioModel;
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        funcionarioModel = new FuncionarioModel();
        funcionario = new Funcionario("Breno", "Analista de Sistemas", "1234", null);
    }

    @AfterEach
    void tearDown() {
        funcionarioModel.remove(funcionario);
        funcionarioModel = null;
        funcionario = null;
    }

    @Test
    void create() {
        funcionario.setId(funcionarioModel.create(funcionario));
        assertEquals(funcionario, funcionarioModel.get(funcionario.getId()));
    }

    @Test
    void remove() {
        funcionario.setId(funcionarioModel.create(funcionario));
        funcionarioModel.remove(funcionario);
        assertEquals(null, funcionarioModel.get(funcionario.getId()));
    }

    @Test
    void update() {
        funcionario.setId(funcionarioModel.create(funcionario));
        funcionario.setNome("Lucas Vambaster");
        funcionario.setCampus(new Campus("Campus 1", "rua 1"));
        funcionarioModel.update(funcionario);

        assertEquals(funcionario.getCampus(), funcionarioModel.get(funcionario.getId()).getCampus());
        assertEquals("Lucas Vambaster", funcionarioModel.get(funcionario.getId()).getNome());
    }

    @Test
    void get() {
        funcionario.setId(funcionarioModel.create(funcionario));
        assertEquals(funcionario, funcionarioModel.get(funcionario.getId()));
    }

    @Test
    void getAll() {

        assertEquals(0, funcionarioModel.getAll().size());
    }
}