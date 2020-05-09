package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object o) {
        return calcular(o, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object o) {
        return calcular(o, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object o) {
        BigDecimal total = BigDecimal.valueOf(0.0);
        total = somar(o).subtract(subtrair(o));
        return total;
    }

    public BigDecimal calcular(Object o, Class c) {
        BigDecimal saida = BigDecimal.ZERO;

        for(Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if(f.isAnnotationPresent(c) && f.getType().equals(BigDecimal.class)) {
                try {
                    saida = saida.add((BigDecimal) f.get(o));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return saida;
    }
}
