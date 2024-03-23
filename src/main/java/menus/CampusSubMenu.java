/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;
import entidades.campus.Campus;
import models.CampusModel;
import java.util.Scanner;
public class CampusSubMenu {
    String nomeCampus;
    String enderecoCampus;
    String opcao;
    public void CampusSubMenu(){
        this.nomeCampus = "";
        this.enderecoCampus = "";
        this.opcao = "";
    }
    public void campusMenu(){

        while(true)
        {
            System.out.println("Campus Submenu");
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Cadastrar Campus");
            System.out.println("2 - Listar Campus");
            System.out.println("3 - Atualizar Campus");
            System.out.println("4 - Deletar Campus");
            System.out.println("5 - Voltar");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();

            switch(opcao)
            {
                case "1":
                    cadastrarCampus();
                    break;
                case "2":
                    listarCampus();
                    break;
                case "3":
                    atualizarCampus();
                    break;
                case "4":
                    deletaCampus();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

    }

    public void clearAtributos(){
        this.nomeCampus = null;
        this.enderecoCampus = null;
        this.opcao =null;
    }

    public void cadastrarCampus(){
        Campus campus = new Campus();
        String nomeCampus;
        String enderecoCampus;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do Campus: ");
        nomeCampus = scanner.nextLine();
        campus.setNome(nomeCampus);
        System.out.println("Digite o endereço do Campus: ");
        enderecoCampus = scanner.nextLine();
        campus.setEndereco(enderecoCampus);
        CampusModel.create(campus);
        clearAtributos();
    }

    public void listarCampus() {
        System.out.println("Listando todos os Campi:");
        for (Campus c : CampusModel.getAll()) {
            System.out.println(c.toString());
        }
        clearAtributos();
    }

    public void atualizarCampus() {
        Campus campus = new Campus();
        String nomeCampus;
        String input;
        Integer idCampus;
        String enderecoCampus;
        Scanner scanner = new Scanner(System.in);

        listarCampus();

        System.out.println("Digite o id do Campus a ser atualizado: ");
        input = scanner.nextLine();
        idCampus = Integer.parseInt(input);

        campus = CampusModel.get(idCampus);

        System.out.println("Digite o novo nome do Campus: ");
        nomeCampus = scanner.nextLine();
        campus.setNome(nomeCampus);
        System.out.println("Digite o novo endereço do Campus: ");
        enderecoCampus = scanner.nextLine();
        campus.setEndereco(enderecoCampus);

        CampusModel.update(campus);
        clearAtributos();
        System.out.println("Campus atualizado com sucesso!");
    }

    public void deletaCampus(){

        Campus campus = new Campus();
        String input;
        Integer idCampus;
        Scanner scanner = new Scanner(System.in);

        listarCampus();

        System.out.println("Digite o id do Campus a ser deletado: ");
        input = scanner.nextLine();
        idCampus = Integer.parseInt(input);

        campus = CampusModel.get(idCampus);

        CampusModel.remove(campus);
        clearAtributos();
        System.out.println("Campus deletado com sucesso!");
    }
}
