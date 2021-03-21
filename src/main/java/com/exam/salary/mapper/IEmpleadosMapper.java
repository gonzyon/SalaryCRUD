package com.exam.salary.mapper;

import com.exam.salary.domain.Empleados;
import com.exam.salary.domain.Usuarios;
import com.exam.salary.dto.EmpleadosDto;
import com.exam.salary.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@SuppressWarnings("squid:S1214")
public interface IEmpleadosMapper extends IMapperGeneric<Empleados, EmpleadosDto> {

}
