export class ${service.nome} {

    <#list service.metodos as metodo>
    ${metodo.nome}
    </#list>

}