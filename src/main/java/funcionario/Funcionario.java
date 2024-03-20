package funcionario;

import campus.Campus;
import usuario.Usuario;

/**
 * @author Breno Vambáster
 * @brief Teste de documentaçãoo
 */
public class Funcionario extends Usuario {


    public Funcionario(String nome, String cargo, String ramal, Campus campus) {
        super(nome, cargo, ramal, campus);
    }

    @Override
    public String toString() {
        return "Funcionario: {" +
                "nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", ramal='" + ramal + '\'' +
                ", campus=" + campus +
                '}';
    }
}
