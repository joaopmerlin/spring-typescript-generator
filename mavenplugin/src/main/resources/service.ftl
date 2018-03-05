export class ${service.nome} {

    <#list service.metodos as metodo>
    public ${metodo.nome}(): ${metodo.retorno} {

    }

    </#list>

}