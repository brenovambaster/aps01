/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades;

import entidades.Campus;
import entidades.Usuario;

/**
 * @author Breno Vambáster
 * @brief Teste de documentaçãoo
 */
public class Funcionario extends Usuario {

    public Funcionario() {
    }

    public Funcionario(String nome, String cargo, String ramal, Campus campus) {
        super(nome, cargo, ramal, campus);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", ramal='" + ramal + '\'' +
                ", campus=" + campus +
                '}';
    }
}
