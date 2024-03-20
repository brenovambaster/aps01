package funcionario;

import entidades.funcionario.Funcionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entidades.usuario.Usuario;
import entidades.campus.Campus;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest extends Usuario {
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        Campus campus = new Campus("Campus 1", "Rua 32, Vilage 2");
        funcionario = new Funcionario("Breno", "Técnico", "1234", campus);
    }

    @AfterEach
    void tearDown() {
        funcionario.setCampus(null);
        funcionario = null;
    }

    @Test
    void testGetNome() {
        assertEquals("Breno", funcionario.getNome());
    }

    @Test
    void testSetNome() {
        funcionario.setNome("Breno Vambáster");
        assertEquals("Breno Vambáster", funcionario.getNome());
    }

    @Test
    void testGetCargo() {
        assertEquals("Técnico", funcionario.getCargo());
    }

    @Test
    void testSetCargo() {
        funcionario.setCargo("Professor");
        assertEquals("Professor", funcionario.getCargo());
    }

    @Test
    void testGetRamal() {
        assertEquals("1234", funcionario.getRamal());
    }

    @Test
    void testSetRamal() {
        funcionario.setRamal("4321");
        assertEquals("4321", funcionario.getRamal());
    }

    @Test
    void testGetCampus() {
        assertEquals("Campus 1", funcionario.getCampus().getNome());
    }

    @Test
    void testSetCampus() {
        Campus campus = new Campus("Campus 2", "Rua 32, Vilage 2");
        funcionario.setCampus(campus);
        assertEquals("Campus 2", funcionario.getCampus().getNome());
    }
}