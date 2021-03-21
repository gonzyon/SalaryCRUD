package com.exam.salary.repository;

import com.exam.salary.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuarios, Long> {

    Usuarios findUsuariosByUsuario(String usuario);

}
