package com.exam.salary.dto;

import com.exam.salary.domain.Empleados;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EmpleadosDto {
    private Long idEmp;
    private String nombre;
    private String direccion;
    private String telefono;
    private CargoDto cargos;
    private Integer salarioTotal;
    private Integer porcentaje;
    private String email;
    private EmpleadosDto empleadoJefe;
    private Boolean isJefe;
    private UserDto usuarios;
}
