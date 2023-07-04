package br.com.med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.med.voll.api.medico.DadosCadastroMedico;
import br.com.med.voll.api.medico.Medico;
import br.com.med.voll.api.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository repository;
	
	@PostMapping
	@Transactional
	public String cadastrar (@RequestBody @Valid DadosCadastroMedico  dados) {
		repository.save(new Medico(dados));
		return  dados.nome() + "" + " Gravado no BD ";
	}

}