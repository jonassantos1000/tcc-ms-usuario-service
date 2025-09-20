package com.usp.esalq.tcc.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.usp.esalq.tcc.domain.entity.UsuarioEntity;
import com.usp.esalq.tcc.domain.model.usuario.DadosUsuarioVO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	@Mapping(target = "id", ignore = true)
	UsuarioEntity toUsuarioEntity(DadosUsuarioVO dadosUsuario);
	
	default UsuarioEntity updateUsuarioEntity(UsuarioEntity usuario, DadosUsuarioVO dadosUsuario) {
		usuario.setNome(dadosUsuario.nome());
		
		if (!dadosUsuario.senha().isBlank()) {
			usuario.setSenha(dadosUsuario.senha());
		}
		return usuario;
	}
}
