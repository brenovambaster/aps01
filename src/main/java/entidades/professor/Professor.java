/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package entidades.professor;
import entidades.campus.Campus;
import entidades.usuario.Usuario;
public class Professor extends  Usuario{
    public Professor(String nome, String cargo, String ramal, Campus campus) {
        super(nome, cargo, ramal, campus);
    }

    @Override
    public String toString() {
        return "Professor {" +
                "nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", ramal='" + ramal + '\'' +
                ", campus=" + campus +
                '}';
    }

}
