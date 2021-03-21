package com.exam.salary.repository;

import com.exam.salary.domain.Cargos;
import com.exam.salary.domain.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadosRepository extends JpaRepository<Empleados, Long> {

//    Empleados findAllByCargo(Cargos cargos);

    Empleados findByNombre(String nombre);

}
