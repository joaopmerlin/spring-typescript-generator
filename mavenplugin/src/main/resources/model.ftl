<#list model.imports as imp>
import {${imp.nome}} from './${imp.nomeArquivo}';
</#list>
<#if model.imports?has_content>

</#if>
export class ${model.nome} {

    <#if model.encapsular>
    <#list model.atributos as attr>
    private _${attr.nome}: ${attr.tipo};
    </#list>

    <#list model.atributos as attr>
    get ${attr.nome}(): ${attr.tipo} {
        return this._${attr.nome};
    }

    </#list>

    <#list model.atributos as attr>
    set ${attr.nome}(value: ${attr.tipo}) {
        this._${attr.nome} = value;
    }

    </#list>
    <#else>
    <#list model.atributos as attr>
    ${attr.nome}: ${attr.tipo};
    </#list>
    </#if>
}