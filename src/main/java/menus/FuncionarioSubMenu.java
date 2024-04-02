/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import controller.CampusController;
import controller.FuncionarioController;
import entidades.Campus;
import entidades.Funcionario;

import java.util.Scanner;

public class FuncionarioSubMenu {
    String nome;
    String cargo;
    String ramal;
    String opcao;
    Campus campus;


    public FuncionarioSubMenu() {
        this.nome = "";
        this.cargo = "";
        this.ramal = "";
        this.campus = null;
    }

    public void funcionarioMenu() {
        FuncionarioController funcionarioController = new FuncionarioController();
        CampusController campusController = new CampusController();
        while (true) {
            System.out.println("Menu Funcionario");
            System.out.println("1 - Cadastrar Funcionario");
            System.out.println("2 - Listar Funcionarios");
            System.out.println("3 - Atualizar Funcionario");
            System.out.println("4 - Deletar Funcionario");
            System.out.println("5 - Voltar");

            Scanner scanner = new Scanner(System.in);

            opcao = scanner.nextLine();
            try {
                switch (opcao) {
                    case "1":
                        if (campusController.getAll() == null || campusController.getAll().isEmpty()) {
                            throw new RuntimeException("Não é possível cadastrar um funcionário sem um campus cadastrado");
                        }
                        cadastrarFuncionario();
                        break;
                    case "2":
                        if (funcionarioController.getAll() == null) {
                            throw new RuntimeException("Não Há funcionarios cadastrados");
                        }
                        listarFuncionarios();
                        break;
                    case "3":
                        if (funcionarioController.getAll() == null) {
                            throw new RuntimeException("Não Há funcionarios cadastrados");
                        }
                        atualizarFuncionario();
                        break;
                    case "4":
                        if (funcionarioController.getAll() == null) {
                            throw new RuntimeException("Não Há funcionarios cadastrados");
                        }
                        deletarFuncionario();
                        break;
                    case "5":
                        return;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado");
            }
        }
    }

    public void clearAtributos() {
        this.nome = null;
        this.cargo = null;
        this.ramal = null;
        this.campus = null;
        this.opcao = null;
    }

    public void cadastrarFuncionario() {
        try {

            String nome;
            String cargo;
            String ramal;
            String input;
            Integer idCampus;

            Scanner scanner = new Scanner(System.in);
            CampusController campusController = new CampusController();

            System.out.println("Campi Cadastrados: ");
            for (Campus c : campusController.getAll()) {
                System.out.println(c.toString());
            }
            System.out.println("Digite o id do Campus ao qual o funcionario será vinculado: ");
            input = scanner.nextLine();
            idCampus = Integer.parseInt(input);

            System.out.println("Digite o nome do Funcionario: ");
            nome = scanner.nextLine();

            System.out.println("Digite o cargo do Funcionario: ");
            cargo = scanner.nextLine();

            System.out.println("Digite o ramal do Funcionario: ");
            ramal = scanner.nextLine();

            FuncionarioController funcionarioController = new FuncionarioController();
            funcionarioController.create(nome, cargo, ramal, idCampus);
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

    public void listarFuncionarios() {
        FuncionarioController funcionarioController = new FuncionarioController();
        System.out.println("Listando todos os Funcionarios:");
        for (Funcionario c : funcionarioController.getAll()) {
            System.out.println(c.toString());
        }
        clearAtributos();
    }

    public void atualizarFuncionario() {
        try {

            String nome;
            String cargo;
            String ramal;
            String input;
            Integer idFuncionario;
            Integer idCampus;

            Scanner scanner = new Scanner(System.in);
            CampusController campusController = new CampusController();
            listarFuncionarios();

            System.out.println("Digite o id do Funcionario a ser atualizado: ");
            input = scanner.nextLine();
            idFuncionario = Integer.parseInt(input);

            System.out.println("Campi Cadastrados: ");
            for (Campus c : campusController.getAll()) {
                System.out.println(c.toString());
            }

            System.out.println("Digite o id do Campus ao qual o funcionario será vinculado: ");
            input = scanner.nextLine();
            idCampus = Integer.parseInt(input);

            System.out.println("Digite o nome do Funcionario: ");
            nome = scanner.nextLine();

            System.out.println("Digite o cargo do Funcionario: ");
            cargo = scanner.nextLine();

            System.out.println("Digite o ramal do Funcionario: ");
            ramal = scanner.nextLine();

            FuncionarioController funcionarioController = new FuncionarioController();
            funcionarioController.update(idFuncionario, nome, cargo, ramal, idCampus);
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

    public void deletarFuncionario() {
        try {

            String input;
            Integer idFuncionario;

            Scanner scanner = new Scanner(System.in);

            listarFuncionarios();

            System.out.println("Digite o id do Funcionario a ser deletado: ");
            input = scanner.nextLine();
            idFuncionario = Integer.parseInt(input);


            FuncionarioController funcionarioController = new FuncionarioController();
            funcionarioController.remove(idFuncionario);
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
