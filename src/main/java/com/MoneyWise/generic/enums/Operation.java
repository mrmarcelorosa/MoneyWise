package com.MoneyWise.generic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Operation {

    ENTRADA(1, "Entrada"),
    SAIDA(2, "Saída");

    private int cod;
    private String description;

    public static Operation toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Operation x : Operation.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
