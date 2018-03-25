package com.spring.typescript.generator.mavenplugin.converter;

import com.spring.typescript.generator.annotation.TsComponent;
import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.mavenplugin.model.Html;
import com.spring.typescript.generator.mavenplugin.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HtmlConverter extends AbstractConverter<Html> implements Converter<Html> {

    private ComponentConverter componentConverter = new ComponentConverter();

    @Override
    public List<Html> converter(Set<Class<?>> classes) {
        List<Html> htmls = new ArrayList<>();
        classes.forEach(aClass -> htmls.add(getHtml(aClass)));
        return htmls;
    }

    public Html getHtml(Class<?> aClass) {
        Html html = new Html();

        TsComponent component = aClass.getAnnotation(TsComponent.class);
        Class<?> clazz = component.value();
        if (!clazz.isAnnotationPresent(TsModel.class)) {
            throw new RuntimeException();
        }
        Model model = getModel(clazz);
        html.setNome(model.getNome());
        html.setModel(model);
        html.setComponent(componentConverter.getComponent(aClass));

        return html;
    }
}
