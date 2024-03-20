/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package reserva;
import sala.Sala;
import usuario.Usuario;
import java.time.LocalDate;
import java.time.LocalTime;
import equipamento.Equipamento;
import java.util.ArrayList;
import java.util.List;

//TODO: REVISAR TODA ESSA CLASSE, BEM COMO OS TESTES
public class Reserva {
    private Usuario usuario;
    private final List<Equipamento> equipamentos;
    private Sala sala;
    private String tipo;
    private LocalDate dataAlocacao;
    private LocalTime horaInicio, horaFim;
    private String assunto;
    private Boolean ativo = false;

    public Reserva() {
        this.equipamentos = new ArrayList<Equipamento>();
    }

    public Reserva(LocalDate dataAlocacao, LocalTime horaInicio, LocalTime horaFim, String assunto, Usuario usuario, Sala sala, String tipo) {
        this();
        this.setDataAlocacao(dataAlocacao);
        this.setSala(sala);
        this.setTipo(tipo);
        this.setHoraInicio(horaInicio);
        this.setHoraFim(horaFim);
        this.setAssunto(assunto);
        this.setUsuario(usuario);
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public LocalDate getDataAlocacao() {
        return dataAlocacao;
    }

    public void setDataAlocacao(LocalDate dataAlocacao) {
        this.dataAlocacao = dataAlocacao;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void addEquipamento(Equipamento equipamento) {

        this.equipamentos.add(equipamento);
    }

    public Boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void deleteEquipamento(Equipamento equipamento) {
        this.equipamentos.remove(equipamento);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "usuario=" + usuario +
                ", equipamentos=" + equipamentos +
                ", sala=" + sala +
                ", tipo='" + tipo + '\'' +
                ", dataAlocacao=" + dataAlocacao +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                ", assunto='" + assunto + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
