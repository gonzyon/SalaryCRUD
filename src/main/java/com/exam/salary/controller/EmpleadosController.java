package com.exam.salary.controller;

import com.exam.salary.constants.AuthConstants;
import com.exam.salary.constants.ResourcesMapping;
import com.exam.salary.dto.EmpleadoResponseDto;
import com.exam.salary.dto.EmpleadosDto;
import com.exam.salary.service.IEmpleadosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(ResourcesMapping.EMPLEADOS)
public class EmpleadosController {

    private final IEmpleadosService empleadosService;


    @PreAuthorize("hasRole('"+ AuthConstants.ROLE_ADMIN +"')")
    @PostMapping(ResourcesMapping.SAVE + ResourcesMapping.USER_EMPLEADO +ResourcesMapping.USER_JEFE)
    public ResponseEntity<EmpleadoResponseDto> saveEmpleadoJefe(@RequestBody EmpleadosDto empleado) {
        EmpleadoResponseDto empleadoResponse = new EmpleadoResponseDto();
        empleadoResponse.setIdEmpleado(empleadosService.saveEmpleadoJefe(empleado));
        empleadoResponse.setText("Empleado creado exitosamente!");
        return ResponseEntity.ok(empleadoResponse);
    }
}
