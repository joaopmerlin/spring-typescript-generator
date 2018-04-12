package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.mavenplugin.enumeration.TipoComponente;
import org.apache.commons.lang3.ClassUtils;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Field;
import java.util.Date;

public class TipoComponenteService {

    public static TipoComponente getTipoComponente(Field field) {
        if (ClassUtils.isAssignable(field.getType(), Iterable.class)) {
            Class type = (Class)((ParameterizedTypeImpl) field.getGenericType()).getActualTypeArguments()[0];

            if (type.isAnnotationPresent(TsModel.class)){
                return TipoComponente.AUTO_COMPLETE_MULTIPLE;
            } else {
                return TipoComponente.MULTI_SELECT;
            }
        } else if (field.getType().isAnnotationPresent(TsModel.class)) {
            return TipoComponente.AUTO_COMPLETE;
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
