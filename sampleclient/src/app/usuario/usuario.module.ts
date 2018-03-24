import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from "@angular/forms";
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {InputTextModule} from "primeng/primeng";
import {UsuarioService} from './usuario.service';
import {UsuarioComponent} from './usuario.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    TableModule,
    ButtonModule,
    DialogModule,
    InputTextModule
  ],
  declarations: [
    UsuarioComponent
  ],
  providers: [
    UsuarioService
  ]
})
export class UsuarioModule {
}