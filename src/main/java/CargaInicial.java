import controller.*;

/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

public class CargaInicial {
    public static void main() {
        CampusController campusController = new CampusController();
        EquipamentoController equipamentoController = new EquipamentoController();
        SalaController salaController = new SalaController();
        PredioController predioController = new PredioController();
        FuncionarioController funcionarioController = new FuncionarioController();
        ReservaController reservaController = new ReservaController();

        campusController.create("Campus 1", "Rua 1");
        campusController.create("Campus 2", "Rua 2");
        campusController.create("Campus 3", "Rua 3");

        equipamentoController.create("Equipamento 1", "Patrimonio 1");
        equipamentoController.create("Equipamento 2", "Patrimonio 2");
        equipamentoController.create("Equipamento 3", "Patrimonio 3");


        predioController.create("Predio 1", 0);
        predioController.create("Predio 2", 1);
        predioController.create("Predio 3", 2);

        salaController.create(3, 2, 300);
        salaController.create(2, 1, 100);
        salaController.create(1, 0, 200);

        funcionarioController.create("Funcionario 1", "123456789", "", 0);
        funcionarioController.create("Funcionario 2", "987654321", "", 1);
        funcionarioController.create("Funcionario 3", "123123123", "", 2);



    }

}
