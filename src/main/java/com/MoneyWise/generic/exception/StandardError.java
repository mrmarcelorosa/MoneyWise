package com.MoneyWise.generic.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class StandardError implements Serializable {

    private Integer status;
    private String msg;
    private Long timeStemp;
}
