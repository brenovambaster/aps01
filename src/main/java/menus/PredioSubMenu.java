/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import entidades.campus.Campus;
import entidades.predio.Predio;
import models.CampusModel;
import models.PredioModel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class PredioSubMenu {
    String opcao;
    String nome;
    Campus campus;

    PredioModel predioModel = new PredioModel();
    CampusModel campusModel = new CampusModel();

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
                switch (opcao) {
                    case "1":
                        if (campusModel.getAll() == null || campusModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não é possível cadastrar um predio sem um campus cadastrado");
                        }
                        cadastrarPredio();
                        break;
                    case "2":
                        if (predioModel.getAll() == null || predioModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não Há predios cadastrados");
                        }
                        listarPredios();
                        break;
                    case "3":
                        if (predioModel.getAll() == null || predioModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não Há predios cadastrados");
                        }
                        atualizarPredio();
                        break;
                    case "4":
                        if (predioModel.getAll() == null || predioModel.getAll().isEmpty()) {
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
        System.out.println("Predios Cadastrados: ");
        for (Predio p : this.predioModel.getAll()) {
            System.out.println(p.toString());
        }
    }

    public void listarCampus() {
        System.out.println("Campi Cadastrados: ");
        for (Campus c : campusModel.getAll()) {
            System.out.println(c.toString());
        }
    }

    public void cadastrarPredio() {
        try {
            Scanner scanner = new Scanner(System.in);
            Campus campus = new Campus();
            Predio predio = new Predio();
            String input;
            Integer idCampus;

            listarCampus();
            System.out.println("Digite o id do campus que sera vinculado ao predio: ");
            input = scanner.nextLine();
            idCampus = Integer.parseInt(input);
            campus = campusModel.get(idCampus);
            if(campus == null){
                throw new RuntimeException("Campus não encontrado");
            }
            predio.setCampus(campus);

            System.out.println("Digite o nome do predio: ");
            predio.setNome(scanner.nextLine());

            this.predioModel.create(predio);
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

    public void atualizarPredio() {
        try {
            Predio predio = new Predio();
            String nome;
            String input;
            Integer idPredio;
            Scanner scanner = new Scanner(System.in);

            listarPredios();

            System.out.println("Digite o id do predio a ser atualizado: ");
            input = scanner.nextLine();
            idPredio = Integer.parseInt(input);
            predio = this.predioModel.get(idPredio);
            if(predio == null){
                throw new RuntimeException("Predio não encontrado");
            }

            System.out.println("Digite o novo nome do predio: ");
            nome = scanner.nextLine();
            predio.setNome(nome);

            this.predioModel.update(predio);
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

    public void deletarPredio() {
        try {
            Predio predio = new Predio();
            String input;
            Integer idPredio;
            Scanner scanner = new Scanner(System.in);

            listarPredios();

            System.out.println("Digite o id do predio a ser deletado: ");
            input = scanner.nextLine();
            idPredio = Integer.parseInt(input);
            predio = this.predioModel.get(idPredio);
            if(predio == null){
                throw new RuntimeException("Predio não encontrado");
            }

            this.predioModel.remove(predio);
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
