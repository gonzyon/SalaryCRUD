package com.exam.salary.mapper;

import com.exam.salary.domain.Usuarios;
import com.exam.salary.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@SuppressWarnings("squid:S1214")
public interface IUsuariosMapper extends IMapperGeneric<Usuarios, UserDto> {

}
