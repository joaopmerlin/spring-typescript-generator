import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
<#list module.providers as provider>
import {${provider.nome}} from './${provider.nomeArquivo}';
</#list>
<#list module.declarations as declaration>
import {${declaration.nome}} from './${declaration.nomeArquivo}';
</#list>

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    <#list module.declarations as declaration>
    ${declaration.nome}<#sep>,</#sep>
    </#list>
  ],
  providers: [
    <#list module.providers as provider>
    ${provider.nome}<#sep>,</#sep>
    </#list>
  ]
})
export class ${module.nome} {
}