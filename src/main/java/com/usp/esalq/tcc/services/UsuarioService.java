package com.usp.esalq.tcc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usp.esalq.tcc.domain.entity.UsuarioEntity;
import com.usp.esalq.tcc.domain.mapper.UsuarioMapper;
import com.usp.esalq.tcc.domain.model.usuario.DadosUsuarioVO;
import com.usp.esalq.tcc.exceptions.MsgException;
import com.usp.esalq.tcc.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
	
	private final UsuarioMapper mapper;
	private final UsuarioRepository usuarioRepository;

	@Transactional
	public void cadastrar(DadosUsuarioVO dadosUsuario) {
		
		if (usuarioRepository.existsByEmail(dadosUsuario.email())) {
			throw new MsgException("Usuário já esta cadastrado.");
		}
		
		usuarioRepository.save(mapper.toUsuarioEntity(dadosUsuario));
	}

	public void atualizar(DadosUsuarioVO dadosUsuario) {
		Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByEmail(dadosUsuario.email());
		if (usuarioOpt.isEmpty()) {
			throw new MsgException("Usuário não encontrado.");
		}
		
		usuarioRepository.save(mapper.updateUsuarioEntity(usuarioOpt.get(), dadosUsuario));		
	}

	public void remover(DadosUsuarioVO dadosUsuario) {
		Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByEmail(dadosUsuario.email());
		if (usuarioOpt.isEmpty()) {
			throw new MsgException("Usuário não encontrado.");
		}
		
		usuarioRepository.delete(usuarioOpt.get());	
	}

}
