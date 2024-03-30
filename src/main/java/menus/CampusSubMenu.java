/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import controller.CampusController;
import entidades.Campus;

import java.util.Scanner;

public class CampusSubMenu {
    String nomeCampus;
    String enderecoCampus;
    String opcao;
    CampusController campusController = new CampusController();

    public void campusMenu() {

        while (true) {
            System.out.println("Campus Submenu");
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Cadastrar Campus");
            System.out.println("2 - Listar Campus");
            System.out.println("3 - Atualizar Campus");
            System.out.println("4 - Deletar Campus");
            System.out.println("5 - Voltar");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();
            try {
                switch (opcao) {
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
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void clearAtributos() {
        this.nomeCampus = null;
        this.enderecoCampus = null;
        this.opcao = null;
    }

    public void cadastrarCampus() {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o nome do Campus: ");
            nomeCampus = scanner.nextLine();

            System.out.println("Digite o endereço do Campus: ");
            enderecoCampus = scanner.nextLine();

            campusController.create(nomeCampus, enderecoCampus);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array fora do limite");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String fora do limite");
        } catch (NullPointerException e) {
            System.out.println("Valores nulos nao sao validos");
        } catch (NumberFormatException e) {
            System.out.println("Número inválido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarCampus() {

        System.out.println("Listando todos os Campi:");
        for (Campus c : campusController.getAll()) {
            System.out.println(c.toString());
        }
    }

    public void atualizarCampus() {

        try {
            Campus campus = new Campus();
            Scanner scanner = new Scanner(System.in);
            String nomeCampus;
            String input;
            Integer idCampus;
            String enderecoCampus;

            listarCampus();

            System.out.println("Digite o id do Campus a ser atualizado: ");
            input = scanner.nextLine();
            idCampus = Integer.parseInt(input);
            if (campus == null) {
                throw new RuntimeException("Campus não encontrado");
            }

            System.out.println("Digite o novo nome do Campus: ");
            nomeCampus = scanner.nextLine();

            System.out.println("Digite o novo endereço do Campus: ");
            enderecoCampus = scanner.nextLine();

            campusController.update(idCampus, nomeCampus, enderecoCampus);
            clearAtributos();
            System.out.println("Campus atualizado com sucesso!");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array fora do limite");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String fora do limite");
        } catch (NullPointerException e) {
            System.out.println("Valores nulos nao sao validos");
        } catch (NumberFormatException e) {
            System.out.println("Número inválido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletaCampus() {
        try {

            Campus campus = new Campus();
            String input;
            Integer idCampus;
            Scanner scanner = new Scanner(System.in);

            listarCampus();

            System.out.println("Digite o id do Campus a ser deletado: ");
            input = scanner.nextLine();
            idCampus = Integer.parseInt(input);
            campus = campusController.get(idCampus);
            if (campus == null) {
                throw new RuntimeException("Campus não encontrado");
            }
            campusController.remove(idCampus);
            clearAtributos();
            System.out.println("Campus deletado com sucesso!");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array fora do limite");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String fora do limite");
        } catch (NullPointerException e) {
            System.out.println("Valores nulos nao sao validos");
        } catch (NumberFormatException e) {
            System.out.println("Número inválido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
