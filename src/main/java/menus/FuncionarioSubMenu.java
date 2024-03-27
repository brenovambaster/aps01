/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import entidades.campus.Campus;
import entidades.funcionario.Funcionario;
import models.CampusModel;
import models.FuncionarioModel;

import java.text.ParseException;
import java.util.Scanner;

public class FuncionarioSubMenu {
    String nome;
    String cargo;
    String ramal;
    String opcao;
    Campus campus;


    FuncionarioModel funcionarioModel = new FuncionarioModel();
    CampusModel campusModel = new CampusModel();

    public FuncionarioSubMenu() {
        this.nome = "";
        this.cargo = "";
        this.ramal = "";
        this.campus = null;
    }

    public void funcionarioMenu() {

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
                        if (campusModel.getAll() == null || campusModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não é possível cadastrar um funcionário sem um campus cadastrado");
                        }
                        cadastrarFuncionario();
                        break;
                    case "2":
                        if (this.funcionarioModel.getAll() == null) {
                            throw new RuntimeException("Não Há funcionarios cadastrados");
                        }
                        listarFuncionarios();
                        break;
                    case "3":
                        if (this.funcionarioModel.getAll() == null) {
                            throw new RuntimeException("Não Há funcionarios cadastrados");
                        }
                        atualizarFuncionario();
                        break;
                    case "4":
                        if (this.funcionarioModel.getAll() == null) {
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

            }catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }catch(Exception e) {
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
        try{
            Funcionario funcionario = new Funcionario();
            String nome;
            String cargo;
            String ramal;
            String input;
            Integer idCampus;

            Scanner scanner = new Scanner(System.in);

            System.out.println("Campi Cadastrados: ");
            for (Campus c : campusModel.getAll()) {
                System.out.println(c.toString());
            }
            System.out.println("Digite o id do Campus ao qual o funcionario será vinculado: ");
            input = scanner.nextLine();
            idCampus = Integer.parseInt(input);
            campus = campusModel.get(idCampus);
            if(campus == null){
                throw new RuntimeException("Campus não encontrado");
            }
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

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array fora do limite");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("String fora do limite");
        }catch (NullPointerException e){
            System.out.println("Valores nulos nao sao validos");
        }catch (NumberFormatException e){
            System.out.println("Número inválido");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarFuncionarios() {
        System.out.println("Listando todos os Funcionarios:");
        for (Funcionario c : this.funcionarioModel.getAll()) {
            System.out.println(c.toString());
        }
        clearAtributos();
    }

    public void atualizarFuncionario() {
        try{
            Funcionario funcionario = new Funcionario();
            String nome;
            String cargo;
            String ramal;
            String input;
            Integer idFuncionario;
            Integer idCampus;

            Scanner scanner = new Scanner(System.in);

            listarFuncionarios();

            System.out.println("Digite o id do Funcionario a ser atualizado: ");
            input = scanner.nextLine();
            idFuncionario = Integer.parseInt(input);
            funcionario = this.funcionarioModel.get(idFuncionario);

            if(funcionario == null){
                throw new RuntimeException("Campus não encontrado");
            }

            System.out.println("Campi Cadastrados: ");
            for (Campus c : campusModel.getAll()) {
                System.out.println(c.toString());
            }
            System.out.println("Digite o id do Campus ao qual o funcionario será vinculado: ");
            input = scanner.nextLine();
            idCampus = Integer.parseInt(input);
            campus = campusModel.get(idCampus);

            if(campus == null){
                throw new RuntimeException("Campus não encontrado");
            }
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

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array fora do limite");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("String fora do limite");
        }catch (NullPointerException e){
            System.out.println("Valores nulos nao sao validos");
        }catch (NumberFormatException e){
            System.out.println("Número inválido");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deletarFuncionario() {
        try{
            Funcionario funcionario = new Funcionario();
            String input;
            Integer idFuncionario;

            Scanner scanner = new Scanner(System.in);

            listarFuncionarios();

            System.out.println("Digite o id do Funcionario a ser deletado: ");
            input = scanner.nextLine();
            idFuncionario = Integer.parseInt(input);
            funcionario = this.funcionarioModel.get(idFuncionario);

            if(funcionario == null){
                throw new RuntimeException("Campus não encontrado");
            }
            this.funcionarioModel.remove(funcionario);
            clearAtributos();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array fora do limite");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("String fora do limite");
        }catch (NullPointerException e){
            System.out.println("Valores nulos nao sao validos");
        }catch (NumberFormatException e){
            System.out.println("Número inválido");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
