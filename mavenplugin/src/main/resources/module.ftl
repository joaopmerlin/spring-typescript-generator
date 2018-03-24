import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
<#if module.crud>
import {FormsModule} from "@angular/forms";
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {InputTextModule} from "primeng/primeng";
</#if>
<#list module.providers as provider>
import {${provider.nome}} from './${provider.nomeArquivo}';
</#list>
<#list module.declarations as declaration>
import {${declaration.nome}} from './${declaration.nomeArquivo}';
</#list>

@NgModule({
  imports: [
    CommonModule<#if module.crud>,</#if>
    <#if module.crud>
    FormsModule,
    TableModule,
    ButtonModule,
    DialogModule,
    InputTextModule
    </#if>
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