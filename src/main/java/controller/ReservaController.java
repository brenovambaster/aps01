/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package controller;

import entidades.*;
import models.FuncionarioModel;
import models.ReservaModel;
import models.SalaModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ReservaController {
    private Reserva reserva;
    private ReservaModel reservaModel = new ReservaModel();

    public void create(Integer idFuncionario, Integer idSala,
                       String tipo, LocalDate dataAlocacao, LocalTime horaInicio,
                       LocalTime horaFim, String assunto, ArrayList<Equipamento> equipamentos) {

        reserva = new Reserva();

        reserva.setSala(verificaSala(idSala));
        reserva.setUsuario(verificaFuncionario(idFuncionario));
        reserva.setTipo(tipo);
        reserva.setDataAlocacao(dataAlocacao);
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFim(horaFim);
        reserva.setAssunto(assunto);
        reserva.setEquipamentos(equipamentos);
        reservaModel.create(reserva);

    }

    public void remove(Integer id) {
        this.reserva = reservaModel.get(id);
        if (reserva == null)
            throw new IllegalArgumentException("Reserva não encontrada");

        reservaModel.remove(this.reserva);
    }

    public Boolean update(Integer id, Integer idFuncionario, Integer idSala,
                          String tipo, LocalDate dataAlocacao, LocalTime horaInicio,
                          LocalTime horaFim, String assunto, ArrayList<Equipamento> equipamentos) {

        this.reserva = reservaModel.get(id);
        if (reserva == null)
            throw new IllegalArgumentException("Reserva não encontrada");

        reserva.setSala(verificaSala(idSala));
        reserva.setUsuario(verificaFuncionario(idFuncionario));
        reserva.setTipo(tipo);
        reserva.setDataAlocacao(dataAlocacao);
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFim(horaFim);
        reserva.setAssunto(assunto);
        reserva.setEquipamentos(equipamentos);
        return reservaModel.update(reserva);
    }

    public Reserva get(Integer id) {
        return reservaModel.get(id);
    }

    public ArrayList<Reserva> getAll() {
        return reservaModel.getAll();
    }


    public ArrayList<Sala> obterSalasLivres(LocalTime horaInicio, LocalTime horaFim, LocalDate data) {
        return reservaModel.obterSalasLivres(horaInicio, horaFim, data);
    }

    public ArrayList<Sala> obterSalasReservadas(LocalTime horaInicio, LocalTime horaFim, LocalDate data) {
        return reservaModel.obterSalasReservadas(horaInicio, horaFim, data);
    }

    private Sala verificaSala(Integer idSala) {
        Sala sala = new Sala();
        SalaModel salaModel = new SalaModel();
        sala = salaModel.get(idSala);
        if (sala == null) {
            throw new IllegalArgumentException("Sala não encontrada");
        }
        return sala;
    }

    private Funcionario verificaFuncionario(Integer idFuncionario) {
        Funcionario fun = new Funcionario();
        FuncionarioModel funModel = new FuncionarioModel();
        fun = funModel.get(idFuncionario);
        if (fun == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        return fun;
    }
}
