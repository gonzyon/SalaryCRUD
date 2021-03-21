package com.exam.salary.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("ALL")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum CargoType {

    GERENTE(1),
    ASISTENTE(2),
    DESARROLLADOR(3);

    private int code;

    public int getCode(){ return this.code; }



}
