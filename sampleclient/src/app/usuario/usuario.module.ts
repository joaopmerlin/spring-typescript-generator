import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from "@angular/forms";
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {ConfirmDialogModule, InputTextModule} from "primeng/primeng";
import {CalendarModule} from 'primeng/calendar';
import {CheckboxModule} from 'primeng/checkbox';
import {DropdownModule} from 'primeng/dropdown';
import {ConfirmationService} from "primeng/api";
import {UsuarioService} from './usuario.service';
import {UsuarioComponent} from './usuario.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    TableModule,
    ButtonModule,
    DialogModule,
    InputTextModule,
    CalendarModule,
    CheckboxModule,
    DropdownModule,
    ConfirmDialogModule
  ],
  declarations: [
    UsuarioComponent
  ],
  providers: [
    ConfirmationService,
    UsuarioService
  ]
})
export class UsuarioModule {
}