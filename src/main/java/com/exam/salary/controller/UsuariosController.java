package com.exam.salary.controller;

import com.exam.salary.constants.AuthConstants;
import com.exam.salary.constants.ResourcesMapping;
import com.exam.salary.dto.UsuarioResponseDto;
import com.exam.salary.dto.UserDto;
import com.exam.salary.service.IEmpleadosService;
import com.exam.salary.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(ResourcesMapping.USERS)
public class UsuariosController {

    private final IUsuarioService usuarioService;
    private final IEmpleadosService empleadosService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PreAuthorize("hasRole('"+ AuthConstants.ROLE_ADMIN +"')")
    @PostMapping(ResourcesMapping.SAVE + ResourcesMapping.USER_JEFE)
    public ResponseEntity<UsuarioResponseDto> saveUsuarioJefe(@RequestBody UserDto user) {
        user.setClave(bCryptPasswordEncoder.encode(user.getClave()));
        Long idUsuario = usuarioService.saveUser(user);
        UsuarioResponseDto usuarioResponse = new UsuarioResponseDto();
        usuarioResponse.setIdUsuario(idUsuario);
        return ResponseEntity.ok(usuarioResponse);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{name}")
    public ResponseEntity<List<UserDto>> helloWorld(@PathVariable String name) {
        UserDto userr = new UserDto();
        userr.setClave("hello");
        userr.setUsuario("Juan Fer");
        List<UserDto> lista = Arrays.asList(userr, userr);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
