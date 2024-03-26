/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import entidades.equipamento.Equipamento;
import entidades.funcionario.Funcionario;
import entidades.sala.Sala;
import entidades.usuario.Usuario;
import entidades.reserva.Reserva;
import models.EquipamentoModel;
import models.FuncionarioModel;
import models.ReservaModel;
import models.SalaModel;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
public class ReservaSubMenu {
    Usuario usuario;
    List<Equipamento> equipamentos;
    String tipo;
    LocalDate dataAlocacao;
    LocalTime horaInicio, horaFim;
    String assunto;
    Boolean ativo = false;
    String opcao;
    ReservaModel reservaModel = new ReservaModel();
    Equipamento equipamento = new Equipamento();
    FuncionarioModel funcionarioModel = new FuncionarioModel();
    SalaModel salaModel = new SalaModel();
    EquipamentoModel equipamentoModel = new EquipamentoModel();
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

            switch (opcao) {
                case "1":
                    cadastrarReserva();
                    break;
                case "2":
                    listarReserva();
                    break;
                case "3":
                    atualizarReserva();
                    break;
                case "4":
                    deletarReserva();
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
        this.usuario = null;
        this.equipamentos = null;
        this.tipo = "";
        this.dataAlocacao = null;
        this.horaInicio = null;
        this.horaFim = null;
        this.assunto = "";
    }

    public void listarFuncionarios(){
        System.out.println("Funcionarios Cadastrados: ");
        for (Funcionario funcionario : this.funcionarioModel.getAll()) {
            System.out.println(funcionario.toString());
        }
    }
    public void listarSalas(){
        System.out.println("Salas Cadastradas: ");
        for (Sala sala : this.salaModel.getAll()) {
            System.out.println(sala.toString());
        }
    }
    public void listarReserva(){
        System.out.println("Listando Reservas: ");
        for (Reserva reserva : this.reservaModel.getAll()) {
            System.out.println(reserva.toString());
        }
    }
    public void listarEquipamentos(){
        System.out.println("Equipamentos Cadastrados: ");
        for (Equipamento equipamento : this.equipamentoModel.getAll()) {
            System.out.println(equipamento.toString());
        }
    }
    public void cadastrarReserva(){
        Funcionario funcionario = new Funcionario();
        Reserva reserva = new Reserva();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);
        Scanner scanner6 = new Scanner(System.in);
        Scanner scanner7 = new Scanner(System.in);

        Integer idFunc,idSala;
        String idEquip,tipa,assunto,date;
        LocalDate data;

        listarFuncionarios();
        System.out.println("Digite o id do Funcionario vinculado a reserva: ");
        idFunc = scanner.nextInt();
        funcionario = funcionarioModel.get(idFunc);
        reserva.setUsuario(funcionario);

        System.out.println("Digite o tipo da reserva: ");
        tipa = scanner1.nextLine();
        reserva.setTipo(tipa);

        listarSalas();
        System.out.println("Digite o id da sala vinculada: ");
        idSala = scanner2.nextInt();
        sala = salaModel.get(idSala);
        sala.toString();

        reserva.setSala(sala);

        System.out.println("Digite a data de alocação: (dd/MM/yyyy)");
        try {
            date = new Scanner(System.in).nextLine();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            formatoData.setLenient(false);
            data = formatoData.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dataAlocacao = data;
            reserva.setDataAlocacao(dataAlocacao);
        }catch (ParseException e){
            System.out.println("Data inválida");
        }

        //date =  new Scanner(System.in).nextLine();
        //DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //data = LocalDate.parse(date, formatoData);


        System.out.println("Digite a hora de inicio:(HH:mm) ");
        horaInicio = LocalTime.parse(scanner4.nextLine());
        reserva.setHoraInicio(horaInicio);

        System.out.println("Digite a hora de fim:(HH:mm) ");
        horaFim = LocalTime.parse(scanner5.nextLine());
        reserva.setHoraFim(horaFim);

        System.out.println("Digite o assunto: ");
        assunto = scanner6.nextLine();
        reserva.setAssunto(assunto);

        listarEquipamentos();

        while (true) {
            System.out.println("Digite o id dos equipamentos vinculado(digite 'q' para sair):");
            idEquip = scanner7.nextLine();
            if (idEquip.equals("q")) {
                break;
            }
            //try parse do idequip para inteiro
            equipamento = equipamentoModel.get(Integer.parseInt(idEquip));
            reserva.addEquipamento(equipamento);
        }
        reserva.setAtivo(true);
       this.reservaModel.create(reserva);
       clearAtributos();
    }

    public void atualizarReserva(){

        Reserva reserva = new Reserva();
        Scanner scanner = new Scanner(System.in);
        Integer idReserva;
        String idEquip;
        String input,date;
        Integer idFunc,idSala;
        LocalDate data;

        listarReserva();
        System.out.println("Digite o id da reserva a ser atualizada: ");
        idReserva = scanner.nextInt();
        reserva = this.reservaModel.get(idReserva);

        listarFuncionarios();
        System.out.println("Digite o id do Funcionario vinculado a reserva: ");
        idFunc = scanner.nextInt();
        reserva.setUsuario(funcionarioModel.get(idFunc));

        System.out.println("Digite o tipo da reserva: ");
        tipo = scanner.nextLine();
        reserva.setTipo(tipo);

        listarSalas();
        System.out.println("Digite o id da sala vinculada: ");
        idSala = scanner.nextInt();
        reserva.setSala(salaModel.get(idSala));

        System.out.println("Digite a data de alocação: ");
        try {
            date = new Scanner(System.in).nextLine();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            formatoData.setLenient(false);
            data = formatoData.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dataAlocacao = data;
            reserva.setDataAlocacao(dataAlocacao);
        }catch (ParseException e){
            System.out.println("Data inválida");
        }
        dataAlocacao = LocalDate.parse(scanner.nextLine());
        reserva.setDataAlocacao(dataAlocacao);

        System.out.println("Digite a hora de inicio:(HH:mm) ");
        horaInicio = LocalTime.parse(scanner.nextLine());
        reserva.setHoraInicio(horaInicio);

        System.out.println("Digite a hora de fim:(HH:mm) ");
        horaFim = LocalTime.parse(scanner.nextLine());
        reserva.setHoraFim(horaFim);

        System.out.println("Digite o assunto: ");
        assunto = scanner.nextLine();
        reserva.setAssunto(assunto);

        listarEquipamentos();
        System.out.println("Digite o id dos equipamentos vinculado(digite 'q' para sair):");
        while (true) {
            idEquip = scanner.nextLine();
            if (idEquip.equals("q")) {
                break;
            }
            equipamento = equipamentoModel.get(Integer.parseInt(idEquip));
            reserva.addEquipamento(equipamento);
        }

        reserva.setAtivo(true);
        this.reservaModel.update(reserva);
        clearAtributos();
    }

    public void deletarReserva(){
        Reserva reserva = new Reserva();
        Scanner scanner = new Scanner(System.in);
        Integer idReserva;

        listarReserva();
        System.out.println("Digite o id da reserva a ser deletada: ");
        idReserva = scanner.nextInt();
        reserva = this.reservaModel.get(idReserva);
        this.reservaModel.remove(reserva);
        clearAtributos();
    }
}
