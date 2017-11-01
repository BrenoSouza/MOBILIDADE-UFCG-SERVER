package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Form;

public interface FormRapository extends JpaRepository<Form, Long>{
	
	//busca por Id
	Form findByid(Long Id);
	
	//busca por dados da viagem
	Form findBysetorRequisitante(String setorRequisitante);
	
	Form findBydataRequisição(String dataRequisição);
	
	Form findBydestino(String destino);
	
	//busca pelo solicitate 
	
	Form findBynome(String nome);
	Form findBytelefone(String telefone);
	
	//busca por datas e horas da viagem
	Form findBydataViagem(String dataViagem);
	Form findByhoraSaida(String horaSaida);
	Form findByregressoProvavel(String regressoProvavel);
	Form findByhora(String hora);
	Form findbylocaSaida(String locaSaida);
	

}
