package com.usp.esalq.tcc.domain.mapper;

import com.usp.esalq.tcc.domain.entity.UsuarioEntity;
import com.usp.esalq.tcc.domain.model.usuario.DadosUsuarioVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-20T14:39:52-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioEntity toUsuarioEntity(DadosUsuarioVO dadosUsuario) {
        if ( dadosUsuario == null ) {
            return null;
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setEmail( dadosUsuario.email() );
        usuarioEntity.setNome( dadosUsuario.nome() );
        usuarioEntity.setSenha( dadosUsuario.senha() );

        return usuarioEntity;
    }
}
