import {Component, OnInit} from '@angular/core';
<#if component.crud>
import {ConfirmationService} from 'primeng/api';
</#if>
import {${component.service.nome}} from './${component.service.nomeArquivo}';
<#list component.service.imports as imp>
<#if imp.folder != component.service.folder>
import {${imp.nome}} from '../${imp.folder}/${imp.nomeArquivo}';
</#if>
<#if imp.folder == component.service.folder>
import {${imp.nome}} from './${imp.nomeArquivo}';
</#if>
</#list>

@Component({
  selector: 'app-${component.folder}',
  templateUrl: './${component.folder}.component.html',
  styleUrls: ['./${component.folder}.component.css']
})
export class ${component.nome} implements OnInit {

  <#if component.crud>
  list${component.service.model.nome}: ${component.service.model.nome}[];
  selected${component.service.model.nome} = new ${component.service.model.nome}();
  showModal = false;
  </#if>

  constructor(private ${component.service.nomeLower}: ${component.service.nome}<#if component.crud>, private confirmationService: ConfirmationService</#if>) {
  }

  ngOnInit(): void {
  <#list component.service.metodos as metodo>
  <#if metodo.findAll>
    this.${metodo.nome}();
  </#if>
  </#list>
  }

  <#list component.service.metodos as metodo>
  ${metodo.nome}(${metodo.getParametrosString()}) {
    <#if metodo.delete>
    this.confirmationService.confirm({
      message: 'Do you want to delete this record?',
      accept: () => {
        this.${component.service.nomeLower}.${metodo.nome}(${metodo.parametrosNomes}).subscribe(e => {
          <#list component.service.metodos as metodo>
          <#if metodo.findAll>
          this.${metodo.nome}();
          </#if>
          </#list>
        });
      }
    });
    <#else>
    this.${component.service.nomeLower}.${metodo.nome}(${metodo.parametrosNomes}).subscribe(e => {
    <#if metodo.findAll>
      this.list${component.service.model.nome} = e;
    <#elseif metodo.save>
      <#list component.service.metodos as metodo>
      <#if metodo.findAll>
      this.${metodo.nome}();
      </#if>
      </#list>
      this.showModal = false;
    </#if>
    });
    </#if>
  }

  </#list>
  <#if component.crud>
  new() {
    this.selected${component.service.model.nome} = new ${component.service.model.nome}();
    this.showModal = true;
  }

  edit(${component.service.model.nomeLower}: ${component.service.model.nome}) {
    this.selected${component.service.model.nome} = JSON.parse(JSON.stringify(${component.service.model.nomeLower}));
    this.showModal = true;
  }
  </#if>
}
