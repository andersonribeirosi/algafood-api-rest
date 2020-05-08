package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiRestApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class ConsultaCidadeMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiRestApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository todasCidades = applicationContext.getBean(CidadeRepository.class);
		
		List<Cidade> cidades = todasCidades.listar();
		
		for(Cidade cidade: cidades) {
			System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome());
		}
	}
}
