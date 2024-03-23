/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import entidades.campus.Campus;
import entidades.funcionario.Funcionario;
import models.CampusModel;
import models.FuncionarioModel;

import java.util.Scanner;

public class FuncionarioSubMenu {
    String nome;
    String cargo;
    String ramal;
    String opcao;
    Campus campus;

    FuncionarioModel funcionarioModel = new FuncionarioModel();
    public FuncionarioSubMenu() {
        this.nome = "";
        this.cargo = "";
        this.ramal = "";
        this.campus = null;
    }

    public void funcionarioMenu(){
        while(true){
            System.out.println("Menu Funcionario");
            System.out.println("1 - Cadastrar Funcionario");
            System.out.println("2 - Listar Funcionarios");
            System.out.println("3 - Atualizar Funcionario");
            System.out.println("4 - Deletar Funcionario");
            System.out.println("5 - Voltar");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();

            switch(opcao){
                case "1":
                    cadastrarFuncionario();
                    break;
                case "2":
                    listarFuncionarios();
                    break;
                case "3":
                    atualizarFuncionario();
                    break;
                case "4":
                    deletarFuncionario();
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
        this.nome = null;
        this.cargo = null;
        this.ramal = null;
        this.campus = null;
        this.opcao =null;
    }
    public void cadastrarFuncionario(){
        Funcionario funcionario = new Funcionario();
        String nome;
        String cargo;
        String ramal;
        String input;
        Integer idCampus;
        CampusModel campusModel = new CampusModel();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Campi Cadastrados: ");
        for (Campus c : campusModel.getAll()) {
            System.out.println(c.toString());
        }
        System.out.println("Digite o id do Campus ao qual o funcionario será vinculado: ");
        input = scanner.nextLine();
        idCampus = Integer.parseInt(input);
        campus = campusModel.get(idCampus);

        funcionario.setCampus(campus);

        System.out.println("Digite o nome do Funcionario: ");
        nome = scanner.nextLine();
        funcionario.setNome(nome);

        System.out.println("Digite o cargo do Funcionario: ");
        cargo = scanner.nextLine();
        funcionario.setCargo(cargo);

        System.out.println("Digite o ramal do Funcionario: ");
        ramal = scanner.nextLine();
        funcionario.setRamal(ramal);

        this.funcionarioModel.create(funcionario);
        clearAtributos();
    }

    public void listarFuncionarios(){
        System.out.println("Listando todos os Funcionarios:");
        for (Funcionario c : this.funcionarioModel.getAll()) {
            System.out.println(c.toString());
        }
        clearAtributos();;
    }

    public void atualizarFuncionario(){
        Funcionario funcionario = new Funcionario();
        String nome;
        String cargo;
        String ramal;
        String input;
        Integer idFuncionario;
        CampusModel campusModel = new CampusModel();
        Integer idCampus;

        Scanner scanner = new Scanner(System.in);

        listarFuncionarios();

        System.out.println("Digite o id do Funcionario a ser atualizado: ");
        input = scanner.nextLine();
        idFuncionario = Integer.parseInt(input);
        funcionario = this.funcionarioModel.get(idFuncionario);

        System.out.println("Campi Cadastrados: ");
        for (Campus c : campusModel.getAll()) {
            System.out.println(c.toString());
        }
        System.out.println("Digite o id do Campus ao qual o funcionario será vinculado: ");
        input = scanner.nextLine();
        idCampus = Integer.parseInt(input);
        campus = campusModel.get(idCampus);
        funcionario.setCampus(campus);

        System.out.println("Digite o nome do Funcionario: ");
        nome = scanner.nextLine();
        funcionario.setNome(nome);

        System.out.println("Digite o cargo do Funcionario: ");
        cargo = scanner.nextLine();
        funcionario.setCargo(cargo);

        System.out.println("Digite o ramal do Funcionario: ");
        ramal = scanner.nextLine();
        funcionario.setRamal(ramal);

        this.funcionarioModel.update(funcionario);
        clearAtributos();
    }

    public void deletarFuncionario(){
        Funcionario funcionario = new Funcionario();
        String input;
        Integer idFuncionario;

        Scanner scanner = new Scanner(System.in);

        listarFuncionarios();

        System.out.println("Digite o id do Funcionario a ser deletado: ");
        input = scanner.nextLine();
        idFuncionario = Integer.parseInt(input);
        funcionario = this.funcionarioModel.get(idFuncionario);

        this.funcionarioModel.remove(funcionario);
        clearAtributos();
    }

}
