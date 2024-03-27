/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;
import java.util.Scanner;
import menus.CampusSubMenu;
public class MainMenu {
    String opcao;

    public void mostrarMenu() {

        CampusSubMenu campusSubMenu = new CampusSubMenu();
        PredioSubMenu predioSubMenu = new PredioSubMenu();
        FuncionarioSubMenu funcionarioSubMenu = new FuncionarioSubMenu();
        EquipamentoSubMenu equipamentoSubMenu = new EquipamentoSubMenu();
        SalaSubMenu salaSubMenu = new SalaSubMenu();
        ReservaSubMenu reservaSubMenu = new ReservaSubMenu();
        try{
            while (true) {

                System.out.println("Digite a opção do menu desejada:");
                System.out.println("Digite '1' para menu do Campus");
                System.out.println("Digite '2' para menu do Predio");
                System.out.println("Digite '3' para menu da Sala");
                System.out.println("Digite '4' para menu do Funcionario");
                System.out.println("Digite '5' para menu do Equipamento");
                System.out.println("Digite '6' para menu da Reserva");
                //??? System.out.println("Digite '6' para cadastrar um Professor");
                System.out.println("Digite '8' para sair");

                Scanner scanner = new Scanner(System.in);
                opcao = scanner.nextLine();

                switch(opcao) {
                    case "1":
                        campusSubMenu.campusMenu();
                        break;
                    case "2":
                        predioSubMenu.predioMenu();
                        break;
                    case "3":
                        salaSubMenu.salaMenu();
                        break;
                    case "4":
                        funcionarioSubMenu.funcionarioMenu();
                        break;
                    case "5":
                        equipamentoSubMenu.equipamentoMenu();
                        break;
                    case "6":
                        reservaSubMenu.reservaMenu();
                        break;
                    case "8":
                        System.out.println("Sistema Encerrado pelo Usuario");
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
