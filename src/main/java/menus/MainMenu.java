/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;
import java.util.Scanner;
import menus.CampusSubMenu;
public class MainMenu {
    String opcao;

    public void mostrarMenu() {

        while (true) {

            System.out.println("Digite a opção do menu desejada:");


            System.out.println("Digite '1' para cadastrar um Campus");
            System.out.println("Digite '2' para cadastrar um Predio");
            System.out.println("Digite '3' para cadastrar uma Sala");
            System.out.println("Digite '4' para cadastrar um Funcionario");
            System.out.println("Digite '5' para cadastrar um Equipamento");
            System.out.println("Digite '6' para cadastrar uma Reserva");
            //??? System.out.println("Digite '6' para cadastrar um Professor");
            System.out.println("Digite '8' para sair");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();

            switch(opcao) {
                case "1":
                    CampusSubMenu campusSubMenu = new CampusSubMenu();
                    campusSubMenu.campusMenu();
                    break;
                case "2":
                    // Adicione o código para a opção 2
                    break;
                case "3":
                    // Adicione o código para a opção 3
                    break;
                case "4":
                    // Adicione o código para a opção 4
                    break;
                case "5":
                    // Adicione o código para a opção 5
                    break;
                case "6":
                    // Adicione o código para a opção 6
                    break;
                case "8":
                    System.out.println("Sistema Encerrado pelo Usuario");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
