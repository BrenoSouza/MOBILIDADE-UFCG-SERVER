package com.server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "form")
public class Form implements Serializable{

	private Long id;
	
	//dados da viagem
	private String setorRequisitante;
	private String dataRequisição;
	private String destino;
	private String objetivo;
	
	//dados do solicitante
	private String nome;
	private String telefone;
	
	//datas e horas da viagem
	private String data;
	private String horaSaida;
	private String regressoProvavel;
	private String hora;
	private String locaSaida;
	
	//passageiros no aeroporto
	
	private String horarioDeChegada;
	private String numeroVoo;
	private String empresaAerea;
	private String OrigemViagem;
	
	//responsável pela diarias do motorista
	private String setorResponsávelMotorista;
	
	//construtor padrão
	public Form () {
		
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSetorRequisitante() {
		return setorRequisitante;
	}

	public void setSetorRequisitante(String setorRequisitante) {
		this.setorRequisitante = setorRequisitante;
	}

	public String getDataRequisição() {
		return dataRequisição;
	}

	public void setDataRequisição(String dataRequisição) {
		this.dataRequisição = dataRequisição;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getRegressoProvavel() {
		return regressoProvavel;
	}

	public void setRegressoProvavel(String regressoProvavel) {
		this.regressoProvavel = regressoProvavel;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLocaSaida() {
		return locaSaida;
	}

	public void setLocaSaida(String locaSaida) {
		this.locaSaida = locaSaida;
	}

	public String getHorarioDeChegada() {
		return horarioDeChegada;
	}

	public void setHorarioDeChegada(String horarioDeChegada) {
		this.horarioDeChegada = horarioDeChegada;
	}

	public String getNumeroVoo() {
		return numeroVoo;
	}

	public void setNumeroVoo(String numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

	public String getEmpresaAerea() {
		return empresaAerea;
	}

	public void setEmpresaAerea(String empresaAerea) {
		this.empresaAerea = empresaAerea;
	}

	public String getOrigemViagem() {
		return OrigemViagem;
	}

	public void setOrigemViagem(String origemViagem) {
		OrigemViagem = origemViagem;
	}

	public String getSetorResponsávelMotorista() {
		return setorResponsávelMotorista;
	}

	public void setSetorResponsávelMotorista(String setorResponsávelMotorista) {
		this.setorResponsávelMotorista = setorResponsávelMotorista;
	}
	
}