package com.exam.salary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@DynamicInsert
@DynamicUpdate
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emp")
    private Long idEmp;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne()
    @JoinColumn(name="id_cargo_emp", referencedColumnName="id_car", foreignKey = @ForeignKey(name = "cargo_fk"))
    private Cargos cargos;

    @Column(name = "salario_total")
    private Integer salarioTotal;

    @Column(name = "porcentaje")
    private Integer porcentaje;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name="id_jefe_emp", referencedColumnName="id_emp", foreignKey = @ForeignKey(name = "jefe_fk"))
    private Empleados empleadoJefe;

    @Column(name = "is_jefe")
    private Boolean isJefe;

    @ManyToOne
    @JoinColumn(name="id_usuario_em", referencedColumnName="id_usu", foreignKey = @ForeignKey(name = "usuario_fk"))
    private Usuarios usuarios;

}
