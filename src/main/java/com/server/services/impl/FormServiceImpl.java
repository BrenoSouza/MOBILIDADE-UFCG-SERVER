package com.server.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entities.Form;
import com.server.repositories.FormRepository;
import com.server.services.FormService;

@Service
public class FormServiceImpl implements FormService {
	
	@Autowired
	private FormRepository formRepository;

	@Override
	public Form findByid(Long Id) {
		return this.formRepository.findByid(Id);
	}

	@Override
	public Form findBysetorRequisitante(String setorRequisitante) {
		return this.formRepository.findBysetorRequisitante(setorRequisitante);
	}

	@Override
	public Form findBydataRequisição(String dataRequisição) {
		return this.formRepository.findBydataRequisição(dataRequisição);
	}

	@Override
	public Form findBydestino(String destino) {
		return this.formRepository.findBydestino(destino);
	}

	@Override
	public Form findBynome(String nome) {
		return this.formRepository.findBynome(nome);
	}

	@Override
	public Form findBytelefone(String telefone) {
		return this.formRepository.findBytelefone(telefone);
	}

	@Override
	public Form findBydataViagem(String dataViagem) {
		return this.formRepository.findBydataViagem(dataViagem)
;	}

	@Override
	public Form findByhoraSaida(String horaSaida) {
		return this.formRepository.findByhoraSaida(horaSaida);
	}

	@Override
	public Form findByregressoProvavel(String regressoProvavel) {
		return this.formRepository.findByregressoProvavel(regressoProvavel);
	}

	@Override
	public Form findByhora(String hora) {
		return this.formRepository.findByhora(hora);
	}

	/*@Override
	public Form findbylocaSaida(String locaSaida) {
		return this.formRepository.findbylocalSaida(locaSaida);
	}*/

	@Override
	public Form persistir(Form formulario) {
		return this.formRepository.save(formulario);
	}

}
