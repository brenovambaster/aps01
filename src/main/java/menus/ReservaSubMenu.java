/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import controller.EquipamentoController;
import controller.FuncionarioController;
import controller.ReservaController;
import controller.SalaController;
import entidades.Equipamento;
import entidades.Funcionario;
import entidades.Reserva;
import entidades.Sala;
import entidades.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservaSubMenu {
    Usuario usuario;
    List<Equipamento> equipamentos;
    String tipo;
    LocalDate dataAlocacao;
    LocalTime horaInicio, horaFim;
    String assunto;
    Boolean ativo = false;
    String opcao;
    ReservaController reservaController = new ReservaController();
    Equipamento equipamento = new Equipamento();
    FuncionarioController funcionarioController = new FuncionarioController();
    SalaController salaController = new SalaController();
    EquipamentoController equipamentoController = new EquipamentoController();
    Sala sala = new Sala();

    public ReservaSubMenu() {
        this.usuario = null;
        this.equipamentos = null;
        this.tipo = "";
        this.dataAlocacao = null;
        this.horaInicio = null;
        this.horaFim = null;
        this.assunto = "";
    }

    public void reservaMenu() {
        while (true) {
            System.out.println("Reserva Submenu");
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Cadastrar Reserva");
            System.out.println("2 - Listar Reserva");
            System.out.println("3 - Atualizar Reserva");
            System.out.println("4 - Deletar Reserva");
            System.out.println("5 - Voltar");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();
            try {
                switch (opcao) {
                    case "1":
                        if (funcionarioController.getAll() == null || funcionarioController.getAll().isEmpty()) {
                            throw new RuntimeException("Não é possível cadastrar uma reserva sem um funcionário cadastrado");
                        }
                        if (salaController.getAll() == null || salaController.getAll().isEmpty()) {
                            throw new RuntimeException("Não é possível cadastrar uma reserva sem uma sala cadastrada");
                        }
                        cadastrarReserva();
                        break;
                    case "2":
                        if (reservaController.getAll() == null || reservaController.getAll().isEmpty()) {
                            throw new RuntimeException("Não há reservas cadastradas");
                        }
                        listarReserva();
                        break;
                    case "3":
                        if (reservaController.getAll() == null || reservaController.getAll().isEmpty()) {
                            throw new RuntimeException("Não há reservas cadastradas");
                        }
                        atualizarReserva();
                        break;
                    case "4":
                        if (reservaController.getAll() == null || reservaController.getAll().isEmpty()) {
                            throw new RuntimeException("Não há reservas cadastradas");
                        }
                        deletarReserva();
                        break;
                    case "5":
                        return;
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
        this.usuario = null;
        this.equipamentos = null;
        this.tipo = "";
        this.dataAlocacao = null;
        this.horaInicio = null;
        this.horaFim = null;
        this.assunto = "";
    }

    public void listarFuncionarios() {
        System.out.println("Funcionarios Cadastrados: ");
        for (Funcionario funcionario : this.funcionarioController.getAll()) {
            System.out.println(funcionario.toString());
        }
    }

    public void listarSalas() {
        System.out.println("Salas Cadastradas: ");
        for (Sala sala : this.salaController.getAll()) {
            System.out.println(sala.toString());
        }
    }

    public void listarReserva() {
        System.out.println("Listando Reservas: ");
        System.out.println("-----Reservas ativas-----:");
        for (Reserva reserva : this.reservaController.getAll()) {
            if (reserva.getAtivo()) {
                System.out.println(reserva.toString());
            }
        }
        System.out.println("-----Reservas inativas-----:");
        for (Reserva reserva : this.reservaController.getAll()) {
            if (!reserva.getAtivo()) {
                System.out.println(reserva.toString());
            }
        }
    }

    public void listarEquipamentos() {
        System.out.println("Equipamentos Cadastrados: ");
        for (Equipamento equipamento : this.equipamentoController.getAll()) {
            System.out.println(equipamento.toString());
        }
    }

    public void cadastrarReserva() {
        try {

            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            Scanner scanner3 = new Scanner(System.in);
            Scanner scanner4 = new Scanner(System.in);
            Scanner scanner5 = new Scanner(System.in);
            Scanner scanner6 = new Scanner(System.in);
            Scanner scanner7 = new Scanner(System.in);

            Integer idFunc, idSala, usado = 0;
            String idEquip, tipo, assunto, date;
            LocalDate data;
            ArrayList<Sala> salasLivres = new ArrayList<>();

            listarFuncionarios();

            System.out.println("Digite o id do Funcionario vinculado a reserva: ");
            idFunc = scanner.nextInt();


            System.out.println("Digite o tipo da reserva: ");
            tipo = scanner1.nextLine();


            System.out.println("Digite a data de alocação: (dd/MM/yyyy)");
            date = new Scanner(System.in).nextLine();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            formatoData.setLenient(false);
            data = formatoData.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dataAlocacao = data;


            System.out.println("Digite a hora de inicio:(HH:mm) ");
            horaInicio = LocalTime.parse(scanner4.nextLine());


            System.out.println("Digite a hora de fim:(HH:mm) ");
            horaFim = LocalTime.parse(scanner5.nextLine());


            System.out.println("Digite o assunto: ");
            assunto = scanner6.nextLine();


            System.out.println("Salas disponiveis na Data e horario fornecidos:");
            salasLivres = this.reservaController.obterSalasLivres(horaInicio, horaFim, dataAlocacao);
            if (salasLivres.isEmpty()) {
                throw new RuntimeException("# Não há salas livres #\n");
            }
            for (Sala s : salasLivres) {
                System.out.println(s.toString());
            }

            System.out.println("Digite o id da sala vinculada: ");
            idSala = scanner2.nextInt();
            sala = salaController.get(idSala);
            if (sala == null) {
                throw new RuntimeException("Sala não encontrada");
            }
            for (Sala s : salasLivres) {
                if (s == sala) {
                    usado = 1;
                    break;
                }
            }
            if (usado == 0) {
                throw new RuntimeException("Sala não disponivel");
            }

            ArrayList<Equipamento> equipamentos = new ArrayList<>();
            listarEquipamentos();
            while (true) {
                System.out.println("Digite o id dos equipamentos vinculado(digite 'q' para sair):");
                idEquip = scanner7.nextLine();
                if (idEquip.equals("q")) {
                    break;
                }
                //try parse do idequip para inteiro
                equipamento = equipamentoController.get(Integer.parseInt(idEquip));
                if (equipamento == null) {
                    throw new RuntimeException("Equipamento não encontrado");
                } else
                    equipamentos.add(equipamento);

            }

            reservaController.create(idFunc, idSala, tipo, dataAlocacao, horaInicio, horaFim, assunto, equipamentos);
            clearAtributos();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array fora do limite");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String fora do limite");
        } catch (NullPointerException e) {
            System.out.println("Valores nulos nao sao validos");
        } catch (NumberFormatException e) {
            System.out.println("Número inválido");
        } catch (ParseException e) {
            System.out.println("Data inválida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizarReserva() {
        try {

            Scanner scanner = new Scanner(System.in);
            Integer idReserva;
            String idEquip;
            String input, date;
            Integer idFunc, idSala;
            LocalDate data;

            listarReserva();
            System.out.println("Digite o id da reserva a ser atualizada: ");
            idReserva = scanner.nextInt();


            listarFuncionarios();
            System.out.println("Digite o id do Funcionario vinculado a reserva: ");
            idFunc = scanner.nextInt();


            System.out.println("Digite o tipo da reserva: ");
            tipo = scanner.nextLine();


            listarSalas();
            System.out.println("Digite o id da sala vinculada: ");
            idSala = scanner.nextInt();

            System.out.println("Digite a data de alocação: ");
            date = new Scanner(System.in).nextLine();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            formatoData.setLenient(false);
            data = formatoData.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dataAlocacao = data;


            System.out.println("Digite a hora de inicio:(HH:mm) ");
            horaInicio = LocalTime.parse(scanner.nextLine());


            System.out.println("Digite a hora de fim:(HH:mm) ");
            horaFim = LocalTime.parse(scanner.nextLine());


            System.out.println("Digite o assunto: ");
            assunto = scanner.nextLine();


            listarEquipamentos();
            ArrayList<Equipamento> equipamentos = new ArrayList<>();

            System.out.println("Digite o id dos equipamentos vinculado(digite 'q' para sair):");
            while (true) {
                idEquip = scanner.nextLine();
                if (idEquip.equals("q")) {
                    break;
                }
                equipamento = equipamentoController.get(Integer.parseInt(idEquip));
                if (equipamento == null) {
                    throw new RuntimeException("Equipamento não encontrado");
                }
                equipamentos.add(equipamento);
            }


            reservaController.update(idReserva, idFunc, idSala, tipo, dataAlocacao, horaInicio, horaFim, assunto, equipamentos);

            clearAtributos();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array fora do limite");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String fora do limite");
        } catch (NullPointerException e) {
            System.out.println("Valores nulos nao sao validos");
        } catch (NumberFormatException e) {
            System.out.println("Número inválido");
        } catch (ParseException e) {
            System.out.println("Data inválida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletarReserva() {
        try {

            Scanner scanner = new Scanner(System.in);
            Integer idReserva;

            listarReserva();
            System.out.println("Digite o id da reserva a ser deletada: ");
            idReserva = scanner.nextInt();

            this.reservaController.remove(idReserva);
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
