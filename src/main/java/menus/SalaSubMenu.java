/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import entidades.campus.Campus;
import entidades.predio.Predio;
import models.PredioModel;
import models.SalaModel;
import entidades.sala.Sala;
import java.util.Scanner;
public class SalaSubMenu {
    Integer numeroSala;
    Integer qtdLugares;
    Predio predio;
    String opcao;

    SalaModel salaModel = new SalaModel();
    public void SalaSubMenu() {
        this.numeroSala = null;
        this.qtdLugares = null;
        this.predio = null;
    }

    public void salaMenu() {
        while (true) {
            System.out.println("Sala Submenu");
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Cadastrar Sala");
            System.out.println("2 - Listar Sala");
            System.out.println("3 - Atualizar Sala");
            System.out.println("4 - Deletar Sala");
            System.out.println("5 - Voltar");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarSala();
                    break;
                case "2":
                    listarSala();
                    break;
                case "3":
                    atualizarSala();
                    break;
                case "4":
                    deletarSala();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public void clearAtributos() {
        this.numeroSala = null;
        this.qtdLugares = null;
        this.predio = null;
    }

    public void listarSala(){
        System.out.println("Listando Salas: ");
        for (Sala sala : this.salaModel.getAll()) {
            System.out.println(sala.toString());
        }
    }

    public void listarPredios(){
        PredioModel predioModel = new PredioModel();
        System.out.println("Listando Prédios: ");
        for (Predio predio : predioModel.getAll()) {
            System.out.println(predio.toString());
        }
    }
    public void cadastrarSala() {
        Scanner scanner = new Scanner(System.in);
        Predio predio = new Predio();
        PredioModel predioModel = new PredioModel();
        String input;
        Integer idPredio;
        Integer numeroSala;
        Integer qtdLugares;
        Sala sala = new Sala();

        listarPredios();
        System.out.println("Digite o id do predio vinculado a sala: ");
        input = scanner.nextLine();
        idPredio = Integer.parseInt(input);
        predio = predioModel.get(idPredio);
        sala.setPredio(predio);

        System.out.println("Digite o número da sala: ");
        numeroSala = scanner.nextInt();
        sala.setNumeroSala(numeroSala);

        System.out.println("Digite a quantidade de lugares: ");
        qtdLugares = scanner.nextInt();
        sala.setQtdLugares(qtdLugares);


        this.salaModel.create(sala);
        clearAtributos();
    }

    public void atualizarSala(){
        Sala sala = new Sala();
        String input;
        Integer idSala;
        Integer numeroSala;
        Integer qtdLugares;
        Integer idPredio;
        Scanner scanner = new Scanner(System.in);
        Predio predio = new Predio();
        PredioModel predioModel = new PredioModel();

        listarSala();

        System.out.println("Digite o id da sala a ser atualizada: ");
        input = scanner.nextLine();
        idSala = Integer.parseInt(input);
        sala = this.salaModel.get(idSala);

        System.out.println("Digite o novo número da sala: ");
        numeroSala = scanner.nextInt();
        sala.setNumeroSala(numeroSala);

        System.out.println("Digite a nova quantidade de lugares: ");
        qtdLugares = scanner.nextInt();
        sala.setQtdLugares(qtdLugares);

        System.out.println("Digite o id do predio vinculado a sala: ");
        input = scanner.nextLine();
        idPredio = Integer.parseInt(input);
        predio = predioModel.get(idPredio);

        sala.setPredio(predio);
        this.salaModel.update(sala);
        clearAtributos();
    }

    public void deletarSala(){
        Sala sala = new Sala();
        String input;
        Integer idSala;
        Scanner scanner = new Scanner(System.in);

        listarSala();

        System.out.println("Digite o id da sala a ser deletada: ");
        input = scanner.nextLine();
        idSala = Integer.parseInt(input);
        sala = this.salaModel.get(idSala);

        this.salaModel.remove(sala);
        clearAtributos();
    }
}
