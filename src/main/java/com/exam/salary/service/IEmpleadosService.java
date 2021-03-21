package com.exam.salary.service;

import com.exam.salary.dto.EmpleadosDto;

public interface IEmpleadosService {

    Long findEmpleado(String nombreJefe);

    Long saveEmpleadoJefe(EmpleadosDto empleado);

    Long saveEmpleado(EmpleadosDto empleado);

}
