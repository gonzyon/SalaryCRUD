package com.exam.salary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class Usuarios {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_usu")
    private Long idUsu;

    @Column(length = 20)
    private String usuario;

    @Column(length = 100)
    private String clave;

    @ManyToOne()
    @JoinColumn(name="id_rol_usu", referencedColumnName="id_rol", foreignKey = @ForeignKey(name = "id_rol_usu_fk"))
    private Rol rol;

    @OneToMany(mappedBy = "usuarios", cascade= CascadeType.ALL)
    private List<Empleados> empleados;
}
