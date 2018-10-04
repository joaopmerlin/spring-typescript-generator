package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.annotation.TsRelationship;
import com.spring.typescript.generator.mavenplugin.enumeration.TipoComponente;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Field;
import java.util.Date;

public class TipoComponenteService {

    public static TipoComponente getTipoComponente(Field field) {
        if (field.isAnnotationPresent(TsRelationship.class)) {
            if (ClassUtils.isAssignable(field.getType(), Iterable.class)) {
                return TipoComponente.MULTI_SELECT;
            }
            return TipoComponente.DROPDOWN;
        } else if (ClassUtils.isAssignable(field.getType(), String.class)) {
            return TipoComponente.INPUT_TEXT;
        } else if (ClassUtils.isAssignable(field.getType(), Number.class)) {
            return TipoComponente.INPUT_NUMBER;
        } else if (ClassUtils.isAssignable(field.getType(), Date.class)) {
            return TipoComponente.CALENDAR;
        } else if (ClassUtils.isAssignable(field.getType(), Boolean.class)) {
            return TipoComponente.CHECKBOX;
        }


        return TipoComponente.INPUT_TEXT;
    }
}
