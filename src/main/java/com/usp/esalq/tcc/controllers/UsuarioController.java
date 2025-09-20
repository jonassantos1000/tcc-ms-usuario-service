package com.usp.esalq.tcc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usp.esalq.tcc.domain.model.usuario.DadosUsuarioVO;
import com.usp.esalq.tcc.services.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	private void cadastrar(@RequestBody DadosUsuarioVO dadosUsuario) {
		usuarioService.cadastrar(dadosUsuario);
	}
	
	@PutMapping
	private void atualizar(@RequestBody DadosUsuarioVO dadosUsuario) {
		usuarioService.atualizar(dadosUsuario);
	}
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	private void remover(@RequestBody DadosUsuarioVO dadosUsuario) {
		usuarioService.remover(dadosUsuario);
	}
}
