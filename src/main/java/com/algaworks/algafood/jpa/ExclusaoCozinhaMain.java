package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiRestApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

public class ExclusaoCozinhaMain {

	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiRestApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		
		CadastroCozinhaService cadastroService = applicationContext.getBean(CadastroCozinhaService.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);
	
		cadastroService.excluir(2l);
	
	}
}
