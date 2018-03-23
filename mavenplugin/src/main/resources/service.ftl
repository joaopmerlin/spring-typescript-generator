import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
<#list service.imports as imp>
<#if imp.folder != service.folder>
import {${imp.nome}} from '../${imp.folder}/${imp.nomeArquivo}';
</#if>
<#if imp.folder == service.folder>
import {${imp.nome}} from './${imp.nomeArquivo}';
</#if>
</#list>

@Injectable()
export class ${service.nome} {

  constructor(private http: HttpClient) {
  }

  <#list service.metodos as metodo>
  public ${metodo.nome}(${metodo.parametrosString}): Observable<${metodo.retorno}> {
    <#if metodo.getParametroBody()??>
    return this.http.${metodo.method}<${metodo.retorno}>(`${metodo.url}`, ${metodo.parametroBody});
    <#else>
    return this.http.${metodo.method}<${metodo.retorno}>(`${metodo.url}`);
    </#if>
  }

  </#list>
}
