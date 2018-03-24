<button type="button" pButton (click)="selected${html.model.nome} = {}; showModal = true" label="New"></button>

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
        <button type="button" pButton (click)="selected${html.model.nome} = item; showModal = true" icon="fa-search"></button>
      </td>
    </tr>
  </ng-template>
</p-table>

<p-dialog header="CRUD" [(visible)]="showModal" [modal]="true">

  <#list html.model.atributos as attr>
  <div class="ui-g">
    <div class="ui-g-4">${attr.nome}</div>
    <div class="ui-g-8">
      <input type="text" pInputText [(ngModel)]="selected${html.model.nome}.${attr.nome}"/>
    </div>
  </div>
  </#list>

  <p-footer>
    <button pButton type="button" (click)="save(selected${html.model.nome})" label="Save" class="ui-button-success"></button>
    <button pButton type="button" (click)="showModal = false" label="Cancel" class="ui-button-secondary"></button>
  </p-footer>
</p-dialog>
