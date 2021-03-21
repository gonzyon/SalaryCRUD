package com.exam.salary.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("ALL")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RolType {

    ADMIN(1L),
    JEFE(2L),
    EMPLEADO(3L);

    private Long code;

    public Long getCode() {
        return this.code;
    }
}
