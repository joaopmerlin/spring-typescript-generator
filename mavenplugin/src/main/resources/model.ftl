<#list model.imports as imp>
import {${imp.nome}} from '../${imp.folder}/${imp.nomeArquivo}';
</#list>
<#if model.imports?has_content>

</#if>
export ${model.modifier}class ${model.nome} {

  <#list model.atributos as attr>
  ${attr.nome}: ${attr.tipo};
  </#list>

}
