package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiRestApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiRestApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository cadastroRestaurante = applicationContext.getBean(RestauranteRepository.class);
		
		
		List<Restaurante> restaurantes = cadastroRestaurante.listar();
		
		for(Restaurante restaurante: restaurantes) {
			System.out.printf("%s - %f - %s\n ", restaurante.getNome(), 
					restaurante.getTaxaFrete(),
					restaurante.getCozinha().getNome());
		}
	}
}
