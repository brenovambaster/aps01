/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import entidades.campus.Campus;
import entidades.predio.Predio;
import models.PredioModel;
import models.ReservaModel;
import models.SalaModel;
import entidades.sala.Sala;

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
    PredioModel predioModel = new PredioModel();
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
            System.out.println("6- Disponibilidade de salas");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();
            try {
                switch (opcao) {
                    case "1":
                        if (predioModel.getAll() == null || predioModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não é possível cadastrar uma sala sem um predio cadastrado");
                        }
                        cadastrarSala();
                        break;
                    case "2":
                        if (salaModel.getAll() == null || salaModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não há salas cadastradas");
                        }
                        listarSala();
                        break;
                    case "3":
                        if (salaModel.getAll() == null || salaModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não há salas cadastradas");
                        }
                        atualizarSala();
                        break;
                    case "4":
                        if (salaModel.getAll() == null || salaModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não há salas cadastradas");
                        }
                        deletarSala();
                        break;
                    case "5":
                        return;
                    case "6":
                        if (salaModel.getAll() == null || salaModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não há salas cadastradas");
                        }
                        verDisponibilidadeSalas();
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
        System.out.println("Listando Salas: ");
        for (Sala sala : this.salaModel.getAll()) {
            System.out.println(sala.toString());
        }
    }

    public void listarPredios() {
        System.out.println("Listando Prédios: ");
        for (Predio predio : predioModel.getAll()) {
            System.out.println(predio.toString());
        }
    }

    public void cadastrarSala() {
        try {
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
            if (predio == null) {
                throw new RuntimeException("Predio não encontrado");
            }
            sala.setPredio(predio);

            System.out.println("Digite o número da sala: ");
            numeroSala = scanner.nextInt();
            sala.setNumeroSala(numeroSala);

            System.out.println("Digite a quantidade de lugares: ");
            qtdLugares = scanner.nextInt();
            sala.setQtdLugares(qtdLugares);

            this.salaModel.create(sala);
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
            if (sala == null) {
                throw new RuntimeException("Sala não encontrada");
            }

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
            Sala sala = new Sala();
            String input;
            Integer idSala;
            Scanner scanner = new Scanner(System.in);

            listarSala();

            System.out.println("Digite o id da sala a ser deletada: ");
            input = scanner.nextLine();
            idSala = Integer.parseInt(input);
            sala = this.salaModel.get(idSala);
            if (sala == null) {
                throw new RuntimeException("Sala não encontrada");
            }
            this.salaModel.remove(sala);
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
        ReservaModel reservaModel = new ReservaModel();
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
        salasLivres = reservaModel.obterSalasLivres(horaInicio, horaFim, data);
        System.out.println("\n----------------Salas livres---------------------\n ");
        if (salasLivres.isEmpty()) {
            System.out.println("# Não há salas livres #\n");
        }
        for (Sala sala : salasLivres) {
            System.out.println(sala.toString());
        }

        System.out.println("\n--------------Salas reservadas ---------------\n ");
        ArrayList<Sala> salasReservadas = reservaModel.obterSalasReservadas(horaInicio, horaFim, data);
        if (salasReservadas.isEmpty()) {
            System.out.println("# Não há salas reservadas #\n");
        }
        for (Sala sala : salasReservadas) {
            System.out.println(sala.toString());
        }
    }
}
