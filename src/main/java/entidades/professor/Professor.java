/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades.professor;

import entidades.campus.Campus;
import entidades.usuario.Usuario;

/**
 * Classe professor
 *
 * @atribute id: Integer
 * @atribute nome: String
 * @atribute cargo: String
 * @atribute ramal: String
 * @atribute campus: Campus
 * @see Campus
 */
public class Professor extends Usuario {
    public Professor(String nome, String cargo, String ramal, Campus campus) {
        super(nome, cargo, ramal, campus);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", ramal='" + ramal + '\'' +
                ", campus=" + campus +
                '}';
    }
}
