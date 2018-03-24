import {Component, OnInit} from '@angular/core';
import {${component.service.nome}} from "./${component.service.nomeArquivo}";
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

  constructor(private ${component.service.nomeLower}: ${component.service.nome}) {
  }

  ngOnInit(): void {
  <#list component.service.metodos as metodo>
  <#if metodo.find>
    this.${metodo.nome}();
  </#if>
  </#list>
  }

  <#list component.service.metodos as metodo>
  ${metodo.nome}(${metodo.getParametrosString()}) {
    this.${component.service.nomeLower}.${metodo.nome}(${metodo.parametrosNomes}).subscribe(e => {
    <#if metodo.find>
      this.list${component.service.model.nome} = e;
    <#elseif metodo.save>
      this.selected${component.service.model.nome} = e;
      <#list component.service.metodos as metodo>
      <#if metodo.find>
      this.${metodo.nome}();
      </#if>
      </#list>
      this.showModal = false;
    </#if>
    });
  }

  </#list>

}
