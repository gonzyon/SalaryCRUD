package com.exam.salary.service.impl;

import com.exam.salary.domain.Empleados;
import com.exam.salary.domain.Usuarios;
import com.exam.salary.dto.EmpleadosDto;
import com.exam.salary.dto.UserDto;
import com.exam.salary.mapper.IEmpleadosMapper;
import com.exam.salary.mapper.IUsuariosMapper;
import com.exam.salary.repository.IEmpleadosRepository;
import com.exam.salary.repository.IUsuarioRepository;
import com.exam.salary.service.IEmpleadosService;
import com.exam.salary.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpeladosService implements IEmpleadosService {

    private final IEmpleadosRepository empleadosRepository;

    @Autowired
    private final IEmpleadosMapper empleadosMapper;

    @Override
    public Long findEmpleado(String nombreJefe) {
        return empleadosRepository.findByNombre(nombreJefe).getIdEmp();
    }

    @Override
    public Long saveEmpleadoJefe(EmpleadosDto empleado) {
        //Se valida si el empleado que sera jefe, tiene un jefe asignado
        if(empleado.getEmpleadoJefe() != null){
            Long idJefe = empleadosRepository.findByNombre(empleado.getEmpleadoJefe().getNombre()).getIdEmp();
            empleado.getEmpleadoJefe().setIdEmp(idJefe);
        }
        Empleados empleadoEnt = empleadosMapper.dtoToEntity(empleado);
        Empleados empleadoSave = empleadosRepository.save(empleadoEnt);
        return empleadoSave.getIdEmp();
    }

    @Override
    public Long saveEmpleado(EmpleadosDto empleado) {
        return null;
    }
}
