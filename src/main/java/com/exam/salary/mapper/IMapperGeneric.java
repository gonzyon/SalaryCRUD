package com.exam.salary.mapper;

/**
 *
 * @param <T> Entity
 * @param <D> Dto
 */
@SuppressWarnings("squid:s1214")
public interface IMapperGeneric<T, D> {

    T dtoToEntity(D dto);

    D entityToDto(T entity);

}
