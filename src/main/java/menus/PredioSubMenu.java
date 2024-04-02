/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import controller.CampusController;
import controller.PredioController;
import entidades.Campus;
import entidades.Predio;

import java.util.Scanner;

public class PredioSubMenu {
    String opcao;
    String nome;
    Campus campus;


    CampusController campusController = new CampusController();

    public PredioSubMenu() {
        this.nome = "";
        this.campus = null;
    }

    public void predioMenu() {
        while (true) {
            System.out.println("Menu Predio");
            System.out.println("1 - Cadastrar Predio");
            System.out.println("2 - Listar Predios");
            System.out.println("3 - Atualizar Predio");
            System.out.println("4 - Deletar Predio");
            System.out.println("5 - Voltar");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();
            try {
                PredioController predioController = new PredioController();
                switch (opcao) {
                    case "1":
                        if (campusController.getAll() == null || campusController.getAll().isEmpty()) {
                            throw new RuntimeException("Não é possível cadastrar um predio sem um campus cadastrado");
                        }
                        cadastrarPredio();
                        break;
                    case "2":
                        if (predioController.getAll() == null || predioController.getAll().isEmpty()) {
                            throw new RuntimeException("Não Há predios cadastrados");
                        }
                        listarPredios();
                        break;
                    case "3":
                        if (predioController.getAll() == null || predioController.getAll().isEmpty()) {
                            throw new RuntimeException("Não Há predios cadastrados");
                        }
                        atualizarPredio();
                        break;
                    case "4":
                        if (predioController.getAll() == null || predioController.getAll().isEmpty()) {
                            throw new RuntimeException("Não Há predios cadastrados");
                        }
                        deletarPredio();
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
        this.nome = null;
        this.campus = null;
    }

    public void listarPredios() {
        PredioController predioController = new PredioController();
        System.out.println("Predios Cadastrados: ");
        for (Predio p : predioController.getAll()) {
            System.out.println(p.toString());
        }
    }

    public void listarCampus() {
        System.out.println("Campi Cadastrados: ");
        for (Campus c : campusController.getAll()) {
            System.out.println(c.toString());
        }
    }

    public void cadastrarPredio() {
        try {
            PredioController predioController = new PredioController();
            Scanner scanner = new Scanner(System.in);

            String input, nomePredio;
            Integer idCampus;

            listarCampus();
            System.out.println("Digite o id do campus que sera vinculado ao predio: ");
            input = scanner.nextLine();
            idCampus = Integer.parseInt(input);


            System.out.println("Digite o nome do predio: ");
            nomePredio = scanner.nextLine();

            predioController.create(nomePredio, idCampus);
            clearAtributos();

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

    public void atualizarPredio() {
        try {

            String nome;
            String input;
            Integer idPredio;
            Scanner scanner = new Scanner(System.in);

            listarPredios();

            System.out.println("Digite o id do predio a ser atualizado: ");
            input = scanner.nextLine();
            idPredio = Integer.parseInt(input);


            System.out.println("Digite o novo nome do predio: ");
            nome = scanner.nextLine();

            PredioController predioController = new PredioController();
            predioController.update(idPredio, nome);
            clearAtributos();

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

    public void deletarPredio() {
        try {

            String input;
            Integer idPredio;
            Scanner scanner = new Scanner(System.in);

            listarPredios();

            System.out.println("Digite o id do predio a ser deletado: ");
            input = scanner.nextLine();
            idPredio = Integer.parseInt(input);
            PredioController predioController = new PredioController();
            predioController.remove(idPredio);
            clearAtributos();

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
