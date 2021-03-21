package com.exam.salary.repository;

import com.exam.salary.domain.Cargos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICargoRepository extends JpaRepository<Cargos, Long> {

}
