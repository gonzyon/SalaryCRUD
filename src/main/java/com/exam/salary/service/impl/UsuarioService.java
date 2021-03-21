package com.exam.salary.service.impl;

import com.exam.salary.constants.RolType;
import com.exam.salary.domain.Usuarios;
import com.exam.salary.dto.UserDto;
import com.exam.salary.mapper.IUsuariosMapper;
import com.exam.salary.repository.IUsuarioRepository;
import com.exam.salary.service.IUsuarioService;
import com.sun.xml.bind.v2.TODO;
import jdk.nashorn.internal.ir.IfNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    private final IUsuariosMapper usuariosMapper;

    @Override
    public Long saveUser(UserDto user) {
        if (user.getRol().getRol() != null){
            List<RolType> roles = Arrays.asList(RolType.values());
            if (roles.stream().anyMatch(u -> u.name().equals(user.getRol().getRol()))){
                roles.stream().forEach(rol -> {
                    if(rol.name().equals(user.getRol().getRol())){
                        user.getRol().setIdRol(rol.getCode());
                    }
                });
            }else{
                TODO excepcion;
            }

        }
        Usuarios usuario = usuariosMapper.dtoToEntity(user);
        return usuarioRepository.save(usuario).getIdUsu();
    }


}
