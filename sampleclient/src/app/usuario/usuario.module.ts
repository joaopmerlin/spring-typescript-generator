import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UsuarioService} from './usuario.service';
import {UsuarioComponent} from './usuario.component';

@NgModule({
  imports: [
    CommonModule
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