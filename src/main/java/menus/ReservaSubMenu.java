/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;

import entidades.equipamento.Equipamento;
import entidades.funcionario.Funcionario;
import entidades.reserva.Reserva;
import entidades.sala.Sala;
import entidades.usuario.Usuario;
import models.EquipamentoModel;
import models.FuncionarioModel;
import models.ReservaModel;
import models.SalaModel;

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
            try {
                switch (opcao) {
                    case "1":
                        if (funcionarioModel.getAll() == null || funcionarioModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não é possível cadastrar uma reserva sem um funcionário cadastrado");
                        }
                        if (salaModel.getAll() == null || salaModel.getAll().isEmpty()) {
                            throw new RuntimeException("Não é possível cadastrar uma reserva sem uma sala cadastrada");
                        }
                        cadastrarReserva();
                        break;
                    case "2":
                        if(reservaModel.getAll() == null || reservaModel.getAll().isEmpty()){
                            throw new RuntimeException("Não há reservas cadastradas");
                        }
                        listarReserva();
                        break;
                    case "3":
                        if(reservaModel.getAll() == null || reservaModel.getAll().isEmpty()){
                            throw new RuntimeException("Não há reservas cadastradas");
                        }
                        atualizarReserva();
                        break;
                    case "4":
                        if(reservaModel.getAll() == null || reservaModel.getAll().isEmpty()){
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
            }catch(Exception e){
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
        System.out.println("-----Reservas ativas-----:");
        for (Reserva reserva : this.reservaModel.getAll()) {
            if(reserva.getAtivo()){
                System.out.println(reserva.toString());
            }
        }
        System.out.println("-----Reservas inativas-----:");
        for (Reserva reserva : this.reservaModel.getAll()) {
            if (!reserva.getAtivo()) {
                System.out.println(reserva.toString());
            }
        }
    }
    public void listarEquipamentos(){
        System.out.println("Equipamentos Cadastrados: ");
        for (Equipamento equipamento : this.equipamentoModel.getAll()) {
            System.out.println(equipamento.toString());
        }
    }
    public void cadastrarReserva(){
        try {
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

            Integer idFunc, idSala,usado = 0;
            String idEquip, tipa, assunto, date;
            LocalDate data;
            ArrayList<Sala> salasLivres = new ArrayList<>();

            listarFuncionarios();
            System.out.println("Digite o id do Funcionario vinculado a reserva: ");
            idFunc = scanner.nextInt();
            funcionario = funcionarioModel.get(idFunc);
            if(funcionario == null){
                throw new RuntimeException("Funcionario não encontrado");
            }
            reserva.setUsuario(funcionario);

            System.out.println("Digite o tipo da reserva: ");
            tipa = scanner1.nextLine();
            reserva.setTipo(tipa);

            System.out.println("Digite a data de alocação: (dd/MM/yyyy)");
            date = new Scanner(System.in).nextLine();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            formatoData.setLenient(false);
            data = formatoData.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dataAlocacao = data;
            reserva.setDataAlocacao(dataAlocacao);

            System.out.println("Digite a hora de inicio:(HH:mm) ");
            horaInicio = LocalTime.parse(scanner4.nextLine());
            reserva.setHoraInicio(horaInicio);

            System.out.println("Digite a hora de fim:(HH:mm) ");
            horaFim = LocalTime.parse(scanner5.nextLine());
            reserva.setHoraFim(horaFim);

            System.out.println("Digite o assunto: ");
            assunto = scanner6.nextLine();
            reserva.setAssunto(assunto);

            System.out.println("Salas disponiveis na Data e horario fornecidos:");
            salasLivres = this.reservaModel.obterSalasLivres(horaInicio,horaFim,dataAlocacao);
            if (salasLivres.isEmpty()) {
                throw new RuntimeException("# Não há salas livres #\n");
            }
            for (Sala s : salasLivres) {
                System.out.println(s.toString());
            }

            System.out.println("Digite o id da sala vinculada: ");
            idSala = scanner2.nextInt();
            sala = salaModel.get(idSala);
            if(sala == null){
                throw new RuntimeException("Sala não encontrada");
            }
            for (Sala s : salasLivres) {
                if(s == sala){
                    usado = 1;
                    break;
                }
            }
            if(usado == 0){
                throw new RuntimeException("Sala não disponivel");
            }
            reserva.setSala(sala);

            listarEquipamentos();
            while (true) {
                System.out.println("Digite o id dos equipamentos vinculado(digite 'q' para sair):");
                idEquip = scanner7.nextLine();
                if (idEquip.equals("q")) {
                    break;
                }
                //try parse do idequip para inteiro
                equipamento = equipamentoModel.get(Integer.parseInt(idEquip));
                if(equipamento == null){
                    throw new RuntimeException("Equipamento não encontrado");
                }
                reserva.addEquipamento(equipamento);
            }
            reserva.setAtivo(true);
            this.reservaModel.create(reserva);
            clearAtributos();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array fora do limite");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("String fora do limite");
        }catch (NullPointerException e){
            System.out.println("Valores nulos nao sao validos");
        }catch (NumberFormatException e){
            System.out.println("Número inválido");
        }catch (ParseException e){
            System.out.println("Data inválida");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void atualizarReserva(){
        try {
            Reserva reserva = new Reserva();
            Scanner scanner = new Scanner(System.in);
            Integer idReserva;
            String idEquip;
            String input, date;
            Integer idFunc, idSala;
            LocalDate data;

            listarReserva();
            System.out.println("Digite o id da reserva a ser atualizada: ");
            idReserva = scanner.nextInt();
            reserva = this.reservaModel.get(idReserva);
            if(reserva == null){
                throw new RuntimeException("Reserva não encontrada");
            }

            listarFuncionarios();
            System.out.println("Digite o id do Funcionario vinculado a reserva: ");
            idFunc = scanner.nextInt();
            reserva.setUsuario(funcionarioModel.get(idFunc));
            if(funcionarioModel.get(idFunc) == null){
                throw new RuntimeException("Funcionario não encontrado");
            }

            System.out.println("Digite o tipo da reserva: ");
            tipo = scanner.nextLine();
            reserva.setTipo(tipo);

            listarSalas();
            System.out.println("Digite o id da sala vinculada: ");
            idSala = scanner.nextInt();
            reserva.setSala(salaModel.get(idSala));
            if(salaModel.get(idSala) == null){
                throw new RuntimeException("Sala não encontrada");
            }

            System.out.println("Digite a data de alocação: ");
            date = new Scanner(System.in).nextLine();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            formatoData.setLenient(false);
            data = formatoData.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dataAlocacao = data;
            reserva.setDataAlocacao(dataAlocacao);

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
                if(equipamento == null){
                    throw new RuntimeException("Equipamento não encontrado");
                }
                reserva.addEquipamento(equipamento);
            }

            reserva.setAtivo(true);
            this.reservaModel.update(reserva);
            clearAtributos();

        }catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Array fora do limite");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("String fora do limite");
        }catch (NullPointerException e){
            System.out.println("Valores nulos nao sao validos");
        }catch (NumberFormatException e){
            System.out.println("Número inválido");
        }catch (ParseException e){
            System.out.println("Data inválida");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deletarReserva(){
        try {
            Reserva reserva = new Reserva();
            Scanner scanner = new Scanner(System.in);
            Integer idReserva;

            listarReserva();
            System.out.println("Digite o id da reserva a ser deletada: ");
            idReserva = scanner.nextInt();
            reserva = this.reservaModel.get(idReserva);
            if(reserva == null){
                throw new RuntimeException("Reserva não encontrada");
            }

            this.reservaModel.remove(reserva);
            clearAtributos();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array fora do limite");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("String fora do limite");
        }catch (NullPointerException e) {
            System.out.println("Valores nulos nao sao validos");
        }catch (NumberFormatException e) {
            System.out.println("Número inválido");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
