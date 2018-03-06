
@Injectable
export class ${service.nome} {

    construtor(private http: HttpClient) { }

    <#list service.metodos as metodo>
    public ${metodo.nome}(): Observable<${metodo.retorno}> {
        return this.http.${metodo.method}<${metodo.retorno}>(`${metodo.url}`);
    }

    </#list>

}