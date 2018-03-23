package com.spring.typescript.generator.mavenplugin.converter;

import com.spring.typescript.generator.annotation.TsComponent;
import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.mavenplugin.model.Css;
import com.spring.typescript.generator.mavenplugin.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CssConverter extends AbstractConverter<Css> implements Converter<Css> {

    @Override
    public List<Css> converter(Set<Class<?>> classes) {
        List<Css> htmls = new ArrayList<>();
        classes.forEach(aClass -> htmls.add(getCss(aClass)));
        return htmls;
    }

    public Css getCss(Class<?> aClass) {
        Css html = new Css();

        TsComponent component = aClass.getAnnotation(TsComponent.class);
        Class<?> clazz = component.value();
        if (!clazz.isAnnotationPresent(TsModel.class)) {
            throw new RuntimeException();
        }
        Model model = getModel(clazz);
        html.setNome(model.getNome());

        return html;
    }
}
