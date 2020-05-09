package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;

	// Deixa explicito que só aceita requisições HTTP do tipo JSON no seu body
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Restaurante> listar() {
		return restauranteRepository.listar();
	}

	// @ResponseStatus(HttpStatus.OK) // Forma simples de devolver o status da
	// requisição
	// ResponseEntity - forma mais elegante e com poder de manipulação da resposta
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);

		if (restaurante != null) {
//			return ResponseEntity.status(HttpStatus.OK).body(restaurante);

			// Shortcut - atalho para requisição
			return ResponseEntity.ok(restaurante);
		}

		return ResponseEntity.notFound().build();

		// Redirecionamento da URI - Status 302
//		HttpHeaders headers = new HttpHeaders();
//		headers.add(HttpHeaders.LOCATION, "Ex: http://localhost:8080/cozinhas");
//		
//		return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();

	}
}
