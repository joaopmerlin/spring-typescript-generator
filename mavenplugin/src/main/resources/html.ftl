<#if html.component.crud>
<button type="button" pButton (click)="new()" label="New"></button>

<p-table [value]="list${html.model.nome}" [paginator]="true" [rows]="10">
  <ng-template pTemplate="header">
    <tr>
      <#list html.model.atributos as attr>
      <th>${attr.nome}</th>
      </#list>
      <th></th>
    </tr>
  </ng-template>
  <ng-template pTemplate="body" let-item>
    <tr>
      <#list html.model.atributos as attr>
      <td>{{item.${attr.nome}}}</td>
      </#list>
      <td>
        <button type="button" pButton (click)="edit(item)" icon="fa-edit"></button>
        <#list html.component.service.metodos as metodo>
        <#if metodo.delete>
        <button type="button" pButton (click)="${metodo.nome}(item.${metodo.parametrosNomes})" icon="fa-trash" class="ui-button-danger"></button>
        </#if>
        </#list>
      </td>
    </tr>
  </ng-template>
</p-table>

<p-dialog header="CRUD" [(visible)]="showModal" [modal]="true" [width]="600">

  <#list html.model.atributos as attr>
  <div class="ui-g">
    <div class="ui-g-4">${attr.nome}</div>
    <div class="ui-g-8">
      <#if attr.tipoComponente == 'INPUT_TEXT'>
      <input type="text" pInputText [(ngModel)]="selected${html.model.nome}.${attr.nome}"/>
      <#elseif attr.tipoComponente == 'INPUT_NUMBER'>
      <input type="number" pInputText [(ngModel)]="selected${html.model.nome}.${attr.nome}"/>
      </#if>
    </div>
  </div>
  </#list>

  <p-footer>
    <#list html.component.service.metodos as metodo>
    <#if metodo.save>
    <button pButton type="button" (click)="${metodo.nome}(selected${html.model.nome})" label="Save" class="ui-button-success"></button>
    </#if>
    </#list>
    <button pButton type="button" (click)="showModal = false" label="Cancel" class="ui-button-secondary"></button>
  </p-footer>
</p-dialog>

<p-confirmDialog header="Delete Confirmation" icon="fa fa-trash"></p-confirmDialog>
</#if>