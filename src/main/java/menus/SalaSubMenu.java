/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import controller.PredioController;
import controller.ReservaController;
import controller.SalaController;
import entidades.Predio;
import entidades.Sala;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;

public class SalaSubMenu {
    Integer numeroSala;
    Integer qtdLugares;
    Predio predio;
    String opcao;
    PredioController predioController = new PredioController();
    ReservaController reservaController = new ReservaController();

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
            System.out.println("6 - Disponibilidade de salas");
            System.out.println("7- Ocupação de salas por data");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();
            try {
                SalaController salaController = new SalaController();
                switch (opcao) {
                    case "1":
                        if (predioController.getAll() == null || predioController.getAll().isEmpty()) {
                            throw new RuntimeException("Não é possível cadastrar uma sala sem um predio cadastrado");
                        }
                        cadastrarSala();
                        break;
                    case "2":
                        if (salaController.getAll() == null || salaController.getAll().isEmpty()) {
                            throw new RuntimeException("Não há salas cadastradas");
                        }
                        listarSala();
                        break;
                    case "3":
                        if (salaController.getAll() == null || salaController.getAll().isEmpty()) {
                            throw new RuntimeException("Não há salas cadastradas");
                        }
                        atualizarSala();
                        break;
                    case "4":
                        if (salaController.getAll() == null || salaController.getAll().isEmpty()) {
                            throw new RuntimeException("Não há salas cadastradas");
                        }
                        deletarSala();
                        break;
                    case "5":
                        return;
                    case "6":
                        if (salaController.getAll() == null || salaController.getAll().isEmpty()) {
                            throw new RuntimeException("Não há salas cadastradas");
                        }
                        verDisponibilidadeSalas();
                        break;
                    case "7":
                        if (salaController.getAll() == null || salaController.getAll().isEmpty()) {
                            throw new RuntimeException("Não há salas cadastradas");
                        }
                        ocupacaoSalasPorData();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void clearAtributos() {
        this.numeroSala = null;
        this.qtdLugares = null;
        this.predio = null;
    }

    public void listarSala() {
        SalaController salaController = new SalaController();
        System.out.println("Listando Salas: ");
        for (Sala sala : salaController.getAll()) {
            System.out.println(sala.toString());
        }
    }

    public void listarPredios() {
        System.out.println("Listando Prédios: ");
        for (Predio predio : predioController.getAll()) {
            System.out.println(predio.toString());
        }
    }

    public void ocupacaoSalasPorData() {
        LocalDate data;
        System.out.println("Digite a data de ocupação: (dd/MM/yyyy)");
        String date = new Scanner(System.in).nextLine();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        formatoData.setLenient(false);

        try {
            data = formatoData.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            throw new RuntimeException("Parse da data falhou:  " + e);
        }

        System.out.println("----------- Ocupação de salas por dia: -----------------");
        for (Sala sala : reservaController.obterSalasReservadasPorDia(data)) {
            System.out.println(sala.toString());
        }
        System.out.println("\n\n");

        System.out.println("----------- Ocupação de salas por mês: -----------------");
        for (Sala sala : reservaController.obterSalasReservadasPorMes(data)) {
            System.out.println(sala.toString());
        }
        System.out.println("\n\n");

    }

    public void cadastrarSala() {
        try {
            Scanner scanner = new Scanner(System.in);
            String input;
            Integer idPredio;
            Integer numeroSala;
            Integer qtdLugares;

            listarPredios();
            System.out.println("Digite o id do predio vinculado a sala: ");
            input = scanner.nextLine();
            idPredio = Integer.parseInt(input);

            System.out.println("Digite o número da sala: ");
            numeroSala = scanner.nextInt();

            System.out.println("Digite a quantidade de lugares: ");
            qtdLugares = scanner.nextInt();

            SalaController salaController = new SalaController();
            salaController.create(numeroSala, idPredio, qtdLugares);
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

    public void atualizarSala() {
        try {

            String input;
            Integer idSala;
            Integer numeroSala;
            Integer qtdLugares;
            Integer idPredio;
            Scanner scanner = new Scanner(System.in);

            listarSala();

            System.out.println("Digite o id da sala a ser atualizada: ");
            input = scanner.nextLine();
            idSala = Integer.parseInt(input);


            System.out.println("Digite o novo número da sala: ");
            numeroSala = scanner.nextInt();


            System.out.println("Digite a nova quantidade de lugares: ");
            qtdLugares = scanner.nextInt();


            System.out.println("Digite o id do predio vinculado a sala: ");
            input = (String.valueOf(scanner.nextInt()));
            idPredio = Integer.parseInt(input);

            SalaController salaController = new SalaController();
            salaController.update(idSala, numeroSala, idPredio, qtdLugares);
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

    public void deletarSala() {
        try {

            String input;
            Integer idSala;
            Scanner scanner = new Scanner(System.in);

            listarSala();

            System.out.println("Digite o id da sala a ser deletada: ");
            input = scanner.nextLine();
            idSala = Integer.parseInt(input);

            SalaController salaController = new SalaController();
            salaController.remove(idSala);
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

    public void verDisponibilidadeSalas() {
        String date;
        LocalDate data;
        Scanner scanner = new Scanner(System.in);
        ReservaController reservaController = new ReservaController();

        ArrayList<Sala> salasLivres = new ArrayList<>();
        System.out.println("Digite a data para consulta: (dd/MM/yyyy)");

        date = new Scanner(System.in).nextLine();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        formatoData.setLenient(false);
        try {
            data = formatoData.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            throw new RuntimeException("Parse da data falhou:  " + e);
        }

        System.out.println("Digite a hora de inicio:(HH:mm) ");
        LocalTime horaInicio = LocalTime.parse(scanner.nextLine());


        System.out.println("Digite a hora de fim:(HH:mm) ");
        LocalTime horaFim = LocalTime.parse(scanner.nextLine());
        salasLivres = reservaController.obterSalasLivres(horaInicio, horaFim, data);
        System.out.println("\n----------------Salas livres---------------------\n ");
        if (salasLivres.isEmpty()) {
            System.out.println("# Não há salas livres #\n");
        }
        for (Sala sala : salasLivres) {
            System.out.println(sala.toString());
        }

        System.out.println("\n--------------Salas reservadas ---------------\n ");
        ArrayList<Sala> salasReservadas = reservaController.obterSalasReservadas(horaInicio, horaFim, data);
        if (salasReservadas.isEmpty()) {
            System.out.println("# Não há salas reservadas #\n");
        }
        for (Sala sala : salasReservadas) {
            System.out.println(sala.toString());
        }
    }
}
