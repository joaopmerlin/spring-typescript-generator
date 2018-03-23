package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.mavenplugin.converter.Converter;
import com.spring.typescript.generator.mavenplugin.converter.ModelConverter;
import com.spring.typescript.generator.mavenplugin.model.Atributo;
import com.spring.typescript.generator.mavenplugin.model.Model;
import com.spring.typescript.generator.mavenplugin.model.Service;
import com.spring.typescript.generator.mavenplugin.model.Tipos;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpringService {

    private Converter<Model> converter = new ModelConverter();

    public String getMethod(Method method) {
        if (method.getDeclaredAnnotation(DeleteMapping.class) != null) {
            return "delete";
        } else if (method.getDeclaredAnnotation(GetMapping.class) != null) {
            return "get";
        } else if (method.getDeclaredAnnotation(PatchMapping.class) != null) {
            return "patch";
        }  else if (method.getDeclaredAnnotation(PostMapping.class) != null) {
            return "post";
        }  else if (method.getDeclaredAnnotation(PutMapping.class) != null) {
            return "put";
        }  else if (method.getDeclaredAnnotation(RequestMapping.class) != null) {
            RequestMapping requestMapping = method.getDeclaredAnnotation(RequestMapping.class);
            RequestMethod requestMethod = requestMapping.method()[0];
            return requestMethod.name().toLowerCase();
        }

        throw new RuntimeException();
    }

    public String getUrl(Class c, Method m, Set<Atributo> parametros) {
        String url = "/" + getUrl(c) + "/" + getUrl(m).replace("{", "${");
        url = url.replace("//", "/");
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }

        Supplier<Stream<Atributo>> parametrosStream = () -> parametros.stream().filter(e -> e.getParam());
        if (parametrosStream.get().count() > 0) {
            url = url + "?" + parametrosStream.get().map(e -> e.getNome() + "=${" + e.getNome() + "}").collect(Collectors.joining("&"));
        }


        return url;
    }

    public Set<Atributo> getParametros(Method method, Service service) {
        Set<Atributo> parametros = new LinkedHashSet<>();

        Arrays.asList(method.getParameters()).forEach(p -> {
            Atributo atributo = new Atributo();
            atributo.setNome(getParametroNome(p));

            if (p.getDeclaredAnnotation(RequestBody.class) != null) {
                atributo.setBody(true);
            }

            if (p.getDeclaredAnnotation(RequestParam.class) != null) {
                atributo.setParam(true);
            }

            setParametroTipo(p, atributo, service, method);

            parametros.add(atributo);
        });

        return parametros;
    }

    private String getParametroNome(Parameter p) {
        PathVariable pathVariable = p.getDeclaredAnnotation(PathVariable.class);
        if (pathVariable != null && !pathVariable.value().isEmpty()) {
            return pathVariable.value();
        }

        RequestParam requestParam = p.getDeclaredAnnotation(RequestParam.class);
        if (requestParam != null && !requestParam.value().isEmpty()) {
            return requestParam.value();
        }

        return p.getName();
    }

    private void setParametroTipo(Parameter p, Atributo atributo, Service service, Method method) {
        if (ClassUtils.isAssignable(p.getType(), Iterable.class)) {
            Class type = (Class) ((ParameterizedTypeImpl) p.getParameterizedType()).getActualTypeArguments()[0];

            if (type.isAnnotationPresent(TsModel.class)){
                Model model = converter.getModel(type);
                atributo.setTipo(model.getNome() + "[]");
                service.addImport(converter.getModel(type));
            } else {
                atributo.setTipo("any[]");
            }
        }

        else if (p.getType().isAnnotationPresent(TsModel.class)) {
            Model model = converter.getModel(p.getType());
            atributo.setTipo(model.getNome());
            service.addImport(converter.getModel(method.getReturnType()));
        }

        else {
            Tipos.getTipos().forEach((key, value) -> {
                if (ClassUtils.isAssignable(p.getType(), key)) {
                    atributo.setTipo(value);
                    return;
                }
            });
        }
    }

    private String getUrl(Class c) {
        if (c.getDeclaredAnnotation(RequestMapping.class) != null) {
            RequestMapping requestMapping = (RequestMapping) c.getDeclaredAnnotation(RequestMapping.class);
            return requestMapping.value().length == 0 ? "" : requestMapping.value()[0];
        }
        return "";
    }

    private String getUrl(Method method) {
        if (method.getDeclaredAnnotation(DeleteMapping.class) != null) {
            DeleteMapping deleteMapping = method.getDeclaredAnnotation(DeleteMapping.class);
            return deleteMapping.value().length == 0 ? "" : deleteMapping.value()[0];
        } else if (method.getDeclaredAnnotation(GetMapping.class) != null) {
            GetMapping getMapping = method.getDeclaredAnnotation(GetMapping.class);
            return getMapping.value().length == 0 ? "" : getMapping.value()[0];
        } else if (method.getDeclaredAnnotation(PatchMapping.class) != null) {
            PatchMapping patchMapping = method.getDeclaredAnnotation(PatchMapping.class);
            return patchMapping.value().length == 0 ? "" : patchMapping.value()[0];
        }  else if (method.getDeclaredAnnotation(PostMapping.class) != null) {
            PostMapping postMapping = method.getDeclaredAnnotation(PostMapping.class);
            return postMapping.value().length == 0 ? "" : postMapping.value()[0];
        }  else if (method.getDeclaredAnnotation(PutMapping.class) != null) {
            PutMapping putMapping = method.getDeclaredAnnotation(PutMapping.class);
            return putMapping.value().length == 0 ? "" : putMapping.value()[0];
        }  else if (method.getDeclaredAnnotation(RequestMapping.class) != null) {
            RequestMapping requestMapping = method.getDeclaredAnnotation(RequestMapping.class);
            return requestMapping.value().length == 0 ? "" : requestMapping.value()[0];
        }

        throw new RuntimeException();
    }
}
