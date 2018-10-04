import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
<#if module.crud>
import {FormsModule} from "@angular/forms";
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {ConfirmDialogModule, InputTextModule} from "primeng/primeng";
import {CalendarModule} from 'primeng/calendar';
import {CheckboxModule} from 'primeng/checkbox';
import {DropdownModule} from 'primeng/dropdown';
import {ConfirmationService} from "primeng/api";
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
    InputTextModule,
    CalendarModule,
    CheckboxModule,
    DropdownModule,
    ConfirmDialogModule
    </#if>
  ],
  declarations: [
    <#list module.declarations as declaration>
    ${declaration.nome}<#sep>,</#sep>
    </#list>
  ],
  providers: [
    <#if module.crud>
    ConfirmationService<#if module.providers?has_content>,</#if>
    </#if>
    <#list module.providers as provider>
    ${provider.nome}<#sep>,</#sep>
    </#list>
  ]
})
export class ${module.nome} {
}