import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
<#list service.imports as imp>
import {${imp.nome}} from '../model/${imp.nomeArquivo}';
</#list>

@Injectable()
export class ${service.nome} {

    constructor(private http: HttpClient) { }

    <#list service.metodos as metodo>
    public ${metodo.nome}(${metodo.getParametrosString()}): Observable<${metodo.retorno}> {
        <#if metodo.getParametroBody()??>
        return this.http.${metodo.method}<${metodo.retorno}>(`${metodo.url}`, ${metodo.getParametroBody()});
        <#else>
        return this.http.${metodo.method}<${metodo.retorno}>(`${metodo.url}`);
        </#if>
    }

    </#list>
}
