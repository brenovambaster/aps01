/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import entidades.campus.Campus;
import entidades.predio.Predio;
import models.CampusModel;
import models.PredioModel;

import java.util.ArrayList;
import java.util.Scanner;

public class PredioSubMenu {
    String opcao;
    String nome;
    Campus campus;

    PredioModel predioModel = new PredioModel();
    public PredioSubMenu() {
        this.nome = "";
        this.campus = null;
    }

    public void predioMenu(){
        while(true){
            System.out.println("Menu Predio");
            System.out.println("1 - Cadastrar Predio");
            System.out.println("2 - Listar Predios");
            System.out.println("3 - Atualizar Predio");
            System.out.println("4 - Deletar Predio");
            System.out.println("5 - Voltar");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();

            switch(opcao){
                case "1":
                    cadastrarPredio();
                    break;
                case "2":
                    listarPredios();
                    break;
                case "3":
                    atualizarPredio();
                    break;
                case "4":
                    deletarPredio();
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
        this.campus = null;
    }
    public void listarPredios(){
        System.out.println("Predios Cadastrados: ");
        for (Predio p : this.predioModel.getAll()) {
            System.out.println(p.toString());
        }
    }
    public void listarCampus(){
        CampusModel campusModel = new CampusModel();
        System.out.println("Campi Cadastrados: ");
        for (Campus c : campusModel.getAll()) {
            System.out.println(c.toString());
        }
    }
    public void cadastrarPredio(){

        Scanner scanner = new Scanner(System.in);
        Campus campus = new Campus();
        CampusModel campusModel = new CampusModel();
        Predio predio = new Predio();
        String input;
        Integer idCampus;

        listarCampus();
        System.out.println("Digite o id do campus que sera vinculado ao predio: ");
        input = scanner.nextLine();
        idCampus = Integer.parseInt(input);
        campus = campusModel.get(idCampus);
        predio.setCampus(campus);

        System.out.println("Digite o nome do predio: ");
        predio.setNome(scanner.nextLine());

        this.predioModel.create(predio);
        clearAtributos();
    }

    public void atualizarPredio(){
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

        System.out.println("Digite o novo nome do predio: ");
        nome = scanner.nextLine();
        predio.setNome(nome);

        this.predioModel.update(predio);
        clearAtributos();
    }

    public void deletarPredio(){
        Predio predio = new Predio();
        String input;
        Integer idPredio;
        Scanner scanner = new Scanner(System.in);

        listarPredios();

        System.out.println("Digite o id do predio a ser deletado: ");
        input = scanner.nextLine();
        idPredio = Integer.parseInt(input);
        predio = this.predioModel.get(idPredio);

        this.predioModel.remove(predio);
        clearAtributos();
    }
}
